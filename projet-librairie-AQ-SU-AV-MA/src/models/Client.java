package models;

public class Client {
//extends Utilisateur à ajouter ATTENTION
// Attributs de la classe Utilisateur à ajouter

	private String nom;
	private String prenom;

	private int idBDD;
	private String numeroCompte;
	private String login;
	private String motDePasse;
	private final String role = "client";

	public Client(String nom, String prenom, String numeroCompte, String login, String motDePasse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.numeroCompte = numeroCompte;
		this.login = login;
		this.motDePasse = motDePasse;
	}

	public Client(String nom, String prenom, int idBDD, String numeroCompte, String login, String motDePasse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.idBDD = idBDD;
		this.numeroCompte = numeroCompte;
		this.login = login;
		this.motDePasse = motDePasse;
	}

	
	
	public Client(int idBDD ,String nom, String prenom ) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.idBDD = idBDD;
	}

	public int getIdBDD() {
		return idBDD;
	}

	public String getNumeroCompte() {
		return numeroCompte;
	}

	public String getLogin() {
		return login;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getRole() {
		return role;
	}

	public void setIdBDD(int idBDD) {
		this.idBDD = idBDD;
	}

	public void setNumeroCompte(String numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		return "Client [idBDD=" + idBDD + ", numeroCompte=" + numeroCompte + ", login=" + login + ", motDePasse="
				+ motDePasse + "]";
	}

}
