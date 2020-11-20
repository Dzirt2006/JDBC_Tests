package Navigators;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddStroreConnector extends BaseConnector {
	String query = "SELECT * FROM store;";
	String queryInsert0 = "INSERT INTO staff( first_name, last_name, address_id, email,store_id, username) "
			+ "    VALUES( 'John', 'Doe', 3, 'pampa@gmail.com',2,'staff'); ";
	String queryInsert1 = "  SET @staffId=LAST_INSERT_ID();";
	String queryInsert2 = "    INSERT INTO address( address, district, city_id, phone, location) "
			+ "    VALUES( '777 Hunter', '13', 300,2344445,ST_GeomFromText('POINT(1 1)'));";
	String queryInsert3 = "    SET @addressID=LAST_INSERT_ID()";
	String queryInsert4 = "INSERT INTO store( manager_staff_id, address_id) VALUES( @staffId, @addressID);";
	ResultSet resultSet;
	List<Store> stores;
	{
		stores = new ArrayList<>();
	}

	public AddStroreConnector(String connectionString) {
		super(connectionString);
	}

	public AddStroreConnector connectDb() {
		super.connectDb();
		return this;
	}

	public AddStroreConnector queryInsert() {
		// I thought about executeBatch() ,but we have a different tables and also set variables
		super.executeUpdate(queryInsert0);
		super.executeUpdate(queryInsert1);
		super.executeUpdate(queryInsert2);
		super.executeUpdate(queryInsert3);
		super.executeUpdate(queryInsert4);
		return this;
	}

	public AddStroreConnector queryGet() {
		resultSet = super.query(query);
		return this;
	}

	public List<Store> getAllStores() {
		try {
			while (resultSet.next()) {
				int id = resultSet.getInt("STORE_ID");
				int managerId = resultSet.getInt("manager_staff_id");
				int addressId = resultSet.getInt("address_id");
				Store obj = new Store(id, managerId, addressId);
				stores.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stores;
	}
}
