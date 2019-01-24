package com.accenture.tdd.service;

import static com.accenture.tdd.testdatabuilder.AccountTestDataBuilder.anAccount;
import static com.accenture.tdd.testdatabuilder.TransactionTestDataBuilder.aTransaction;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.accenture.tdd.model.Account;
import com.accenture.tdd.repository.AccountRepository;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {

	@InjectMocks
	private AccountService service;

	@Mock
	private AccountRepository accountRepository;

	@Test
	public void getAnAccountWithTwoTransactions() {

		// Arrange
		Account expected = anAccount().with(aTransaction(), aTransaction().withAmount(5000000d)).build();
		// Act
		when(this.accountRepository.findAccount("008123456-90")).thenReturn(expected);
		Account actual = this.service.getAccount("008123456-90");
		// Assert
		assertEquals(expected, actual);
	}
}
