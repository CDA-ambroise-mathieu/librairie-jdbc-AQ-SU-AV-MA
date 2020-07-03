package dao;

import dao.Dao;
import models.Livre;

public interface LivreDao extends Dao<Livre>{

	//Ajouter des méthodes spécifiques
	
	Livre findByLibelle(String libelle);
	Livre findByTitre(String titre);
	Livre findByAuteur(String auteur);
	Livre findByAnneParution(int anneeParution);
	Livre findByEdition(String edition);
}
