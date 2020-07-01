package dao.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.LivreDao;
import models.Livre;

public class LivreDaoImpl implements LivreDao {
	Livre livre;
	List<Livre> listeDesLivres = new ArrayList<>();

	@Override
	public Livre save(Livre obj) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			PreparedStatement ps;
			try {
				ps = c.prepareStatement(
						"INSERT INTO livre (libelle,titre,auteur,edition,anneParution,quantiteStock,prixUnitaire) values (?,?,?,?,?,?,?); ",
						PreparedStatement.RETURN_GENERATED_KEYS);

				ps.setString(1, livre.getLibelle());
				ps.setString(2, livre.getTitre());
				ps.setString(3, livre.getAuteur());
				ps.setString(4, livre.getEdition());
				ps.setString(5, livre.getAnneeParution());
				ps.setInt(6, livre.getQuantiteEnStock());
				ps.setDouble(7, livre.getPrixUnitaire());
				ps.executeUpdate();

				ResultSet resultat = ps.getGeneratedKeys();
				if (resultat.next()) {
					livre.setIdBDD(resultat.getInt(1));
					listeDesLivres.add(livre);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return livre;
	}

	@Override
	public void remove(Livre obj) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("DELETE FROM livre WHERE idBB = ?;");
				ps.setInt(1, livre.getIdBDD());
				int nbr = ps.executeUpdate();
				listeDesLivres.remove(livre);
				if (0 != nbr) {
					System.out.println("OK Delete");
				} else {
					System.out.println("KO Delete");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Livre update(Livre obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Livre findById(int idBDD) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("SELECT * FROM livre WHERE idBDD = ?;");
				ps.setInt(1, idBDD);
				ResultSet r = ps.executeQuery();
				if (r.next()) {
					livre = new Livre(r.getInt("idBDD"), r.getString("libelle"), r.getString("titre"),
							r.getString("auteur"), r.getString("edition"), r.getString("anneeParution"),
							r.getInt("quantiteEnStock"), r.getDouble("prixUnitaire"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return livre;
	}

	@Override
	public Livre findByLibelle(String id) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("SELECT * FROM livre WHERE libelle = ?;");
				ps.setString(1, livre.getLibelle());
				ResultSet r = ps.executeQuery();
				if (r.next()) {
					livre = new Livre(r.getInt("idBDD"), r.getString("libelle"), r.getString("titre"),
							r.getString("auteur"), r.getString("edition"), r.getString("anneeParution"),
							r.getInt("quantiteEnStock"), r.getDouble("prixUnitaire"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return livre;
	}

	@Override
	public List<Livre> getAll() {
		Connection c = MyConnection.getConnection();
		List<Livre> listeLivres = new ArrayList<>();
		PreparedStatement ps;

		try {
			ps = c.prepareStatement("SELECT * FROM livre");
			ResultSet vResultatSelect = ps.executeQuery();

			int vIdBDD;
			String vLibelle;
			String vTitre;
			String vAuteur;
			String vEdition;
			String vAnneeParution;
			int vQuantiteEnStock;
			double vPrixUnitaire;

			while (vResultatSelect.next()) {
				vIdBDD = vResultatSelect.getInt("idBDD");
				vLibelle = vResultatSelect.getString("libelle");
				vTitre = vResultatSelect.getString("titre");
				vAuteur = vResultatSelect.getString("auteur");
				vEdition = vResultatSelect.getString("edition");
				vAnneeParution = vResultatSelect.getString("anneeParution");
				vQuantiteEnStock = vResultatSelect.getInt("quantiteEnStock");
				vPrixUnitaire = vResultatSelect.getInt("prixUnitaire");

				livre = new Livre(vIdBDD, vLibelle, vTitre, vAuteur, vEdition, vAnneeParution, vQuantiteEnStock,
						vPrixUnitaire);

				listeLivres.add(livre);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listeLivres;
	}

	@Override
	public Livre findByTitre(String titre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Livre findByAuteur(String auteur) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Livre findByAnneParution(String anneeParution) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Livre findByEdition(String edition) {
		// TODO Auto-generated method stub
		return null;
	}

	// Rajouter d'autres FindBy

}
