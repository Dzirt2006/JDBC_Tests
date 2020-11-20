package Navigators;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Number7Connector extends BaseConnector {
	String query = "CALL getInv(2,'Alien Center');";
	String function="CREATE PROCEDURE  getInv(IN storeId INT , IN filmTitle VARCHAR(45)) BEGIN SELECT I.inventory_id FROM store as S join inventory AS I on S.store_id=I.store_id and S.store_id=storeId join film as F on F.film_id=I.film_id where F.title=filmTitle; END";
//	String function = "CREATE PROCEDURE  getInv(IN storeId INT , IN filmTitle VARCHAR(45))" + " BEGIN "
//			+ " SELECT I.inventory_id " + " FROM store as S " + " join inventory AS I "
//			+ " on S.store_id=I.store_id and S.store_id=storeId " + " join film as F "
//			+ " on F.film_id=I.film_id where F.title=filmTitle; " + " END // ";

	ResultSet resultSet;
	List<Integer> ids;
	{
		ids = new ArrayList<>();
	}

	public Number7Connector(String connectionString) {
		super(connectionString);
	}

	public Number7Connector connectDb() {
		super.connectDb();
		return this;
	}

	public Number7Connector queryCreateFunc() {
		super.execute(function);
		return this;
	}

	public Number7Connector queryCallFunc() {
		resultSet = super.query(query);
		return this;
	}

	public List<Integer> getAllIdsFromQuery() {
		try {
			while (resultSet.next()) {
				int id = resultSet.getInt("INVENTORY_ID");
				ids.add(id);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ids;
	}
}
