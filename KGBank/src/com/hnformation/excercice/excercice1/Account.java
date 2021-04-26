/**
 *
 */
package com.hnformation.excercice.excercice1;

/**
 * @author jorji
 *
 */
public abstract class Account {
	// 1.2.1 Creation of the account class
	// attributs
	protected String label;
	protected double balance;
	protected int accountNumber = 0;
	protected static int number = 0;
	protected Client client;

	// Constructors

	public Account() {
	}

	public Account(String label, Client client) {
		this.label = label;
		this.client = client;
		accountNumber = number;
		number++;
	}

	// Getter & setter

	protected String getLabel() {
		return label;
	}

	protected void setLabel(String label) {
		this.label = label;
	}

	protected double getBalance() {
		return balance;
	}

	protected void setBalance(double balance) {
		this.balance = balance;
	}

	protected int getAccountNumber() {
		return accountNumber;
	}

	protected void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	protected Client getClient() {
		return client;
	}

	protected void setClient(Client client) {
		this.client = client;
	}

	// Methods
	@Override
	public String toString() {
		return "Account [label=" + label + ", balance=" + balance + ", accountNumber=" + accountNumber + ", client="
				+ client.toString() + "]";
	}

}
