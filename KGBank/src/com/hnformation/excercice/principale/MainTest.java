/**
 *
 */
package com.hnformation.excercice.principale;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Optional;
import java.util.stream.Stream;

import com.hnformation.excercice.excercice1.Account;
import com.hnformation.excercice.excercice1.Client;
import com.hnformation.excercice.excercice1.Credit;
import com.hnformation.excercice.excercice1.CurrentAccount;
import com.hnformation.excercice.excercice1.Debit;
import com.hnformation.excercice.excercice1.Flow;
import com.hnformation.excercice.excercice1.SavingsAccount;
import com.hnformation.excercice.excercice1.Transfert;

/**
 * @author jorji
 *
 */
public class MainTest {
	private static Client[] clientArray;
	private static Account[][] accountArray;
	private static Hashtable<Integer, Account> accountTable;
	private static Flow[] flowArray;

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

		accountTable = loadAccountTable(accountArray);
		flowArray = loadFlowArray();
		updateBalance(flowArray, accountTable);
		System.out.println("Display accountTable");
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

	/**
	 * This method allows us to load the flow
	 *
	 * @return
	 */
	private static Flow[] loadFlowArray() {
		int size = 1 + accountArray[0].length + accountArray[1].length + 1;
		int compteur = 0;
		// Adds debit flow
		Flow[] flow = new Flow[size];
		Flow debitAccount1 = new Debit();
		debitAccount1.setAmount(50);
		debitAccount1.setTargetAccountNumber(1);
		flow[compteur] = debitAccount1;

		// Adds credit flow on all current accounts
		for (Account currentAccount : accountArray[0]) {
			compteur++;
			Flow credit = new Credit();
			credit.setAmount(100.5);
			credit.setTargetAccountNumber(currentAccount.getAccountNumber());
			flow[compteur] = credit;
		}

		// Adds credit flow on all savings account
		for (Account savingsAccount : accountArray[1]) {
			compteur++;
			Flow credit = new Credit();
			credit.setAmount(1500);
			credit.setTargetAccountNumber(savingsAccount.getAccountNumber());
			flow[compteur] = credit;
		}

		// Adds transfert flow
		Transfert transfert = new Transfert();
		transfert.setAmount(50);
		transfert.setTargetAccountNumber(2);
		transfert.setAccountIssuing(1);
		flow[++compteur] = transfert;

		// Adds a date flow to each flow
		LocalDateTime dateFlow = LocalDateTime.now().plusDays(2);
		for (Flow flowAccount : flow) {
			flowAccount.setFlowDate(dateFlow);
		}

		return flow;
	}

	/**
	 * This methods updates each balance of the accounts through the flows
	 * 
	 * @param flow
	 * @param accountTable
	 */
	private static void updateBalance(Flow[] flow, Hashtable<Integer, Account> accountTable) {
		for (Flow flowAccount : flow) {
			if (flowAccount instanceof Transfert) {// Specify the accountIssuing if the flow is a Transfert
				accountTable.get(((Transfert) flowAccount).getAccountIssuing()).setBalance(flowAccount);
			}
			accountTable.get(flowAccount.getTargetAccountNumber()).setBalance(flowAccount);
		}

		Stream<Account> accountStream = accountTable.values().stream();
		Optional<Account> optionalAccount = accountStream.filter(account -> account.getBalance() < 0).findAny();
		if (optionalAccount.isPresent()) {
			System.out.println("There is an account with negative  balance");
		}
	}

}
