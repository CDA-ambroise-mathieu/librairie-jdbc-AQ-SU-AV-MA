package dao.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Dao;
import models.Commande;
import models.Utilisateur;

public class CommandeDaoImpl implements Dao<Commande> {

	private static Commande com1 = new Commande();

	@Override
	public Commande save(Commande pCommande) {

		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement(
						"insert into commande (date_commande, nb_articles, etat) values (?,?,?); ",
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, pCommande.getDateCommande());
				ps.setInt(2, pCommande.getNombreArticles());
				ps.setInt(3, pCommande.getEtat());

				ps.executeUpdate();
				ResultSet resultat = ps.getGeneratedKeys();
				if (resultat.next()) {
					pCommande.setId(resultat.getInt(1));
					return pCommande;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return null;
	}

	@Override
	public void remove(Commande pCommande) {

		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("DELETE from commande \r\n" + "WHERE id_commande=?");
				ps.setInt(1, pCommande.getId());
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Commande update(Commande pCommande) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("UPDATE commande \r\n"
						+ "SET date_commande= ? , nb_articles =? ,  etat =?\r\n" + "WHERE id_commande=?");
				ps.setString(1, pCommande.getDateCommande());
				ps.setInt(2, pCommande.getNombreArticles());
				ps.setInt(3, pCommande.getEtat());
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Commande findById(int id) {
		Commande commande = null;
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("select * from commande where id_commande = ?; ");
				ps.setInt(1, id);
				ResultSet r = ps.executeQuery();
				if (r.next())
					commande = new Commande(r.getInt("id_commande"), r.getString("date_commande"),
							r.getInt("nb_articles"), r.getInt("etat"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return commande;
	}

	@Override
	public List<Commande> getAll() {
		String request = "SELECT * from commande;";
		PreparedStatement ps;
		ArrayList<Commande> listeRetour = new ArrayList<>();
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				ps = c.prepareStatement(request);

				ResultSet retour = ps.executeQuery();

				while (retour.next()) {
					int id = retour.getInt("id_commande");
					String dateCommande = retour.getString("date_commande");
					int nombreArticles = retour.getInt("nb_articles");
					int etat = retour.getInt("etat");

					com1.setId(id);
					com1.setDateCommande(dateCommande);
					com1.setNombreArticles(nombreArticles);
					com1.setEtat(etat);
					listeRetour.add(com1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listeRetour;
	}

	@Override
	public Utilisateur findByLogin(String pLogin) {
		// TODO Auto-generated method stub
		return null;
	}

}
