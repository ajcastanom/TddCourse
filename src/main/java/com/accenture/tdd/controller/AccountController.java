package com.accenture.tdd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.tdd.model.Account;
import com.accenture.tdd.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	private AccountService service;

	@RequestMapping(value = "/getAnAccount", method = RequestMethod.GET)
	public Account getAccount(@RequestParam("accountNumber") String accountNumber) {
		return this.service.getAccount(accountNumber);

	}
}
