package com.klaf.javaUtils;

public class CommonUtils 
{
	public void waitForSometime()
	{
		try
		{
			Thread.sleep(10000);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
