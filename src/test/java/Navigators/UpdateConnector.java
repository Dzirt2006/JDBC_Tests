package Navigators;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;


public class UpdateConnector extends BaseConnector {
	PreparedStatement stmt;
	Timestamp date;
	ResultSet resultSet;
	String query = "SELECT * FROM store;";
	String queryInsert0 = "SET SQL_SAFE_UPDATES = 0;";
	String queryInsert1 = "UPDATE store AS s JOIN address AS a ON a.address_id=s.address_id SET s.last_update = ? WHERE a.address = '777 Hunter';";
	String queryInsert2 = "SET SQL_SAFE_UPDATES = 1;";

	{
		date = new Timestamp(new java.util.Date().getTime());
	}

	public UpdateConnector(String connectionString) {
		super(connectionString);
	}

	public UpdateConnector connectDb() {
		super.connectDb();
		return this;
	}

	public UpdateConnector queryUpdate() {
		stmt = super.prepareState(queryInsert1);
		try {
			stmt.setTimestamp(1, date);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		super.executeUpdate(queryInsert0);
		super.execPreparedState(stmt);
		super.executeUpdate(queryInsert2);
		return this;
	}

	public boolean compareStamps() {
		String select = "SELECT * FROM store WHERE store_id=3";
		Timestamp actualTime = null;
		ResultSet rs = query(select);
		try {
			while (rs.next()) {
				actualTime = rs.getTimestamp("last_update");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(actualTime);
//		String actualTimestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		return actualTime.after(date) || actualTime.equals(date);
	}
}
