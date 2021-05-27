package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {

	static WebDriver driver;
	WebDriverWait wait;

	public Page(WebDriver driver) {
		this.driver = driver;

	}

	// abstract methods

	public abstract String getPageTitle();

	public abstract WebElement getWebELement(By locator);

	public abstract void waitForElementPresent(WebElement element, int time);

	public <TPage extends BasePage> TPage getPageInstance(Class<TPage> pageClass) {
		try {
			return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
