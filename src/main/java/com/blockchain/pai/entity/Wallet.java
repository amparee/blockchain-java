package com.blockchain.pai.entity;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.ECGenParameterSpec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.blockchain.pai.PaiApplication;

public class Wallet {

	public PrivateKey privateKey;
	public PublicKey publicKey;

	public HashMap<String, TransactionOutput> UTXOs = new HashMap<String, TransactionOutput>(); // solo UTXOs propio de
																								// la wallet

	public Wallet() {
		generateKeyPair();
	}

	public void generateKeyPair() {
		try {
			KeyPairGenerator keyGen = KeyPairGenerator.getInstance("ECDSA", "BC");
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
			ECGenParameterSpec ecSpec = new ECGenParameterSpec("prime192v1");
			// inicia key generator y genera un keypair
			keyGen.initialize(ecSpec, random); // 256 bytes provee una seguridad apta
			KeyPair keyPair = keyGen.generateKeyPair();
			// Set de public y private keys para el keyPair
			privateKey = keyPair.getPrivate();
			publicKey = keyPair.getPublic();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// retorna balance y guarda el UTXO's propio de su cartera en este UTXO's
	public float getBalance() {
		float total = 0;
		for (Map.Entry<String, TransactionOutput> item : PaiApplication.UTXOs.entrySet()) {
			TransactionOutput UTXO = item.getValue();
			if (UTXO.isMine(publicKey)) { // si la salida me pertenece (si las monedas me pertenecen)
				UTXOs.put(UTXO.id, UTXO); // agregarlo a nuestra lista de transacciones no gastadas.
				total += UTXO.value;
			}
		}
		return total;
	}

	// Genera y retorna una nueva transaccion desde su wallet
	public Transaction sendFunds(PublicKey _recipient, float value) {
		if (getBalance() < value) { // reune $$ y chequea fondos
			System.out.println("#Not Enough funds to send transaction. Transaction Discarded.");
			return null;
		}
		// crea un array list de inputs
		ArrayList<TransactionInput> inputs = new ArrayList<TransactionInput>();

		float total = 0;
		for (Map.Entry<String, TransactionOutput> item : UTXOs.entrySet()) {
			TransactionOutput UTXO = item.getValue();
			total += UTXO.value;
			inputs.add(new TransactionInput(UTXO.id));
			if (total > value)
				break;
		}

		Transaction newTransaction = new Transaction(publicKey, _recipient, value, inputs);
		newTransaction.generateSignature(privateKey);

		for (TransactionInput input : inputs) {
			UTXOs.remove(input.transactionOutputId);
		}
		return newTransaction;
	}

}