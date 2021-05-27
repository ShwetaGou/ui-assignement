package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthenticationPage extends BasePage {

	@FindBy(id="email")
	private WebElement userNameField;
	
	@FindBy(id="passwd")
	private WebElement passwordField;
	
	@FindBy(id="SubmitLogin")
	private WebElement signinButton;
	
	@FindBy(id="SubmitCreate")
	private WebElement createAnAccountButton;
	
	@FindBy(id="email_create")
	private WebElement emailCreateField;
	
	
	public AuthenticationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void enterUserNameField(String userName) {
		userNameField.sendKeys(userName);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void enterEmailaddress(String email) {
		emailCreateField.sendKeys(email);
	}
	
	public CreateAnAccountPage clickCreateAccount() {
		 createAnAccountButton.click();
		 return getPageInstance(CreateAnAccountPage.class);
		 
	}
	public MyAccountPage clickSigninButton() {
		signinButton.click();
		return getPageInstance(MyAccountPage.class);
	}

}
