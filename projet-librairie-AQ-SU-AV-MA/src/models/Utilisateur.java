package models;

import lombok.Data;

@Data
public class Utilisateur {

	private int id;
	private boolean inscrit = false;
	private String prenom;
	private String nom;

	public Utilisateur(int pIdentifiant, boolean pInscrit, String pPrenom, String pNom) {
		super();
		this.id = pIdentifiant;
		this.inscrit = pInscrit;
		this.prenom = pPrenom;
		this.nom = pNom;
	}

	public Utilisateur(boolean pInscrit, String pPrenom, String pNom) {
		super();
		this.inscrit = pInscrit;
		this.prenom = pPrenom;
		this.nom = pNom;
	}

	public Utilisateur(int pId, String pPrenom, String pNom) {
		super();
		this.id = pId;
		this.prenom = pPrenom;
		this.nom = pNom;
	}

	public Utilisateur() {
		super();
	}

}
