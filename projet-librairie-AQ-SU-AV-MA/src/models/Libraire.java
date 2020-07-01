package models;

public class Libraire extends Utilisateur {

	private Compte monCompte;
	private int id;
	private final String role = " libraire";

	public Libraire(int pId, String pPrenom, String pNom, Compte pMonCompte) {
		super(pId, pPrenom, pNom);
		this.monCompte = pMonCompte;
	}

	public Libraire() {

	}

	public Libraire(int pId, String pNom, String pPrenom) {
		super(pId, pPrenom, pNom);
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
		return "Libraire [id=" + id + ", role=" + role + ", Prenom()=" + getPrenom() + ", Nom =" + getNom() + "]";
	}

}