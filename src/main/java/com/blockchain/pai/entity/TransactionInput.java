package com.blockchain.pai.entity;

public class TransactionInput {
	public String transactionOutputId; // Reference to TransactionOutputs -> transactionId
	public TransactionOutput UTXO; // Contiene el resultado de la transacción no utilizada

	public TransactionInput(String transactionOutputId) {
		this.transactionOutputId = transactionOutputId;
	}
}