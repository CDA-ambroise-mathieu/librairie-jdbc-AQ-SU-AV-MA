package models;

import lombok.Data;

@Data
public class Utilisateur {

	private int id_utilisateur;
	private String prenom;
	private String nom;
	private String role;
	private int num_compte;
	private String login;
	private String password;
	private boolean inscrit;
	
	public Utilisateur(int pId_utilisateur, String pPrenom, String pNom) {
		super();
		this.id_utilisateur = pId_utilisateur;
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
	
	public Utilisateur(String nom2, String prenom2, String role2, String num_compte2, String login2, String mdp,
			boolean b, boolean c) {
		// TODO Auto-generated constructor stub
	}

	public int getId_utilisateur() {
		return id_utilisateur;
	}
	public void setId(int pId_utilisateur) {
		id_utilisateur = pId_utilisateur;
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

}
