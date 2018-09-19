package com.accenture.tdd.testdatabuilder;

import static com.accenture.tdd.testdatabuilder.TransactionTestDataBuilder.aTransaction;

import java.util.ArrayList;
import java.util.List;

import com.accenture.tdd.model.Account;
import com.accenture.tdd.model.Transaction;

public class AccountTestDataBuilder {

	private String type;
	private String number;
	private double balance;
	private List<Transaction> transactions;

	public AccountTestDataBuilder() {
		this.type = "ahorros";
		this.number = "008123456-90";
		this.balance = 5850000d;
		with(aTransaction());
	}

	public AccountTestDataBuilder withType(String type) {
		this.type = type;
		return this;
	}

	public AccountTestDataBuilder withNumber(String number) {
		this.number = number;
		return this;
	}

	public AccountTestDataBuilder withBalance(double balance) {
		this.balance = balance;
		return this;
	}

	public AccountTestDataBuilder with(TransactionTestDataBuilder... builders) {
		this.transactions = new ArrayList<>();

		for (TransactionTestDataBuilder builder : builders) {
			this.transactions.add(builder.build());
		}
		return this;
	}

	public Account build() {
		return new Account(this.type, this.number, this.balance, this.transactions);
	}

	public static AccountTestDataBuilder anAccount() {
		return new AccountTestDataBuilder();
	}
}
