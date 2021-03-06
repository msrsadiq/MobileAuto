package com.klaf.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;

public class NewDocObject extends BasePageObjects
{
	public NewDocObject(AppiumDriver driver)
	{
		super(driver);
	}
	
	public void openForm(String formName)
	{
		try
		{
			WebElement form = driver.findElement(By.id(formName));
			String name = form.getText();
			System.out.println("Opening Form: "+name);
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.elementToBeClickable(form));
			form.click();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
