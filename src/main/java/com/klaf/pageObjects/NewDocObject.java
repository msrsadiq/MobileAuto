package com.klaf.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;

public class NewDocObject 
{
	protected AppiumDriver driver;
	
	public NewDocObject(AppiumDriver driver)
	{
		this.driver = driver;
	}
	
	public void openForm(String formName)
	{
		try
		{
			WebElement aideSup = driver.findElement(By.id(formName));
			String name = aideSup.getText();
			System.out.println(name);
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.elementToBeClickable(aideSup));
			System.out.println("Navigating to Aide Supervisory Visit form");
			aideSup.click();

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
