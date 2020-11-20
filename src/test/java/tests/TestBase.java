package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import frameworks.loadingConfig.TestLoadManager;

public class TestBase {
	String dbName = "sakila";
	String username = "root";
	String password = "w2w2";
	String connectionString = "jdbc:mysql://localhost/" + dbName + "?user=" + username + "&password=" + password
			+ "&useUnicode=true&characterEncoding=UTF-8";

	@BeforeMethod
	public void beforeMethod() {
		TestLoadManager manager = new TestLoadManager();
		manager.loadConfigurations();
		dbName = manager.dbName;
		username = manager.username;
		password = manager.password;
	}

	@AfterMethod
	public void afterMethod() {

	}
}
