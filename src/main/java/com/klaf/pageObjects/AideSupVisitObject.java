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
    
	String changesText = "";
	String commentsText = "";
	
	//Setters
	public void setChangesText(String changes)
	{
		this.changesText = changes;
	}
	
	public void setCommentsText(String comments)
	{
		this.commentsText = comments;
	}
	
	//Getters
	public String getChangesText()
	{
		return this.changesText;
	}
	
	public String getCommentsText()
	{
		return this.commentsText;
	}

	public void aideSupervisoryVisit()
    {
    	//Get Test Data
    	TestDataGenerator testData = new TestDataGenerator();
        HashMap<?,?> formObj = testData.generateFormObject("aideSupVisit");
        CommonSeleniumUtils selUtil = new CommonSeleniumUtils();
        
        //Fill Form
        
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys((String)formObj.get("FirstName"));
        
        WebElement middleName = driver.findElement(By.id("middleName"));
        middleName.sendKeys((String)formObj.get("MiddleName"));
        
        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys((String)formObj.get("LastName"));
        
        //TODO radio button selection logic
        
        WebElement supDate = driver.findElement(By.xpath("//*[@id='frm_sDate']/label/button"));
        selUtil.scrollToElem(supDate);
        supDate.click();
        
        WebElement supName = driver.findElement(By.id("supervisorName"));
        selUtil.scrollToElem(supName);
        supName.click();
        
        WebElement cliPrsnt = driver.findElement(By.xpath("//*[@id='Visit Assesment']/div/div[1]/div[3]/div/div/div/label[1]/div"));
        selUtil.scrollToElem(cliPrsnt);
        cliPrsnt.click();
        
        WebElement notifyClient = driver.findElement(By.xpath(".//*[@id='Visit Assesment']/div/div[1]/div[4]/div/div/div/label[1]/div"));
        selUtil.scrollToElem(notifyClient);
        notifyClient.click();
        
        WebElement reportDuty = driver.findElement(By.xpath("//*[@id='Visit Assesment']/div/div[1]/div[5]/div/div/div/label[2]/div"));
        selUtil.scrollToElem(reportDuty);
        reportDuty.click();
        
        WebElement coopClient = driver.findElement(By.xpath("//*[@id='Visit Assesment']/div/div[1]/div[6]/div/div/div/label[3]/div"));
        selUtil.scrollToElem(coopClient);
        coopClient.click();
        
        WebElement courtClient = driver.findElement(By.xpath("//*[@id='Visit Assesment']/div/div[1]/div[7]/div/div/div/label[4]/div"));
        selUtil.scrollToElem(courtClient);
        courtClient.click();
        
        WebElement carePlan = driver.findElement(By.xpath("//*[@id='Visit Assesment']/div/div[1]/div[8]/div/div/div/label[1]/div"));
        selUtil.scrollToElem(carePlan);
        carePlan.click();
        
        WebElement docApp = driver.findElement(By.xpath("//*[@id='Visit Assesment']/div/div[1]/div[9]/div/div/div/label[2]/div"));
        selUtil.scrollToElem(docApp);
        docApp.click();
        
        WebElement notifySup = driver.findElement(By.xpath("//*[@id='Visit Assesment']/div/div[1]/div[10]/div/div/div/label[3]/div"));
        selUtil.scrollToElem(notifySup);
        notifySup.click();
        
        WebElement orgPolicy = driver.findElement(By.xpath("//*[@id='Visit Assesment']/div/div[1]/div[11]/div/div/div/label[4]/div"));
        selUtil.scrollToElem(orgPolicy);
        orgPolicy.click();
        
        WebElement aideInstructions = driver.findElement(By.id("AideSupVisitInstruction"));
        selUtil.scrollToElem(aideInstructions);
        aideInstructions.sendKeys((String) formObj.get("Changes"));
        
        WebElement aideComments = driver.findElement(By.id("AideSupVisitComments"));
        selUtil.scrollToElem(aideComments);
        aideComments.sendKeys((String) formObj.get("Comments"));
        
    }

}
