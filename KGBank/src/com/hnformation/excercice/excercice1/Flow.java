/**
 * 
 */
package com.hnformation.excercice.excercice1;

import java.time.LocalDateTime;

/**
 * @author jorji
 *
 */
public abstract class Flow {
	// Attributs
	private String comment;
	private int identifier = 0;
	private double amount;
	private int targetAccountNumber;
	private boolean effect;
	private LocalDateTime flowDate;
	private static int identifierValue = 0;

	// constructors
	public Flow() {
		identifier = identifierValue;
		identifierValue++;
	}

	public Flow(String comment, int identifier, double amount, int targetAccountNumber, boolean effect,
			LocalDateTime flowDate) {
		this.comment = comment;
		this.identifier = identifier;
		this.amount = amount;
		this.targetAccountNumber = targetAccountNumber;
		this.effect = effect;
		this.flowDate = flowDate;
	}

	// getters & setters
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getIdentifier() {
		return identifier;
	}

	public void setIdentifier(int identifier) {
		this.identifier = identifier;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getTargetAccountNumber() {
		return targetAccountNumber;
	}

	public void setTargetAccountNumber(int targetAccountNumber) {
		this.targetAccountNumber = targetAccountNumber;
	}

	public boolean isEffect() {
		return effect;
	}

	public void setEffect(boolean effect) {
		this.effect = effect;
	}

	public LocalDateTime getFlowDate() {
		return flowDate;
	}

	public void setFlowDate(LocalDateTime flowDate) {
		this.flowDate = flowDate;
	}

	// Methods
	@Override
	public String toString() {
		return "Flow [comment=" + comment + ", identifier=" + identifier + ", amount=" + amount
				+ ", targetAccountNumber=" + targetAccountNumber + ", effect=" + effect + ", flowDate=" + flowDate
				+ "]";
	}

}
