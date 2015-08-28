package com.klaf.testScripts;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.klaf.pageObjects.*;
import com.klaf.javaUtils.*;

public class TestCase1 {
	AndroidDriver driver;

	LaunchAppium io = new LaunchAppium();

	@BeforeSuite
	public void beforeClass() throws MalformedURLException {

		try {
			// Start Appium
			// io.StartAppium();

			// Configuring APK File Path
			File appDir = new File("C:\\Users\\sadiqs\\Desktop\\apk");
			File app = new File(appDir, "KinnserLink-debug-unaligned2.apk");

			// Android Desired Capabilities
			DesiredCapabilities capa = new DesiredCapabilities();

			capa.setCapability("automationName", "Appium");
			capa.setCapability("platformName", "Android");
			capa.setCapability("platformVersion", 4.4); // Set platform name as
														// test device
			capa.setCapability("deviceName", "Samsung");
			capa.setCapability("app", app.getAbsolutePath());
			capa.setCapability("appPackage", "com.kinnser.link");
			capa.setCapability("autoWebview", true);

			// Stating the Application using appium driver
			System.out.println("Initiating App Launch");

			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
					capa);

			System.out.println("App Launched");
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			Thread.sleep(10000);
			System.out.println(driver.getContext());
			System.out.println("Driver After Launching Appium: " + driver);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// return driver;

	}

	@AfterSuite
	public void afterClass() {
		System.out.println("Exiting Appium");
		driver.quit();
	}

	@Test(priority = 1)
	public void validCredentialsLogin() {
		System.out.println("Executing Login Test");
		BasePageObjects base = new BasePageObjects(driver);
		System.out.println("test");
		base.initialLoginAttempt("sadiq.shaik", "mma4user");
		// Add Assertion for successful login
	}

	@Test(priority = 2)
	public void saveAideSupVisitfromDocuments() {
		try {
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

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
