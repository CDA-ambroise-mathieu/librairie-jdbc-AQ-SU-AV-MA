package models;

import lombok.Data;

@Data
public class Utilisateur {

	private int id;
	private boolean inscrit;
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
	public Utilisateur(String pPrenom, String pNom) {
		super();
		this.prenom = pPrenom;
		this.nom = pNom;
	}
	public Utilisateur() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int pIdentifiant) {
		id = pIdentifiant;
	}
	public boolean isInscrit() {
		return inscrit;
	}
	public void setInscrit(boolean pInscrit) {
		this.inscrit = pInscrit;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String pPrenom) {
		this.prenom = pPrenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String pNom) {
		this.nom = pNom;
	}
	@Override
	public String toString() {
		return "Utilisateur [inscrit=" + inscrit + ", prenom=" + prenom + ", nom=" + nom + "]";
	}

}
