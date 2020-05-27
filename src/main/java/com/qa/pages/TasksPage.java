package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.BaseTest;

public class TasksPage extends BaseTest {
	@FindBy(xpath="(//div[@class='title ellipsis'])[4]")
	WebElement addNewTasksButton;
	
	public TasksPage(){
		PageFactory.initElements(driver,this);
	}
	public boolean validateTasksPage() {
		return addNewTasksButton.isDisplayed();
	}
}
