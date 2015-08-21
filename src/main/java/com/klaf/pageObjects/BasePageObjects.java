package com.klaf.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;

public class BasePageObjects 
{
	protected AppiumDriver driver;
	
	public BasePageObjects(AppiumDriver driver)
	{
		this.driver = driver;
	}

	public void initialLoginAttempt(String userName, String password)
	{
        WebElement username = driver.findElement(By.id("username"));
        if(username.isDisplayed())
        {
        	username.sendKeys(userName);
        }
        
        WebElement pwd = driver.findElement(By.id("password"));
        pwd.sendKeys(password);
        
        WebElement loginButton = driver.findElement(By.id("btnSignIn"));
        loginButton.click();
	}
	
	public void navtoSideMenu()
	{

	}
	
	//Navigating from Hotbox to New Documents by taping on New Documents button
	public void navtoNewDocFromHotbox()
	{
		try
		{
	        WebDriverWait wait = new WebDriverWait(driver, 60);
	        WebElement element = driver.findElement(By.id("newDoc"));
	        wait.until(ExpectedConditions.elementToBeClickable(element));
	   
	        if (element.isDisplayed())
	        	element.click();
	        else
	        	System.out.println("Element not present");
	        
	        Thread.sleep(2000);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
 
	}

}
