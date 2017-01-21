package com.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.utility.PropertyUtility;

public class MasterMMTTest {

	public static AppiumDriver driver;
	public static Process process;
	
	@BeforeTest
	public void launchApp() throws IOException, InterruptedException
	{
		
		//Start Appium Server
		String start_Server = "D:\\AppiumServer\\node.exe D:\\AppiumServer\\node_modules\\appium\\bin\\appium.js";
	    process = Runtime.getRuntime().exec(start_Server);
	    Thread.sleep(10000);
	    
	    if(process!=null)
	    {
	    	System.out.println("Appium Server Started");
	    }
		
		// Set up capabilities
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		
	    String deviceName = PropertyUtility.readPropertyFile("./mmt.properties", "deviceName");
	    String platformName = PropertyUtility.readPropertyFile("./mmt.properties", "platformName");
	    String platformVersion = PropertyUtility.readPropertyFile("./mmt.properties", "platformVersion");
	    String appPackage = PropertyUtility.readPropertyFile("./mmt.properties", "appPackage");
	    String appActivity = PropertyUtility.readPropertyFile("./mmt.properties", "appActivity");

		capabilities.setCapability("deviceName",deviceName);
		capabilities.setCapability("platformName",platformName);
		capabilities.setCapability("platformVersion",platformVersion);
		
		capabilities.setCapability("appPackage",appPackage);
		capabilities.setCapability("appActivity",appActivity);

		//Pass capabilities to appium server
	    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub/"),capabilities);
	    System.out.println("App Launched");
	}
	
	@AfterTest
	public void closeApp() throws InterruptedException
	{
		//close app
		driver.close();
		
		//Stop appium server
	    if(process!=null)
	    {
	    	
	    	process.destroy();
		    Thread.sleep(4000);
	    	
	    	System.out.println("Appium Server Stopped");
	    }
	}
	
}
