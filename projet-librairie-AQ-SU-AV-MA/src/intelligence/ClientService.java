package intelligence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import dao.Dao;
import dao.bdd.CommandeDaoImpl;
import dao.bdd.LivreDaoImpl;
import models.Commande;
import models.Livre;

public class ClientService {
	
	Dao<Commande> CmdDAO;
	Scanner sc;
	
	public ClientService() {
		sc = new Scanner(System.in);
		CmdDAO = new CommandeDaoImpl();
	}
	
	public void annulerCommand() {
		listerCommandes();
		System.out.print("ID de la commande à annuler : ");
		int id = sc.nextInt();
		Commande c = CmdDAO.findById(id);
		c.setEtat(5);
		if(c != null) {
			CmdDAO.update(c);
		}
	}
	
	public void listerCommandes() {
		ArrayList<Commande> commandes = (ArrayList<Commande>) CmdDAO.getAll();
		for (Commande commande : commandes) {
			System.out.println("("+commande.getId()+") "+commande.getNombreArticles()+" "+commande.getDateCommande()+" "+etatCommande(commande.getEtat()));
			
		}
	}
	
	public void commander() {
		HashMap<Livre,Integer> panier = new HashMap<>();
		LivreDaoImpl ldao = new LivreDaoImpl();
		CommandeDaoImpl cmdDao = new CommandeDaoImpl();
		Commande curr = new Commande();
		
		ArrayList<Livre> livres = (ArrayList<Livre>) ldao.getAll();
		for (Livre livre : livres) {
			System.out.println("("+livre.getId()+")"+livre.getTitre()+" par "+livre.getAuteur()+" - "+livre.getAnneeParution());
		}
		int i = 1;
		while(i!=0) {
			curr.getDesignationArticles().entrySet().stream().forEach(x->System.out.println(x.getKey().getTitre()+" : "+x.getValue()));
		
			
			System.out.print("ID du livre à ajouter : ");
			int id = sc.nextInt();
			sc.nextLine();
			
			System.out.print("En quelle quantité : ");
			int qte = sc.nextInt();
			sc.nextLine();
			
			Livre tmp = ldao.findById(id);
			
			curr.ajouterCommande(tmp,qte);
			
			System.out.print("Continuer (0) Non (1) Oui : ");
			i = sc.nextInt();
			sc.nextLine();
		}
		
		System.out.println("Etat du panier après finalisation : ");
		curr.getDesignationArticles().entrySet().stream().forEach(x->System.out.println(x.getKey().getTitre()+" : "+x.getValue()));
		
		cmdDao.save(curr);
	}
	
	public String etatCommande(int i) {
		String str = null;
		switch(i) {
		case 1:
			str = "En Péparation";
			break;
		case 2:
			str = "Validée";
			break;
		case 3:
			str = "En cours de Livraison";
			break;
		case 4:
			str = "Livrée";
			break;
		case 5:
			str = "Annulée";
			break;
		}
		return str;
	}
}
