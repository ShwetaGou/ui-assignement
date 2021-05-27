package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummaryPage extends BasePage {

	@FindBy(css =  "#cart_navigation > button")
	private WebElement confirmMyOrderButton;

	public OrderSummaryPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public OrderConfirmationPage confirmOrder() {
			confirmMyOrderButton.click();
		
		return getPageInstance(OrderConfirmationPage.class);
	}

}
