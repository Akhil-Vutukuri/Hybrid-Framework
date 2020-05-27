package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.BaseTest;

public class UsersPage extends BaseTest {

	@FindBy(xpath = "//div[@class='addUserButton beigeButton useNativeActive']")
	@CacheLookup //this is used to improve the performance speed of test scripts execution. 
	             //and it dosent work if the page is refreshed. 
	             //if we use we get stale element exception,.
	WebElement addNewUserButton;

	@FindBy(name = "firstName")
	WebElement firstNameTB;

	@FindBy(name = "lastName")
	WebElement lastNameTB;

	//@FindBy(id = "userDataLightBox_emailField")
	//WebElement emailTB;

	@FindBy(name = "username")
	WebElement usernameTB;

	@FindBy(name = "password")
	WebElement passwordTB;

	@FindBy(name = "passwordCopy")
	WebElement retypePasswordTB;

	@FindBy(xpath = "//span[text()='Create User']")
	WebElement createUserBtn;

	@FindBy(xpath = "(//div[text()='Cancel'])[1]")
	WebElement cancelBtn;

	public UsersPage() {
		PageFactory.initElements(driver, this);
	}

	public void createUser(String fn, String ln, String un, String pw, String repw) {
		addNewUserButton.click();

		firstNameTB.sendKeys(fn);
		lastNameTB.sendKeys(ln);
		//emailTB.sendKeys(email);
		usernameTB.sendKeys(un);
		passwordTB.sendKeys(pw);
		retypePasswordTB.sendKeys(repw);
		createUserBtn.click();
	}
}
