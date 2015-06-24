package com.kalf.driverScript;

import com.kalf.javaUtils.StartServer;

import io.appium.java_client.AppiumDriver;

public class Driver
{
	private AppiumDriver driver = null;
	
	public void startAppium()
	{
		StartServer str = new StartServer();
		str.StartAppium();
	}
}

