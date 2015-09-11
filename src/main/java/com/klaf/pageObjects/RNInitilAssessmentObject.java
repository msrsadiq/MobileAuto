package com.klaf.pageObjects;

import java.util.HashMap;

import org.apache.commons.collections.SetUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.klaf.javaUtils.CommonSeleniumUtils;
import com.klaf.javaUtils.TestDataGenerator;

import io.appium.java_client.AppiumDriver;

public class RNInitilAssessmentObject extends BasePageObjects 
{

	public RNInitilAssessmentObject(AppiumDriver driver) 
	{
		super(driver);
	}

	String changesText = "";
	String commentsText = "";
	
	//Setters
	public void setChangesText(String changes)
	{
		this.changesText = changes;
	}
	
	public void setCommentsText(String comments)
	{
		this.commentsText = comments;
	}
	
	//Getters
	public String getChangesText()
	{
		return this.changesText;
	}
	
	public String getCommentsText()
	{
		return this.commentsText;
	}
	
	public void rnInitialAssessment()
	{
    	TestDataGenerator testData = new TestDataGenerator();
        HashMap<?,?> formObj = testData.generateFormObject("RNInitial Assessment");
        CommonSeleniumUtils selUtil = new CommonSeleniumUtils(driver);
        
        //Fill Form
        System.out.println("Filling RN Initial Assessemnt Form");
        WebElement myForm = driver.findElement(By.xpath("html/body/ion-nav-view/ion-side-menus/ion-side-menu-content/ion-nav-bar/div[3]/ion-header-bar/div[2]/span"));
        System.out.println("Filling :"+myForm.getText());	
        
        WebElement firstName = driver.findElement(By.id("First"));
        firstName.sendKeys((String)formObj.get("FirstName"));
        String myFirstName = firstName.getText();
        
        WebElement middleName = driver.findElement(By.id("Middle"));
        middleName.sendKeys((String)formObj.get("MiddleName"));
        String myMiddleName = middleName.getText();
        
        WebElement lastName = driver.findElement(By.id("Last"));
        lastName.sendKeys((String)formObj.get("LastName"));
        String myLastName = lastName.getText();
        
        String patientName = myLastName+", "+myFirstName+" "+myMiddleName+".";
        
        WebElement timeIn = driver.findElement(By.xpath("//*[@id='visit-record']/div/div/div[1]/div/div/div[1]/div[2]/div[2]/km-time-now/label/button"));
        selUtil.scrollToElem(timeIn);
        timeIn.click();
        
        WebElement timeOut = driver.findElement(By.xpath("//*[@id='visit-record']/div/div/div[1]/div/div/div[2]/div[2]/div[2]/km-time-now/label/button"));
        selUtil.scrollToElem(timeOut);
        timeOut.click();
 
        WebElement visitDate = driver.findElement(By.xpath("//*[@id='visit-record']/div/div/div[2]/div/div/div[1]/div/div[2]/km-date-today/label/button"));
        selUtil.scrollToElem(visitDate);
        visitDate.click();
 
        WebElement milage = driver.findElement(By.xpath("//*[@id='visit-record']/div/div/div[2]/div/div/div[2]/div/input"));
        selUtil.scrollToElem(milage);
        milage.sendKeys("12.5");
        
        //Vital Signs
 
        WebElement temperature = driver.findElement(By.id("frm_VSTemperature"));
        selUtil.scrollToElem(temperature);
        temperature.sendKeys("70");;
 
        WebElement heartRate = driver.findElement(By.id("frm_VSDuringHeartRate"));
        selUtil.scrollToElem(heartRate);
        heartRate.sendKeys("80");
        
        WebElement tempType = driver.findElement(By.id("frm_VSTemperatureType"));
        selUtil.scrollToElem(tempType);
        Select tempdropdown = new Select(tempType);
        tempdropdown.selectByIndex(1);
 
        WebElement resp = driver.findElement(By.id("frm_VSDuringResp"));
        selUtil.scrollToElem(resp);
        resp.sendKeys("45");
 
        WebElement bpsys = driver.findElement(By.id("frm_VSDuringBPsys"));
        selUtil.scrollToElem(bpsys);
        bpsys.sendKeys("90");
 
        WebElement bpdia = driver.findElement(By.id("frm_VSDuringBPdia"));
        selUtil.scrollToElem(bpdia);
        bpdia.sendKeys("120");
 
        WebElement osat = driver.findElement(By.id("frm_VSDuring02Sat"));
        selUtil.scrollToElem(osat);
        osat.click();
        
        WebElement osattype = driver.findElement(By.id("frm_VSDuring02SatType"));
        selUtil.scrollToElem(osattype);
        Select sattype = new Select(osattype);
        sattype.selectByIndex(1);
        
        WebElement osatruote = driver.findElement(By.id("frm_VSDuring02SatRoute"));
        selUtil.scrollToElem(osatruote);
        Select satroute = new Select(tempType);
        satroute.selectByIndex(1);
 
        WebElement vsComments = driver.findElement(By.id("frm_VSComments"));
        selUtil.scrollToElem(vsComments);
        vsComments.sendKeys((String) formObj.get("Comments"));
        
        //Height and Weight
 
        WebElement heightft = driver.findElement(By.id("rn-vital-signs-height-ft"));
        selUtil.scrollToElem(heightft);
        heightft.click();
 
        WebElement heightin = driver.findElement(By.id("rn-vital-signs-height-in"));
        selUtil.scrollToElem(heightin);
        heightin.click();
 
        WebElement canWeighted = driver.findElement(By.id("//*[@id='vital signs']/div[3]/div/div/div[3]/div/div/div/div/div/label[1]/div"));
        selUtil.scrollToElem(canWeighted);
        timeIn.click();
 
        WebElement weight = driver.findElement(By.id("vitals_weight"));
        selUtil.scrollToElem(weight);
        weight.click();
        
        WebElement mac = driver.findElement(By.id("vitals_midArmCircumference"));
        selUtil.scrollToElem(mac);
        mac.click();
        
        WebElement bmi = driver.findElement(By.id("vitals_bmi"));
        selUtil.scrollToElem(bmi);
        Select bmidropdown = new Select(bmi);
        bmidropdown.selectByIndex(1);
        
        WebElement weightChange = driver.findElement(By.id("vitals_reportedWeightChanges_gainLoss"));
        selUtil.scrollToElem(weightChange);
        Select weightChangedd = new Select(weightChange);
        weightChangedd.selectByIndex(1);
        
        WebElement weightChangevalue = driver.findElement(By.id("vitals_reportedWeightChanges"));
        selUtil.scrollToElem(weightChangevalue);
        weightChangevalue.sendKeys("5 pounds gain");;
 
        WebElement vWeight = driver.findElement(By.id("//*[@id='vital signs']/div[3]/div/div/div[7]/div/div/div/div/div/label[1]/div"));
        selUtil.scrollToElem(vWeight);
        timeIn.click();
 
        WebElement weightTime = driver.findElement(By.id("vitals_weight_time"));
        selUtil.scrollToElem(weightTime);
        weightTime.click();
        
        WebElement weightdays = driver.findElement(By.id("vital_weight_daysWeeks"));
        selUtil.scrollToElem(weightdays);
        Select weightdd = new Select(weightdays);
        weightdd.selectByIndex(1);
        
        //Diagnosis Information
        
        WebElement terminalDiag = driver.findElement(By.id("diagnosticInformation_TerminalDiagnosis_ICD10"));
        selUtil.scrollToElem(terminalDiag);
        terminalDiag.sendKeys("fev");
        Select terminaloptions = new Select(terminalDiag);
        terminaloptions.selectByIndex(4);
        
        
        WebElement comodity1 = driver.findElement(By.id("diagnosticInformation_Comorbidity1_ICD10"));
        selUtil.scrollToElem(comodity1);
        comodity1.sendKeys("fev");
        Select comodity1Options = new Select(comodity1);
        comodity1Options.selectByIndex(2);
        
        
        WebElement comodity2 = driver.findElement(By.id("diagnosticInformation_Comorbidity2_ICD10"));
        selUtil.scrollToElem(comodity2);
        comodity1.sendKeys("tes");
        Select comodity2OPtions = new Select(comodity2);
        comodity2OPtions.selectByIndex(2);
        
        
        WebElement comodity3 = driver.findElement(By.id("diagnosticInformation_Comorbidity3_ICD10"));
        selUtil.scrollToElem(comodity3);
        comodity1.sendKeys("fev");
        Select comodity3Options = new Select(comodity3);
        comodity3Options.selectByIndex(2);
        
        
        WebElement comodity4 = driver.findElement(By.id("diagnosticInformation_Comorbidity4_ICD10"));
        selUtil.scrollToElem(comodity4);
        comodity4.sendKeys("fev");
        Select comodity4Options = new Select(comodity4);
        comodity4Options.selectByIndex(2);
        
        
        WebElement comodity5 = driver.findElement(By.id("diagnosticInformation_Comorbidity5_ICD10"));
        selUtil.scrollToElem(comodity5);
        comodity1.sendKeys("fev");
        Select comodity5Options = new Select(comodity5);
        comodity5Options.selectByIndex(2);
        
        //Local Coverage Determined (LCD) Guidelines
 
        WebElement nonDisease = driver.findElement(By.id("lcd_decline_nonDiseaseSpecificDeclineInCinincalStatusGuidelines"));
        selUtil.scrollToElem(nonDisease);
        nonDisease.click();
        
        //Other Diseases Guidelines
 
        WebElement cancerDiag = driver.findElement(By.id("lcd_otherdiseaseguildelines_cancerDiagnosis"));
        selUtil.scrollToElem(cancerDiag);
        cancerDiag.click();
 
        WebElement pulDis = driver.findElement(By.id("lcd_otherdiseaseguildelines_pulmonaryDisease"));
        selUtil.scrollToElem(pulDis);
        pulDis.click();
 
        WebElement amoyo = driver.findElement(By.id("lcd_otherdiseaseguildelines_amoyotrphicLateralSclerosis"));
        selUtil.scrollToElem(amoyo);
        amoyo.click();
 
        WebElement acute = driver.findElement(By.id("lcd_otherdiseaseguildelines_acuteRenalFailure"));
        selUtil.scrollToElem(acute);
        acute.click();
 
        WebElement alzheimer = driver.findElement(By.id("lcd_otherdiseaseguildelines_dementiaDueToAlzheimersDiseaseRelatedDisorders"));
        selUtil.scrollToElem(alzheimer);
        alzheimer.click();
 
        WebElement chronic = driver.findElement(By.id("lcd_otherdiseaseguildelines_chronicRenalFailure"));
        selUtil.scrollToElem(chronic);
        chronic.click();
 
        WebElement heartdis = driver.findElement(By.id("lcd_otherdiseaseguildelines_heartDisease"));
        selUtil.scrollToElem(heartdis);
        heartdis.click();
 
        WebElement stroke = driver.findElement(By.id("lcd_otherdiseaseguildelines_stroke"));
        selUtil.scrollToElem(stroke);
        stroke.click();
        
        WebElement hivdis = driver.findElement(By.id("lcd_otherdiseaseguildelines_hivDisease"));
        selUtil.scrollToElem(hivdis);
        hivdis.click();
 
        WebElement coma = driver.findElement(By.id("lcd_otherdiseaseguildelines_coma"));
        selUtil.scrollToElem(coma);
        coma.click();
 
        WebElement liverdis = driver.findElement(By.id("lcd_otherdiseaseguildelines_liverDisease"));
        selUtil.scrollToElem(liverdis);
        liverdis.click();
        
        //HIS Measures
 
        WebElement admForm = driver.findElement(By.id("HIS_AdmittedFrom"));
        selUtil.scrollToElem(admForm);
        Select admfromdd = new Select(admForm);
        admfromdd.selectByIndex(1);

 
        WebElement priDiag = driver.findElement(By.id("HIS_PrincipalDiagnosis"));
        selUtil.scrollToElem(priDiag);
        Select priDiagdd = new Select(priDiag);
        priDiagdd.selectByIndex(1);
        
        //Radio Buttons
        WebElement f2000a = driver.findElement(By.xpath("//*[@id='HIS_AskedAboutCPR_1']/div/label"));
        selUtil.scrollToElem(f2000a);
        f2000a.click();
 
        WebElement cprComments = driver.findElement(By.id("HIS_AskedAboutCPR_Comment"));
        selUtil.scrollToElem(cprComments);
        cprComments.click();
 
        WebElement cprDate = driver.findElement(By.id("HIS_AskedAboutCPRDate"));
        selUtil.scrollToElem(cprDate);
        cprDate.sendKeys("09/11/2015");
 
        WebElement f2100a = driver.findElement(By.xpath("//*[@id='HIS_AskedAboutTreatmentsOther_2']/div/label"));
        selUtil.scrollToElem(f2100a);
        f2100a.click();
 
        WebElement treatmentComm = driver.findElement(By.id("HIS_AskedAboutTreatmentsOther_Comment"));
        selUtil.scrollToElem(treatmentComm);
        treatmentComm.click();
 
        
        WebElement f2100b = driver.findElement(By.id("HIS_AskedAboutTreatmentsOtherDate"));
        selUtil.scrollToElem(f2100b);
        f2100b.sendKeys("09/11/2015");
        
        
        WebElement f2200a = driver.findElement(By.xpath("//*[@id='HIS_AskedAboutHospitalization_1']/div/label"));
        selUtil.scrollToElem(f2200a);
        f2200a.click();
        
        
        WebElement f2200aComm = driver.findElement(By.id("HIS_AskedAboutHospitalization_Comment"));
        selUtil.scrollToElem(f2200aComm);
        f2200aComm.click();
        
        
        WebElement f2200b = driver.findElement(By.id("HIS_AskedAboutHospitalizationDate"));
        selUtil.scrollToElem(f2200b);
        f2200b.click();
        
        
        WebElement vitalSignComm = driver.findElement(By.id("VitalSignsComments"));
        selUtil.scrollToElem(vitalSignComm);
        vitalSignComm.click();
        
 	}

}
