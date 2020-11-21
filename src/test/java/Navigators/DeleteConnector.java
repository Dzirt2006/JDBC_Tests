package Navigators;

public class DeleteConnector extends BaseConnector {
	String query = "DELETE FROM store WHERE store_id=3;";

	public DeleteConnector(String connectionString) {
		super(connectionString);
	}

	public DeleteConnector connectDb() {
		super.connectDb();
		return this;
	}

	public int deleteStore() {
		return super.executeUpdate(query);
	}
}
