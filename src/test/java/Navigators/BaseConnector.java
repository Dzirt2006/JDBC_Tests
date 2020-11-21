package Navigators;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseConnector {
	String connectionString;
	public Connection con;

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

	public PreparedStatement prepareState(String state) {
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(state);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stmt;
	}

	public void execPreparedState(PreparedStatement state) {
		try {
			state.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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

	public int executeUpdate(String query) {
		Statement stmt = null;
		int effected = 0;
		try {
			stmt = con.createStatement();
			effected = stmt.executeUpdate(query);
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return effected;
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

	public void startTransaction() {
		try {
			con.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void commitTransaction() {
		try {
			con.commit();
			con.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void rollbackTransaction() {

	}

}
