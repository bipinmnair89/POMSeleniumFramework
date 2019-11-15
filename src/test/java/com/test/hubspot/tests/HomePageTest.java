package com.test.hubspot.tests;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.test.hubspot.base.BaseConfiguration;
import com.test.hubspot.page.ContactsPage;
import com.test.hubspot.page.HomePage;
import com.test.hubspot.page.LoginPage;
import com.test.hubspot.utils.Utilities;

public class HomePageTest extends BaseConfiguration{
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	
	SoftAssert softassert;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void initialSetup()
	{
		initializationMethod();
		loginpage=new LoginPage();
		homepage=loginpage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority=1)
	public void validateHomePageTitleTest()
	{
		String homepageTitle=homepage.validateHomePageTitle();
		System.out.println("The actual homepage title is : "+homepageTitle);
		Assert.assertEquals(homepageTitle, "Account Setup | HubSpot");
	}
	@Test(priority=1)
	public void validatedContactsIsDisplayedTest()
	{
		softassert=new SoftAssert();
		softassert.assertTrue(homepage.validateContactsDropMenuIsDisplayed());
		homepage.validateClickOnContactsDropMenu();
		softassert.assertTrue(homepage.validateContactsOptionIsDisplayed());
		softassert.assertAll();
	}
	@Test(priority=1)
	public void validateNavigationToContactsTest()
	{
		homepage.validateClickOnContactsDropMenu();
		contactspage=homepage.validateClickOnContactsOption();
		
		//validation after navigation
		String contactspageTitle=contactspage.validateContactsPageTitle();
		System.out.println("The actual contacts page title is : "+contactspageTitle);
		Assert.assertEquals(contactspageTitle, "Contacts");
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
	
	
}
	

