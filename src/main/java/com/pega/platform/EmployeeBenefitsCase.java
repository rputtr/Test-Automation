package com.pega.platform;

import java.io.IOException;

import org.openqa.selenium.By;

import com.pega.crm.customerservice.interactions.Interactions;
import com.pega.page.TopDocument;
import com.pega.ri.Wizard;

public interface EmployeeBenefitsCase extends TopDocument  {
	By COMPANYNAME_XPATH =By.xpath("//*[@data-testid='Company Name:input:control']");
	By TYPEOFBUSS_SELECT=By.xpath("//*[@data-testid='Type of Business:select:control']");
	By COMPANYSUBGRP_SELECT=By.xpath("//*[@data-testid='Company Sub Group:select:control']");
	By CONTACTEMAIL_XPATH =By.xpath("//*[@data-testid='Point of Contact Email:input:control']");
	By MANUALADDR_XPATH =By.xpath("//label[contains(@for, 'ManualAddressOrGMAP.Manual')]");
	By COUNTRY_XPATH =By.xpath("//*[@data-testid='Country:combo-box:control']");
	By ADDRLINE1_XPATH =By.xpath("//*[@data-testid='Address Line 1:input:control']");
	By ADDRLINE2_XPATH =By.xpath("//*[@data-testid='Address Line 2:input:control']");
	By CITY_XPATH =By.xpath("//*[@data-testid='City / Town:input:control']");
	By STATE_SELECT =By.xpath("//*[@data-testid='State:select:control']");
	By POSTALCODE_XPATH =By.xpath("//*[@data-testid='Postal Code:input:control']");
	By NUMOFINSURED_XPATH =By.xpath("//*[@data-testid='Number of Insured Persons:number-input:control']");

	By AGENTNAME_SELECT=By.xpath("//*[@data-testid='Agent Name:select:control']");
	By AGENTKEY_XPATH=By.xpath("//*[@data-testid='Agent Key:input:control']");
	By LINEOFBUSS_SELECT=By.xpath("//*[@data-testid='Line Of Business:select:control']");
	By EMAIL_XPATH =By.xpath("//*[@data-testid='Email:input:control']");
	By DUTIESACTIVITIES_XPATH =By.xpath("//*[@data-testid='Duties Activities Carried Out:input:control']");
	By CURRENTINSURRER_XPATH =By.xpath("//*[@data-testid='Current Insurrer:input:control']");
	By YEAREXPERIENCE_XPATH =By.xpath("//*[@data-testid='Year of Experience in Insurance:number-input:control']");
	By ISSUEDATE_DATEPICKER=By.xpath("(//*[contains(text(),'Date Issued')]//following-sibling::div)[1]");
	By ISSUEDATE_XPATH=By.xpath("(//input[@placeholder='DD'])[1]");
	By ISSUEMONTH_XPATH=By.xpath("(//input[@placeholder='MM'])[1]");
	By ISSUEYEAR_XPATH=By.xpath("(//input[@placeholder='YYYY'])[1]");
	By EXPRDATE_DATEPICKER=By.xpath("(//*[contains(text(),'Expiration Date')]//following-sibling::div)[1]");
	By EXPRDATE_XPATH=By.xpath("(//input[@placeholder='DD'])[2]");
	By EXPRMONTH_XPATH=By.xpath("(//input[@placeholder='MM'])[2]");
	By EXPRYEAR_XPATH=By.xpath("(//input[@placeholder='YYYY'])[2]");
	By CONTRACTOR_XPATH =By.xpath("//*[@data-testid='Contractor:input:control']");
	By COMMISSION_XPATH =By.xpath("//*[@data-testid='Commision:number-input:control']");
	By EMAILCC1_XPATH =By.xpath("//*[@data-testid='Email CC1:input:control']");
	By EMAILCC2_XPATH =By.xpath("//*[@data-testid='Email CC2:input:control']");
	By EMAILCC3_XPATH =By.xpath("//*[@data-testid='Email CC3:input:control']");
	By EMAILCC4_XPATH =By.xpath("//*[@data-testid='Email CC4:input:control']");
		
