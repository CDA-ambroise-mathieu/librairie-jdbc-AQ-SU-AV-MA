package dao.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Dao;
import models.Libraire;

public class LibraireDaoImpl implements Dao<Libraire> {

	private static Libraire l1 = new Libraire();

	@Override
	public Libraire save(Libraire pLibraire) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement(
						"insert into utilisateur (nom, prenom, role, num_compte, login, password) values (?,?,?,?,?,?); ",
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, pLibraire.getNom());
				ps.setString(2, pLibraire.getPrenom());
				ps.setString(3, pLibraire.getRole());
				ps.setInt(4, pLibraire.getNum_compte());
				ps.setString(5, pLibraire.getLogin());
				ps.setString(6, pLibraire.getPassword());
				ps.executeUpdate();
				ResultSet resultat = ps.getGeneratedKeys();
				if (resultat.next()) {
					pLibraire.setId(resultat.getInt(1));
					return pLibraire;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public void remove(Libraire pLibraire) {

		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("DELETE from utilisateur \r\n" + "WHERE id_utilisateur=?");
				ps.setInt(1, pLibraire.getId_utilisateur());
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Libraire update(Libraire pLibraire) {

		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement(
						"UPDATE utilisateur \r\n" + "SET nom= ? , prenom =?\r\n" + "WHERE id_utilsateur=?");
				ps.setString(1, pLibraire.getNom());
				ps.setString(1, pLibraire.getPrenom());
				ps.setInt(3, pLibraire.getId_utilisateur());
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Libraire findById(int id) {
		Libraire libraire = null;
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("select * from utilisateur where id_utilisateur = ?; ");
				ps.setInt(1, id);
				ResultSet r = ps.executeQuery();
				if (r.next())
					libraire = new Libraire(r.getInt("id_utilisateur"), r.getString("nom"), r.getString("prenom"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return libraire;
	}

	public Libraire fingByName(String pNom) {
		Libraire libraire = null;
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("select * from utilisateur where nom = ?; ");
				ps.setString(1, pNom);
				ResultSet r = ps.executeQuery();
				if (r.next())
					libraire = new Libraire(r.getInt("id_utilisateur"), r.getString("nom"), r.getString("prenom"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return libraire;
	}

	@Override
	public List<Libraire> getAll() {

		String request = "SELECT * from utilisateur where role = libraire;";
		PreparedStatement ps;
		ArrayList<Libraire> listeRetour = new ArrayList<>();
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				ps = c.prepareStatement(request);

				ResultSet retour = ps.executeQuery();

				while (retour.next()) {
					int id = retour.getInt("id_utilisateur");
					String nom = retour.getString("nom");
					String prenom = retour.getString("prenom");

					l1.setId(id);
					l1.setNom(nom);
					l1.setPrenom(prenom);
					listeRetour.add(l1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listeRetour;
	}

}
