package models;

public class Session {
	private Utilisateur currentUser;
	private static Session INSTANCE;
	
	private Session() {
	}
		
	public static Session getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new Session();
		}
		return INSTANCE;
	}
	
	public void connexion(Utilisateur user) {
		if(currentUser == null) {
			currentUser = user;
		}else {
			System.out.println("L'utilisateur est déjà connecté.");
		}
	}
	
	public void deconnexion() {
		if(currentUser != null) {
			currentUser = null;
		}else {
			System.out.println("Vous etes déjà déconnecté !");
		}
	}
	
	public Utilisateur getCurrentUser() {
		return currentUser;
	}
	
}
