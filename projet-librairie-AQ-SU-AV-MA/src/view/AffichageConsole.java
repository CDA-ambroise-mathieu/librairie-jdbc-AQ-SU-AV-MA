package view;

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

	/* UTILISATEUR */
	private void choixMenuUtilisateur(int choix) {
		switch (choix) {
		case 1:
			connexion();
			break;
		case 2:
			inscription();
			break;
		case 3:
			listerLivres();
			break;
		case 4:
			deconnexion();
			break;
		case 5:
			quitter();
			break;
		default:
			System.out.println("Ce n'est pas un bon choix !");
			choixMenuUtilisateur(choix);
			break;
		}
	}

	public void connexion() {
		this.testRole = "libraire";
		System.out.println("********  Bonjour "+this.testRole+"  ********");
	}

	public void inscription() {
		System.out.println("*** Quel rôle voulez vous ? ***");
		System.out.println("(1) Client");
		System.out.println("(2) Libraire");
		if (scanner.hasNextInt()) {
			int choix = scanner.nextInt();
			switch (choix) {
			case 1:
				this.testRole = "client";
				break;
			case 2:
				this.testRole = "libraire";
				break;
			}
		} else {
			System.out.println("Veuillez n'entrer que des chiffres !");
			inscription();
		}
	}

	public void deconnexion() {
		if(!this.testRole.equals("invite")) {
			this.testRole = "invite";
		}else {
			System.out.println("Vous êtes déjà déconnecté !");
		}
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

	
	
	/* LIBRAIRE */

	private void choixMenuLibraire(int choix) {
		switch (choix) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			deconnexion();
			break;
		case 5: 
			quitter();
			break;
		default:
			
			break;
		}
	}
}
