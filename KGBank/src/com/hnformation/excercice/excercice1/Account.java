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

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	// Methods
	@Override
	public String toString() {
		return "Account [label=" + label + ", balance=" + balance + ", accountNumber=" + accountNumber + ", client="
				+ client.toString() + "]";
	}

}
