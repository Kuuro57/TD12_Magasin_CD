package main;

import java.io.IOException;
import java.util.Scanner;

import donnees.ComparateurAlbum;
import donnees.ComparateurArtiste;
import donnees.Magasin;
import XML.ChargeurMagasin;

/**
 * permet de charger un magasin de test
 */
public class MainChargeurMagasin {

	/**
	 * methode principale
	 * 
	 * @param args
	 *            inutilise
	 * @throws IOException
	 *             en cas de probleme de lecture entree/sortie
	 */
	public static void main(String args[]) throws IOException {

		String repertoire = "magasinCD_donnees/musicbrainzSimple/";
		ChargeurMagasin charge = new ChargeurMagasin(repertoire);
		Magasin resultat = charge.chargerMagasin();

		ComparateurArtiste compArtiste = new ComparateurArtiste();
		ComparateurAlbum compAlbum = new ComparateurAlbum();

		System.out.println(resultat.trier(compAlbum));


	}

}
