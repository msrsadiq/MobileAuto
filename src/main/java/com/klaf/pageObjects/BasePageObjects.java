package com.klaf.pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;

public class BasePageObjects 
{
	protected AppiumDriver driver;
	
	//WebDriver driver;

	public BasePageObjects(AppiumDriver driver) 
	{
		this.driver = driver;
	}

	public void initialLoginAttempt(String userName, String password) 
	{
		try 
		{
			System.out.println("Entering Credentials");
			WebElement un = driver.findElement(By.id("username"));
			if (un.isDisplayed())
			{
				un.sendKeys(userName);
			}

			WebElement pwd = driver.findElement(By.id("password"));
			pwd.sendKeys(password);

			WebElement loginButton = driver.findElement(By.id("sign_In"));
			loginButton.click();
			
			Thread.sleep(5000);
			System.out.println("Login Successful");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	public void navtoSideMenu() 
	{

	}

	// Navigating from Hotbox to New Documents by taping on New Documents button
	public void navtoNewDocFromHotbox() 
	{
		try 
		{
			System.out.println("Navigating to New Documents");
			WebDriverWait wait = new WebDriverWait(driver, 60);
			WebElement element = driver.findElement(By.id("newDoc_hotbox"));
			wait.until(ExpectedConditions.elementToBeClickable(element));

			if (element.isDisplayed())
				element.click();
			else
				System.out.println("Element not present");

			Thread.sleep(1000);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

}
