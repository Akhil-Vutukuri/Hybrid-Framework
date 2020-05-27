package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.BaseTest;

public class LoginPage extends BaseTest {

	// declaration
	@FindBy(id = "username")
	private WebElement unTB;

	@FindBy(name = "pwd")
	private WebElement pwTB;

	@FindBy(xpath = "//div[text()='Login ']")
	private WebElement LgnBTN;

	@FindBy(xpath = "//span[contains(text(),'invalid.')]")
	private WebElement ErrMSG;

	// Initialization
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// utilization
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public HomePage login(String un, String pw) {
		unTB.sendKeys(un);
		pwTB.sendKeys(pw);
		LgnBTN.click();
		return new HomePage();
	}
}
