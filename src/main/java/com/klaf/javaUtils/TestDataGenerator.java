package com.klaf.javaUtils;

import java.util.HashMap;
import java.util.Random;

import com.klaf.pageObjects.AideSupVisitObject;
import com.klaf.pageObjects.RNInitilAssesVitalSignsObject;

public class TestDataGenerator 
{
	
	String firstName = "";
	String lastName = "";
	String middleName = "";
	
	public void generateName()
	{
		int numId = randInt(100, 1000);
		this.firstName = "Alister"+numId;
		this.lastName = "Cook"+numId;
		this.middleName = "M";
	}
	
	public String getFirstName()
	{
		return this.firstName;
	}
	
	public String getLastName()
	{
		return this.lastName;
	}
	
	public String getMiddleName()
	{
		return this.middleName;
	}
	
	public static int randInt(int min, int max) 
	{
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
	
	public HashMap<?, ?> generateFormObject(String formName)
	{
		
		HashMap<String, String> formObj = new HashMap<String, String>();
		
		//Generate Patient Name
		generateName();
		
		if(formName.equalsIgnoreCase("aideSupVisit"))
		{
			AideSupVisitObject aideSup = new AideSupVisitObject(null);
			aideSup.setChangesText(randomStringGenerator(10, "alphanum"));
			aideSup.setCommentsText(randomStringGenerator(10, "alphanum"));
			
			formObj.put("FirstName", this.getFirstName());
			formObj.put("MiddleName", this.getMiddleName());
			formObj.put("LastName", this.getLastName());
			formObj.put("Comments", aideSup.getCommentsText());
			formObj.put("Changes", aideSup.getChangesText());
		}
		
		else if(formName.equalsIgnoreCase("RNInitialAssessment"))
		{
			RNInitilAssesVitalSignsObject rninitial = new RNInitilAssesVitalSignsObject(null);
			rninitial.setChangesText(randomStringGenerator(10, "alphanum"));
			rninitial.setCommentsText(randomStringGenerator(10, "alphanum"));
			
			formObj.put("FirstName", this.getFirstName());
			formObj.put("MiddleName", this.getMiddleName());
			formObj.put("LastName", this.getLastName());
			formObj.put("Comments", rninitial.getCommentsText());
			formObj.put("Changes", rninitial.getChangesText());
		}
		
				
		return formObj;
	}
	
	public String randomStringGenerator(int len, String type){
		
		String alphaNum = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String numeric = "0123456789";
		
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder( len );
		
		for( int i = 0; i < len; i++ )
		{ 
			if(type.equalsIgnoreCase("alpha"))
			{
				sb.append( alpha.charAt( rnd.nextInt(alpha.length())));
			}
			else if(type.equalsIgnoreCase("alphanum"))
			{
				sb.append( alphaNum.charAt( rnd.nextInt(alphaNum.length())));
			}
			else if(type.equalsIgnoreCase("num"))
			{
				sb.append( numeric.charAt( rnd.nextInt(numeric.length())));
			}
			
		}
		
		return sb.toString();
		
	}
}
