package models;

import lombok.Data;

@Data
public class Livre {

	private int id;
	private String libelle;
	private String titre;
	private String auteur;
	private String edition;
	private int anneeParution;
	private int quantiteEnStock;
	private double prixUnitaire;

	// Constructeur sans autoincr idBDD
	public Livre(String libelle, String titre, String auteur, String edition, int anneeParution, int quantiteEnStock,
			double prixUnitaire) {
		this.libelle = libelle;
		this.titre = titre;
		this.auteur = auteur;
		this.edition = edition;
		this.anneeParution = anneeParution;
		this.quantiteEnStock = quantiteEnStock;
		this.prixUnitaire = prixUnitaire;
	}

	// Constructeur avec id pour BDD auto incr
	public Livre(int id, String libelle, String titre, String auteur, String edition, int anneeParution,
			int quantiteEnStock, double prixUnitaire) {
		this.id = id;
		this.libelle = libelle;
		this.titre = titre;
		this.auteur = auteur;
		this.edition = edition;
		this.anneeParution = anneeParution;
		this.quantiteEnStock = quantiteEnStock;
		this.prixUnitaire = prixUnitaire;
	}

}
