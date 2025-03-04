package com.pega.platform.impl;

import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Reporter;

import com.pega.TestEnvironment;
import com.pega.framework.PegaWebDriver;
import com.pega.page.TopDocumentImpl;
import com.pega.platform.BusinessLifeCase;


public class PegaBusinessLifeCase extends TopDocumentImpl implements BusinessLifeCase{

	public PegaBusinessLifeCase(String frameId, TestEnvironment testEnv) {
		super(testEnv);
		// TODO Auto-generated constructor stub
	}
//	public PegaBusinessLifeCase(String frameId, TestEnvironment testEnv) {
//		super(frameId, testEnv);
//		pegadriver=testEnv.getPegaDriver();
//		this.testEnv=testEnv;
//	}
	private PegaWebDriver pegadriver;
	static String CaseIDVALUE;
	
	

	@Override
	public void ApplicantInformation() {
		findElement(FIRSTNAME_XPATH).sendKeys("John");
		findElement(LASTNAME_XPATH).sendKeys("Wills");
		findSelectBox(GENDER_SELECT).selectByValue("Female");
		//findElement(DOB_DATEPICKER).click();
		//findElement(DOB_DATEPICKER).sendKeys("01/12/1960");
		findElement(MONTH_XPATH).sendKeys("01");
		findElement(DATE_XPATH).sendKeys("12");
		findElement(YEAR_XPATH).sendKeys("1960");
		findElement(AGE_XPATH).sendKeys("64");
		findSelectBox(STATUS_SELECT).selectByValue("Married");
		findSelectBox(TOI_SELECT).selectByValue("Passport");
		findElement(ID_XPATH).sendKeys("AMP19299");
		findElement(PHONENUMBER_XPATH).sendKeys("9897876543");
		findElement(EMAILNB_XPATH).clear();
		findElement(EMAILNB_XPATH).sendKeys("johnXX@wills@.com"); //Intentional incorrect email to display error message
		findElement(EMAILNB_XPATH).sendKeys(Keys.TAB);
		waitHandler.waitForElementVisibility(ERROR_XPATH);
		String ErrorMessage= findElement(ERROR_XPATH).getAttribute("innerText");
		Assert.assertTrue( ErrorMessage.contains("Invalid Email")); //Verify error message displayed
		findElement(EMAILNB_XPATH).clear();
		findElement(EMAILNB_XPATH).sendKeys("johnXX@wills.com");

		findElement(ZIPCODE_XPATH).sendKeys("32223");
		findElement(CONSENT_RADIOBUTTON).click();
		//findElement(COVERAGE_XPATH).sendKeys("Partial");
		findSelectBox(PLAN_SELECT).selectByValue("A");
		findSelectBox(SUMASSURED_SELECT).selectByValue("$100,000");
		findElement(SMOKER_CHECKBOX).click();
		String CASEID= findElement(GETID_XPATH).getText();
		int start = CASEID.indexOf('(');
        int end = CASEID.indexOf(')', start);
        CaseIDVALUE=  CASEID.substring(start + 1, end);
		findElement(NEXTBUTTONNB_XPATH).click();
		
		
		
	}

	@Override
	public void verifyQuote() {
		String ReviewQuote="Thank you for choosing Metlife.  The actual premiums can only be determined by a full application and underwriting process, including some medical testing at our expense.";
		
		String QuoteID= findElement(QUOTEID_XPATH).getAttribute("value");
		assertNotNull(QuoteID);
		findElement(NEXTBUTTONNB_XPATH).click();
		String quoteText= findElement(REVIEWQUOTE_XPATH).getText();
		System.out.println("Quote Text==>"+quoteText);
		Assert.assertEquals("Quote Text is same", ReviewQuote,quoteText);
		findElement(PROCEED_XPATH).check();
		findElement(SUBMITNB_XPATH).click();
		findElement(SUBMITNB_XPATH).click();
		System.out.println("Case ID created=>"+CaseIDVALUE);
		Reporter.log("Case ID created=>"+CaseIDVALUE);
		
		}
	
	public void verifyCaseDetails() {
		pegaDriver.waitForDocStateReady();
		String Status= findElement(INTERNALSTATUS_XPATH).getText();
		System.out.println("Status Text==>"+Status);
		Assert.assertEquals("QUOTE-ACCEPTED", Status);
		String NBLCASEID= findElement(NBLCASEID_XPATH).getText();
		Assert.assertEquals(CaseIDVALUE,NBLCASEID);
		System.out.println("Value on landing page==>"+NBLCASEID);
	}

}
