package com.blockchain.pai.entity;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.blockchain.pai.util.StringUtil;

public class Block {

	private Long id;
	public String hash;
	public String previousHash;
	public String merkleRoot;
	public ArrayList<Transaction> transactions = new ArrayList<Transaction>(); // nuestra data es un msj
	public long timeStamp;
	public int nonce;

	// Block Constructor.
	public Block(String previousHash) {
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();

		this.hash = calculateHash(); // Making sure we do this after we set the other values.
	}

	// calcula el nuevo hash del contenido
	public String calculateHash() {
		String calculatedhash = StringUtil
				.applySha256(previousHash + Long.toString(timeStamp) + Integer.toString(nonce) + merkleRoot);
		return calculatedhash;
	}

	// incrementa en uno el valor antes de que el hash sea alcanzado
	public void mineBlock(int difficulty) {
		merkleRoot = StringUtil.getMerkleRoot(transactions);
		String target = StringUtil.getDificultyString(difficulty); // Crea un string con dificultad 0
		while (!hash.substring(0, difficulty).equals(target)) {
			nonce++;
			hash = calculateHash();
		}
		System.out.println("Bloque Minado!!! : " + hash);
	}

	// agrega transaccion al bloque
	public boolean addTransaction(Transaction transaction) {
		// procesa trx y chequea si es valido, a menos que el sea block genesis
		if (transaction == null)
			return false;
		if ((previousHash != "0")) {
			if ((transaction.processTransaction() != true)) {
				System.out.println("Transaction failed to process. Discarded.");
				return false;
			}
		}
		transactions.add(transaction);
		System.out.println("Transacción agregada al bloque");
		return true;
	}
}