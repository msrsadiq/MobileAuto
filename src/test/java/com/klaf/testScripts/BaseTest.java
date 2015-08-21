package com.klaf.testScripts;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.klaf.pageObjects.*;
import com.klaf.javaUtils.*;



public class BaseTest 
{	
	AppiumDriver driver;
	LaunchAppium io = new LaunchAppium();

	@BeforeSuite
	public void beforeClass() throws MalformedURLException 
	{
		//Start Appium
		io.StartAppium();		
		
		//Configuring APK File Path
		File appDir = new File("C:\\Users\\sadiqs\\Desktop\\apk");
		File app = new File(appDir, "KinnserLink-debug-unaligned.apk");

		//Android Desired Capabilities
		DesiredCapabilities capa = new DesiredCapabilities();
		
		capa.setCapability("automationName","Appium");
		capa.setCapability("platformName","Android");
		capa.setCapability("platformVersion",4.4); //Set platform name as test device
		capa.setCapability("deviceName","Samsung");
		capa.setCapability("autoWebview", true);
		capa.setCapability("app", app.getAbsolutePath());
		
		//Stating the Application using appium driver
		System.out.println("Initiating App Launch");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capa);
		System.out.println("App Launched");
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
 
	}
	
	@AfterSuite
	public void afterClass()
	{
		driver.quit();
	}
}

