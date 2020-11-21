package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Navigators.DeleteConnector;

public class Number10 extends TestBase {
	@Test
	public void deleteStore() {
		int actual = new DeleteConnector(connectionString).connectDb().deleteStore();
		Assert.assertEquals(actual, 1);
	}
}
