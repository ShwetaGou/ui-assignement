package com.automationpractice.dailogbox;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.pages.AuthenticationPage;
import com.automationpractice.pages.BasePage;
import com.automationpractice.pages.ShoppingCartSummryPage;

public class ProductsDailog extends BasePage {

	@FindBy(css = "[title='Close window']")
	private WebElement productDailogWindowCloseButton;

	@FindBy(css = "[title='Proceed to checkout']")
	private WebElement proceedToCheckoutLink;
	
	@FindBy(css = "[title='Continue shopping']")
	private WebElement continueShoppingLink;
	

	public ProductsDailog(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void closeProductDailogWindow() {
		productDailogWindowCloseButton.click();
	}

	public ShoppingCartSummryPage clickProceedToCheckoutLink() {
		proceedToCheckoutLink.click();
		return getPageInstance(ShoppingCartSummryPage.class);
	}
	
	public AuthenticationPage clickProceedToCheckoutLinkToGoShipping() {
		proceedToCheckoutLink.click();
		return getPageInstance(AuthenticationPage.class);
	}
	
	
	public void clickContinueShoppingLink() {
//		continueShoppingLink.click();
		clickUsingJavscript(continueShoppingLink);
	}
	
	
}