	By COVERAGE_XPATH =By.xpath("//*[@data-testid='Coverage:number-input:control']");
	By PLAN_SELECT=By.xpath("//*[@data-testid='Plan:select:control']");
	By SUMASSURED_SELECT=By.xpath("//*[@data-testid='Sum Assured:select:control']");
	By HQTAB_SELECT=By.xpath("//*[@data-testid='HQ Tab:select:control']");
	By ELIGIBILITY_XPATH =By.xpath("//*[@data-testid='Eligibility:input:control']");
	By DEDUCTIBLE_XPATH =By.xpath("//*[@data-testid='Deductible:number-input:control']");
	By NATIONALCOINSR_XPATH =By.xpath("//*[@data-testid='National Coinsurance:number-input:control']");
	By ZONE_SELECT=By.xpath("//*[@data-testid='Zone:select:control']");
	By REGION_SELECT=By.xpath("//*[@data-testid='Region:select:control']");
	By INSUREHOLDER_XPATH =By.xpath("//*[@data-testid='Insured Holders:number-input:control']");
	By TOTALINSURED_XPATH =By.xpath("//*[@data-testid='Total Insured:number-input:control']");
	By OVERSEAEMERGENCY_SELECT=By.xpath("//*[@data-testid='Overseas Emergency:select:control']");
	By OVERSEACATAST_SELECT=By.xpath("//*[@data-testid='Overseas Catastrophe:select:control']");
	By CONVERSIONRIGHT_SELECT=By.xpath("//*[@data-testid='Conversion Right:select:control']");
	By OVERSEACOVERAGE_SELECT=By.xpath("//*[@data-testid='Overseas Coverage:select:control']");
	By INCLUDERDH_XPATH=By.xpath("(//label[text()='Include RDH']//child::div)[1]");
	By INCLUDEDENTALVISION_XPATH=By.xpath("(//label[text()='Include Dental and Vision Coverages']//child::div)[1]");
	By ADMINCOMMENT_XPATH =By.xpath("//*[@data-testid='Administration Comment:input:control']");
	By GMMEXCESSES_XPATH=By.xpath("(//label[text()='GMM Excesses']//child::div)[1]");
	By GMMPROTECTION_XPATH=By.xpath("(//label[text()='GMM Protections']//child::div)[1]");
	By GMMOPTIONAL_XPATH=By.xpath("(//label[text()='GMM Optional']//child::div)[1]");
	By BASICLIFE_XPATH=By.xpath("(//label[text()='Basic Life']//child::div)[1]");
	By OPTLIFE_XPATH=By.xpath("(//label[text()='Optional Life']//child::div)[1]");
	By LIFEFUNERALEXPENSE_XPATH=By.xpath("(//label[text()='Life Funeral Expenses']//child::div)[1]");
	By INCLUDEPAD_XPATH=By.xpath("(//label[text()='Include PAD with Waiting Period']//child::div)[1]");
	By INCLUDEMATERNITY_XPATH=By.xpath("(//label[text()='Include Maternity']//child::div)[1]");
	By INCLUDEPREEXISTING_XPATH=By.xpath("(//label[text()='Include Preexisting']//child::div)[1]");
	By INCLUDECNOSE_XPATH=By.xpath("(//label[text()='Include C Nose']//child::div)[1]");
	By INCLUDENEWBORN_XPATH=By.xpath("(//label[text()='Include Healthy Newborn']//child::div)[1]");
	By INCLUDEMENOPAUSE_XPATH=By.xpath("(//label[text()='Include Menopause']//child::div)[1]");
	By INCLUDESHOEORTHO_XPATH=By.xpath("(//label[text()='Include Shoes adn Orthopedics']//child::div)[1]");
	By INCLUDECOINSURANCE_XPATH=By.xpath("(//label[text()='Include Coinsurance Rule']//child::div)[1]");
	By INCLUDECURETTAGE_XPATH=By.xpath("(//label[text()='Include Curettage']//child::div)[1]");
	By INCLUDESTERILITYDIAG_XPATH=By.xpath("(//label[text()='Include Sterility Diagonasis']//child::div)[1]");
	By INCLUDEACCUPUNCTURE_XPATH=By.xpath("(//label[text()='Include Accupuncture']//child::div)[1]");
	By INCLUDEVISIONCORRECTION_XPATH=By.xpath("(//label[text()='Include Vision Correction']//child::div)[1]");
	By INCLUDEOTHERCOVERAGE_XPATH=By.xpath("(//label[text()='Include Other Coverages']//child::div)[1]");
	By ADDITIONALNOTE_XPATH =By.xpath("//*[@data-testid='Additional Notes:input:control']");

	By FOLIOTYPEOFBUSS_SELECT=By.xpath("//*[@data-testid='Type Of Business:select:control']");
	By FOLIOID_SELECT=By.xpath("//*[@data-testid='Folio ID:select:control']");
	By FOLIOGRP_SELECT=By.xpath("//*[@data-testid='Folio Group:select:control']");

	By DUPLICATECASE_XPATH=By.xpath("//*[text()='Potential duplicate cases:']");
	By IGNOREANDCONTBUTTON_XPATH=By.xpath("//button[@name='Ignore']");
	
	By NEXTBUTTONNB_XPATH=By.xpath("//button[@name='next']");
	
	// Verify Input Data
	By EVALRDH_XPATH =By.xpath("(//dd[@data-testid='Include RDH:field-value-item:value']//child::span)[1]");
	
	By SUBMITNB_XPATH=By.xpath("//button[@name='submit']");
	By GETID_XPATH=By.xpath("//span[contains(text(),'Individual Employee Benefits')]");
	By INTERNALSTATUS_XPATH=By.xpath("//*[text()='Internal Status']//following-sibling::dd");
	By WORKSTATUS_XPATH=By.xpath("//*[text()='Work Status']//following-sibling::dd");
	By NBLCASEID_XPATH=By.xpath("//*[text()='Individual Employee Benefits']//following-sibling::p");
	By ERROR_XPATH=By.xpath("//*[@role='alert']");
	void CompanyInformation() throws IOException;
	void AgentDetail();
	void ProductDetail();
	void AssignFolio();
	void DuplicateCheckIgnore();
	void ManageDocument();
	void ReviewSummary();
	void verifyCaseDetails();
}
