package dao;

import models.Client;

public interface ClientDao extends Dao<Client> {

	//Ajouter des méthodes spé aux ClientDao
	Client findByPrenom(String prenom);
	Client findByNom(String nom);
	Client findByNumCompte(int numCompte);
	
}
