package com.pega.platform;

import org.openqa.selenium.By;

import com.pega.crm.customerservice.interactions.Interactions;
import com.pega.page.TopDocument;
import com.pega.ri.Wizard;

public interface BusinessLifeCase extends TopDocument  {
By FIRSTNAME_XPATH =By.xpath("//*[@data-testid='First Name:input:control']");
By LASTNAME_XPATH =By.xpath("//*[@data-testid='Last Name:input:control']");
By GENDER_SELECT=By.xpath("//*[@data-testid='Gender:select:control']");
By NEXTBUTTONNB_XPATH=By.xpath("//button[@name='next']");
//By DOB_DATEPICKER=By.xpath("//*[@data-testid=':date-input:open-close-picker']");
By DOB_DATEPICKER=By.xpath("(//*[contains(text(),'Date Of Birth')]//following-sibling::div)[1]");
By DATE_XPATH=By.xpath("//input[@placeholder='DD']");
By MONTH_XPATH=By.xpath("//input[@placeholder='MM']");
By YEAR_XPATH=By.xpath("//input[@placeholder='YYYY']");
By AGE_XPATH=By.xpath("//*[@data-testid='Age:number-input:control']");
By STATUS_SELECT=By.xpath("//*[@data-testid='Martial Status:select:control']");
By TOI_SELECT=By.xpath("//*[@data-testid='Type of Identification:select:control']");
By ID_XPATH=By.xpath("//*[@data-testid='Identification Number:number-input:control']");
By PHONENUMBER_XPATH =By.xpath("//*[@data-testid='Phone Number:phone-input:control']");
By EMAILNB_XPATH=By.xpath("//*[@data-testid='Email:input:control']");
By ZIPCODE_XPATH=By.xpath("//*[@data-testid='Zip code:input:control']");
//By CONSENT_RADIOBUTTON=By.xpath("(//input[contains(@id, 'Consent.Yes')])[1]");
By CONSENT_RADIOBUTTON=By.xpath("//label[contains(@for, 'Consent.Yes')]");
By COVERAGE_XPATH=By.xpath("//*[@data-testid='Coverage:number-input:control']");
By PLAN_SELECT=By.xpath("//*[@data-testid='Plan:select:control']");
By SUMASSURED_SELECT=By.xpath("//*[@data-testid='Sum Assured:select:control']");
By SMOKER_CHECKBOX=By.xpath("//*[text()='Smoker']");
By QUOTEID_XPATH=By.xpath("//*[@data-testid='Quote ID:input:control']");
By REVIEWQUOTE_XPATH=By.xpath("//*[@data-testid='Review Quote:text-area:control']");
By PROCEED_XPATH=By.xpath("//label[contains(@for, 'ProceedToPolicy.Yes')]");
By SUBMITNB_XPATH=By.xpath("//button[@name='submit']");
By GETID_XPATH=By.xpath("//span[contains(text(),'Create New Business Life')]");
By INTERNALSTATUS_XPATH=By.xpath("//*[text()='Internal Status']//following-sibling::dd");
By NBLCASEID_XPATH=By.xpath("//*[text()='New Business Life']//following-sibling::p");
By ERROR_XPATH=By.xpath("//*[@role='alert']");
void ApplicantInformation();
void verifyQuote();
void verifyCaseDetails();
}
