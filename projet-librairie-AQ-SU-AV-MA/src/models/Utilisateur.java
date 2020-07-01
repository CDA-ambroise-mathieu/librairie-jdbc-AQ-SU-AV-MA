package models;

import lombok.Data;

@Data
public class Utilisateur {

	private int id;
	private boolean inscrit = false; // comme ça pas d'ambiguïté même si sa valeur par défaut est false 
	private String prenom;
	private String nom;
	
	public Utilisateur(int pId, boolean pInscrit, String pPrenom, String pNom) {
		super();
		this.id = pId;
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
	
	public int getId() {
		return id;
	}
	public void setId(int pId) {
		id = pId;
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
