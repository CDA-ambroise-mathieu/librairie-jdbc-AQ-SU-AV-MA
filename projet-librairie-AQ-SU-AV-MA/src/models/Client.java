package models;

public class Client extends Utilisateur {

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(int id_utilisateur, String nom, String prenom, String role, String login, String password,
			boolean inscrit, boolean masque) {
		super(id_utilisateur, nom, prenom, role, login, password, inscrit, masque);
		// TODO Auto-generated constructor stub
	}

	public Client(int id_utilisateur, String nom, String prenom) {
		super(id_utilisateur, nom, prenom);
		// TODO Auto-generated constructor stub
	}

	public Client(int id_utilisateur, String nom, String prenom, String role, String login, String password) {
		super(id_utilisateur, nom, prenom, role, login, password);
		// TODO Auto-generated constructor stub
	}

	public Client(String nom, String prenom, String role, String login, String password, boolean inscrit,
			boolean masque) {
		super(nom, prenom, role, login, password, inscrit, masque);
		// TODO Auto-generated constructor stub
	}

}
