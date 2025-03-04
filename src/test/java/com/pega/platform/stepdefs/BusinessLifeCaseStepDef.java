package com.pega.platform.stepdefs;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.google.inject.Inject;
import com.pega.CRMTestEnvironment;
import com.pega.framework.PegaWebDriver;
import com.pega.platform.BusinessLifeCase;

@ScenarioScoped
public class BusinessLifeCaseStepDef {
	private TopNavStepdef topNavFixture;
	private PegaWebDriver pegaDriver;
	private BusinessLifeCase businesslifecase;
	@Inject
	public BusinessLifeCaseStepDef(TopNavStepdef topNavFixture,CRMTestEnvironment testEnv) {
	        this.topNavFixture = topNavFixture;	
		
			pegaDriver = testEnv.getPegaDriver();
			businesslifecase = topNavFixture.getBusinessLifeCase();
	}
	@When("enter Applicant information and submits case")
	public void enter_applicant_information_and_submits_case() {
		businesslifecase.ApplicantInformation();
		businesslifecase.verifyQuote();
	}
	
	@Then("a new case should be created")
	public void a_new_case_should_be_created() {
		businesslifecase.verifyCaseDetails();
	}
	
	}

