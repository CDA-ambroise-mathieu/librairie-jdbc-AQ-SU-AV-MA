package models;

public class Client extends Utilisateur {
//extends Utilisateur à ajouter ATTENTION
// Attributs de la classe Utilisateur à ajouter

	private Compte monCompte;
	private int id;
	private final String role = "client";

	public Client(int pId, String pPrenom, String pNom, Compte pMonCompte) {
		super(pId, pPrenom, pNom);
		this.monCompte = pMonCompte;
	}

	public Client(int pId, String pPrenom, String pNom) {
		super(pId, pPrenom, pNom);
	}

	public Client() {
	}

	public Compte getMonCompte() {
		return monCompte;
	}

	public void setMonCompte(Compte monCompte) {
		this.monCompte = monCompte;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	@Override
	public String toString() {
		return "Client [monCompte=" + monCompte + ", id=" + id + ", role=" + role + "]";
	}

}
