package com.klaf.testScripts;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.klaf.pageObjects.*;
import com.klaf.javaUtils.*;

public class TestCase1 
{
	AppiumDriver driver;
	//WebDriver driver;

	LaunchAppium io = new LaunchAppium();

	@BeforeClass
	public void beforeClass() throws MalformedURLException 
	{

		try {
			// Start Appium
			io.StartAppium();

			// Configuring APK File Path
			File appDir = new File("C:\\Users\\sadiqs\\Desktop\\apk");
			File app = new File(appDir, "CordovaApp-debug-unaligned.apk");

			// Android Desired Capabilities
			DesiredCapabilities capa = new DesiredCapabilities();

			capa.setCapability("automationName", "Appium");
			capa.setCapability("platformName", "Android");
			capa.setCapability("platformVersion", 4.4); // Set platform name as
			capa.setCapability("deviceName", "Samsung");
			capa.setCapability("app", app.getAbsolutePath());
			capa.setCapability("appPackage", "com.kinnser.link");
			capa.setCapability("launchActivity", "com.kinnser.link.MainActivity");
			capa.setCapability("autoWebview", true);
	
			// Stating the Application using appium driver
			System.out.println("Initiating App Launch");
			
			//Thread.sleep(3000);

			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capa);

			Thread.sleep(100);

			System.out.println("App Launched");
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			Thread.sleep(100);
			System.out.println("Driver After Launching Appium: " + driver);
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	@AfterClass
	public void afterClass()
	{
		System.out.println("Exiting Appium");
		driver.quit();
	}

	@Test(priority = 1)
	public void validCredentialsLogin() 
	{
		System.out.println("Executing Login Test");
		BasePageObjects base = new BasePageObjects(driver);
		base.initialLoginAttempt("sadiq.shaik", "mma4user");
		
		// Add Assertion for successful login
	}

	@Test(priority = 2)
	public void saveAideSupVisitfromDocuments() 
	{
		try 
		{
			System.out.println("Aidesupvisit");
			// Navigate to New Documents
			BasePageObjects basepage = new BasePageObjects(driver);
			basepage.navtoNewDocFromHotbox();
			// Open Aide Supervisory Form
			NewDocObject newdoc = new NewDocObject(driver);
			newdoc.openForm("newdoc_3");
			// Fill the form
			AideSupVisitObject asv = new AideSupVisitObject(driver);
			asv.aideSupervisoryVisit();
			// Save the Form - Navigate to Documents

			// Confirm form is saved
			
			System.out.println("Completed Aide Sup Visit");

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void rnInitialAssVitalSigns() 
	{
		try 
		{
			System.out.println("Rn Initial Assessment Vital Sigs");
			// Navigate to New Documents
			BasePageObjects basepage = new BasePageObjects(driver);
			basepage.navtoNewDocFromHotbox();
			// Open Aide Supervisory Form
			NewDocObject newdoc = new NewDocObject(driver);
			newdoc.openForm("newdoc_1");
			// Fill the form
			RNInitilAssesVitalSignsObject rnia = new RNInitilAssesVitalSignsObject(driver);
			rnia.rnInitialAssessment();
			// Save the Form - Navigate to Documents

			// Confirm form is saved
			
			System.out.println("Completed Rn Initial Assessment");

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
