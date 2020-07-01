package models;

public class Client {
//extends Utilisateur à ajouter ATTENTION
// Attributs de la classe Utilisateur à ajouter

	private String nom;
	private String prenom;

	private int id;
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

	public Client( int id, String nom, String prenom, String numeroCompte, String login, String motDePasse) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.numeroCompte = numeroCompte;
		this.login = login;
		this.motDePasse = motDePasse;
	}

	
	
	public Client(int id ,String nom, String prenom ) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}

	public int getId() {
		return id;
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

	public void setId(int id) {
		this.id = id;
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
		return "Client [id=" + id + ", numeroCompte=" + numeroCompte + ", login=" + login + ", motDePasse="
				+ motDePasse + "]";
	}

}
