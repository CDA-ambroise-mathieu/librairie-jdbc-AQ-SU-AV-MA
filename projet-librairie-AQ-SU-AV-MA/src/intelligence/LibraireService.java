package intelligence;

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

	public LibraireService() {
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
