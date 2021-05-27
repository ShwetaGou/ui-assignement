package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends Page {

	@FindBy(className = "logout")
	private WebElement signOutLink;

	@FindBy(css = "[class^='submenu-container']  a[title='Dresses']")
	private WebElement dressesLink;

	@FindBy(linkText = "Summer Dresses")
	private WebElement SummerDressesLink;

	public BasePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public String getPageTitle() {
		return driver.getTitle();
	}

	@Override
	public WebElement getWebELement(By locator) {
		try {
			return driver.findElement(locator);
		} catch (Exception e) {
			System.out.println("exception occured while creating a object:" + locator.toString());
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public void waitForElementPresent(WebElement element, int time) {

		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForElementToBeClickable(WebElement element, int time) {

		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void clickUsingJavscript(WebElement ele) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", ele);
	}

	public void clickUsingActionClass(WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).click().build().perform();

	}

	public void moveToElement(WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).build().perform();

	}

	public AuthenticationPage clickSigninLink() {
		WebElement signInLink = getWebELement(By.className("login"));
		signInLink.click();
		return getPageInstance(AuthenticationPage.class);
	}

	public String getLoggedinUsername() {
		WebElement loggedinUsername = getWebELement(By.cssSelector(".account span"));
		return loggedinUsername.getText();
	}

	public WomenCategoryPage selectCategory(String category) {
		getWebELement(By.linkText(category)).click();
		return getPageInstance(WomenCategoryPage.class);

	}

	public void signOut() {
		signOutLink.click();
	}

	public void enterDataInToField(String label, WebElement ele, String data) {
		ele.sendKeys(data);
	}

	public WebElement getDressesLink() {
		return dressesLink;
	}

	public WebElement getSummerDressesLink() {
		return SummerDressesLink;
	}

	public void selectValueFromDropDown(WebElement ele, String text) {
		Select select = new Select(ele);
		select.selectByVisibleText(text);
	}

	public void clickDressesLink() {
		dressesLink.click();
	}

	public void clickSummerDressLink() {
		SummerDressesLink.click();
	}
}
