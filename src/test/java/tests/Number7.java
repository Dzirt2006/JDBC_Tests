package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Navigators.ProcedureConnector;

public class Number7 extends TestBase {
	@Test
	public void idOfThird() {
		int id = new ProcedureConnector(connectionString).connectDb().queryCreateFunc().queryCallFunc()
				.getAllIdsFromQuery().get(2);
		Assert.assertEquals(id, 75);
	}
	
	@Test
	public void size() {
		int size = new ProcedureConnector(connectionString).connectDb().queryCreateFunc().queryCallFunc()
				.getAllIdsFromQuery().size();
		Assert.assertEquals(size, 4);
	}
	
	
}
