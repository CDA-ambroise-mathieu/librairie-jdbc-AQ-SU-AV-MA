package dao.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Dao;
import lombok.Data;
import models.Utilisateur;

@Data
public class UtilisateurDaoImpl implements Dao<Utilisateur> {

	private static Utilisateur u1 = new Utilisateur();

	protected Connection connect = null;

//	public DAO(Connection conn) { // il faut la connexion avec la BDD créée pour que 
//	ça fonctionne non ?
//		this.connect = conn;
//	}

	@Override
	public Utilisateur save(Utilisateur pUtilisateur) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				// ******* Penser à vérifer s'il faut ajouter le role par défaut! *****
				// ******* Ajouter login et mdp!
				PreparedStatement ps = c.prepareStatement("insert into utilisateur (nom, prenom) values (?,?);",
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, pUtilisateur.getNom());
				ps.setString(2, pUtilisateur.getPrenom());
				ps.executeUpdate();
				ResultSet resultat = ps.getGeneratedKeys();
				if (resultat.next()) {
					pUtilisateur.setId(resultat.getInt(1));
					return pUtilisateur;
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return null;
	}

	@Override
	public void remove(Utilisateur pUtilisateur) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("DELETE from utilisateur \r\n" + "WHERE id=?");
				ps.setInt(1, pUtilisateur.getId());
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Utilisateur update(Utilisateur pUtilisateur) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {

				// ajouter login et mdp
				PreparedStatement ps = c
						.prepareStatement("UPDATE utilisateur \r\n" + "SET nom= ? , prenom =?\r\n" + "WHERE id=?");
				ps.setString(1, pUtilisateur.getNom());
				ps.setString(1, pUtilisateur.getPrenom());
				ps.setInt(3, pUtilisateur.getId());
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Utilisateur findById(int pIdentifiant) {
		Utilisateur pUtilisateur = null;
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("select * from utilisateur where num = ?;");
				ps.setInt(1, pIdentifiant);
				ResultSet r = ps.executeQuery();
				if (r.next())
					pUtilisateur = new Utilisateur(r.getInt("identifiant"), r.getBoolean("inscrit"),
							r.getString("prenom"), r.getString("nom"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return pUtilisateur;
	}

	@Override
	public List<Utilisateur> getAll() {

		// Penser à ajouter login et mdp.
		String request = "SELECT * from utilisateur;";
		PreparedStatement ps;
		ArrayList<Utilisateur> listeRetour = new ArrayList<>();
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				ps = c.prepareStatement(request);

				ResultSet retour = ps.executeQuery();

				while (retour.next()) {
					int id = retour.getInt("id");
					String nom = retour.getString("nom");
					String prenom = retour.getString("prenom");

					u1.setId(id);
					u1.setNom(nom);
					u1.setPrenom(prenom);
					listeRetour.add(u1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listeRetour;
	}

}
