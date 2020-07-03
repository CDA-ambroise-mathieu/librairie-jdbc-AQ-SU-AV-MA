package dao.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ClientDao;
import models.Client;
import models.Utilisateur;

public class ClientDaoImpl implements ClientDao {
	Client client;
	List<Client> listeDesClients = new ArrayList<>();

	@Override
	public Client save(Client pClient) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			PreparedStatement ps;
			try {
				ps = c.prepareStatement(
						"INSERT INTO utilisateur (nom,prenom,role,num_compte,login,password) values (?,?,?,?,?,?); ",
						PreparedStatement.RETURN_GENERATED_KEYS);

				ps.setString(1, pClient.getNom());
				ps.setString(2, pClient.getPrenom());
				ps.setString(3, pClient.getRole());
				ps.setInt(4, pClient.getNum_compte());
				ps.setString(5, pClient.getLogin());
				ps.setString(6, pClient.getPassword());
				ps.executeUpdate();

				ResultSet resultat = ps.getGeneratedKeys();
				if (resultat.next()) {
					pClient.setId_utilisateur(resultat.getInt(1));
					listeDesClients.add(pClient);
					return pClient;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public void remove(Client pClient) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("DELETE FROM utilisateur WHERE id = ?;");
				ps.setInt(1, client.getId_utilisateur());
				int nbr = ps.executeUpdate();
				listeDesClients.remove(client);
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

	// Update exemple du nom et prenom, recup avec id via findById
	// A Revoir
	@Override
	public Client update(Client pClient) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("UPDATE utilisateur SET nom= ? , prenom =? WHERE id=?");
				ps.setString(1, pClient.getNom());
				ps.setString(1, pClient.getPrenom());
				ps.setInt(3, pClient.getId_utilisateur());
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Client findById(int id) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("SELECT * FROM utilisateur WHERE id_utilisateur = ?;");
				ps.setInt(1, client.getId_utilisateur());
				ResultSet r = ps.executeQuery();

				// Avec un constructeur simple idbdd, nom , prenom
				if (r.next()) {
					client = new Client(r.getInt("id_utilisateur"), r.getString("prenom"), r.getString("nom"),
							r.getString("role"), r.getInt("num_compte"), r.getString("login"), r.getString("password"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return client;
	}

	@Override
	public List<Client> getAll() {
		Connection c = MyConnection.getConnection();
		List<Client> listeClients = new ArrayList<>();
		PreparedStatement ps;

		try {
			ps = c.prepareStatement("SELECT * FROM utilisateur WHERE role = 'client';");
			ResultSet vResultatSelect = ps.executeQuery();

			// Exemple avec Client idbdd, nom, prenom --> autres attributs à ajouter
			int vId;
			String vNom;
			String vPrenom;

			while (vResultatSelect.next()) {
				vId = vResultatSelect.getInt("id_utilisateur");
				vNom = vResultatSelect.getString("nom");
				vPrenom = vResultatSelect.getString("prenom");

				client = new Client(vId, vNom, vPrenom);

				listeClients.add(client);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listeClients;
	}

	@Override
	public Client findByPrenom(String pPrenom) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("SELECT * FROM livre WHERE prenom = ?;");
				ps.setString(1, pPrenom);
				ResultSet r = ps.executeQuery();
				if (r.next()) {
					client = new Client(r.getInt("id_utilisateur"), r.getString("prenom"), r.getString("nom"),
							r.getString("role"), r.getInt("num_compte"), r.getString("login"), r.getString("password"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return client;
	}

	@Override
	public Client findByNom(String pNom) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("SELECT * FROM livre WHERE nom = ?;");
				ps.setString(1, pNom);
				ResultSet r = ps.executeQuery();
				if (r.next()) {
					client = new Client(r.getInt("id_utilisateur"), r.getString("prenom"), r.getString("nom"),
							r.getString("role"), r.getInt("num_compte"), r.getString("login"), r.getString("password"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return client;
	}

	@Override
	public Client findByNumCompte(int pNumCompte) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("SELECT * FROM livre WHERE num_compte = ?;");
				ps.setInt(1, pNumCompte);
				ResultSet r = ps.executeQuery();
				if (r.next()) {
					client = new Client(r.getInt("id_utilisateur"), r.getString("prenom"), r.getString("nom"),
							r.getString("role"), r.getInt("num_compte"), r.getString("login"), r.getString("password"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return client;
	}

	@Override
	public Utilisateur findByLogin(String pLogin) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("SELECT * FROM livre WHERE login = ?;");
				ps.setString(1, pLogin);
				ResultSet r = ps.executeQuery();
				if (r.next()) {
					client = new Client(r.getInt("id_utilisateur"), r.getString("prenom"), r.getString("nom"),
							r.getString("role"), r.getInt("num_compte"), r.getString("login"), r.getString("password"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return client;
	}

}
