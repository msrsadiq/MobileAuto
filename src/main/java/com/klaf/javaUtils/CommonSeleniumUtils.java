package com.klaf.javaUtils;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CommonSeleniumUtils 
{
	protected AppiumDriver driver;

	public void webdriverWait()
	{
		
	}
	
    public void scrollToElem(WebElement element)
    {
    	Actions action = new Actions(driver);
        Actions actionScroll = action.moveToElement(element);
        actionScroll.perform();
    }

}
