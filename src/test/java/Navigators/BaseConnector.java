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
//		finally {
//			if (stmt != null) {
//				try {
//					stmt.close();
//				} catch (SQLException e) {
//					System.err.println("SQLException: " + e.getMessage());
//				}
//			}
//			if (con != null) {
//				try {
//					con.close();
//				} catch (SQLException e) {
//					System.err.println("SQLException: " + e.getMessage());
//				}
//			}
//		}
		return rs;
	}

	public void executeUpdate(String query) {
		Statement stmt = null;
		try {

			stmt = con.createStatement();

			int code = stmt.executeUpdate(query);
			System.out.println("trying " + code + " <-code");
			System.out.println();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void execute(String query) {
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			boolean code = stmt.execute(query);
			System.out.println("trying " + code);
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
	}

}
