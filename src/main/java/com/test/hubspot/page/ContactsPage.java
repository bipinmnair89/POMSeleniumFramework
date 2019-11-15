package com.test.hubspot.page;

import org.openqa.selenium.By;

import com.test.hubspot.base.BaseConfiguration;
import com.test.hubspot.utils.Utilities;

public class ContactsPage extends BaseConfiguration{
	
	Utilities util;
	
	public ContactsPage()
	{
		util=new Utilities();
	}

	//OR - Object repository
	By pageHeader=By.xpath("//div[@class='private-header__inner']/descendant::*[contains(text(),'Contacts')]");
	By createContactBtn=By.xpath("//div[@class='m-left-3 UIColumn-content']/descendant::span[contains(text(),'Create contact')]");
	
	//Action Methods
	public String validateContactsPageTitle()
	{
		util.explicitWaitTillByElementVisible(createContactBtn);
		return driver.getTitle();
	}
	public String validateContactsPageHeader()
	{
		util.explicitWaitTillByElementVisible(pageHeader);
		return driver.findElement(pageHeader).getText();
	}
	public boolean validateCreateContactBtn()
	{
		util.explicitWaitTillByElementVisible(createContactBtn);
		return driver.findElement(createContactBtn).isEnabled();
	}

}
