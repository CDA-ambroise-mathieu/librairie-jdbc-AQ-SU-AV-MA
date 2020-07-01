package models;

public class Personne {

	private String nom;
	private String prenom;
	private static int id = 0;

	public Personne() {
		id++;
	}

	public Personne(String pNom, String pPrenom) {
		this.nom = pNom;
		this.prenom = pPrenom;
		id++;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + "]";
	}

	public int getId() {
		return id;
	}

}
