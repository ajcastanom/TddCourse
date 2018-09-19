package com.accenture.tdd.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.accenture.tdd.TddApplication;
import com.accenture.tdd.repository.AccountRepository;
import com.accenture.tdd.service.AccountService;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TddApplication.class)
public class AccountControllerTest {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mockMvc;

	@Mock
	private AccountService service;

	@Mock
	private AccountRepository repository;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void getAnAccountWithTwoTransactionsTest() throws Exception {
		String accountNumber = "008123456-90";
		mockMvc.perform(get("/getAnAccount").content(accountNumber)).andExpect(status().isOk())
				.andExpect(jsonPath("$.type").value("ahorros")).andExpect(jsonPath("$.number").value(accountNumber));
	}

	@Test
	public void notFoundUriTest() throws Exception {
		String accountNumber = "008123456-90";
		mockMvc.perform(get("/getAnAccounts").content(accountNumber)).andExpect(status().isNotFound());
	}

	@Test
	public void badRequestTest() throws Exception {
		mockMvc.perform(get("/getAnAccount")).andExpect(status().isBadRequest());
	}
}
