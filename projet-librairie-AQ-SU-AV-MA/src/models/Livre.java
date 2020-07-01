package models;

import lombok.Data;

@Data
public class Livre {

	private int idBDD;
	private String libelle;
	private String titre;
	private String auteur;
	private String edition;
	private String anneeParution;
	private int quantiteEnStock;
	private double prixUnitaire;

	// Constructeur sans autoincr idBDD
	public Livre(String libelle, String titre, String auteur, String edition, String anneeParution, int quantiteEnStock,
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
	public Livre(int idBDD, String libelle, String titre, String auteur, String edition, String anneeParution,
			int quantiteEnStock, double prixUnitaire) {
		this.idBDD = idBDD;
		this.libelle = libelle;
		this.titre = titre;
		this.auteur = auteur;
		this.edition = edition;
		this.anneeParution = anneeParution;
		this.quantiteEnStock = quantiteEnStock;
		this.prixUnitaire = prixUnitaire;
	}

}
