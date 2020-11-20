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
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return rs;
	}

	public void executeUpdate(String query) {
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			int code = stmt.executeUpdate(query);
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void execute(String query) {
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			boolean code = stmt.execute(query);
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
	}

}
