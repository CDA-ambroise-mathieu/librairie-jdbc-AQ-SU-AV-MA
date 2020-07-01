package models;

public class Libraire {

	private String nom;
	private String prenom;
	private int id;
	private final String role = " libraire";

	public Libraire() {

	}

	public Libraire(int id, String Nom, String Prenom) {

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Libraire [nom=" + nom + ", prenom=" + prenom + ", id=" + id + "]";
	}

	public String getRole() {
		return role;
	}

}
