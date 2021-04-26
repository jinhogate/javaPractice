package com.hnformation.excercice.excercice1;

/**
 * @author jorji
 */
public class Client {
	// Excercice 1.1.1 Creation of the client class

	// The attributes
	private String name;
	private String firstName;
	private static int number;

	// constructors
	public Client() {
	}

	public Client(String name, String firstName) {
		this.name = name;
		this.firstName = firstName;
		Client.number++;
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

	public static int getNumber() {
		return number;
	}

	public static void setNumber(int number) {
		Client.number = number;
	}

	// Methods
	@Override
	public String toString() {
		return "Client [name=" + name + ", firstName=" + firstName + ", numeber=" + number + "]";
	}

}
