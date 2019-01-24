package com.accenture.tdd.model;

import java.util.Date;

public class Transaction {

	private Date date;
	private double amount;

	public Transaction(Date date, double amount) {
		this.date = date;
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
