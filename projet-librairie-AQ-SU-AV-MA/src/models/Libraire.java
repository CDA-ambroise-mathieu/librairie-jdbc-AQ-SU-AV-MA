package models;

public class Libraire extends Utilisateur {

	public Libraire() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Libraire(int id_utilisateur, String nom, String prenom, String role, String login, String password,
			boolean inscrit, boolean masque) {
		super(id_utilisateur, nom, prenom, role, login, password, inscrit, masque);
		// TODO Auto-generated constructor stub
	}

	public Libraire(String nom, String prenom, String role, String login, String password, boolean inscrit,
			boolean masque) {
		super(nom, prenom, role, login, password, inscrit, masque);
		// TODO Auto-generated constructor stub
	}

	public Libraire(int id_utilisateur, String nom, String prenom) {
		super(id_utilisateur, nom, prenom);
		// TODO Auto-generated constructor stub
	}

}