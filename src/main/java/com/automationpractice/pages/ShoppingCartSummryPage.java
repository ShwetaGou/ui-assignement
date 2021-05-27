package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ShoppingCartSummryPage extends BasePage {

	@FindBy(css = "p.cart_navigation.clearfix  > [title='Proceed to checkout']")
	private WebElement proceedToCheckoutLink;

	public ShoppingCartSummryPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public AddressPage clickProceedToCheckoutLink() {
		proceedToCheckoutLink.click();
		return getPageInstance(AddressPage.class);
	}

}
