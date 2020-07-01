package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AffichageConsole {
	private String testRole = "invite";
	private boolean continuer = true;
	private Scanner scanner;
	private ArrayList<String> listeClientAttente;
	private ArrayList<String> listeClient;
	private ArrayList<String> listeClientMasque;
	private Map<String,String> listeCommande;
	
	public void init() {
		if (scanner == null) {
			scanner = new Scanner(System.in);
			listeClientAttente = new ArrayList<>();
			listeClient = new ArrayList<>();
			listeClientMasque = new ArrayList<>();
			listeCommande = new HashMap<>();
			
			listeClientAttente.add("Selexia");
			listeClientAttente.add("Saecla");
			listeClientAttente.add("Burzhuan");
			listeClientAttente.add("Finrodd");
			
			listeClient.add("Romsh");
			
			listeCommande.put("Ghost in Love par Marc Lévy", "preparation");
			listeCommande.put("Au soleil redouté par Michel Bussi", "attente");
			listeCommande.put("Le Signal par Maxime Chattam", "attente");
			
			
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
		System.out.println("********  Bonjour "+this.testRole+"  ********");
	}

	public void inscription() {
		System.out.println("*** Quel rôle voulez vous ? ***");
		System.out.println("(1) Client");
		System.out.println("(2) Libraire");
		System.out.println("(3) Annuler");
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

	public void choixMenuLibraire(int pChoixML) {
		switch (pChoixML) {
		case 1: // Client
			System.out.println("*** Client ***");
			System.out.println("(1) Valider création compte");
			System.out.println("(2) Refuser création compte");
			System.out.println("(3) Désactiver compte");
			System.out.println("(4) Annuler");
			
			if(scanner.hasNextInt()) {
				int pChoixSML = scanner.nextInt();
				scanner.nextLine();
				this.choixSousMenuLibraire(pChoixML, pChoixSML);
			}else {
				System.out.println("Veuillez n'entrer que des chiffres !");
			}
			break;
		case 2: // Commande
			System.out.println("*** Commande ***");
			System.out.println("(1) Lister les commandes");
			System.out.println("(2) Modifier statut commande");
			System.out.println("(3) Annuler");
			if(scanner.hasNextInt()) {
				int pChoixSML = scanner.nextInt();
				scanner.nextLine();
				this.choixSousMenuLibraire(pChoixML, pChoixSML);
			}else {
				System.out.println("Veuillez n'entrer que des chiffres !");
			}
			break;
		case 3: // Livre
			System.out.println("*** Livres ***");
			System.out.println("(1) Ajouter livre");
			System.out.println("(2) Supprimer livre");
			System.out.println("(3) Modifier stock d'un livre");
			System.out.println("(4) Annuler");
			if(scanner.hasNextInt()) {
				int pChoixSML = scanner.nextInt();
				scanner.nextLine();
				this.choixSousMenuLibraire(pChoixML, pChoixSML);
			}else {
				System.out.println("Veuillez n'entrer que des chiffres !");
			}
			break;
		case 4:
			break;
		case 5:
			deconnexion();
			break;
		case 6: 
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
				listeClientAttente.stream().forEach(x->System.out.println(listeClientAttente.indexOf(x)+" "+x));
				if(scanner.hasNextInt()) {
					int choix = scanner.nextInt();
					scanner.nextLine();
					listeClient.add(listeClientAttente.get(choix));
					listeClientAttente.remove(choix);
				}
				break;
				
			case 2: // Refuser Compte
				listeClientAttente.stream().forEach(x->System.out.println(listeClientAttente.indexOf(x)+" "+x));
				if(scanner.hasNextInt()) {
					int choix = scanner.nextInt();
					scanner.nextLine();
					listeClientAttente.remove(choix);
				}
				break;
				
			case 3: // Désactiver Compte
				listeClient.stream().forEach(x->System.out.println(listeClient.indexOf(x)+" "+x));
				if(scanner.hasNextInt()) {
					int choix = scanner.nextInt();
					scanner.nextLine();
					listeClientMasque.add(listeClient.get(choix));
					listeClient.remove(choix);
				}
				break;
				
			case 4: // Annuler
				break;
				
			default:
				System.out.println("Ce n'est pas un bon choix !");
				break;
			}
			
			break;
		case 2:	// Commande
			switch(pChoixSML) {
			
			}
			break;
		case 3: //  Livre
			switch(pChoixSML) {
			
			}
			break;
		default:
			break;
		}		
	}
}
