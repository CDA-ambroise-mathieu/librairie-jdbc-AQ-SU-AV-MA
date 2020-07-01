package dao.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ClientDao;
import models.Client;

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
						"INSERT INTO utilisateur (nom,prenom,numeroCompte,login,motDePasse,role) values (?,?,?,?,?,?); ",
						PreparedStatement.RETURN_GENERATED_KEYS);

				ps.setString(1, client.getNom());
				ps.setString(2, client.getPrenom());
				ps.setString(3, client.getNumeroCompte());
				ps.setString(4, client.getLogin());
				ps.setString(5, client.getMotDePasse());
				ps.setString(6, client.getRole());
				ps.executeUpdate();

				ResultSet resultat = ps.getGeneratedKeys();
				if (resultat.next()) {
					client.setIdBDD(resultat.getInt(1));
					listeDesClients.add(client);
					return client;
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
				PreparedStatement ps = c.prepareStatement("DELETE FROM utilisateur WHERE idBB = ?;");
				ps.setInt(1, client.getIdBDD());
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

	
	//Update exemple du nom et prenom, recup avec id
	@Override
	public Client update(Client pClient) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("UPDATE utilisateur SET nom= ? , prenom =? WHERE idBDD=?");
				ps.setString(1, pClient.getNom());
				ps.setString(1, pClient.getPrenom());
				ps.setInt(3, pClient.getIdBDD());
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
				PreparedStatement ps = c.prepareStatement("SELECT * FROM utilisateur WHERE idBDD = ?;");
				ps.setInt(1, client.getIdBDD());
				ResultSet r = ps.executeQuery();
				
				//Avec un constructeur simple idbdd, nom , prenom
				if (r.next()) {
					client = new Client(r.getInt("idBDD"), r.getString("nom"), r.getString("prenom"));
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

			//Exemple avec Client idbdd, nom, prenom --> autres attributs à ajouter
			int vIdBDD;
			String vNom;
			String vPrenom;

			while (vResultatSelect.next()) {
				vIdBDD = vResultatSelect.getInt("idBDD");
				vNom = vResultatSelect.getString("nom");
				vPrenom = vResultatSelect.getString("prenom");

				client = new Client(vIdBDD, vNom, vPrenom);

				listeClients.add(client);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listeClients;
	}

}
