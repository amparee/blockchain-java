package com.blockchain.pai.entity;

import java.security.*;
import java.util.ArrayList;

import com.blockchain.pai.PaiApplication;
import com.blockchain.pai.util.StringUtil;

public class Transaction {

	public String transactionId; // Este es también el hash de la transacción.
	public PublicKey sender; // envia address/public key.
	public PublicKey reciepient; // recibe address/public key.
	public float value;
	public byte[] signature; // esto es para evitar que alguien más gaste fondos en nuestra billetera.

	public ArrayList<TransactionInput> inputs = new ArrayList<TransactionInput>();
	public ArrayList<TransactionOutput> outputs = new ArrayList<TransactionOutput>();

	private static int sequence = 0; // un recuento aproximado de cuántas transacciones se han generado.

	// Constructor:
	public Transaction(PublicKey from, PublicKey to, float value, ArrayList<TransactionInput> inputs) {
		this.sender = from;
		this.reciepient = to;
		this.value = value;
		this.inputs = inputs;
	}

	// Esto calcula el hash de la transacción (que se utilizará como su ID)
	private String calulateHash() {
		sequence++; // Incrementa la secuencia para evitar 2 transacciones idénticas que tengan el
					// mismo hash.
		return StringUtil.applySha256(StringUtil.getStringFromKey(sender) + StringUtil.getStringFromKey(reciepient)
				+ Float.toString(value) + sequence);
	}

	// Firma todos los datos que no deseamos ser manipulados.
	public void generateSignature(PrivateKey privateKey) {
		String data = StringUtil.getStringFromKey(sender) + StringUtil.getStringFromKey(reciepient)
				+ Float.toString(value);
		signature = StringUtil.applyECDSASig(privateKey, data);
	}

	// Verifica que los datos que firmamos no hayan sido manipulados.
	public boolean verifiySignature() {
		String data = StringUtil.getStringFromKey(sender) + StringUtil.getStringFromKey(reciepient)
				+ Float.toString(value);
		return StringUtil.verifyECDSASig(sender, data, signature);
	}

	public boolean processTransaction() {

		if (verifiySignature() == false) {
			System.out.println("#Transaction Signature failed to verify");
			return false;
		}

		// recopilar entradas de transacciones (asegúrese de que no estén gastadas):
		for (TransactionInput i : inputs) {
			i.UTXO = PaiApplication.UTXOs.get(i.transactionOutputId);
		}

		// check if transaction is valid:
		if (getInputsValue() < PaiApplication.minimumTransaction) {
			System.out.println("#Transaction Inputs to small: " + getInputsValue());
			return false;
		}

		// generar salidas de transacción:
		float leftOver = getInputsValue() - value; // obtener el valor de las entradas luego el cambio de izquierda
		transactionId = calulateHash();
		outputs.add(new TransactionOutput(this.reciepient, value, transactionId)); // enviar valor al destinatario
		outputs.add(new TransactionOutput(this.sender, leftOver, transactionId)); // enviar el cambio a la izquierda 
																					// sender

		// agregar salidas a la lista no gastada
		for (TransactionOutput o : outputs) {
			PaiApplication.UTXOs.put(o.id, o);
		}

		// eliminar entradas de transacción de las listas UTXO como gastadas:
		for (TransactionInput i : inputs) {
			if (i.UTXO == null)
				continue; // Si no se puede encontrar Transacción, omítelo.
			PaiApplication.UTXOs.remove(i.UTXO.id);
		}

		return true;
	}

//returns sum de inputs(UTXOs) values
	public float getInputsValue() {
		float total = 0;
		for (TransactionInput i : inputs) {
			if (i.UTXO == null)
				continue; // Si no se puede encontrar Transacción, omítelo.
			total += i.UTXO.value;
		}
		return total;
	}

//returns suma de outputs:
	public float getOutputsValue() {
		float total = 0;
		for (TransactionOutput o : outputs) {
			total += o.value;
		}
		return total;
	}

}