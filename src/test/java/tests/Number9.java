package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Navigators.UpdateConnector;

public class Number9 extends TestBase {
	@Test
	public void querySize() {
		boolean actual = new UpdateConnector(connectionString).connectDb().queryUpdate().compareStamps();
		Assert.assertEquals(actual, true);
	}
}
