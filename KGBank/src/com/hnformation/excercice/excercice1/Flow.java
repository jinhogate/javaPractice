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
	private int identifier;
	private double amount;
	private int targetAccountNumber;
	private boolean effect;
	private LocalDateTime flowDate;

	// constructors
	public Flow() {
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
	protected String getComment() {
		return comment;
	}

	protected void setComment(String comment) {
		this.comment = comment;
	}

	protected int getIdentifier() {
		return identifier;
	}

	protected void setIdentifier(int identifier) {
		this.identifier = identifier;
	}

	protected double getAmount() {
		return amount;
	}

	protected void setAmount(double amount) {
		this.amount = amount;
	}

	protected int getTargetAccountNumber() {
		return targetAccountNumber;
	}

	protected void setTargetAccountNumber(int targetAccountNumber) {
		this.targetAccountNumber = targetAccountNumber;
	}

	protected boolean isEffect() {
		return effect;
	}

	protected void setEffect(boolean effect) {
		this.effect = effect;
	}

	protected LocalDateTime getFlowDate() {
		return flowDate;
	}

	protected void setFlowDate(LocalDateTime flowDate) {
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
