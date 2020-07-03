package models;

import java.util.List;

import lombok.Data;

@Data
public class Commande {

	private int id;
	private String dateCommande;
	private int nombreArticles;
	private List<Livre> designationArticles;
	private boolean annulee = false;
	private boolean enCoursLivraison = false;
	private boolean livree = false;

	public Commande() {

	}

	public Commande(List<Livre> pDesignationArticles) {
		this.designationArticles = pDesignationArticles;
	}

	public Commande(int pId, String pDateCommande, int pNombreArticles, boolean pLivree) {
		this.id = pId;
		this.dateCommande = pDateCommande;
		this.nombreArticles = pNombreArticles;
		this.livree = pLivree;
	}

}
