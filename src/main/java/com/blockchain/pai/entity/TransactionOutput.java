package com.blockchain.pai.entity;

import java.security.PublicKey;

import com.blockchain.pai.util.StringUtil;

public class TransactionOutput {
	public String id;
	public PublicKey reciepient; // También conocido como el nuevo propietario de estas monedas.
	public float value; // la cantidad de monedas que poseen
	public String parentTransactionId; //El ID de la transacción en que se creó esta salida.

	// Constructor
	public TransactionOutput(PublicKey reciepient, float value, String parentTransactionId) {
		this.reciepient = reciepient;
		this.value = value;
		this.parentTransactionId = parentTransactionId;
		this.id = StringUtil
				.applySha256(StringUtil.getStringFromKey(reciepient) + Float.toString(value) + parentTransactionId);
	}

	//Comprueba si la moneda te pertenece.
	public boolean isMine(PublicKey publicKey) {
		return (publicKey == reciepient);
	}

}