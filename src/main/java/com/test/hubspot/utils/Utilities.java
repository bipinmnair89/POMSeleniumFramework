package com.test.hubspot.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.hubspot.base.BaseConfiguration;

public class Utilities extends BaseConfiguration{
	
	public static void takeScreenshot(long filename)
	{
		TakesScreenshot scrShot=(TakesScreenshot)driver;
		File scrFile=scrShot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("D://Learning//Workspace//POMBasicFramework//Screenshots//Failures//"+filename+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void explicitWaitTillWebElementClickable(WebElement contactsLink)
	{
		wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(contactsLink));
	}
	
	public void explicitWaitTillByElementClickable(By locator)
	{
		wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void explicitWaitTillWebElementVisible(WebElement element)
	{
		wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void explicitWaitTillByElementVisible(By locator)
	{
		wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

}
