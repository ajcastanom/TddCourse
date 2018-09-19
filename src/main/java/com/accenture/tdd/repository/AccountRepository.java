package com.accenture.tdd.repository;

import org.springframework.stereotype.Component;

import com.accenture.tdd.model.Account;
import static com.accenture.tdd.testdatabuilder.AccountTestDataBuilder.anAccount;
import static com.accenture.tdd.testdatabuilder.TransactionTestDataBuilder.aTransaction;

@Component
public class AccountRepository {

	public Account findAccount(String accountNumber) {
		return anAccount().withNumber(accountNumber).with(aTransaction(), aTransaction().withAmount(5000000d)).build();
	}

}
