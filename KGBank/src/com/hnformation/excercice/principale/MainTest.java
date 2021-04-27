/**
 *
 */
package com.hnformation.excercice.principale;

import java.util.Arrays;
import java.util.Hashtable;
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
	private static Hashtable<Integer, Account> accountTable;

	/**
	 * Main method
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Display clientArray");
		clientArray = loadClientArray(5);
		displayClientArray(clientArray);

		System.out.println("Display accountArray");
		accountArray = loadAccountArray(clientArray);
		displayAccountArray(accountArray);

		System.out.println("Display HashTable");
		accountTable = loadAccountTable(accountArray);

		displayAccountTable(accountTable);
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

	/**
	 * @param accountArray
	 * @return a HastTable
	 */
	private static Hashtable<Integer, Account> loadAccountTable(Account[][] accountArray) {
		Hashtable<Integer, Account> accountTable = new Hashtable<>();
		Stream<Account[]> accountStream = Arrays.stream(accountArray);
		accountStream.forEach(value -> {
			Arrays.stream(value).forEach(account -> {
				double rand = Math.random() * 50;
				account.setBalance(rand);
				accountTable.put(account.getAccountNumber(), account);
			});
		});
		return accountTable;
	}

	/**
	 * This methods displays accountTable by ordered balance of account
	 *
	 * @param accountTable
	 */
	private static void displayAccountTable(Hashtable<Integer, Account> accountTable) {
		Stream<Account> accountStream = accountTable.values().stream();
		accountStream
				.sorted((Account account1, Account account2) -> comparer(account1.getBalance(), account2.getBalance()))
				.forEachOrdered(account -> System.out.println(account.toString()));
	}

	/**
	 * This method compares 2 values and return either negative or positive or 0
	 *
	 * @param a
	 * @param b
	 * @return
	 */
	private static int comparer(double a, double b) {
		double res = a - b;
		int retour = 0;
		if (res < 0) {
			retour = -1;
		} else if (res > 0) {
			retour = 1;
		}
		return retour;
	}

}
