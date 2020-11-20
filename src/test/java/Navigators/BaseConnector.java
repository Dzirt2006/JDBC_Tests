package Navigators;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseConnector {
	String connectionString;
	Connection con;

	public BaseConnector(String connectionString) {
		this.connectionString = connectionString;
	}

	public BaseConnector connectDb() {
		try {
			con = DriverManager.getConnection(connectionString);
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return this;
	}

	public ResultSet query(String query) {
		ResultSet rs = null;
		try {
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(query);

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return rs;
	}

}
