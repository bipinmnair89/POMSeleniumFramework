package com.test.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.hubspot.utils.WebEventListener;

public class BaseConfiguration {
	
	public static Properties prop;
	public static WebDriver driver;
	public WebDriverWait wait;
	
	//Webdriver fire events
	public static EventFiringWebDriver e_driver; 
	public static WebEventListener e_listener;
	
	//constructor of base class with the code for properties file
	public BaseConfiguration()
	{
		try {
		prop=new Properties();
		FileInputStream ip = new FileInputStream("D://Learning//Workspace//POMBasicFramework//src//main//java//com//test//hubspot//properties//config.properties");
		prop.load(ip);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//initialization method to initialize browser, load the url
	public static void initializationMethod()
	{
		prop=new Properties();
		String browser=prop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D://Learning//JARFiles//chromedriver.exe");
			if(prop.getProperty("headless").equals("yes"))
			{
				ChromeOptions options=new ChromeOptions();
				options.setHeadless(true);
				driver=new ChromeDriver(options);
			}
			else
			{
				driver=new ChromeDriver();
			}
			
		}else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "D://Learning//JARFiles//geckodriver.exe");
			if(prop.getProperty("headless").equals("yes"))
			{
				FirefoxOptions options=new FirefoxOptions();
				options.setHeadless(true);
				driver=new FirefoxDriver(options);
			}
			else
			{
				driver=new FirefoxDriver();
			}
			
		}
		//invoking webdriver fire event
		e_driver=new EventFiringWebDriver(driver);
		e_listener=new WebEventListener();
		e_driver.register(e_listener);
		driver=e_driver;
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		
		
	}

}
