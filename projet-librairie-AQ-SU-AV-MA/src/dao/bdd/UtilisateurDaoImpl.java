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
				PreparedStatement ps = c.prepareStatement("insert into utilisateur (nom, prenom, role, num_compte, login, password) values (?,?,?,?,?,?);",
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, pUtilisateur.getNom());
				ps.setString(2, pUtilisateur.getPrenom());
				ps.setString(3, pUtilisateur.getRole());
				ps.setInt(4, pUtilisateur.getNum_compte());
				ps.setString(5, pUtilisateur.getLogin());
				ps.setString(6, pUtilisateur.getPassword());
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
				PreparedStatement ps = c.prepareStatement("DELETE from utilisateur \r\n" + "WHERE id_utilisateur=?");
				ps.setInt(1, pUtilisateur.getId_utilisateur());
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
						.prepareStatement("UPDATE utilisateur \r\n" + "SET nom= ? , prenom =? , role=? , num_compte=? , login=? , password=?\r\n," + "WHERE id_utilisateur=?");
				ps.setString(1, pUtilisateur.getNom());
				ps.setString(2, pUtilisateur.getPrenom());
				ps.setString(3,  pUtilisateur.getRole());
				ps.setInt(4,  pUtilisateur.getNum_compte());
				ps.setString(5, pUtilisateur.getLogin());
				ps.setString(6, pUtilisateur.getPassword());
				ps.setInt(7, pUtilisateur.getId_utilisateur());
				
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	// faire pareil que find by id mais find by login 
	@Override
	public Utilisateur findById(int pId_utilisateur) {
		Utilisateur pUtilisateur = null;
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("select * from utilisateur where id_utilisateur= ?;");
				ps.setInt(1, pId_utilisateur);
				ResultSet r = ps.executeQuery();
				if (r.next())
					pUtilisateur = new Utilisateur(r.getInt("id_utilisateur"),
							r.getString("prenom"), r.getString("nom"), r.getString("role"), r.getInt("num_compte"), r.getString("login"), r.getString("password"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return pUtilisateur;
	}
	

// find by login 
@Override
public Utilisateur findByLogin(String pLogin) {
	Utilisateur pUtilisateur = null;
	Connection c = MyConnection.getConnection();
	if (c != null) {
		try {
			PreparedStatement ps = c.prepareStatement("select * from utilisateur where login= ?;");
			ps.setString(1, pLogin);
			ResultSet r = ps.executeQuery();
			if (r.next())
				pUtilisateur = new Utilisateur(r.getString("login"),
						r.getString("prenom"), r.getString("nom"), r.getString("role"), r.getInt("num_compte"), r.getInt("id_utilisateur"), r.getString("password"));
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
					int id_utilisateur = retour.getInt("id_utilisateur");
					String nom = retour.getString("nom");
					String prenom = retour.getString("prenom");
					String role = retour.getString

					u1.setId_utilisateur(id_utilisateur);
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
