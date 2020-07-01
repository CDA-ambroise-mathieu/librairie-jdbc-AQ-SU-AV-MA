package models;

public class Livre {

	private int idBDD;
	private String libelle;
	private String titre;
	private String auteur;
	private String edition;
	private String parution;
	private int quantiteEnStock;
	private double prixUnitaire;

	// Constructeur sans autoincr idBDD
	public Livre(String libelle, String titre, String auteur, String edition, String parution, int quantiteEnStock,
			double prixUnitaire) {
		this.libelle = libelle;
		this.titre = titre;
		this.auteur = auteur;
		this.edition = edition;
		this.parution = parution;
		this.quantiteEnStock = quantiteEnStock;
		this.prixUnitaire = prixUnitaire;
	}

	// Constructeur avec id pour BDD auto incr
	public Livre(int idBDD, String libelle, String titre, String auteur, String edition, String parution,
			int quantiteEnStock, double prixUnitaire) {
		this.idBDD = idBDD;
		this.libelle = libelle;
		this.titre = titre;
		this.auteur = auteur;
		this.edition = edition;
		this.parution = parution;
		this.quantiteEnStock = quantiteEnStock;
		this.prixUnitaire = prixUnitaire;
	}

	public int getIdBDD() {
		return idBDD;
	}

	public void setIdBDD(int idBDD) {
		this.idBDD = idBDD;
	}
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getParution() {
		return parution;
	}

	public void setParution(String parution) {
		this.parution = parution;
	}

	public int getQuantiteEnStock() {
		return quantiteEnStock;
	}

	public void setQuantiteEnStock(int quantiteEnStock) {
		this.quantiteEnStock = quantiteEnStock;
	}

	public double getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	@Override
	public String toString() {
		return "Livre [libelle=" + libelle + ", titre=" + titre + ", auteur=" + auteur + ", edition=" + edition
				+ ", parution=" + parution + ", quantiteEnStock=" + quantiteEnStock + ", prixUnitaire=" + prixUnitaire
				+ "]";
	}

	

}
