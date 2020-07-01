package models;

import java.util.List;

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

	public String getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(String dateCommande) {
		this.dateCommande = dateCommande;
	}

	public int getNombreArticles() {
		return nombreArticles;
	}

	public void setNombreArticles(int nombreArticles) {
		this.nombreArticles = nombreArticles;
	}

	public List<Livre> getDesignationArticles() {
		return designationArticles;
	}

	public void setDesignationArticles(List<Livre> designationArticles) {
		this.designationArticles = designationArticles;
	}

	public boolean isAnnulee() {
		return annulee;
	}

	public void setAnnulee(boolean annulee) {
		this.annulee = annulee;
	}

	public boolean isEnCoursLivraison() {
		return enCoursLivraison;
	}

	public void setEnCoursLivraison(boolean enCoursLivraison) {
		this.enCoursLivraison = enCoursLivraison;
	}

	public boolean isLivree() {
		return livree;
	}

	public void setLivree(boolean livree) {
		this.livree = livree;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
