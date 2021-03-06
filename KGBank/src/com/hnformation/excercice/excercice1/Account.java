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
	protected double balance = 0.0;
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

	public void setBalance(Flow flow) {
		if (flow instanceof Transfert) {
			Transfert transfert = (Transfert) flow;
			if (this.accountNumber == transfert.getTargetAccountNumber()) {
				this.balance += transfert.getAmount();
			}
			if (this.accountNumber == transfert.getAccountIssuing()) {
				this.balance -= transfert.getAmount();
			}
		} else if (flow instanceof Credit) {
			Credit credit = (Credit) flow;
			this.balance += credit.getAmount();
		} else {
			Debit debit = (Debit) flow;
			this.balance -= debit.getAmount();
		}
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
