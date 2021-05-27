package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends BasePage {

	@FindBy(id = "total_price")
	private WebElement totalPrice;
	
	
	public PaymentPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public OrderSummaryPage selectPaymentType(String paymentType) {
		getWebELement(By.cssSelector("a[title='"+paymentType+"']")).click();
		return getPageInstance(OrderSummaryPage.class);

	}
	
	public String getTotalOrderAmount() {
		return totalPrice.getText();
	}


}
