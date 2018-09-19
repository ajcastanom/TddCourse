package com.accenture.tdd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.accenture.tdd.model.Account;
import com.accenture.tdd.repository.AccountRepository;

@Component
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	public Account getAccount(String accountNumber) {
		return this.accountRepository.findAccount(accountNumber);
	}

}
