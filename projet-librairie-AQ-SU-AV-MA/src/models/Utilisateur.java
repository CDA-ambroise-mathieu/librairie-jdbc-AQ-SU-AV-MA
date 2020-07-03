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

	public Utilisateur(String pPrenom, String pNom, String pRole, int pNum_compte, String pLogin, String pPassword) {
		this.prenom = pPrenom;
		this.nom = pNom;
		this.role = pRole;
		this.num_compte = pNum_compte;
		this.login = pLogin;
		this.password = pPassword;
	}

	public Utilisateur(String pPrenom, String pNom) {
		super();
		this.prenom = pPrenom;
		this.nom = pNom;
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

	public Utilisateur(int pId_utilisateur, String pPrenom, String pNom, String pRole, int pNum_compte, String pLogin,
			String pPassword, boolean pInscrit) {
		super();
		this.id_utilisateur = pId_utilisateur;
		this.prenom = pPrenom;
		this.nom = pNom;
		this.role = pRole;
		this.num_compte = pNum_compte;
		this.login = pLogin;
		this.password = pPassword;
		this.inscrit = pInscrit;
	}

	public Utilisateur(int pId_utilisateur, String pPrenom, String pNom, String pRole, int pNum_compte, String pLogin,
			String pPassword) { // constructeur pour findById
		super();
		this.id_utilisateur = pId_utilisateur;
		this.prenom = pPrenom;
		this.nom = pNom;
		this.role = pRole;
		this.num_compte = pNum_compte;
		this.login = pLogin;
		this.password = pPassword;
	}
	

	public Utilisateur(String pLogin, String pPrenom, String pNom, String pRole, int pNum_compte,int pId_utilisateur,
			String pPassword) { // constructeur pour findByLogin
		super();
		this.id_utilisateur = pId_utilisateur;
		this.prenom = pPrenom;
		this.nom = pNom;
		this.role = pRole;
		this.num_compte = pNum_compte;
		this.login = pLogin;
		this.password = pPassword;
	}

}
