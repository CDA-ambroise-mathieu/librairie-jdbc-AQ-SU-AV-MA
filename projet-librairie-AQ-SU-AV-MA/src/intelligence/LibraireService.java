package intelligence;

import java.util.ArrayList;
import java.util.Scanner;

import dao.Dao;
import dao.LivreDao;
import dao.bdd.ClientDaoImpl;
import dao.bdd.CommandeDaoImpl;
import dao.bdd.LivreDaoImpl;
import models.Client;
import models.Commande;
import models.Livre;

public class LibraireService {

	private LivreDao livreDao;
	private Dao<Commande> commandeDao;
	private Scanner sc;

	public LibraireService() {
		sc = new Scanner(System.in);
		this.livreDao = new LivreDaoImpl();
		this.commandeDao = new CommandeDaoImpl();
	}

	public void modifierStatutCommande(Commande pCommande) {

	}

	public void masquerCompteClient(Client pClient) {
		ClientDaoImpl cdao = new ClientDaoImpl();
		pClient.setMasque(true);
		cdao.update(pClient);
		
	}

	public void validerCreationCompte(Client pClient) {
		ClientDaoImpl cdao = new ClientDaoImpl();
		pClient.setInscrit(true);
		cdao.update(pClient);
	}

	public void refuserCreationCompte(Client pClient) {
		ClientDaoImpl cdao = new ClientDaoImpl();
		pClient.setMasque(true);
		cdao.update(pClient);
	}

	public void ajouterLivre(Livre pLivre) {
		LivreDao ldao = new LivreDaoImpl();
		Livre present  = ldao.findByTitre(pLivre.getTitre());
		if(present == null) {
			ldao.save(pLivre);
		}
	}

	public void supprimerLivre() {
		LivreDao ldao = new LivreDaoImpl();
		ArrayList<Livre> livres = (ArrayList<Livre>) ldao.getAll();
		livres.stream().forEach(x->System.out.println("("+x.getId()+") "+x.getTitre()+" "+x.getAuteur()+" "+x.getAnneeParution()));
		
		System.out.print("Quel livre supprimer : ");
		int idLS = sc.nextInt();
		sc.nextLine();
		
		Livre suppr = ldao.findById(idLS);
		if(suppr != null) {
			if(!((LivreDaoImpl)ldao).livreCommandee(suppr)) {
				ldao.remove(suppr);
			}else {
				System.out.println("Le livre est présent dans des commandes.");
			}
		}
	}

	public void modifierStockLivre() {
		//VOIR MODIFIER QUANTITE LIVRE
	}

	public void afficherHistoriqueCommande() {

	}

	public void modifierQuantiteLivre() {
		LivreDao ldao = new LivreDaoImpl();
		ArrayList<Livre> livres = (ArrayList<Livre>) ldao.getAll();
		livres.stream().forEach(x->System.out.println("("+x.getId()+") "+x.getTitre()+" "+x.getAuteur()+" "+x.getAnneeParution()+" "+x.getQuantiteEnStock()));
		
		System.out.print("Quel livre a modifier le stock : ");
		int idLS = sc.nextInt();
		sc.nextLine();
		
		Livre stock = ldao.findById(idLS);
		if(stock != null) {
			System.out.println("blblb");
			System.out.print("Quelle est la nouvelle quantité : ");
			int qte = sc.nextInt();
			sc.nextLine();
			stock.setQuantiteEnStock(qte);
		}
		((LivreDaoImpl)ldao).update(stock);
	}
	
}
