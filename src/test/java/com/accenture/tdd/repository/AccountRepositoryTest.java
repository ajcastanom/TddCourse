package com.accenture.tdd.repository;

import static com.accenture.tdd.testdatabuilder.AccountTestDataBuilder.anAccount;
import static com.accenture.tdd.testdatabuilder.TransactionTestDataBuilder.aTransaction;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.accenture.tdd.model.Account;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class AccountRepositoryTest {

	@InjectMocks
	private AccountRepository accountRepository;

	@Test
	public void getAnAccountWithTwoTransactionsTest() {

		// Arrange
		Account expected = anAccount().with(aTransaction(), aTransaction().withAmount(5000000d)).build();
		// Act
		Account actual = this.accountRepository.findAccount("008123456-90");
		// Assert
		assertEquals(expected.getNumber(), actual.getNumber());
		assertEquals(2, actual.getTransactions().size());
	}
}
