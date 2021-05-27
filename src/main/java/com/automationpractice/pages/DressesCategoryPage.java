package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DressesCategoryPage extends BasePage {
	
	@FindBy(linkText = "Summer Dresses")
	private WebElement SummerDressesLink;
	
	public DressesCategoryPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickSummerDressLink() {
		SummerDressesLink.click();
	}
	
	


}
