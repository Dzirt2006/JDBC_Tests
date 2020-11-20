package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Navigators.AddStroreConnector;

public class Number8 extends TestBase {
	AddStroreConnector testConn = new AddStroreConnector(connectionString).connectDb();

	@Test
	public void querySize() {
		int size = testConn.queryInsert().queryGet().getAllStores().size();
		Assert.assertEquals(size, 3);
	}

	@Test
	public void secondTitle() {
		int expected = 3;
		int actual = testConn.queryInsert().queryGet().getAllStores().get(2).getId();
		Assert.assertEquals(actual, expected);
	}
}
