package com.generic;

import io.appium.java_client.AppiumDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericMMT {

	public static void explicitWait(WebDriver driver, WebElement element,long duration)
	{
		WebDriverWait wait  = new WebDriverWait(driver, duration);
		wait.until(ExpectedConditions.visibilityOf(element));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static void swipeAndSelctDate(AppiumDriver driver,String monthXpath,String dateSelectXpath) throws InterruptedException
	{
		Dimension size = driver.manage().window().getSize();
		int starty = (int)(size.height*0.60);
		int endy = (int)(size.height*0.30);
		int startx = (int)(size.width*0.50);
		
		do
  		{   
  			List<WebElement> monthList = driver.findElementsByXPath(monthXpath);
  			int size1 = monthList.size();
  			System.out.println("Size : "+size1);
  			
  			if(size1>0)
  			{
  				System.out.println("Month Found, Size : "+size1);
  				//driver.swipe(startx, starty, startx, endy, 500);
  				System.out.println("Selected month");
  				
  				explicitWait(driver, driver.findElementByXPath(dateSelectXpath), 20);
  			    driver.findElementByXPath(dateSelectXpath).click();
  				break;
  			}

  			driver.swipe(startx, starty, startx, endy, 500);
  		}while(true);
	}
}
