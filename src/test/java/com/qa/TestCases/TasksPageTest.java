package com.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.TasksPage;
import com.qa.util.BaseTest;

public class TasksPageTest extends BaseTest {
	LoginPage loginPage;
	TasksPage tasksPage;
	HomePage homePage;

	@BeforeMethod
	public void setUp() {
		initilization();
		loginPage = new LoginPage();
		tasksPage = new TasksPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		tasksPage = homePage.clickOnTasksButton();
	}

	@Test
	public void validateTasksPageTest() {
		boolean flag = tasksPage.validateTasksPage();
		Assert.assertTrue(flag);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
