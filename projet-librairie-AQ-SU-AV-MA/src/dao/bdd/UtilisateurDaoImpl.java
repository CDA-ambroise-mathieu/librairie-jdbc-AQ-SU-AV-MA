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
//	

	@Override
	public Utilisateur save(Utilisateur pUtilisateur) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("insert into utilisateur (nom, prenom, role, login, password,inscrit, masque) values (?,?,?,?,?,?,?);",
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, pUtilisateur.getNom());
				ps.setString(2, pUtilisateur.getPrenom());
				ps.setString(3, pUtilisateur.getRole());
				ps.setString(4, pUtilisateur.getLogin());
				ps.setString(5, pUtilisateur.getPassword());
				ps.setBoolean(6, pUtilisateur.getInscrit());
				ps.setBoolean(7, pUtilisateur.getMasque());
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
						.prepareStatement("UPDATE utilisateur SET nom= ? , prenom =? , role=?, inscrit=?, masque=? WHERE id_utilisateur=?");
				ps.setString(1, pUtilisateur.getNom());
				ps.setString(2, pUtilisateur.getPrenom());
				ps.setString(3,  pUtilisateur.getRole());
				ps.setBoolean(4, pUtilisateur.getInscrit());
				ps.setBoolean(5, pUtilisateur.getMasque());
				ps.setInt(6, pUtilisateur.getId_utilisateur());
				
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
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
							r.getString("nom"), r.getString("prenom"), r.getString("role"), r.getString("login"), r.getString("password"), r.getBoolean("inscrit"), r.getBoolean("masque"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return pUtilisateur;
	}
	


 public Utilisateur findByLogin(String pLogin) {
	Utilisateur pUtilisateur = null;
	Connection c = MyConnection.getConnection();
	if (c != null) {
		try {
			PreparedStatement ps = c.prepareStatement("select * from utilisateur where login= ?;");
			ps.setString(1, pLogin);
			ResultSet r = ps.executeQuery();
			if (r.next())
				pUtilisateur = new Utilisateur(r.getString("nom"), r.getString("prenom"), r.getString("role"), r.getString("login"), r.getString("password"), r.getBoolean("inscrit"), r.getBoolean("masque"));
			} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return pUtilisateur;
}

	@Override
	public List<Utilisateur> getAll() {

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
					String role = retour.getString("role");
					String login = retour.getString("login");
					String password = retour.getString("password");

					u1.setId_utilisateur(id_utilisateur);
					u1.setNom(nom);
					u1.setPrenom(prenom);
					u1.setRole(role);
					u1.setLogin(login);
					u1.setPassword(password);
					listeRetour.add(u1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listeRetour;
	}

}
