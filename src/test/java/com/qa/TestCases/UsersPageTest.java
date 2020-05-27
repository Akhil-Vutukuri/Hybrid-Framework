package com.qa.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.UsersPage;
import com.qa.util.BaseTest;
import com.qa.util.TestUtil;

public class UsersPageTest extends BaseTest {
	LoginPage loginPage;
	HomePage homePage;
	UsersPage usersPage;

	public UsersPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initilization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		usersPage = new UsersPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}

	/*
	 * @DataProvider public void getTestData() {
	 * 
	 * }
	 */
	int rowCount = TestUtil.get_Row_Size(prop.getProperty("filePath"), prop.getProperty("sheetName"));

	@Test
	public void ValidatecreateUsersTest() {

		for (int i = 0; i < rowCount; i++) {
			
			homePage.clickOnUsersButton();
			
			String firstName = TestUtil.read_Data_from_XLsheet(prop.getProperty("filePath"),
					prop.getProperty("sheetName"), i, 0);
			String lastName = TestUtil.read_Data_from_XLsheet(prop.getProperty("filePath"),
					prop.getProperty("sheetName"), i, 1);
			String username = TestUtil.read_Data_from_XLsheet(prop.getProperty("filePath"),
					prop.getProperty("sheetName"), i, 2);
			String password = TestUtil.read_Data_from_XLsheet(prop.getProperty("filePath"),
					prop.getProperty("sheetName"), i, 3);
			String retryPassword = TestUtil.read_Data_from_XLsheet(prop.getProperty("filePath"),
					prop.getProperty("sheetName"), i, 4);

			usersPage.createUser(firstName, lastName, username, password, retryPassword);
			//TestUtil.takeScreenShot(driver, "E:\\Akhil's\\actiTimePOMCucumber\\target");
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
