package donnees;

import java.util.ArrayList;

/**
 * La classe Magasin represente un magasin qui vend des CDs.</p>
 * 
 * cette classe est caracterisee par un ensemble de CDs correspondant aux CDS
 * vendus dans ce magasin.
 * 
 */
public class Magasin {

	/**
	 * la liste des CDs disponibles en magasin
	 */
	private ArrayList<CD> listeCds;

	/**
	 * construit un magasin par defaut qui ne contient pas de CD
	 */
	public Magasin() {
		listeCds = new ArrayList<CD>();
	}

	/**
	 * ajoute un cd au magasin
	 * 
	 * @param cdAAjouter
	 *            le cd a ajouter
	 */
	public void ajouteCd(CD cdAAjouter) {
		listeCds.add(cdAAjouter);
	}

	@Override
	/**
	 * affiche le contenu du magasin
	 */
	public String toString() {
		String chaineResultat = "";
		//parcours des Cds
		for (int i = 0; i < listeCds.size(); i++) {
			chaineResultat += listeCds.get(i);
		}
		chaineResultat += "nb Cds: " + listeCds.size();
		return (chaineResultat);

	}

	/**
	 * @return le nombre de Cds du magasin
	 */
	public int getNombreCds() {
		return listeCds.size();
	}
	
	/**
	 * permet d'acceder à un CD
	 * 
	 * @return le cd a l'indice i ou null si indice est non valide
	 */
	public CD getCd(int i)
	{
		CD res=null;
		if ((i>=0)&&(i<this.listeCds.size()))
			res=this.listeCds.get(i);
		return(res);
	}

	/**
	 * Méthode trierAriste qui tri les CD en fonction du nom de l'artiste
	 * @return une List de CDs
	 */
	public ArrayList<CD> trierAriste() {
		// Initialisation des variables
		ArrayList<CD> newListeCds = new ArrayList<>();
		String artiste1 = "";
		String artiste2 = "";
		boolean cdAjouter = false;
		// On boucle sur tous les cd du Magasin
		for (CD cd : this.listeCds) {
			// Si la nouvelle liste est vide
			if (newListeCds.isEmpty()) {
				// On ajoute le cd
				newListeCds.add(cd);
			}
			// Sinon
			else {
				// On récupère l'artiste du cd du Magasin
				artiste1 = cd.getNomArtiste();
				// On boucle sur la nouvelle liste
				for (int i = 0; i < newListeCds.size(); i++) {
					// Si on a pas ajouté de cd
					if (!cdAjouter) {
						// On récupère le cd qu'on regarde de la nouvelle liste
						CD cdNewListe = newListeCds.get(i);
						// On récupère l'artiste du cd de la nouvelle liste
						artiste2 = cdNewListe.getNomArtiste();
						// Si ils ont le même artiste
						if (artiste1.compareTo(artiste2) == 0) {
							// On ajoute le cd derrière celui qu'on regarde
							newListeCds.add(i, cd);
							cdAjouter = true;
						}
						// Si il a un plus petit nom (avant dans l'alphabet)
						if (artiste1.compareTo(artiste2) < 0) {
							// On ajoute le cd derrière celui qu'on regarde
							newListeCds.add(i, cd);
							cdAjouter = true;
						}
						// Si on est à la fin de la liste
						if (i == newListeCds.size() - 1) {
							// On ajoute à la fin de la liste le cd
							newListeCds.addLast(cd);
							cdAjouter = true;
						}
					}
				}
				// On remet le booléen cdAjouter à false
				cdAjouter = false;
			}
		}
		// On retourne la liste
		return newListeCds;
	}


	/**
	 * Méthode trierAriste qui tri les CD en fonction du nom de l'artiste
	 * @return une List de CDs
	 */
	public ArrayList<CD> trierAlbum() {
		// Initialisation des variables
		ArrayList<CD> newListeCds = new ArrayList<>();
		String artiste1 = "";
		String artiste2 = "";
		boolean cdAjouter = false;
		// On boucle sur tous les cd du Magasin
		for (CD cd : this.listeCds) {
			// Si la nouvelle liste est vide
			if (newListeCds.isEmpty()) {
				// On ajoute le cd
				newListeCds.add(cd);
			}
			// Sinon
			else {
				// On récupère le nom de l'album du cd du Magasin
				artiste1 = cd.getNomCD();
				System.out.println(artiste1);
				// On boucle sur la nouvelle liste
				for (int i = 0; i < newListeCds.size(); i++) {
					// Si on a pas ajouté de cd
					if (!cdAjouter) {
						// On récupère le cd qu'on regarde de la nouvelle liste
						CD cdNewListe = newListeCds.get(i);
						// On récupère le nom de l'album du cd de la nouvelle liste
						artiste2 = cdNewListe.getNomCD();
						System.out.println(artiste2);
						// Si ils ont le même artiste
						if (artiste1.compareTo(artiste2) == 0) {
							// On ajoute le cd derrière celui qu'on regarde
							newListeCds.add(i, cd);
							cdAjouter = true;
						}
						// Si il a un plus petit nom (avant dans l'alphabet)
						if (artiste1.compareTo(artiste2) < 0) {
							// On ajoute le cd derrière celui qu'on regarde
							newListeCds.add(i, cd);
							cdAjouter = true;
						}
						// Si on est à la fin de la liste
						if (i == newListeCds.size() - 1) {
							// On ajoute à la fin de la liste le cd
							newListeCds.addLast(cd);
							cdAjouter = true;
						}
					}
				}
				// On remet le booléen cdAjouter à false
				cdAjouter = false;
			}
		}
		// On retourne la liste
		return newListeCds;
	}

	public ArrayList<CD> trier(ComparateurCd comp) {
		// Initialisation des variables
		ArrayList<CD> newListeCds = new ArrayList<>();
		boolean cdAjouter = false;
		// Boucle sur les cd de la liste de l'objet
		for (CD cd : this.listeCds) {
			// Si la liste est vide
			if (newListeCds.isEmpty()) {
				// On ajoute le cd
				newListeCds.add(cd);
			}
			// Sinon
			else {
				// Boucle sur les cd de la nouvelles liste
				for (int i = 0; i < newListeCds.size(); i++) {
					// Si le cd est pas ajouté
					if (!cdAjouter) {
						// On compare avec le comparateur fourni en paramètre et si il est avant
						if (comp.etreAvant(cd, newListeCds.get(i))) {
							// On ajoute le cd avant le cd qu'on regarde de la nouvelle liste et on met le booléen à true
							newListeCds.add(i, cd);
							cdAjouter = true;
						}
						else if (i == newListeCds.size() - 1) {
							// On ajoute le cd à la fin de la nouvelle liste et on met le booléen à true
							newListeCds.addLast(cd);
							cdAjouter = true;
						}
					}
				}
				// On remet le booléen à false
				cdAjouter = false;
			}
		}
		return newListeCds;
	}
}
