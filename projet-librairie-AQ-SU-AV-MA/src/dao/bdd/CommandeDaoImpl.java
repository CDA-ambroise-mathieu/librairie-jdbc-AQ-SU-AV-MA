package dao.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Dao;
import models.Commande;

public class CommandeDaoImpl implements Dao<Commande> {

	private static Commande com1 = new Commande();

	@Override
	public Commande save(Commande pCommande) {

		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement(
						"insert into commande (dateCommande, nombreArticles, livrée ) values (?,?,?); ",
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, pCommande.getDateCommande());
				ps.setInt(2, pCommande.getNombreArticles());
				ps.setBoolean(3, pCommande.isLivree());
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
				PreparedStatement ps = c.prepareStatement("DELETE from commande \r\n" + "WHERE id=?");
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
				PreparedStatement ps = c.prepareStatement(
						"UPDATE commande \r\n" + "SET nom= ? , prenom =? , livree=?\r\n" + "WHERE id=?");
				ps.setString(1, pCommande.getDateCommande());
				ps.setInt(2, pCommande.getNombreArticles());
				ps.setBoolean(3, pCommande.isLivree());
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
				PreparedStatement ps = c.prepareStatement("select * from commande where id = ?; ");
				ps.setInt(1, id);
				ResultSet r = ps.executeQuery();
				if (r.next())
					commande = new Commande(r.getInt("id"), r.getString("dateCommande"), r.getInt("nombreArticles"),
							r.getBoolean("livree"));
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
					int id = retour.getInt("id");
					String dateCommande = retour.getString("dateCommande");
					int nombreArticles = retour.getInt("nombreCommande");
					boolean livree = retour.getBoolean("livree");

					com1.setId(id);
					com1.setDateCommande(dateCommande);
					com1.setNombreArticles(nombreArticles);
					com1.setLivree(livree);
					listeRetour.add(com1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listeRetour;
	}

}
