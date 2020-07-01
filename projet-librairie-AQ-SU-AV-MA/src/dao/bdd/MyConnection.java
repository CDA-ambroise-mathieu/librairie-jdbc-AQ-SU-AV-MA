package dao.bdd;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

public class MyConnection {
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
}
