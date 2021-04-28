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
	public int getAccountIssuing() {
		return accountIssuing;
	}

	public void setAccountIssuing(int accountIssuing) {
		this.accountIssuing = accountIssuing;
	}

}
