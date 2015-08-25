package com.klaf.testScripts;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;

import com.klaf.pageObjects.*;


public class AideSupVist extends BaseTest
{
	protected AppiumDriver driver;
	@Test
	public AideSupVist(AppiumDriver driver)
	{
		super(driver);
	}


	NewDocObject newdoc = new NewDocObject(driver);
	BasePageObjects basepage = new BasePageObjects(driver);
	AideSupVisitObject asv = new AideSupVisitObject(driver);

	public void saveAideSupVisitfromDocuments()
	{
		try
		{
			//Navigate to New Documents
			basepage.navtoNewDocFromHotbox();				
			//Open Aide Supervisory Form
			newdoc.openForm("doc_3");
			//Fill the form
			asv.aideSupervisoryVisit();
			//Save the Form - Navigate to Documents
			
			//Confirm form is saved

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
