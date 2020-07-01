package dao.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ClientDao;
import models.Client;

public class ClientDaoImpl implements ClientDao{
Client client;
List<Client> listeDesClients = new ArrayList<>();

	@Override
	public Client save(Client obj) {
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
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return client;
	}

	@Override
	public void remove(Client obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Client update(Client obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
