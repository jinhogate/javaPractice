/**
 *
 */
package com.hnformation.excercice.principale;

import java.util.Arrays;
import java.util.stream.Stream;

import com.hnformation.excercice.excercice1.Account;
import com.hnformation.excercice.excercice1.Client;
import com.hnformation.excercice.excercice1.CurrentAccount;
import com.hnformation.excercice.excercice1.SavingsAccount;

/**
 * @author jorji
 *
 */
public class MainTest {
	private static Client[] clientArray;
	private static Account[][] accountArray;

	/**
	 * Main method
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		clientArray = loadClientArray(5);
		displayClientArray(clientArray);

		accountArray = loadAccountArray(clientArray);
		displayAccountArray(accountArray);

	}

	/**
	 * This method loads clientArray
	 *
	 * @param arraySize size of clientArray
	 * @return clientArray filled
	 */
	private static Client[] loadClientArray(int arraySize) {
		Client[] clientArray = new Client[arraySize];
		final String NAME = "name";
		final String FIRSTNAME = "firstName";
		for (int i = 0; i < arraySize; i++) {
			clientArray[i] = new Client(NAME.concat("" + i), FIRSTNAME.concat("" + i));
		}
		return clientArray;
	}

	/**
	 * This method displays the clientArray
	 *
	 * @param clientArray
	 */
	private static void displayClientArray(Client[] clientArray) {
		Stream<Client> clientStream = Arrays.stream(clientArray);
		clientStream.forEach(client -> System.out.println(client.toString()));
	}

	/**
	 * this methods load accounts for all client
	 *
	 * @param clientArray
	 * @return
	 */
	private static Account[][] loadAccountArray(Client[] clientArray) {
		int counter = 0;
		final String SAVINGS_ACCOUNT_LABEL = "Savings_account";
		final String CURRENT_ACCOUNT_LABEL = "Current_account";
		Account[][] accountArray = new Account[2][clientArray.length];
		for (Client client : clientArray) {
			Account currentAccount = new CurrentAccount(CURRENT_ACCOUNT_LABEL, client);
			Account savingsAccount = new SavingsAccount(SAVINGS_ACCOUNT_LABEL, client);
			accountArray[0][counter] = currentAccount;
			accountArray[1][counter] = savingsAccount;
			counter++;
		}
		return accountArray;
	}

	/**
	 * This method displays the accountArray
	 *
	 * @param accountArray
	 */
	private static void displayAccountArray(Account[][] accountArray) {
		Stream<Account[]> accountStream = Arrays.stream(accountArray);
		accountStream.forEach(value -> {
			Arrays.stream(value).forEach(account -> System.out.println(account.toString()));
		});
	}

}
