package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage extends BasePage {

	@FindBy(className = "alert-success")
	private WebElement orderSuccessMessage;

	public OrderConfirmationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public String getOrderConfimationMessage() {
		return orderSuccessMessage.getText();
	}

}
