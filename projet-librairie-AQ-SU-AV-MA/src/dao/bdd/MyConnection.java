package dao.bdd;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import models.Libraire;

class MyConnection {
	private static Connection connexion = null;

	private MyConnection() {

		DataSource dataSource = MyDataSourceFactory.getMySQLDataSource();
		try {
			connexion = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		if (connexion == null) {
			new MyConnection();
		}
		return connexion;
	}

	public static void main(String args[]) {
		String requete = "SELECT * FROM Utilisateur;";
		try {
			Connection co = MyConnection.getConnection();
			PreparedStatement statement = co.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				int str = result.getInt("id_utilisateur");
				System.out.println("Ca marche "+str);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
