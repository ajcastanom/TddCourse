package com.accenture.tdd.model;

import java.util.List;

public class Account {

	private String type;
	private String number;
	private double balance;
	private List<Transaction> transactions;

	public Account(String type, String number, double balance, List<Transaction> transactions) {
		this.type = type;
		this.number = number;
		this.balance = balance;
		this.transactions = transactions;
	}

	public Account() {
		// TODO Auto-generated constructor stub
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

}
