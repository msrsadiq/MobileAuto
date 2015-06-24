package com.kalf.pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestRunner 
{
    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception 
    {
    	
    	//TODO Move config params to properties file
        // Set up appium
    	File appDir = new File("C:\\Users\\sadiqs\\Desktop\\apk"); // Change path as per apk location
		File app = new File(appDir, "Kinnser-new.apk");

		//Android Desired Capabilities
		DesiredCapabilities capa = new DesiredCapabilities();

		
		capa.setCapability("automationName","Appium");
		capa.setCapability("platformName","Android");
		capa.setCapability("platformVersion",4.4); //Set platform name as test device
		capa.setCapability("deviceName","Samsung");
		capa.setCapability("autoWebview", true);
		capa.setCapability("app", app.getAbsolutePath());
		//capa.setCapability("appPackage", "com.kinnser.link");
		//capa.setCapability("appActivity", "KinnserLink");
		
		//Stating the Application using appium driver
		System.out.println("Initiating App Launch");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capa);
		
		System.out.println("App launched");

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    @After
    public void tearDown() throws Exception
    {
    	try
    	{
    	   	System.out.println("Testcase Successful");
    	   	driver.quit();
            driver.closeApp();
     	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }

    //TODO Replace sysout with sl4j / reports
    @Test
    public void webView() throws InterruptedException 
    {
    	try
    	{
            //Login
            WebElement username = driver.findElement(By.id("username"));
            if(username.isDisplayed())
            {
            	username.sendKeys("sadiq.shaik");
            }
            
            WebElement password = driver.findElement(By.id("password"));
            password.sendKeys("mma4user");
            
            WebElement loginButton = driver.findElement(By.id("btnSignIn"));
            loginButton.click();
            
            Thread.sleep(20000);
            
            System.out.println("Navigating to New Documents");
            
            //Navigate to New Documents
            WebDriverWait wait = new WebDriverWait(driver, 60);
            WebElement element = driver.findElement(By.id("newDoc"));
            wait.until(ExpectedConditions.elementToBeClickable(element));
       
            if (element.isDisplayed())
            	element.click();
            else
            	System.out.println("Element not present");
            
            Thread.sleep(2000);
            
            //Filling Aide Supervisory Visit Form
            WebElement aideSup = driver.findElement(By.id("doc_3"));
            String formName = aideSup.getText();
            System.out.println(formName);
            wait.until(ExpectedConditions.elementToBeClickable(aideSup));
            System.out.println("Navigating to Aide Supervisory Visit form");
            aideSup.click();
            
            //Aide Supervisory Visit 
            aideSupervisoryVisit();
            
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    	}
    	
        
    }
    
    public void aideSupervisoryVisit()
    {
    	try
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
            
            //Read Supervisor Name
            //WebElement supName = driver.findElement(By.xpath("/*[@id='Visit Assesment']/div/div[2]/div[1]/div/div/div/div[2]/km-date-today/label/button"));
            
            //Date picker
            WebElement supDate = driver.findElement(By.xpath("//*[@id='Visit Assesment']/div/div[1]/div[1]/div/div/div/div[2]/km-date-today/label/button"));
            scrollToElem(supDate);
            supDate.click();;
               
            //TODO radio button selection logic
            WebElement clinicianPresent = driver.findElement(By.xpath("//*[@id='Visit Assesment']/div/div[1]/div[3]/div/div/div/label[1]/div"));
            scrollToElem(clinicianPresent);
            clinicianPresent.click();
            
            WebElement notifyClient = driver.findElement(By.xpath("//*[@id='Visit Assesment']/div/div[1]/div[4]/div/div/div/label[1]/div"));
            scrollToElem(notifyClient);            
            notifyClient.click();
            
            WebElement reportDuty = driver.findElement(By.xpath("//*[@id='Visit Assesment']/div/div[1]/div[5]/div/div/div/label[2]/div"));
            scrollToElem(reportDuty);
            reportDuty.click();
            
            WebElement cooperativeClient = driver.findElement(By.xpath("//*[@id='Visit Assesment']/div/div[1]/div[6]/div/div/div/label[3]/div"));
            scrollToElem(cooperativeClient);
            cooperativeClient.click();
            
            WebElement courteousClient = driver.findElement(By.xpath("//*[@id='Visit Assesment']/div/div[1]/div[7]/div/div/div/label[4]/div"));
            scrollToElem(courteousClient);
            courteousClient.click();
            
            WebElement clientCare = driver.findElement(By.xpath("//*[@id='Visit Assesment']/div/div[1]/div[8]/div/div/div/label[1]/div"));
            scrollToElem(clientCare);
            clientCare.click();
            
            WebElement document = driver.findElement(By.xpath("//*[@id='Visit Assesment']/div/div[1]/div[9]/div/div/div/label[3]/div"));
            scrollToElem(document);
            document.click();
            
            WebElement notifySup = driver.findElement(By.xpath("//*[@id='Visit Assesment']/div/div[1]/div[10]/div/div/div/label[4]/div"));
            scrollToElem(notifySup);
            notifySup.click();
            
            WebElement adhreOrg = driver.findElement(By.xpath("//*[@id='Visit Assesment']/div/div[1]/div[11]/div/div/div/label[2]/div"));
            scrollToElem(adhreOrg);
            adhreOrg.click();
            
            WebElement aideInstructions = driver.findElement(By.id("AideSupVisitInstruction"));
            scrollToElem(aideInstructions);
            aideInstructions.sendKeys((String) formObj.get("Changes"));
            
            WebElement aideComments = driver.findElement(By.id("AideSupVisitComments"));
            scrollToElem(aideComments);
            aideComments.sendKeys((String) formObj.get("Comments"));
            
            //Saving the form to documents
            WebElement sideMenuNav = driver.findElement(By.xpath("/html/body/ion-nav-view/ion-side-menus/ion-side-menu-content/ion-nav-bar/div[3]/ion-header-bar/div[1]/span[1]/button"));
            scrollToElem(sideMenuNav);
            sideMenuNav.click();
            
            WebElement documentNav = driver.findElement(By.id("documents"));
            scrollToElem(documentNav);
            documentNav.click();
            
            //Verifying saved form in docs
            
            for (int i=1; i<10; i++)
            {
            	String str = "//*[@id='cogHolder']/ul/li["+i+"]/a/div/span[2]";
            	WebElement savedForm = driver.findElement(By.xpath(str));
            	if(savedForm.getText().equals("Aide Supervisory Visit"))
            	{
            		System.out.println(savedForm.getText() + " Saved Successfully!");
            		break;
            	}
            }
            
            
        }
    	catch(ElementNotVisibleException e1)
    	{
    		e1.printStackTrace();

    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    
    public void scrollToElem(WebElement element){
    	Actions action = new Actions(driver);
        Actions actionScroll = action.moveToElement(element);
        actionScroll.perform();
    }

}
