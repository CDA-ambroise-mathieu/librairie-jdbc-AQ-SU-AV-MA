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

		LibraireDaoImpl lib = new LibraireDaoImpl();
		List<Libraire> liste = new ArrayList<>();
		Libraire toto = new Libraire(4, "Test", "Toto", "libraire", 22, "NobToto", "112SS");
//		lib.save(toto);
//		lib.removeById(5);
		lib.update(toto);

		liste = lib.getAll();
		for (Libraire libraire : liste) {
			System.out.println(libraire);
		}

	}
}
