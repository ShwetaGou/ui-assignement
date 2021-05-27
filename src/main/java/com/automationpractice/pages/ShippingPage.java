package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingPage extends BasePage {

	@FindBy(name = "processCarrier")
	private WebElement proceedToCheckoutLink;

	@FindBy(id = "cgv")
	private WebElement agreeToTermsCheckBox;

	public ShippingPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public PaymentPage clickProceedToCheckoutLink() {
		proceedToCheckoutLink.click();
		return getPageInstance(PaymentPage.class);
	}

	public void clickAgreeToTerms() {
		agreeToTermsCheckBox.click();

	}
}
