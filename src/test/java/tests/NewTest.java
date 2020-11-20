package tests;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.Test;

import Navigators.BaseConnector;

public class NewTest extends TestBase {
	String query = "SELECT city FROM city ORDER BY city ASC LIMIT 10;";

	@Test
	public void f() {
		ResultSet rs = new BaseConnector(connectionString).connectDb().query(query);
		try {
			while (rs.next()) {
				System.out.println(rs.getString("city"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
