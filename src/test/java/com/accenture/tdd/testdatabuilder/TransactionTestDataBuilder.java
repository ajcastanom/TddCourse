package com.accenture.tdd.testdatabuilder;

import java.util.Date;

import com.accenture.tdd.model.Transaction;

public class TransactionTestDataBuilder {

	private Date date;
	private double amount;

	public TransactionTestDataBuilder() {
		this.date = new Date();
		this.amount = 2500000d;
	}

	public TransactionTestDataBuilder withDate(Date date) {
		this.date = date;
		return this;
	}

	public TransactionTestDataBuilder withAmount(Double amount) {
		this.amount = amount;
		return this;
	}

	public static TransactionTestDataBuilder aTransaction() {
		return new TransactionTestDataBuilder();
	}

	public Transaction build() {
		return new Transaction(this.date, this.amount);
	}

}
