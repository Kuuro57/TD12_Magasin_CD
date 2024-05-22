package test;

import XML.ChargeurMagasin;
import donnees.*;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestMagasin {

    @Test
    public void test_trierArtiste() throws FileNotFoundException {

        // Initialisation
        String repertoire = "magasinCD_donnees/musicbrainzSimpleTest/";
        ChargeurMagasin charge = new ChargeurMagasin(repertoire);
        Magasin resultat = charge.chargerMagasin();

        // Appel de la méthode
        ArrayList<CD> liste = resultat.trierAriste();
        String artiste1 = liste.get(0).getNomArtiste();
        String artiste2 = liste.get(1).getNomArtiste();
        String artiste3 = liste.get(2).getNomArtiste();

        // Vérifications
        assertEquals("Benabar", artiste1, "Le premier artiste devrait être Bénabar !");
        assertEquals("The Meters", artiste2, "Le deuxième artiste devrait être The Meters !");
        assertEquals("Zebda", artiste3, "Le troisième artiste devrait être Zebda !");

    }

    @Test
    public void test_trierAlbum() throws FileNotFoundException {

        // Initialisation
        String repertoire = "magasinCD_donnees/musicbrainzSimpleTest/";
        ChargeurMagasin charge = new ChargeurMagasin(repertoire);
        Magasin resultat = charge.chargerMagasin();

        // Appel de la méthode
        ArrayList<CD> liste = resultat.trierAlbum();
        String album1 = liste.get(0).getNomCD();
        String album2 = liste.get(1).getNomCD();
        String album3 = liste.get(2).getNomCD();

        // Vérifications
        assertEquals("Benabar", album1, "Le premier album devrait être Benabar !");
        assertEquals("Essence ordinaire", album2, "Le deuxième album devrait être The Meters !");
        assertEquals("The Meters", album3, "Le troisième album devrait être Essence ordinaire !");

    }

}
