package com.klaf.javaUtils;

import java.io.File;

public class LaunchAppium 
{
		static String appiumPath = "D:\\AutomationRnDWorkspace\\MobileAuto\\src\\main\\java\\com\\klaf\\config\\startappium.bat";
		static File file = new File(appiumPath);
		Process appium;
		
		public void StartAppium()
		{
			try
			{
				System.out.println("Verifying exe file");
				
				if (! file.exists()) 
				{
				   System.out.println("File not found in specified path");
				}
				else
				{
					System.out.println("Launching Application...");
					appium = Runtime.getRuntime().exec(new String[]{"cmd.exe", "/C", "Start", file.getAbsolutePath()});
					
				}
				System.out.println("Wait for appium to start");
				Thread.sleep(20000);
				System.out.println("Wait Ends");
			}
			catch (Exception e)
			{
				e.printStackTrace();
				throw new IllegalArgumentException("The file " + appiumPath + " does not exist");
			}
		}
		
		public void stopAppium()
		{
			try
			{
				System.out.println("Stopping Appium");
				appium.exitValue();
				Runtime.getRuntime().exec("taskkill /f /im cmd.exe") ;
				System.out.println("Appium Stoped");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}

}
