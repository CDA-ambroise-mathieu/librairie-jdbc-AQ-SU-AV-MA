package models;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class Commande {

	private int id;
	private Date dateCommande;
	private int nombreArticles;
	private Map<Livre,Integer> designationArticles;
	private int etat; // ce nombre doit être compris entre 1et 5 en fonction de l'avancement de la
						// commande.
	private int id_utilisateur;
	private double prix_total;

	public Commande() {
		designationArticles = new HashMap<>();
	}

	public Commande(int pId, Date pDateCommande, int pNombreArticles, int pEtat, int pId_utilisateur) {
		this.id = pId;
		this.dateCommande = pDateCommande;
		this.nombreArticles = pNombreArticles;
		if (pEtat > 0 && pEtat < 6) {
			this.etat = pEtat;
		} else {
			System.out.println("Saisissez un chiffre entre 1 et 5 compris.");
		}
		this.id_utilisateur = pId_utilisateur;
	}

	public Map<Livre,Integer> getDesignationArticles(){
		return this.designationArticles;
	}
	
	public void ajouterCommande(Livre l, int nb) {
		if(designationArticles.containsKey(l)) {
			designationArticles.put(l,designationArticles.get(l)+nb);
		}else {
			designationArticles.put(l,nb);
		}
	}
}
