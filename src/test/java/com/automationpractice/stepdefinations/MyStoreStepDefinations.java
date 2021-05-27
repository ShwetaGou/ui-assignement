package com.automationpractice.stepdefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automationpractice.dailogbox.ProductsDailog;
import com.automationpractice.driver.BaseTest;
import com.automationpractice.pages.AddressPage;
import com.automationpractice.pages.AuthenticationPage;
import com.automationpractice.pages.BasePage;
import com.automationpractice.pages.CreateAnAccountPage;
import com.automationpractice.pages.DressesCategoryPage;
import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.OrderConfirmationPage;
import com.automationpractice.pages.OrderSummaryPage;
import com.automationpractice.pages.Page;
import com.automationpractice.pages.PaymentPage;
import com.automationpractice.pages.ShippingPage;
import com.automationpractice.pages.ShoppingCartSummryPage;
import com.automationpractice.pages.WomenCategoryPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.*;

public class MyStoreStepDefinations {

	WebDriver driver;
	Page page;
	BasePage basePage;
	BaseTest baseTest = new BaseTest();
	HomePage homePage;
	WomenCategoryPage womenPage;
	ShoppingCartSummryPage shoppingCartSummryPage;
	AddressPage addressPage;
	ShippingPage shippingPage;
	PaymentPage paymentPage;
	OrderSummaryPage orderSummaryPage;
	OrderConfirmationPage orderConfirmationPage;
	AuthenticationPage authenticationPage;
	CreateAnAccountPage createAnAccountPage;

	@Before
	public void launchApplication() {
		driver = baseTest.setup();
		page = new BasePage(driver);
	}

	@After
	public void closeApplication() {
		baseTest.tearDown();

	}

	@Given("user logs into automation practice Website {string} {string} {string}")
	public void user_logs_into_automation_practice_Website(String userName, String password, String loggedinUserName) {

		basePage = page.getPageInstance(BasePage.class);
		authenticationPage = basePage.clickSigninLink();
		authenticationPage.enterUserNameField(userName);
		authenticationPage.enterPassword(password);
		authenticationPage.clickSigninButton();
		Assert.assertEquals(loggedinUserName, basePage.getLoggedinUsername());

	}

	@Given("user selects Category {string}")
	public void user_selects_Category(String category) {
		womenPage = basePage.selectCategory(category);
	}

	@Given("user adds products to cart and navigates to shopping cart summary  {string} {string}")
	public void user_adds_products_to_cart_and_navigates_to_shopping_cart_summary(String product1, String product2) {
		ProductsDailog productsDailog = womenPage.addItemToCart(product1);
		productsDailog.clickContinueShoppingLink();
		womenPage.addItemToCart(product2);
		shoppingCartSummryPage = productsDailog.clickProceedToCheckoutLink();
	}

	@Given("user proceed to checkout from shopping cart summary")
	public void user_proceed_to_checkout_from_shopping_cart_summary() {
		addressPage = shoppingCartSummryPage.clickProceedToCheckoutLink();
	}

	@Given("user proceed to checkout from Address page")
	public void user_proceed_to_checkout_from_Address_page() {
		shippingPage = addressPage.clickProceedToCheckoutLink();
	}

	@Given("user agrees to terms  and  proceed to checkout from shipping page")
	public void user_agrees_to_terms_and_proceed_to_checkout_from_shipping_page() {
		shippingPage.clickAgreeToTerms();
		paymentPage = shippingPage.clickProceedToCheckoutLink();
	}

	@Given("user verify the {string} and select paymenttype {string} on payment page")
	public void user_verify_the_and_select_paymenttype_on_payment_page(String total_amount, String paymentType) {
		Assert.assertEquals(total_amount, paymentPage.getTotalOrderAmount());
		orderSummaryPage = paymentPage.selectPaymentType(paymentType);
	}

	@When("user confirms the order")
	public void user_confirms_the_order() {
		orderConfirmationPage = orderSummaryPage.confirmOrder();

	}

	@Then("verify order is successfully placed")
	public void verify_order_is_successfully_placed() {
		Assert.assertEquals("Your order on My Store is complete.", orderConfirmationPage.getOrderConfimationMessage());
	}

	@Then("user logs out of the application")
	public void user_logs_out_of_the_application() {

		basePage.signOut();
	}

//	---------------
	@Given("user is on automation practice website")
	public void user_is_on_automation_practice_website() {
		basePage = page.getPageInstance(BasePage.class);
		basePage.waitForElementPresent(basePage.getDressesLink(), 5);
		
	}

	@Given("user selects Sub Category Dresses- Summer Dresses")
	public void user_selects_Sub_Category_Dresses_Summer_Dresses() {
		DressesCategoryPage dressesPage=basePage.clickDressesLink();		
		dressesPage.clickSummerDressLink();

	}

	@Given("user adds products to cart and navigates to shopping cart summary  {string}")
	public void user_adds_products_to_cart_and_navigates_to_shopping_cart_summary(String product) {		
		ProductsDailog productsDailog = new WomenCategoryPage(driver).addItemToCart(product);
		shoppingCartSummryPage = productsDailog.clickProceedToCheckoutLink();
	}

	@Given("user enter {string} in signin page")
	public void user_enter_in_signin_page(String email) {
		email=basePage.getRandomNumber()+email;
		authenticationPage = new AuthenticationPage(driver);
		authenticationPage.enterEmailaddress(email);
		createAnAccountPage = authenticationPage.clickCreateAccount();

	}

	@Given("user enter all the details to register to create account {string}  {string} {string}  {string}  {string}  {string}  {string} {string}")
	public void user_enter_all_the_details_to_register_to_create_account(String firstname, String lastname,
			String password, String address, String city, String state, String postcode, String mobphone) {

		basePage.enterDataInToField("firstname", basePage.getWebELement(By.id("customer_firstname")), firstname);
		basePage.enterDataInToField("lastname", basePage.getWebELement(By.id("customer_lastname")), lastname);
		basePage.enterDataInToField("password", basePage.getWebELement(By.id("passwd")), password);
		basePage.enterDataInToField("address", basePage.getWebELement(By.id("address1")), address);
		basePage.enterDataInToField("city", basePage.getWebELement(By.id("city")), city);
		basePage.selectValueFromDropDown(basePage.getWebELement(By.id("id_state")), state);
		basePage.enterDataInToField("Postcode",basePage.getWebELement(By.id("postcode")), postcode);
		basePage.enterDataInToField("Mobile Phone ", basePage.getWebELement(By.id("phone_mobile")), mobphone);
		createAnAccountPage.RegisterAccount();

	}

}
