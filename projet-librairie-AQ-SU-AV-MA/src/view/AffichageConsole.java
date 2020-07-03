package view;

import java.util.Scanner;

import intelligence.ClientService;
import intelligence.UtilisateurService;
import models.Session;

/**
 * Provide the class that will display and call
 * necessary DAO to setup users and their actions.
 * It must be instantiated to be used
 * 
 * @author cda-samuel
 * @since cda-library 0.1
 */
public class AffichageConsole {
	private String testRole = "invite";
	private boolean continuer = true;
	private Scanner scanner;

	/**
	 * Initialization of the console view
	 * by instantiate the <code>Scanner</code>
	 */
	public void init() {
		if (scanner == null) {
			scanner = new Scanner(System.in);
		}
		
		System.out.println("********  Bonjour " + testRole + "  ********");
		this.menuPrincipal();
	}

	/**
	 * Principal menu that check if the user is connected and 
	 * adapt the menu in consequence.
	 */
	public void menuPrincipal() {
		while (continuer) {
			System.out.println("Que voulez vous faire ?");
			
			// role checking
			switch (testRole) {
			
			//user : Libraire
			case "libraire":
				System.out.println("(1) Comptes Clients");
				System.out.println("(2) Commandes");
				System.out.println("(3) Livres");
				System.out.println("(4) Déconnexion");
				System.out.println("(5) Quitter");
				System.out.print("Choix : ");
				
				//checking next input is an Integer
				if (scanner.hasNextInt()) {
					int choix = scanner.nextInt();
					scanner.nextLine();
					System.out.println();
					choixMenuLibraire(choix);
					
				} else { 
					//if not, empty the scanner and display an error message
					scanner.nextLine();
					System.out.println("Veuillez n'entrer que des chiffres !");
				}

				break;
				
			//user : Client
			case "client":
				System.out.println("(1) Mes Commandes");
				System.out.println("(2) Annuler Commande");
				System.out.println("(3) Lister Livre");
				System.out.println("(4) Commander des livres");
				System.out.println("(5) Déconnexion");
				System.out.println("(6) Quitter");
				System.out.print("Choix : ");
				
				//checking next input is an Integer
				if (scanner.hasNextInt()) {
					int choix = scanner.nextInt();
					scanner.nextLine();
					System.out.println();
					choixMenuClient(choix);
				} else {
					//if not, empty the scanner and display an error message
					scanner.nextLine();
					System.out.println("Veuillez n'entrer que des chiffres !");
				}
				break;
				
				
			//user : invite
			case "invite":
				System.out.println("(1) Connexion");
				System.out.println("(2) Inscription");
				System.out.println("(3) Lister les livres");
				System.out.println("(4) Déconnexion");
				System.out.println("(5) Quitter");

				System.out.print("Choix : ");
				//checking next input is an Integer
				if (scanner.hasNextInt()) {
					int choix = scanner.nextInt();
					scanner.nextLine();
					choixMenuUtilisateur(choix);
				} else {
					//if not, empty the scanner and display an error message
					scanner.nextLine();
					System.out.println("Veuillez n'entrer que des chiffres !");
				}
				break;
			}

			System.out.println();
		}
	}

	/* Possible supression une fois les classes ajout�es */
	/* A modifier par les appelles aux DAO Utilisateur/Libraire/Client */

	/*************/
	/* UTILISATEUR */
	/*************/
	
	
	/**
	 * Call the methods that match with the user choice.
	 * Here, the user is not authentified.
	 * @param choix an integer giving the choice of the user
	 */
	private void choixMenuUtilisateur(int choix) {
		switch (choix) {
		case 1: // Connexion
			connexion();
			break;
		case 2: // Inscription
			inscription();
			break;
		case 3: // Lister les livres
			listerLivres();
			break;
		case 4: // Déconnexion
			deconnexion();
			break;
		case 5: // Quitter
			quitter();
			break;
		default:
			System.out.println("Ce n'est pas un bon choix !");
			break;
		}
	}

	/**
	 * Method that call the user DAO to get authentified 
	 */
	public void connexion() {
		// Cette endroit est à modifier en conséquence une fois le DAO Utilisateur fini
		UtilisateurService us = new UtilisateurService();
		if(us.authentification()) {
			this.testRole = Session.getInstance().getCurrentUser().getRole();
			System.out.println("*** Bonjour "+Session.getInstance().getCurrentUser().getLogin()+" ***");
		}
	}

	/**
	 * Method that ask the user DAO for sign up.
	 */
	public void inscription() {
		//Cette méthode est à modifié une fois le DAO Utilisateur fini
		UtilisateurService us = new UtilisateurService();
		if(us.inscription()) {
			System.out.println("*** Inscription réussi, veuillez attendre d'être validé par un libraire. ***");
		}else {
			System.out.println("Problème d'inscription, veuillez recommencer.");
		}
		
	}

	/**
	 * Setup the deconnection by changing the current role
	 * on invite 
	 */
	public void deconnexion() {
		if (!this.testRole.equals("invite")) {
			this.testRole = "invite";
		} else {
			System.out.println("Vous êtes déjà déconnecté !");
		}
		System.out.println("*** Vous êtes connecté en temps que "+this.testRole+".");
	}
	
	
	/**
	 * Allow the program to close correctly by closing the <code>Scanner</code>
	 * and letting the program terminate.
	 */
	public void quitter() {
		this.continuer = false;
		this.scanner.close();
		System.out.println("Au revoir " + this.testRole + " !");
	}

	/**
	 * Calling the Livre DAO to get the list of books in database.
	 * The method just display the content and display their ID close
	 * to the name and the author
	 */
	public void listerLivres() {
		UtilisateurService us = new UtilisateurService();
		us.listerLivres();
	}

