package com.accenture.tdd.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.reflect.Whitebox;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.accenture.tdd.service.AccountService;
import com.accenture.tdd.testdatabuilder.AccountTestDataBuilder;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class AccountControllerTest {

	private MockMvc mockMvc;
	
	@InjectMocks
	private AccountController accountController;

	@Mock
	private AccountService service;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(accountController).build();
		Whitebox.setInternalState(accountController, "service", service);
	}

	@Test
	public void getAnAccountWithTwoTransactions() throws Exception {
		//Arrange
		String accountNumber = "12345678";
		when(service.getAccount(accountNumber)).thenReturn(AccountTestDataBuilder.anAccount().withNumber("12345678").build());
		
		//Act
		ResultActions result = mockMvc.perform(get("/getAnAccount")
									.param("accountNumber", accountNumber).param("ahorros", "ahorros"));
		
		//Assert
		result.andExpect(status().isOk())
			  .andExpect(jsonPath("$.type").value("ahorros"))
			  .andExpect(jsonPath("$.number").value(accountNumber));
	}

	@Test
	public void notFoundUri() throws Exception {
		//Arrange
		String accountNumber = "008123456-90";
		
		//Act
		ResultActions result = mockMvc.perform(get("/getAnAccounts").content(accountNumber));
		
		//Assert
		result.andExpect(status().isNotFound());
	}

	@Test
	public void badRequest() throws Exception {
		//Act
		
		//Arrange
		ResultActions result = mockMvc.perform(get("/getAnAccount"));
		
		//Assert
		result.andExpect(status().isBadRequest());
	}
}
