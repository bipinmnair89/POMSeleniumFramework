package com.test.hubspot.tests;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.hubspot.base.BaseConfiguration;
import com.test.hubspot.page.HomePage;
import com.test.hubspot.page.LoginPage;
import com.test.hubspot.utils.Utilities;

public class LoginPageTest extends BaseConfiguration{
	
	LoginPage loginpage;
	HomePage homepage;
	Utilities util;
	

	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void initialSetup()
	{
		initializationMethod();
		loginpage=new LoginPage();
		util=new Utilities();
	}
	
	@Test(priority=0)
	public void loginPageTitleTest()
	{
		String loginPageTitle=loginpage.validateLoginPageTitle();
		System.out.println("Actual LoginPage title is : "+loginPageTitle);
		Assert.assertEquals(loginPageTitle, "HubSpot Login");
	}
	@Test(priority=0)
	public void textboxIsDisplayedTest()
	{
		Boolean usernameValue=loginpage.validateUsernameTextboxDisplayed();
		Assert.assertTrue(usernameValue);
		Boolean passwordValue=loginpage.validatePasswordTextboxDisplayed();
		Assert.assertTrue(passwordValue);
	}
	@Test(priority=0)
	public void loginTest()
	{
		homepage=loginpage.validateLogin(prop.getProperty("username"),prop.getProperty("password"));
		
		//validation after navigation
		String homepageTitle=homepage.validateHomePageTitle();
		System.out.println("The actual homepage title is : "+homepageTitle);
		Assert.assertEquals(homepageTitle, "Account Setup | HubSpot");
	}
	
	@AfterMethod
	public void tearDown()
	{
//		Utilities.takeScreenshot(System.currentTimeMillis()); //not using object as the method is static
		driver.close();
	}
	
	
}