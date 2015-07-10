package com.klaf.testScripts;

import org.testng.annotations.Test;
import com.klaf.pageObjects.*;

public class LoginAttempt 
{
	
	@Test
	public void validCredentialsLogin()
	{
		BasePageObjects base = new BasePageObjects(null);
		base.initialLoginAttempt("sadiq.shaik", "mma4user");
		//Add Assertion for successful login
	}


}
