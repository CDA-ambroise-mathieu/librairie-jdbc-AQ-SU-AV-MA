package intelligence;

import java.util.ArrayList;
import java.util.Scanner;

import dao.Dao;
import dao.LivreDao;
import dao.bdd.CommandeDaoImpl;
import dao.bdd.LivreDaoImpl;
import models.Client;
import models.Commande;
import models.Livre;

public class LibraireService {

	private LivreDao livreDao;
	private Dao<Commande> commandeDao;
	Scanner sc;

	public LibraireService() {
		this.livreDao = new LivreDaoImpl();
		this.commandeDao = new CommandeDaoImpl();
	}

	public void modifierStatutCommande(Commande pCommande) {
		listerCommandes();
		System.out.println("Saisissez l'ID de la commande :");
		int idCommande = sc.nextInt();
		sc.nextInt();
		System.out.println("Modifier l'état de la commande par : ");
		System.out.println("1- En préparation");
		System.out.println("2- Validée");
		System.out.println("3- En cours de livraison");
		System.out.println("4- Livrée");
		System.out.println("5- Annulée");
		
		int etat = sc.nextInt();
		sc.nextInt();
		
		pCommande.setEtat(etat);

	}

	public void listerCommandes() {
		ArrayList<Commande> commandes = (ArrayList<Commande>) CmdDAO.getAll();
		for (Commande commande : commandes) {
			System.out.println("("+commande.getId()+") "+commande.getNombreArticles()+" "+commande.getDateCommande()+" "+etatCommande(commande.getEtat()));
			
		}
	}
	
	public void masquerCompteClient(Client pClient) {

	}

	public void validerCreationCompte(Client pClient) {

	}

	public void refuserCreationCompte(Client pClient) {

	}

	public void ajouterLivre(Livre pLivre) {

	}

	public void supprimerLivre() {

	}

	public void modifierStockLivre() {

	}

	public void afficherHistoriqueCommande() {

	}

	public void modifierQuantiteLivre() {

	}
}
