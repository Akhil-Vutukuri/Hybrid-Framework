package com.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.TasksPage;
import com.qa.util.BaseTest;

public class HomePageTest extends BaseTest {
	LoginPage loginPage;
	HomePage homePage;
	TasksPage tasksPage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initilization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		tasksPage = new TasksPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	// test cases should be seperated - independent to each other.
	// before each test case - launch the browser and login.
	// before each test case - close the browser.

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String title = homePage.validateHomePageTitle();
		Assert.assertEquals(title, "actiTIME - Enter Time-Track", "HomePage title is not matched");
	}

	@Test(priority = 2)
	public void clickOnTasksButton() {
		tasksPage = homePage.clickOnTasksButton();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
