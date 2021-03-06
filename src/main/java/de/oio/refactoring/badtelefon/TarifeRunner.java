package de.oio.refactoring.badtelefon;

import java.util.Arrays;
import java.util.Random;

import de.oio.refactoring.badtelefon.output.ConsoleOutputter;

public class TarifeRunner {
	public static void main(String args[]) {
		new TarifeRunner().run();
	}

	public void run() {
		Random random = getRandom();

		for(Integer tarif : Arrays.asList(Tarif.PRIVAT, Tarif.BUSINESS, Tarif.PROFI)) {
			System.out.println(String.format("\nVerarbeitung von Tarif %s", tarif));
			Kunde k = new Kunde(tarif, new ConsoleOutputter());
			
			for(int i = 0; i < 10; i++) {
				k.account(random.nextInt(5 + 1), random.nextInt(24), random.nextInt(60));
			}
			
			System.out.println("Abrechnung: " + k.getGebuehr());
		}
	}

	protected Random getRandom() {
		return new Random();
	}
}
