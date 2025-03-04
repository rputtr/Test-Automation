package com.pega.platform.stepdefs;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;

import com.google.inject.Inject;
import com.pega.CRMBrowser;
//import com.pega.PlatformBrowser;
//import com.pega.PlatformTestEnvironment;
import com.pega.TestEnvironment;
import com.pega.platform.IndividualPortal;
import com.pega.platform.stepdefs.TopNavStepdef;
import com.pega.framework.PegaWebDriver;

@ScenarioScoped
public class IndividualPortalStepDef {
	private CRMBrowser browser;
	private TopNavStepdef topNavStepdef;
	private PegaWebDriver pegaDriver;
	public IndividualPortal individualPortal;
	@Inject
	public IndividualPortalStepDef(CRMBrowser browser) {
				individualPortal= browser.getIndPortal();
		
	}
	
	
	}

