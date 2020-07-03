package models;

public class Libraire extends Utilisateur {

	public Libraire(int pId_utilisateur, String pPrenom, String pNom, String pRole, int pNum_compte, String pLogin,
			String pPassword, boolean pInscrit) {
		super(pId_utilisateur, pPrenom, pNom, pRole, pNum_compte, pLogin, pPassword, pInscrit);
		// TODO Auto-generated constructor stub
	}

	public Libraire(int pId_utilisateur, String pPrenom, String pNom, String pRole, int pNum_compte, String pLogin,
			String pPassword) {
		super(pId_utilisateur, pPrenom, pNom, pRole, pNum_compte, pLogin, pPassword);
		// TODO Auto-generated constructor stub
	}

	public Libraire(String pLogin, String pPrenom, String pNom, String pRole, int pNum_compte, int pId_utilisateur,
			String pPassword) {
		super(pLogin, pPrenom, pNom, pRole, pNum_compte, pId_utilisateur, pPassword);
		// TODO Auto-generated constructor stub
	}

	public Libraire() {

	}

	public Libraire(String pPrenom, String pNom, String pRole, int pNum_compte, String pLogin, String pPassword) {
		super(pPrenom, pNom, pRole, pNum_compte, pLogin, pPassword);

	}

	public Libraire(String pPrenom, String pNom) {
		super(pPrenom, pNom);

	}

	public Libraire(int pId_utilisateur, String string, String string2) {

	}

	@Override
	public String toString() {
		return "Libraire [getId_utilisateur()=" + getId_utilisateur() + ", getPrenom()=" + getPrenom() + ", getNom()="
				+ getNom() + ", getRole()=" + getRole() + ", toString()=" + super.toString() + "]";
	}

}