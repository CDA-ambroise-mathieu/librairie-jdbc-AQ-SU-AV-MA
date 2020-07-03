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

// Est il vraiement utile ??
//	public Client(String pPrenom, String pNom) {
//		super(pPrenom, pNom);
//		// TODO Auto-generated constructor stub
//	}

	public Client(int id_utilisateur , String pPrenom, String pNom, String pRole, int pNum_compte, String pLogin, String pPassword) {
		super(pPrenom, pNom, pRole, pNum_compte, pLogin, pPassword);
		// TODO Auto-generated constructor stub
	}
	
	

}
