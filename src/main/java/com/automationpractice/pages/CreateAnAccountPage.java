package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAnAccountPage extends BasePage {

	@FindBy(css = "#customer_firstname")
	private WebElement customerFirstnameField;

	@FindBy(css = "#customer_lastname")
	private WebElement customerLastnameField;

	@FindBy(id = "passwd")
	private WebElement passowrdField;

	@FindBy(id = "address1")
	private WebElement address1Field;

	@FindBy(id = "submitAccount")
	private WebElement submitAccount;

	public CreateAnAccountPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void enterCustomerFirstname(String firstName) {
		customerFirstnameField.sendKeys(firstName);
	}

	public void enterCustomerlastname(String lastName) {
		customerLastnameField.sendKeys(lastName);
	}

	public void enterPassword(String password) {
		passowrdField.sendKeys(password);
	}

	public void RegisterAccount() {

		submitAccount.click();
	}

}
