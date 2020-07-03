package models;

import lombok.Data;

@Data
public class Utilisateur {

	private int id_utilisateur;
	private String nom;
	private String prenom;
	private String role;
	private String login;
	private String password;
	private boolean inscrit;
	private boolean masque;

	public Utilisateur(String nom, String prenom, String role, String login, String password, boolean inscrit,
			boolean masque) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.role = role;
		this.login = login;
		this.password = password;
		this.inscrit = inscrit;
		this.masque = masque;
	}

	public Utilisateur(int id_utilisateur, String nom, String prenom, String role, String login, String password,
			boolean inscrit, boolean masque) {
		super();
		this.id_utilisateur = id_utilisateur;
		this.nom = nom;
		this.prenom = prenom;
		this.role = role;
		this.login = login;
		this.password = password;
		this.inscrit = inscrit;
		this.masque = masque;
	}

	public Utilisateur() {
		super();
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

	public Utilisateur(int id_utilisateur, String nom, String prenom) {
		super();
		this.id_utilisateur = id_utilisateur;
		this.nom = nom;
		this.prenom = prenom;
	}

	public Utilisateur(int id_utilisateur, String nom, String prenom, String role, String login, String password) {
		super();
		this.id_utilisateur = id_utilisateur;
		this.nom = nom;
		this.prenom = prenom;
		this.role = role;
		this.login = login;
		this.password = password;
	}

}
