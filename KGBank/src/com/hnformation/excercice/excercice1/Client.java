package com.hnformation.excercice.excercice1;

/**
 * @author jorji
 */
public class Client {
	// Excercice 1.1.1 Creation of the client class

	// The attributes
	private String name;
	private String firstName;
	private static int number = 0;
	private int clientNumber = 0;

	// constructors
	public Client() {
	}

	public Client(String name, String firstName) {
		this.name = name;
		this.firstName = firstName;
		this.clientNumber = number;
		number++;
	}

	// Methods -- Getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getClientNumber() {
		return clientNumber;
	}

	public void setClientNumber(int clientNumber) {
		this.clientNumber = clientNumber;
	}

	// Methods
	@Override
	public String toString() {
		return "Client [name=" + name + ", firstName=" + firstName + ", number=" + clientNumber + "]";
	}

}
