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
	public Livre save(Livre pLivre) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			PreparedStatement ps;
			try {
				ps = c.prepareStatement(
						"INSERT INTO livre (libelle,titre,auteur,edition,annee_parution,qte_stock,prix_unitaire) values (?,?,?,?,?,?,?); ",
						PreparedStatement.RETURN_GENERATED_KEYS);

				ps.setString(1, pLivre.getLibelle());
				ps.setString(2, pLivre.getTitre());
				ps.setString(3, pLivre.getAuteur());
				ps.setString(4, pLivre.getEdition());
				ps.setInt(5, pLivre.getAnneeParution());
				ps.setInt(6, pLivre.getQuantiteEnStock());
				ps.setDouble(7, pLivre.getPrixUnitaire());
				ps.executeUpdate();

				ResultSet resultat = ps.getGeneratedKeys();
				if (resultat.next()) {
					pLivre.setId(resultat.getInt(1));
					listeDesLivres.add(pLivre);
					return pLivre;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public void remove(Livre pLivre) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("DELETE FROM livre WHERE id_livre = ?;");
				ps.setInt(1, pLivre.getId());
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
		Connection c = MyConnection.getConnection();
		try {
			// ajouter login et mdp
			PreparedStatement ps = c
			.prepareStatement("UPDATE livre SET libelle= ? , titre =? , auteur=?, edition=?, annee_parution=?, qte_stock=?, prix_unitaire=? WHERE id_livre=?");
			ps.setString(1, livre.getLibelle());
			ps.setString(2, livre.getTitre());
			ps.setString(3, livre.getEdition());
			ps.setString(4, livre.getAuteur());
			ps.setInt(5, livre.getAnneeParution());
			ps.setInt(6, livre.getQuantiteEnStock());
			ps.setDouble(7, livre.getPrixUnitaire());
			ps.setInt(8, livre.getId());
			ps.executeUpdate();
			
			return obj;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Livre findById(int pId) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("SELECT * FROM livre WHERE id_livre = ?;");
				ps.setInt(1, pId);
				ResultSet r = ps.executeQuery();
				if (r.next()) {
					livre = new Livre(r.getInt("id_livre"), r.getString("libelle"), r.getString("titre"),
							r.getString("auteur"), r.getString("edition"), r.getInt("annee_parution"),
							r.getInt("qte_stock"), r.getDouble("prix_unitaire"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return livre;
	}

	@Override
	public Livre findByLibelle(String pLibelle) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("SELECT * FROM livre WHERE libelle = ?;");
				ps.setString(1, pLibelle);
				ResultSet r = ps.executeQuery();
				if (r.next()) {
					livre = new Livre(r.getInt("id_livre"), r.getString("libelle"), r.getString("titre"),
							r.getString("auteur"), r.getString("edition"), r.getInt("annee_parution"),
							r.getInt("qte_stock"), r.getDouble("prix_unitaire"));
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
			ps = c.prepareStatement("SELECT * FROM livre;");
			ResultSet vResultatSelect = ps.executeQuery();

			int vId;
			String vLibelle;
			String vTitre;
			String vAuteur;
			String vEdition;
			int vAnneeParution;
			int vQuantiteEnStock;
			double vPrixUnitaire;

			while (vResultatSelect.next()) {
				vId = vResultatSelect.getInt("id_livre");
				vLibelle = vResultatSelect.getString("libelle");
				vTitre = vResultatSelect.getString("titre");
				vAuteur = vResultatSelect.getString("auteur");
				vEdition = vResultatSelect.getString("edition");
				vAnneeParution = vResultatSelect.getInt("annee_parution");
				vQuantiteEnStock = vResultatSelect.getInt("qte_stock");
				vPrixUnitaire = vResultatSelect.getInt("prix_unitaire");

				livre = new Livre(vId, vLibelle, vTitre, vAuteur, vEdition, vAnneeParution, vQuantiteEnStock,
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
	public Livre findByTitre(String pTitre) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("SELECT * FROM livre WHERE titre = ? LIMIT 1;");
				ps.setString(1, pTitre);
				ResultSet r = ps.executeQuery();
				if (r.next()) {
					livre = new Livre(r.getInt("id_livre"), r.getString("libelle"), r.getString("titre"),
							r.getString("auteur"), r.getString("edition"), r.getInt("annee_parution"),
							r.getInt("qte_stock"), r.getDouble("prix_unitaire"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return livre;
	}

	@Override
	public Livre findByAuteur(String pAuteur) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("SELECT * FROM livre WHERE auteur = ? LIMIT 1;");
				ps.setString(1, pAuteur);
				ResultSet r = ps.executeQuery();
				if (r.next()) {
					livre = new Livre(r.getInt("id_livre"), r.getString("libelle"), r.getString("titre"),
							r.getString("auteur"), r.getString("edition"), r.getInt("annee_parution"),
							r.getInt("qte_stock"), r.getDouble("prix_unitaire"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return livre;
	}

	@Override
	public Livre findByAnneParution(int pAnneeParution) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("SELECT * FROM livre WHERE annee_parution = ? LIMIT 1;");
				ps.setInt(1, pAnneeParution);
				ResultSet r = ps.executeQuery();
				if (r.next()) {
					livre = new Livre(r.getInt("id_livre"), r.getString("libelle"), r.getString("titre"),
							r.getString("auteur"), r.getString("edition"), r.getInt("annee_parution"),
							r.getInt("qte_stock"), r.getDouble("prix_unitaire"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return livre;
	}

	@Override
	public Livre findByEdition(String pEdition) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("SELECT * FROM livre WHERE edition = ? LIMIT 1;");
				ps.setString(1, pEdition);
				ResultSet r = ps.executeQuery();
				if (r.next()) {
					livre = new Livre(r.getInt("id_livre"), r.getString("libelle"), r.getString("titre"),
							r.getString("auteur"), r.getString("edition"), r.getInt("annee_parution"),
							r.getInt("qte_stock"), r.getDouble("prix_unitaire"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return livre;
	}
	// Rajouter d'autres FindBy


	public boolean livreCommandee(Livre l) {
		Connection c = MyConnection.getConnection();
		
		l = this.findByTitre(l.getTitre());
		
		boolean res =  false;
		try {
			PreparedStatement ps = c.prepareStatement("SELECT * FROM constituer WHERE id_livre = ?;");
			ps.setInt(1, l.getId());
			ResultSet result = ps.executeQuery();
			if(result.getRow()> 0 ) res = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
}
