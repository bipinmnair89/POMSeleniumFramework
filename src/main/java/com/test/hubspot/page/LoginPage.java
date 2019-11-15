package com.test.hubspot.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.hubspot.base.BaseConfiguration;
import com.test.hubspot.utils.Utilities;

public class LoginPage extends BaseConfiguration{
	
	Utilities util;
	
	//Page class will have the OR, Init of PageFactory in constructor, the Action methods which returns the data to Test Class
	
	//OR with PageFactory
	@FindBy(xpath="//*[text()='Sign up']")
	@CacheLookup
	WebElement signupLink;
	
	@FindBy(xpath="//*[@id='username']")
	@CacheLookup
	WebElement username;
	
	@FindBy(xpath="//*[@id='password']")
	@CacheLookup
	WebElement password;
	
	@FindBy(xpath="//*[@class='private-checkbox__indicator']")
	@CacheLookup
	WebElement rememberMeCheckbox;
	
	@FindBy(xpath="//*[contains(text(),'Show Password')]")
	@CacheLookup
	WebElement showPasswordLink;
	
	@FindBy(xpath="//*[@type='submit' and @id='loginBtn']")
	@CacheLookup
	WebElement loginButton;
	
	
	//now initialize pagefactory using constructor of the class
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
		util=new Utilities();
	}
	
	//write the action methods that would return specific values for assertion in test classes
	
	public String validateLoginPageTitle()
	{
		util.explicitWaitTillWebElementClickable(username);
		String pageTitle=driver.getTitle();
		return pageTitle;
	}
	
	public boolean validateUsernameTextboxDisplayed()
	{
		return username.isDisplayed();
	}
	
	public boolean validatePasswordTextboxDisplayed()
	{
		return password.isDisplayed();
	}
	
	public HomePage validateLogin(String paramUsername,String paramPassword)
	{
		username.clear();
		username.sendKeys(paramUsername);
		password.clear();
		password.sendKeys(paramPassword);
		loginButton.click();
		return new HomePage();  //as we are navigating to homepage on click of login button
	}

}
