package com.myproject.first;

import java.util.List;
import java.util.stream.Stream;

public class GitTest {
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] tab = { 12, 14, 58 };
		Operation op = new Operateur();
		op.afficher();
		int res = op.calculer(15, 17);
		System.out.println("Calcul = " + res);
		String message = Operation.trouver(tab, 14) == -1 ? "pas trouvé!" : "trouvé!";
		System.out.println("Message : " + message);
		List<Integer> numbers = List.of(1, 24, 50);
		Stream<Integer> streamNumbers = numbers.stream();
		streamNumbers.forEach(valeur -> System.out.println("Valeur liste = " + valeur));
		op.afficherAgain();
	}
}
