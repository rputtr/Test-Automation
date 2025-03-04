package com.pega.platform.stepdefs;

import com.google.inject.Inject;
import com.pega.CRMBrowser;
//import com.pega.PlatformBrowser;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.When;

import com.pega.platform.BusinessLifeCase;
import com.pega.platform.EmployeeBenefitsCase;
import com.pega.platform.IndividualPortal;
@ScenarioScoped
public class TopNavStepdef {
	@SuppressWarnings("unused")
	//private PlatformBrowser browser;
	private CRMBrowser browser;
	public IndividualPortal individualPortal;
	private BusinessLifeCase businesslifecase;
	private EmployeeBenefitsCase employeeBenefitsCase;
	
	@Inject
	public TopNavStepdef(CRMBrowser browser) {
		//this.browser = browser;
		individualPortal=browser.getIndPortal();
	}
	public BusinessLifeCase getBusinessLifeCase() {
		return businesslifecase;
	}
	@When("creates New Business Life case")
	public void creates_new_business_life_case() {
		businesslifecase= individualPortal.getTopNav().businesslifecase();
	
	}
	
	@When("creates Employee Benefits case")
	public void creates_employee_benefits_case() {
		employeeBenefitsCase = individualPortal.getTopNav().employeeBenefitsCase();
	}
	
	public EmployeeBenefitsCase getEmployeeBenefitsCase() {
		return employeeBenefitsCase;
	}
}
