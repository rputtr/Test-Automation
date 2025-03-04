package com.pega.platform.impl;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Reporter;

import com.pega.TestEnvironment;
import com.pega.crm.pegamarketing.utils.TestDataReader;
import com.pega.framework.PegaWebDriver;
import com.pega.page.TopDocumentImpl;
import com.pega.platform.EmployeeBenefitsCase;
import com.pega.platform.utils.TestDataExcel;
import com.pega.util.ExcelUtil;
import com.pega.util.WaitUtil;


public class EmployeeBenefitsCaseImpl extends TopDocumentImpl implements EmployeeBenefitsCase{

	private static final String docPath = System.getProperty("user.dir") + "//data//example.pdf";
	private static final String docPath2 = System.getProperty("user.dir") + "//data//example2.pdf";
	String filePath = System.getProperty("user.dir")+"\\data\\testdata.xlsx";
	String sheetName = "Sheet1";
	
	public EmployeeBenefitsCaseImpl(String frameId, TestEnvironment testEnv) {
		super(testEnv);
		// TODO Auto-generated constructor stub
	}
//	
	private PegaWebDriver pegadriver;
	static String CaseIDVALUE;
	
	@Override
	public void CompanyInformation() throws IOException {
		
		// Collect Applicant Information
		//findElement(COMPANYNAME_XPATH).sendKeys("ABC");
		String companyName = 	ExcelUtil.readFromExcel(filePath, sheetName, 1, 0);
		System.out.println("TEST data: " + companyName);
		findElement(COMPANYNAME_XPATH).sendKeys(companyName);
		
		//waitHandler.waitForElementClickable(TYPEOFBUSS_SELECT);
		findSelectBox(TYPEOFBUSS_SELECT).selectByValue("GMM");
		findSelectBox(COMPANYSUBGRP_SELECT).selectByValue("Subgroup 1");
		//findElement(CONTACTEMAIL_XPATH).sendKeys("jsmith@email.com");
		findElement(CONTACTEMAIL_XPATH).sendKeys(TestDataReader.getTestDataValue("TestEmail"));
		findElement(MANUALADDR_XPATH).click();
		WaitUtil.waitForShort();

		waitHandler.waitForElementClickable(COUNTRY_XPATH);
		boolean countryDisplay = findElement(COUNTRY_XPATH).isDisplayed();
		Assert.assertTrue(countryDisplay);
		findElement(COUNTRY_XPATH).sendKeys("United States");
		findElement(COUNTRY_XPATH).sendKeys(Keys.ENTER);
		
		waitHandler.waitForElementClickable(ADDRLINE1_XPATH);
		findElement(ADDRLINE1_XPATH).click();
		findElement(ADDRLINE1_XPATH).sendKeys("1 Main St");
		//findElement(ADDRLINE1_XPATH).sendKeys(Keys.TAB);
		
		waitHandler.waitForElementClickable(CITY_XPATH);
		findElement(CITY_XPATH).click();
		findElement(CITY_XPATH).sendKeys("Miami");
		
		waitHandler.waitForElementClickable(STATE_SELECT);
		findSelectBox(STATE_SELECT).selectByValue("FL");
		
		waitHandler.waitForElementClickable(POSTALCODE_XPATH);
		findElement(POSTALCODE_XPATH).sendKeys("33116");
		findElement(NUMOFINSURED_XPATH).sendKeys("2");
		
		waitHandler.waitForElementClickable(NEXTBUTTONNB_XPATH);
		findElement(NEXTBUTTONNB_XPATH).click();		
			
	}
	@Override
	public void AgentDetail() {
		// Collect Agent Information
		String agentKeyVal = findElement(AGENTKEY_XPATH).getAttribute("value");
		Assert.assertTrue(agentKeyVal.startsWith("AON"));
		findElement(NEXTBUTTONNB_XPATH).click();
	}
	
