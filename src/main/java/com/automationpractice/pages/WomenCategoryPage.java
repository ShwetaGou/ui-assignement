package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.dailogbox.ProductsDailog;

public class WomenCategoryPage extends BasePage {

	public WomenCategoryPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public WebElement getProductContainer(String productName) {
		return getWebELement(By.xpath("//a[@class='product-name' and @title='" + productName
				+ "']//ancestor::div[@class='product-container']"));
	}

	public ProductsDailog addItemToCart(String productName) {
		WebElement productContainer = getProductContainer(productName);
		moveToElement(productContainer);
		productContainer.findElement(By.cssSelector("a[title='Add to cart']")).click();
		return getPageInstance(ProductsDailog.class);

	}

}
