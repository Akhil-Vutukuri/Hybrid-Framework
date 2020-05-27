package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.BaseTest;

public class HomePage extends BaseTest {

	@FindBy(xpath = "//a[@class='content tasks']")
	WebElement tasksButton;

	@FindBy(xpath = "//div[text()='USERS']")
	WebElement usersButton;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String validateHomePageTitle() {
		return driver.getTitle();
	}

	public TasksPage clickOnTasksButton() {
		tasksButton.click();
		return new TasksPage();
	}

	public UsersPage clickOnUsersButton() {
		usersButton.click();
		return new UsersPage();
	}

}
