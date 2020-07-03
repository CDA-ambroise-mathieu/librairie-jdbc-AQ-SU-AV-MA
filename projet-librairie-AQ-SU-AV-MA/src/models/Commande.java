package models;

import java.util.List;

import lombok.Data;

@Data
public class Commande {

	private int id;
	private String dateCommande;
	private int nombreArticles;
	private List<Livre> designationArticles;
	private int etat; // ce nombre doit être compris entre 1et 5 en fonction de l'avancement de la
						// commande.

	public Commande() {

	}

	public Commande(List<Livre> pDesignationArticles) {
		this.designationArticles = pDesignationArticles;
	}

	public Commande(int pId, String pDateCommande, int pNombreArticles, int pEtat) {
		this.id = pId;
		this.dateCommande = pDateCommande;
		this.nombreArticles = pNombreArticles;
		if (pEtat > 0 && pEtat < 6) {
			this.etat = pEtat;
		} else {
			System.out.println("Saisissez un chiffre entre 1 et 5 compris.");
		}
	}

}
