package models;

public class Client {
//extends Utilisateur à ajouter ATTENTION
// Attributs de la classe Utilisateur à ajouter

	private int idBDD;
	private String numeroCompte;
	private String login;
	private String motDePasse;

	public Client(int idBDD, String numeroCompte, String login, String motDePasse) {
		super();
		this.idBDD = idBDD;
		this.numeroCompte = numeroCompte;
		this.login = login;
		this.motDePasse = motDePasse;
	}

	public Client(String numeroCompte, String login, String motDePasse) {
		super();
		this.numeroCompte = numeroCompte;
		this.login = login;
		this.motDePasse = motDePasse;
	}

	public int getIdBDD() {
		return idBDD;
	}

	public String getNumeroCompte() {
		return numeroCompte;
	}

	public String getLogin() {
		return login;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setIdBDD(int idBDD) {
		this.idBDD = idBDD;
	}

	public void setNumeroCompte(String numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	@Override
	public String toString() {
		return "Client [idBDD=" + idBDD + ", numeroCompte=" + numeroCompte + ", login=" + login + ", motDePasse="
				+ motDePasse + "]";
	}

}
