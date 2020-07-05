package dao.bdd;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.mariadb.jdbc.MariaDbDataSource;

public class MyDataSourceFactory {
	public static DataSource getMySQLDataSource() {
		Properties props = new Properties();
		InputStream fis = null;
		MariaDbDataSource mariaDbDataSource = null;

		try {
			fis = MyDataSourceFactory.class.getResourceAsStream("/db.properties");
			props.load(fis);
			mariaDbDataSource = new MariaDbDataSource();
			mariaDbDataSource.setUrl(props.getProperty("url"));
			mariaDbDataSource.setUser(props.getProperty("username"));
			mariaDbDataSource.setPassword(props.getProperty("password"));
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return mariaDbDataSource;
	}
}