package com.klaf.testScripts;

import io.appium.java_client.AppiumDriver;

import org.testng.annotations.Test;

import com.klaf.pageObjects.*;


public class LoginAttempt
{
	AppiumDriver driver;
	
	@Test
	public void validCredentialsLogin()
	{
		System.out.println("Executing Login Test");
		BasePageObjects base = new BasePageObjects(driver);
		base.initialLoginAttempt("sadiq.shaik", "mma4user");
		//Add Assertion for successful login
	}


}
