package com.klaf.pageObjects;

import io.appium.java_client.AppiumDriver;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.klaf.javaUtils.*;

public class AideSupVisitObject extends BasePageObjects
{
	
    public AideSupVisitObject(AppiumDriver driver) 
    {
		super(driver);
	}

	public void aideSupervisoryVisit()
    {
    	//Get Test Data
    	TestDataGenerator testData = new TestDataGenerator();
        HashMap<?,?> formObj = testData.generateFormObject("aideSupVisit");
        
        //Fill Form
        
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys((String)formObj.get("FirstName"));
        
        WebElement middleName = driver.findElement(By.id("middleName"));
        middleName.sendKeys((String)formObj.get("MiddleName"));
        
        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys((String)formObj.get("LastName"));
        
        //TODO radio button selection logic
        
        WebElement aideInstructions = driver.findElement(By.id("AideSupVisitInstruction"));
        scrollToElem(aideInstructions);
        aideInstructions.sendKeys((String) formObj.get("Changes"));
        
        WebElement aideComments = driver.findElement(By.id("AideSupVisitComments"));
        scrollToElem(aideComments);
        aideComments.sendKeys((String) formObj.get("Comments"));
        
    }


}
