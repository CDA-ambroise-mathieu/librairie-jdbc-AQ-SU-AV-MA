package view;

import java.util.ArrayList;
import java.util.Scanner;

public class AffichageConsole {
	private String testRole = "invite";
	private boolean continuer = true;
	private Scanner scanner;

	public void init() {
		if (scanner == null) {
			scanner = new Scanner(System.in);
		}
		System.out.println("********  Bonjour " + testRole + "  ********");
		this.menuPrincipal();
	}

	public void menuPrincipal() {
		while (continuer) {
			System.out.println("Que voulez vous faire ?");
			switch (testRole) {
			case "libraire":
				System.out.println("(1) Comptes Clients");
				System.out.println("(2) Commandes");
				System.out.println("(3) Livres");
				System.out.println("(4) Déconnexion");
				System.out.println("(5) Quitter");
				System.out.print("Choix : ");
				if (scanner.hasNextInt()) {
					int choix = scanner.nextInt();
					scanner.nextLine();
					System.out.println();
					choixMenuLibraire(choix);
				} else {
					System.out.println("Veuillez n'entrer que des chiffres !");
					menuPrincipal();
				}

				break;
			case "client":
				System.out.println("(1) Mes Commandes");
				System.out.println("(2) Lister Livre");
				System.out.println("(3) Déconnexion");
				System.out.println("(4) Quitter");
				System.out.print("Choix : ");
				if (scanner.hasNextInt()) {
					int choix = scanner.nextInt();
					scanner.nextLine();
					System.out.println();
					choixMenuClient(choix);
				} else {
					System.out.println("Veuillez n'entrer que des chiffres !");
					menuPrincipal();
				}
				break;

			default:
				System.out.println("(1) Connexion");
				System.out.println("(2) Inscription");
				System.out.println("(3) Lister les livres");
				System.out.println("(4) Déconnexion");
				System.out.println("(5) Quitter");

				System.out.print("Choix : ");
				if (scanner.hasNextInt()) {
					int choix = scanner.nextInt();
					scanner.nextLine();
					choixMenuUtilisateur(choix);
				} else {
					System.out.println("Veuillez n'entrer que des chiffres !");
					menuPrincipal();
				}
				break;
			}

			System.out.println();
		}
	}

	/* Possible supression une fois les classes ajoutées */
	/* A modifier par les appelles aux DAO Utilisateur/Libraire/Client */
	
	/*************/
	/* UTILISATEUR */
	/*************/
	
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

	public void connexion() {
		this.testRole = "libraire";
		System.out.println("********  Bonjour " + this.testRole + "  ********");
	}

	public void inscription() {
		System.out.println("*** Quel rôle voulez vous ? ***");
		System.out.println("(1) Client");
		System.out.println("(2) Libraire");
		System.out.println("(3) Retour");
		System.out.print("Choix : ");
		if (scanner.hasNextInt()) {
			int choix = scanner.nextInt();
			scanner.nextLine();
			switch (choix) {
			case 1:
				this.testRole = "client";
				break;
			case 2:
				this.testRole = "libraire";
				break;
			case 3:
				break;
			default:
				System.out.println("Ce n'est pas un bon choix !");
				break;
			}
		} else {
			System.out.println("Veuillez n'entrer que des chiffres !");
			inscription();
		}
		System.out.println("*** Vous êtes maintenant connecté en temps que "+this.testRole+".");
	}

	public void deconnexion() {
		if (!this.testRole.equals("invite")) {
			this.testRole = "invite";
		} else {
			System.out.println("Vous êtes déjà déconnecté !");
		}
		System.out.println("*** Vous êtes maintenant connecté en temps que "+this.testRole+".");
	}

	public void quitter() {
		this.continuer = false;
		this.scanner.close();
		System.out.println("Au revoir " + this.testRole + " !");
	}

	public void listerLivres() {
		System.out.println("*** Liste des livres actuel ***");
		System.out.println("- Ghost in Love par Marc Lévy");
		System.out.println("- Au soleil redouté par Michel Bussi");
		System.out.println("- Miroir de nos peines par Pierre Lemaitre");
		System.out.println("- Le Signal par Maxime Chattam");
		System.out.println("- Changer l'eau des fleurs par Valérie Perrin");
		System.out.println("- Le lambeau par Philippe Lançon");
		System.out.println("- Je te promets la liberté par Laurent Gounelle");
		System.out.println("- Ce que savait la nuit par Arnaldur Indridason");
		System.out.println("- A la recherche d'Alice Love");
		System.out.println("- Le Consentement par Vanessa Springora");
	}

	
	/*************/
	/* LIBRAIRE */
	/*************/
	
	public void choixMenuLibraire(int pChoixML) {
		switch (pChoixML) {
		case 1: // Client
			System.out.println("*** Client ***");
			System.out.println("(1) Valider création compte");
			System.out.println("(2) Refuser création compte");
			System.out.println("(3) Désactiver compte");
			System.out.println("(4) Retour");
			System.out.print("Choix : ");

			if (scanner.hasNextInt()) {
				int pChoixSML = scanner.nextInt();
				scanner.nextLine();
				this.choixSousMenuLibraire(pChoixML, pChoixSML);
			} else {
				System.out.println("Veuillez n'entrer que des chiffres !");
			}
			break;
		case 2: // Commande
			System.out.println("*** Commande ***");
			System.out.println("(1) Lister les commandes");
			System.out.println("(2) Modifier statut commande");
			System.out.println("(3) Retour");
			System.out.print("Choix : ");
			if (scanner.hasNextInt()) {
				int pChoixSML = scanner.nextInt();
				scanner.nextLine();
				this.choixSousMenuLibraire(pChoixML, pChoixSML);
			} else {
				System.out.println("Veuillez n'entrer que des chiffres !");
			}
			break;
		case 3: // Livre
			System.out.println("*** Livres ***");
			System.out.println("(1) Ajouter livre");
			System.out.println("(2) Supprimer livre");
			System.out.println("(3) Modifier stock d'un livre");
			System.out.println("(4) Lister les livres");
			System.out.println("(5) Retour");
			System.out.print("Choix : ");
			if (scanner.hasNextInt()) {
				int pChoixSML = scanner.nextInt();
				scanner.nextLine();
				this.choixSousMenuLibraire(pChoixML, pChoixSML);
			} else {
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

	public void choixSousMenuLibraire(int pChoixML, int pChoixSML) {
		switch(pChoixML) {
		case 1: // Client
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
				listerLivres();
				break;
			
			case 5: // Annuler
				break;
			default:
				System.out.println("Ce n'est pas un bon choix !");
				break;
			}
			break;
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
	/*  CLIENT   */
	/*************/
	
	public void choixMenuClient(int choix) {
		switch(choix) {
		case 1: // Mes Commandes
			System.out.println("LISTING DES COMMANDES");
			break;
		case 2: // Lister livres
			listerLivres();
			break;
		case 3: // Déconnexion
			deconnexion();
			break;
		case 4: //Quitter
			quitter();
			break;
		default:
			System.out.println("Ce n'est pas un bon choix !");
			break;
		}
	}	
}