	/*************/
	/* LIBRAIRE */
	/*************/
	
	/**
	 * Display the menu according to the choice allowing the user,
	 * who's a libraire, to access to all his possible action.
	 * 
	 * @param pChoixML choice of the user
	 */
	public void choixMenuLibraire(int pChoixML) {
		switch (pChoixML) {
		
		// the user chose to display the sub-menu Client of Libraire
		case 1: // Client
			System.out.println("*** Client ***");
			System.out.println("(1) Valider création compte");
			System.out.println("(2) Refuser création compte");
			System.out.println("(3) Désactiver compte");
			System.out.println("(4) Afficher la liste des clients");
			System.out.println("(5) Retour");
			System.out.print("Choix : ");

			//checking next input is an Integer
			if (scanner.hasNextInt()) {
				int pChoixSML = scanner.nextInt();
				scanner.nextLine();
				this.choixSousMenuLibraire(pChoixML, pChoixSML);
			} else {
				scanner.nextLine();
				System.out.println("Veuillez n'entrer que des chiffres !");
			}
			break;
			
		// the user chose to display the sub-menu Commande
		case 2: // Commande
			System.out.println("*** Commande ***");
			System.out.println("(1) Lister les commandes");
			System.out.println("(2) Modifier statut commande");
			System.out.println("(3) Retour");
			System.out.print("Choix : ");

			//checking next input is an Integer
			if (scanner.hasNextInt()) {
				int pChoixSML = scanner.nextInt();
				scanner.nextLine();
				this.choixSousMenuLibraire(pChoixML, pChoixSML);
			} else {
				scanner.nextLine();
				System.out.println("Veuillez n'entrer que des chiffres !");
			}
			break;
			
		// the user chose to display the sub-menu Livre
		case 3: // Livre
			System.out.println("*** Livres ***");
			System.out.println("(1) Ajouter livre");
			System.out.println("(2) Supprimer livre");
			System.out.println("(3) Modifier stock d'un livre");
			System.out.println("(4) Lister les livres");
			System.out.println("(5) Retour");
			System.out.print("Choix : ");

			//checking next input is an Integer
			if (scanner.hasNextInt()) {
				int pChoixSML = scanner.nextInt();
				scanner.nextLine();
				this.choixSousMenuLibraire(pChoixML, pChoixSML);
			} else {
				scanner.nextLine();
				System.out.println("Veuillez n'entrer que des chiffres !");
			}
			break;
			
		case 4:
			deconnexion();
			break;
		case 5:
			quitter();
			break;
		default:
			System.out.println("Ce n'est pas un bon choix !");
			break;
		}
	}
	
	/**
	 * Sub menu of choice menu for the Libraire.
	 * 
	 * @param pChoixML user choice of the parent menu
	 * @param pChoixSML user choice of the sub menu
	 */
	public void choixSousMenuLibraire(int pChoixML, int pChoixSML) {
		switch (pChoixML) {
		case 1: // Client

			// L'utilisateur a choisi précédemment le sous menu Client
			switch(pChoixSML) {
			case 1: // Valider Compte
				System.out.println("VALIDATION DE COMPTE");
				break;

			case 2: // Refuser Compte
				System.out.println("REFUS DE COMPTE");
				break;
				
			case 3: // Désactiver Compte
				System.out.println("DESACTION DE COMPTE");
				break;

			case 4: // Lister livre
				System.out.println("LISTER LES CLIENTS");
				break;

			case 5: // Annuler
				break;
			default:
				System.out.println("Ce n'est pas un bon choix !");
				break;
			}
			break;
			
		// L'utilisateur a choisi précédemment le sous menu Commande
		case 2:	// Commande
			switch(pChoixSML) {
			case 1: // Lister Commandes
				System.out.println("LISTAGE DES COMMANDES");
				break;
			case 2: // Changer état commande
				System.out.println("CHEANGAGE DES COMMANDES");
				break;
			case 3: // Annuler
				break;
			default:
				System.out.println("Ce n'est pas un bon choix !");
				break;
			}
			break;
			
		// L'utilisateur a choisi précédemment le sous menu Livre
		case 3: //  Livre
			switch(pChoixSML) {
			case 1: // Ajouter livre
				System.out.println("AJOUT D'UN LIVRE ");
				break;
			case 2: // Supprimer livre
				System.out.println("SUPPRESSION D'UN LIVRE ");
				break;
			case 3: // Modifier quantité livre
				System.out.println("MODIFICATION D'UN LIVRE ");
				break;
			case 4: // Annuler
				break;
			default:
				System.out.println("Ce n'est pas un bon choix !");
				break;
			}
			break;
		default:
			System.out.println("Ce n'est pas un bon choix !");
			break;
		}
	}

	/*************/
	/* CLIENT */
	/*************/
	
	/**
	 * The menu for the user authentified as a Client.
	 * 
	 * @param choix user choice of the main menu
	 */
	public void choixMenuClient(int choix) {
		ClientService cs = new ClientService();
		switch (choix) {
		case 1: // Mes Commandes
			System.out.println("*** LISTING DES COMMANDES ***");
			cs.listerCommandes();
			break;
		case 2: // Annuler une commande
			cs.annulerCommand();
		case 3: // Lister livres
			listerLivres();
			break;
		case 4: // Commander des livres
			cs.commander();
			break;
		case 5: // Déconnexion
			deconnexion();
			break;
		case 6: // Quitter
			quitter();
			break;
		default:
			System.out.println("Ce n'est pas un bon choix !");
			break;
		}
	}
}
