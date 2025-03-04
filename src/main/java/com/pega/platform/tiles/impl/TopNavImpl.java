package com.pega.platform.tiles.impl;

import org.openqa.selenium.By;

import com.pega.TestEnvironment;
import com.pega.page.TopDocumentImpl;
import com.pega.platform.BusinessLifeCase;
import com.pega.platform.EmployeeBenefitsCase;
import com.pega.platform.impl.EmployeeBenefitsCaseImpl;
import com.pega.platform.impl.PegaBusinessLifeCase;
import com.pega.platform.tiles.TopNav;

public class TopNavImpl extends TopDocumentImpl implements TopNav {

	public TopNavImpl(TestEnvironment testEnv) {
		super(testEnv);
	}

	@Override
	public BusinessLifeCase businesslifecase() {

		waitHandler.waitForElementClickable(createCase);
		findElement(createCase).click();		
		findElement(NewBusinessLifeCase).click();
		String frameId = getActiveFrameId(false);
		BusinessLifeCase businesslifecase = new PegaBusinessLifeCase(frameId, testEnv);
		return businesslifecase;
	}

	@Override
	public EmployeeBenefitsCase employeeBenefitsCase() {
		waitHandler.waitForElementClickable(createCase);
		findElement(createCase).click();		
		findElement(EmployeeBenefitsCase).click();
		String frameId = getActiveFrameId(false);
		EmployeeBenefitsCase employeeBenefitsCase = new EmployeeBenefitsCaseImpl(frameId, testEnv);
		return employeeBenefitsCase;
	}
}
