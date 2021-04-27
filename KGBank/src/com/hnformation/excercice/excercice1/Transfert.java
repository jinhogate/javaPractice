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
	private double account;

	// Constructor
	public Transfert() {
		super();
	}

	public Transfert(double account) {
		super();
		this.account = account;
	}

	// Getter&setter
	protected double getAccount() {
		return account;
	}

	protected void setAccount(double account) {
		this.account = account;
	}

}
