package de.oio.refactoring.badtelefon;

import de.oio.refactoring.badtelefon.output.Outputter;

public class Kunde {
	double gebuehr = 0.0;
	Tarif tarif;
	private final Outputter outputter;

	public Kunde(int tarifArt, Outputter outputter) {
		this.tarif = new Tarif(tarifArt);
		this.outputter = outputter;
	}

	public void account(int minuten, int stunde, int minute) {
		outputter.writeLine(String.format("Berechne Gespr�ch mit %02d min um %02d:%02d mit Tarif %s", minuten, stunde, minute, tarif.tarif));
		double preis = 0;

		boolean mondschein = isMondschein(stunde);

		// Gespraechspreis ermitteln
		switch (tarif.tarif) {
		case Tarif.PRIVAT:
			minuten = minuten - 1;
			minuten = minuten < 0 ? 0 : minuten;
			if (mondschein)
				preis = minuten * 0.69;
			else
				preis = minuten * 1.99;
			break;

		case Tarif.BUSINESS:
			if (mondschein)
				preis = minuten * 0.79;
			else
				preis = minuten * 1.29;
			break;

		case Tarif.PROFI:
			preis = minuten * 0.69;
			break;

		}
		outputter.writeLine(String.format("Preis f�r das Gespr�ch: %.2f", preis));
		
		gebuehr += preis;
		outputter.writeLine(String.format("Gesamtgeb�hr nach Gespr�ch um %02d:%02d (Mondscheinzeit: %s): %.2f", stunde, minute, mondschein, gebuehr));
	}

	private static boolean isMondschein(int stunde) {
		return stunde < 9 || stunde > 18;
	}

	public double getGebuehr() {
		return gebuehr;
	}

}
