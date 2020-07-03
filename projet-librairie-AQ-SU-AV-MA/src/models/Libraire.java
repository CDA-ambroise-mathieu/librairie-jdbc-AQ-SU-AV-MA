package models;

public class Libraire extends Utilisateur {

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