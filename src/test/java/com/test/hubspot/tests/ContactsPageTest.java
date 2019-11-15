package com.test.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.hubspot.base.BaseConfiguration;
import com.test.hubspot.page.ContactsPage;
import com.test.hubspot.page.HomePage;
import com.test.hubspot.page.LoginPage;

public class ContactsPageTest extends BaseConfiguration{
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	
	public ContactsPageTest()
	{
		super();
	}

	@BeforeMethod
	public void initializeSetup()
	{
		initializationMethod();
		loginpage=new LoginPage();
		homepage=loginpage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		homepage.validateClickOnContactsDropMenu();
		contactspage=homepage.validateClickOnContactsOption();
		
	}
	@Test(priority=2)
	public void validateContactsPageTitleTest()
	{
		String contactspageTitle=contactspage.validateContactsPageTitle();
		System.out.println("The actual contacts page title is : "+contactspageTitle);
		Assert.assertEquals(contactspageTitle, "Contacts");
	}
	
	@Test(priority=2)
	public void validateContactsPageHeaderTest()
	{
		String actualHeader=contactspage.validateContactsPageHeader();
		System.out.println("The actual contacts page header is : "+actualHeader);
		Assert.assertEquals(actualHeader, "Contacts");
	}
	
	@Test(priority=2)
	public void validateCreateContactBtnTest()
	{
		Assert.assertTrue(contactspage.validateCreateContactBtn());
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
}
