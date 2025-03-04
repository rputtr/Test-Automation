package com.pega.platform.tiles;

import org.openqa.selenium.By;

import com.pega.platform.BusinessLifeCase;
import com.pega.platform.EmployeeBenefitsCase;


public interface TopNav {
	By createCase = By.xpath("(//button[@type='button'])[5]");
	By EmployeeBenefitsCase = By.xpath("//*[text()='Individual Employee Benefits']");
	By NewBusinessLifeCase = By.xpath("//*[@data-testid=':summary-item:primary' and normalize-space()='New Business Life']");
	BusinessLifeCase businesslifecase();
	EmployeeBenefitsCase employeeBenefitsCase();
}
