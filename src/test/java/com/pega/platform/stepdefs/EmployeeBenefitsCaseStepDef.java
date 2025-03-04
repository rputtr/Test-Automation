package com.pega.platform.stepdefs;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import com.google.inject.Inject;
import com.pega.CRMTestEnvironment;
//import com.pega.PlatformTestEnvironment;
import com.pega.framework.PegaWebDriver;
import com.pega.platform.EmployeeBenefitsCase;

@ScenarioScoped
public class EmployeeBenefitsCaseStepDef {
	private TopNavStepdef topNavFixture;
	private PegaWebDriver pegaDriver;
	private EmployeeBenefitsCase employeeBenefitsCase;
	@Inject
	public EmployeeBenefitsCaseStepDef(TopNavStepdef topNavFixture,CRMTestEnvironment testEnv) {
	        this.topNavFixture = topNavFixture;	
		
			pegaDriver = testEnv.getPegaDriver();
			employeeBenefitsCase = topNavFixture.getEmployeeBenefitsCase();
	}
	@When("enter Employee information and submits case")
	public void enter_employee_information_and_submits_case() throws IOException {
		employeeBenefitsCase.CompanyInformation();
		employeeBenefitsCase.AgentDetail();
		employeeBenefitsCase.ProductDetail();
		employeeBenefitsCase.AssignFolio();
		employeeBenefitsCase.DuplicateCheckIgnore();
		employeeBenefitsCase.ManageDocument();
		employeeBenefitsCase.ReviewSummary();
	}
	
	@Then("a new EmployeeBenefits case should be created")
	public void a_new_employeebenfits_case_should_be_created() {
		employeeBenefitsCase.verifyCaseDetails();
	}
	
	}

