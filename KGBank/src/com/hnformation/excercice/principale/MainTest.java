/**
 *
 */
package com.hnformation.excercice.principale;

import java.util.Arrays;
import java.util.stream.Stream;

import com.hnformation.excercice.excercice1.Client;

/**
 * @author jorji
 *
 */
public class MainTest {
	static private Client[] clientArray = { new Client() };

	/**
	 * Excercice 1.1.2 creation of main class for tests
	 *
	 * Main method
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		clientArray = loadClientArray(5);
		displayClientArray(clientArray);
	}

	/**
	 * This method loads clientArray
	 *
	 * @param arraySize size of clientArray
	 * @return clientArray filled
	 */
	private static Client[] loadClientArray(int arraySize) {
		clientArray = new Client[arraySize];
		final String NAME = "name";
		final String FIRSTNAME = "firstName";
		for (int i = 0; i < arraySize; i++) {
			clientArray[i] = new Client(NAME.concat("" + i), FIRSTNAME.concat("" + i));
		}
		return clientArray;
	}

	/**
	 * This method displays the clientArray
	 */
	private static void displayClientArray(Client[] clientArray) {
		Stream<Client> clientStream = Arrays.stream(clientArray);
		clientStream.forEach(client -> System.out.println(client.toString()));
	}

}