	@Override
	public void ProductDetail() {
		// Collect Product Details
		findElement(COVERAGE_XPATH).sendKeys("80");
		findSelectBox(PLAN_SELECT).selectByValue("A");
		findSelectBox(SUMASSURED_SELECT).selectByValue("$100,000");
		findSelectBox(HQTAB_SELECT).selectByValue("HQ 1");
		findElement(DEDUCTIBLE_XPATH).sendKeys("20");
		findElement(NATIONALCOINSR_XPATH).sendKeys("20");
		findSelectBox(ZONE_SELECT).selectByValue("Zone 1");
		findSelectBox(REGION_SELECT).selectByValue("Region 1");
		findElement(INSUREHOLDER_XPATH).sendKeys("2");
		findElement(TOTALINSURED_XPATH).sendKeys("2");
		findSelectBox(OVERSEAEMERGENCY_SELECT).selectByValue("Include");
		findSelectBox(OVERSEACATAST_SELECT).selectByValue("Include");
		findSelectBox(OVERSEACOVERAGE_SELECT).selectByValue("Include");
		findSelectBox(CONVERSIONRIGHT_SELECT).selectByValue("Yes");
		findElement(INCLUDERDH_XPATH).click();
		findElement(INCLUDEDENTALVISION_XPATH).click();
		findElement(GMMEXCESSES_XPATH).click();
		findElement(GMMPROTECTION_XPATH).click();
		findElement(GMMOPTIONAL_XPATH).click();
		findElement(INCLUDECOINSURANCE_XPATH).click();
		findElement(INCLUDEACCUPUNCTURE_XPATH).click();
		findElement(INCLUDEVISIONCORRECTION_XPATH).click();
		findElement(NEXTBUTTONNB_XPATH).click();	
	}
	
	@Override
	public void AssignFolio() {
		// Assign Folio
		pegaDriver.waitForDocStateReady();
		findSelectBox(FOLIOTYPEOFBUSS_SELECT).selectByVisibleText("GMM");
		waitHandler.waitForElementClickable(FOLIOGRP_SELECT);
		findSelectBox(FOLIOGRP_SELECT).selectByValue("GMM000001");
		pegaDriver.waitForDocStateReady();
		findSelectBox(FOLIOID_SELECT).selectByVisibleText("GMM000001234");
		findElement(NEXTBUTTONNB_XPATH).click();	
	}
	
	@Override
	public void DuplicateCheckIgnore() {
		// Duplicate cases
		if (findElement(IGNOREANDCONTBUTTON_XPATH).isVisible()) {
			findElement(IGNOREANDCONTBUTTON_XPATH).click();
			
		}	
	}
	
	@Override
	public void ManageDocument() {
		// Manage Documents
		By SLIPFile_XPATH = By.xpath("//div//*[contains(text(),'SLIP File')]//following::div[1]//input");
		findElement(SLIPFile_XPATH).sendKeys(docPath);
		By EMPLISTING_XPATH = By.xpath("//div//*[contains(text(),'Employee Listing')]//following::div[1]//input");
		findElement(EMPLISTING_XPATH).sendKeys(docPath2);
		try{
			Thread.sleep(10000);
		}catch (Exception e){
			e.printStackTrace();
		}
		findElement(NEXTBUTTONNB_XPATH).click();
	}
	
	@Override
	public void ReviewSummary() {
		pegaDriver.waitForDocStateReady();
		String includeRDHVal = findElement(EVALRDH_XPATH).getText();
		Assert.assertEquals("Yes", includeRDHVal);
		findElement(SUBMITNB_XPATH).click();	
	}
	
	public void verifyCaseDetails() {	
		pegaDriver.waitForDocStateReady();
		String status = findElement(WORKSTATUS_XPATH).getText();
		System.out.println("Status Text==>"+status);
		Assert.assertEquals("DOCUMENT-RECEIVED", status);
		String NBLCASEID= findElement(NBLCASEID_XPATH).getText();
		System.out.println("Verify Case Detail Step: CaseID==>" + NBLCASEID);
	}

}
