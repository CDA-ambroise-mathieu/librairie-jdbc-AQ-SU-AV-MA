package models;

public class Client extends Utilisateur {

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(int pId_utilisateur, String pPrenom, String pNom) {
		super(pId_utilisateur, pPrenom, pNom);
		// TODO Auto-generated constructor stub
	}

	public Client(String pPrenom, String pNom, String pRole, int pNum_compte, String pLogin, String pPassword) {
		super(pPrenom, pNom, pRole, pNum_compte, pLogin, pPassword);
		// TODO Auto-generated constructor stub
	}

	public Client(String pPrenom, String pNom) {
		super(pPrenom, pNom);
		// TODO Auto-generated constructor stub
	}
//extends Utilisateur à ajouter ATTENTION
// Attributs de la classe Utilisateur à ajouter

	@Override
	public String toString() {
		return "Client [getId_utilisateur()=" + getId_utilisateur() + ", getPrenom()=" + getPrenom() + ", getNom()="
				+ getNom() + ", getRole()=" + getRole() + ", getNum_compte()=" + getNum_compte() + ", toString()="
				+ super.toString() + "]";
	}

}
