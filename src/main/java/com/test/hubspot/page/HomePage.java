package com.test.hubspot.page;

import org.openqa.selenium.By;

import com.test.hubspot.base.BaseConfiguration;
import com.test.hubspot.utils.Utilities;

public class HomePage extends BaseConfiguration{
	
	Utilities util;
	
	//OR by using By instead of PageFactory
	
	By contactsdropdownLink=By.xpath("//div[@class='desktop-nav-left-container']/descendant::a[contains(text(),'Contacts')]");
	By contactsOption=By.xpath("//div[@class='desktop-nav-left-container']/descendant::div[contains(text(),'Contacts')]");
	
	By conversationsLink=By.xpath("//div[@class='desktop-nav-left-container']/descendant::a[contains(text(),'Conversations')]");

	public HomePage()
	{
		util=new Utilities();
	}
	
	//Action Methods
	
	public String validateHomePageTitle()
	{
		util.explicitWaitTillByElementClickable(contactsdropdownLink);
		return driver.getTitle();
	}
	
	public boolean validateContactsDropMenuIsDisplayed()
	{
		util.explicitWaitTillByElementClickable(contactsdropdownLink);
		return driver.findElement(contactsdropdownLink).isDisplayed();
	}
		
	public void validateClickOnContactsDropMenu()
	{		
		util.explicitWaitTillByElementClickable(contactsdropdownLink);
		driver.findElement(contactsdropdownLink).click();
	}
	
	public boolean validateContactsOptionIsDisplayed()
	{
		util.explicitWaitTillByElementClickable(contactsOption);
		return driver.findElement(contactsOption).isDisplayed();
	}
	
	public ContactsPage validateClickOnContactsOption()
	{
		util.explicitWaitTillByElementClickable(contactsOption);
		driver.findElement(contactsOption).click();
		return new ContactsPage();
	}
	
	
	
	
	
	
	
	
	
	

}
