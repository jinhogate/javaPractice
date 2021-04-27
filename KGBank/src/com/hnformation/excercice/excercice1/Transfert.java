/**
 * 
 */
package com.hnformation.excercice.excercice1;

/**
 * @author jorji
 *
 */
public class Transfert extends Flow {
	// Attributes
	private int accountIssuing;

	// Constructor
	public Transfert() {
		super();
	}

	public Transfert(int account) {
		super();
		this.accountIssuing = account;
	}

	// Getter&setter
	protected double getAccount() {
		return accountIssuing;
	}

	protected void setAccount(int account) {
		this.accountIssuing = account;
	}

}
