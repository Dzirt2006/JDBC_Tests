package Navigators;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirplaneConnector extends BaseConnector {
	String query = "SELECT * FROM film WHERE title LIKE '%airplane%';";
	ResultSet resultSet;
	List<Film> films;
	{
		films = new ArrayList<>();
	}

	public AirplaneConnector(String connectionString) {
		super(connectionString);
	}

	public AirplaneConnector connectDb() {
		super.connectDb();
		return this;
	}

	public AirplaneConnector query() {
		resultSet = super.query(query);
		return this;
	}

	public List<Film> getAllFilmsFromQuery() {
		try {
			while (resultSet.next()) {

				int id = resultSet.getInt("FILM_ID");
				String title = resultSet.getString("TITLE");
				String description = resultSet.getString("DESCRIPTION");
				Film obj = new Film(id, title, description);
				films.add(obj);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return films;
	}

}

