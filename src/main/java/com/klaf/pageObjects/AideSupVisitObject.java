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
        CommonSeleniumUtils selUtil = new CommonSeleniumUtils(driver);
        
        //Fill Form
        System.out.println("Filling Aide Sup Visit");
        WebElement myForm = driver.findElement(By.xpath("html/body/ion-nav-view/ion-side-menus/ion-side-menu-content/ion-nav-bar/div[3]/ion-header-bar/div[2]/span"));
        System.out.println("Filling :"+myForm.getText());	
        
        WebElement firstName = driver.findElement(By.id("First"));
        firstName.sendKeys((String)formObj.get("FirstName"));
        String myFirstName = firstName.getText();
        
        WebElement middleName = driver.findElement(By.id("Middle"));
        middleName.sendKeys((String)formObj.get("MiddleName"));
        String myMiddleName = middleName.getText();
        
        WebElement lastName = driver.findElement(By.id("Last"));
        lastName.sendKeys((String)formObj.get("LastName"));
        String myLastName = lastName.getText();
        
        String patientName = myLastName+", "+myFirstName+" "+myMiddleName+".";
        
        WebElement supDate = driver.findElement(By.xpath("//*[@id='frm_sDate']/label/button"));
        selUtil.scrollToElem(supDate);
        supDate.click();
        
        WebElement supName = driver.findElement(By.id("supervisorName"));
        selUtil.scrollToElem(supName);
        System.out.println("Supervisor Name: "+supName.getText());
        
        WebElement cliPrsnt = driver.findElement(By.id("frm_cPresent_1"));
        selUtil.scrollToElem(cliPrsnt);
        cliPrsnt.click();
        
        WebElement notifyClient = driver.findElement(By.id("frm_ddlNotify_1"));
        selUtil.scrollToElem(notifyClient);
        notifyClient.click();
        
        WebElement reportDuty = driver.findElement(By.id("frm_ddlDuty_2"));
        selUtil.scrollToElem(reportDuty);
        reportDuty.click();
        
        WebElement coopClient = driver.findElement(By.id("frm_ddlCooperative_3"));
        selUtil.scrollToElem(coopClient);
        coopClient.click();
        
        WebElement courtClient = driver.findElement(By.id("frm_ddlCourteous_4"));
        selUtil.scrollToElem(courtClient);
        courtClient.click();
        
        WebElement carePlan = driver.findElement(By.id("frm_ddlFollowInstructions_1"));
        selUtil.scrollToElem(carePlan);
        carePlan.click();
        
        WebElement docApp = driver.findElement(By.id("frm_ddlDocument_2"));
        selUtil.scrollToElem(docApp);
        docApp.click();
        
        WebElement notifySup = driver.findElement(By.id("frm_ddlNeeds_3"));
        selUtil.scrollToElem(notifySup);
        notifySup.click();
        
        WebElement orgPolicy = driver.findElement(By.id("frm_ddlAdherence_4"));
        selUtil.scrollToElem(orgPolicy);
        orgPolicy.click();
        
        WebElement aideInstructions = driver.findElement(By.id("frm_chgs"));
        selUtil.scrollToElem(aideInstructions);
        aideInstructions.sendKeys((String) formObj.get("Changes"));
        
        WebElement aideComments = driver.findElement(By.id("frm_comments"));
        selUtil.scrollToElem(aideComments);
        aideComments.sendKeys((String) formObj.get("Comments"));
        
        //Navigating to Documents
        WebElement hamburger = driver.findElement(By.xpath("html/body/ion-nav-view/ion-side-menus/ion-side-menu-content/ion-nav-bar/div[3]/ion-header-bar/div[1]/span[1]/button"));
        selUtil.scrollToElem(hamburger);
        hamburger.click();
        
        WebElement docSideMenu = driver.findElement(By.id("documents_sidemenu"));
        docSideMenu.click();
        
        //Asserting if form is saved
        boolean flag = true;
        while(flag)
        {
        	int i=0;
        	String taskID = "name_"+i;
        	System.out.println("My Task ID:"+taskID);
        	WebElement myTaskId = driver.findElement(By.id(taskID));
        	selUtil.scrollToElem(myTaskId);
            patientName = myTaskId.getText();
        	
        	if (patientName.contains(myFirstName))
        	{
        		System.out.println("Aide Sup Visit form Saved Patient Name: "+patientName);
        		flag = false;
        		break;
        	}
        	i++;
        }
    }

}
