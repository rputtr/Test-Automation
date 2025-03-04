package com.pega.crm.pegamarketing.impl.elmt;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.pega.crm.pegamarketing.elmt.Connector;
import com.pega.crm.pegamarketing.elmt.OfferShape;
import com.pega.crm.pegamarketing.impl.rules.PegaOffer;
import com.pega.crm.pegamarketing.rules.Offer;
import com.pega.crm.pegamarketing.rules.Offer.Shape;
import com.pega.crm.pegamarketing.rules.Offer.ShapeProperties;
import com.pega.crm.pegamarketing.utils.GlobalRepository;
import com.pega.framework.Mouse;
import com.pega.framework.PegaWebElement;
import com.pega.framework.PegaWebElementImpl;
import com.pega.framework.elmt.DropDown;

public class PegaOfferShape extends PegaWebElementImpl implements OfferShape {

	private static final String COPYRIGHT = "Copyright (c) 2018  Pegasystems Inc.";
	public static final String VERSION = "$Id: FlowShapeImpl.java 208492 2018-09-06 14:58:05Z VenkatasrikarVadlamudi $";

	protected String shapeName;
	protected Offer offer;

	public PegaOfferShape(WebElement elmt) {
		super(elmt);
	}

	public PegaOfferShape(WebElement elmt, Offer offer, String shapeName) {
		super(elmt);
		this.shapeName = shapeName;
		this.offer = offer;
	}

	public PegaOfferShape(WebElement elmt, String elmtId) {
		super(elmt, elmtId);
	}

	public Connector makeConnection(OfferShape shape, String connectorName) {
		return makeConnection(shape, connectorName, "-1");
	}

	public Connector makeConnection(OfferShape shape, String connectorName, String position) {
		boolean isFirefox = testEnv.getBrowser().isFirefox();
		this.moveMouseToThis(-10, -10);
		String connPointXpath = null;

		if (position.equals("-1")) {
			connPointXpath = "//*[name()='image' and @*[(contains(.,'connector'))]]";
		} else {
			connPointXpath = "(//*[name()='image' and @*[(contains(.,'circle'))]])[" + position + "]";
		}

		Reporter.log("ConnectionPointXPATH::" + connPointXpath, true);
		PegaWebElement connElmt = offer.findElement(By.xpath(connPointXpath));
		if (isFirefox) {
			doClickWithMouse();
			this.moveMouseToThis(-11, -11);
			pegaDriver.handleWaits().sleep(3);
		}
		connElmt.moveMouseToThis();
		if (isFirefox) {
			pegaDriver.handleWaits().sleep(2);
		}
		Mouse mouse = testEnv.getMouse();
		mouse.pressLeftButton();
		if (isFirefox) {
			pegaDriver.handleWaits().sleep(2);
		}
		shape.moveMouseToThis();
		mouse.releaseLeftButton();

		testEnv.getPegaDriver().waitForDocStateReady(3); // An explicit call to wait for doc state ready is needed here
															// as a virtual mouse action is being used instead of using
															// the selenium overloaded click method

		offer.findElement(TOOLBAR_PROPERTIES_BTN);
		offer.findElement(TOOLBAR_PROPERTIES_BTN).click();

		PegaWebElement moName = offer.findElement(By.xpath(Offer.MONAME_XPATH));
		scriptExecutor.sendKeys(moName, connectorName);
		offer.findElement(By.xpath(GlobalRepository.SUBMIT_BUTTON_XPATH)).click(true);
		mouse.moveTo(50, 20);
		By byShapeXpath = By.xpath("//*[*[name()='path']]/following-sibling::*[contains(@style,'visible')]//*[text()='"
				+ connectorName + "']");
		// pegaDriver.handleWaits().waitForElementPresence(byShapeXpath);
		offer.findElement(By.xpath(Offer.DIV_PROCESS_FLOW_XPATH)).click();
		WebElement connElem = offer.findElement(byShapeXpath);
		Connector connObj = new PegaConnector(connElem, offer, connectorName);
		connObj._setEnvironment(testEnv, byShapeXpath, offer.getFrameDocument(), this.getFramesSet());
		return connObj;
	}

	public String getName() {
		return shapeName;
	}

	public ShapeProperties openProperties() {
		doDoubleClickWithMouse(); // An explicit call to wait for doc state ready is needed here as a virtual
									// mouse action is being used instead of using the selenium overloaded click
									// method
		pegaDriver.waitForDocStateReady(3);
		return ((PegaOffer) offer).getShapeProperties();
	}

	public void setDecisionType(String decisionType) {
		DropDown decision = offer.findSelectBox(By.xpath(Offer.DECISIONTYPE_XPATH));
		decision.selectByVisibleText(decisionType, true);
	}

	public void submit() {
		offer.findElement(By.xpath(GlobalRepository.SUBMIT_BUTTON_XPATH)).click();
	}

	public String getInternalName() {
		return null;
	}

	public void delete() {
		boolean isFirefox = testEnv.getBrowser().isFirefox();
		this.moveMouseToThis(-5, -5);
		if (isFirefox) {
			pegaDriver.handleWaits().sleep(3);
		}
		if (this.getName().startsWith("End") || this.getName().startsWith("end")
				|| this.getName().equalsIgnoreCase("start")) {
			doClickWithMouse();
			pegaDriver.waitForDocStateReady(2);
			testEnv.getKeyboard().sendKeys(Keys.DELETE);
			pegaDriver.waitForDocStateReady(3);
		} else {
			String shapeXpath = "//*[@id='shapeLabel'][.//*[contains(text(),'" + this.getName()
					+ "')]]/preceding-sibling::*[@transform]";
			Reporter.log("shapeXpath::" + shapeXpath, true);
			PegaWebElement shapeElmt = offer.findElement(By.xpath(shapeXpath));
			shapeElmt.moveMouseToThis();
			shapeElmt.doClickWithMouse();
			pegaDriver.waitForDocStateReady(2);
			testEnv.getKeyboard().sendKeys(Keys.DELETE);
			pegaDriver.waitForDocStateReady(3);
			testEnv.getMouse().moveTo(10, 10);
		}

	}

	public ShapeProperties openProperties(Shape shape) {
		doDoubleClickWithMouse();
		pegaDriver.waitForDocStateReady(3);
		return ((PegaOffer) offer).getShapeProperties(shape);
	}

}
