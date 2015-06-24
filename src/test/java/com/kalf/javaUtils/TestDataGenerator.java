package com.kalf.javaUtils;

import java.util.HashMap;
import java.util.Random;

public class TestDataGenerator 
{
	
	String firstName = "";
	String lastName = "";
	String middleName = "";
	
	public void generateName()
	{
		int numId = randInt(100, 1000);
		this.firstName = "testFName"+numId;
		this.lastName = "testLName"+numId;
		this.middleName = "M";
	}
	
	public String getFName()
	{
		return this.firstName;
	}
	
	public String getLName()
	{
		return this.lastName;
	}
	
	public String getMName()
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
			AideSupervisoryFormObject aideSup = new AideSupervisoryFormObject();
			aideSup.setChangesText(randomStringGenerator(10, "alphanum"));
			aideSup.setCommentsText(randomStringGenerator(10, "alphanum"));
			
			formObj.put("FirstName", this.getFName());
			formObj.put("MiddleName", this.getMName());
			formObj.put("LastName", this.getLName());
			formObj.put("Comments", aideSup.getCommentsText());
			formObj.put("Changes", aideSup.getChangesText());
		}
		
				
		return formObj;
	}
	
	public String randomStringGenerator(int len, String type){
		
		String alphaNum = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String numeric = "0123456789";
		
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder( len );
		
		for( int i = 0; i < len; i++ ){ 
			if(type.equalsIgnoreCase("alpha")){
				sb.append( alpha.charAt( rnd.nextInt(alpha.length()) ) );
			}else if(type.equalsIgnoreCase("alphanum")){
				sb.append( alphaNum.charAt( rnd.nextInt(alphaNum.length()) ) );
			}else if(type.equalsIgnoreCase("num")){
				sb.append( numeric.charAt( rnd.nextInt(numeric.length()) ) );
			}
			
		}
		
		return sb.toString();
		
	}
}
