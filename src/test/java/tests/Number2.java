package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Navigators.AirplaneConnector;

public class Number2 extends TestBase {

	@Test
	public void querySize() {
		int size = new AirplaneConnector(connectionString).connectDb().query().getAllFilmsFromQuery().size();
		Assert.assertEquals(size, 2);
	}

	@Test
	public void secondTitle() {
		String expected = "RAGING AIRPLANE";
		String actual = new AirplaneConnector(connectionString).connectDb().query().getAllFilmsFromQuery().get(1)
				.getTitle();
		Assert.assertEquals(actual, expected);
	}

}
