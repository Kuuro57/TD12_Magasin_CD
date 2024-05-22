package main;

import java.io.IOException;

import donnees.CD;
import XML.ChargeurCD;

/**
 * un main permettant de charger un CD
 */
public class MainChargeurCD {

	/**
	 * methode principale qui charge un cd
	 * 
	 * @param args
	 *            inutilise
	 * @throws IOException
	 *             si fichier inexistant
	 */
	public static void main(String args[]) throws IOException {
		String nomFichier1 = "magasinCD_donnees/musicbrainzSimple/Benabar_Benabar.xml";
		String nomFichier2 = "magasinCD_donnees/musicbrainzSimple/Gorillaz_.xml";
		ChargeurCD charge1 = new ChargeurCD(nomFichier1);
		ChargeurCD charge2 = new ChargeurCD(nomFichier2);
		CD c1 = charge1.chargerCD();
		CD c2 = charge2.chargerCD();
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c1.getNomArtiste().compareTo(c2.getNomArtiste()));
	}

}
