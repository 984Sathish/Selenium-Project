package StepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import Pages.CartPage;
import Pages.CheckOutPage;
import Pages.LoginPage;
import Pages.OrderConfirmPage;
import Pages.OrdersPage;
import Pages.ProductPage;
import TestComponent.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends BaseTest {
	
	public LoginPage loginPage;
	public ProductPage productPage;
	public CartPage cartPage;
	public CheckOutPage checkOutPage;
	public OrderConfirmPage orderConfirmPage;
	public String orderId;
	public String productName;

	@Given("Navigate to ecommerce page")
	public void navigate_to_ecommerce_page() throws IOException {

		launchApplication();
	}

	@Given("Login with username sathishsuresh984@gmail.com and password Satz@{int}")
	public void login_with_username_and_password(String username, String password) {

		productPage = loginPage.login(username, password);
	}

	@When("Add product IPHONE {int} PRO from cart")
	public void add_product_from_cart(String product) {

		productName = product;
		productPage.addProductToCart(productName);
		cartPage = productPage.clickToCart();
	}
	
	@When("Checkout IPHONE {int} PRO and submit order")
	public void checkout_iphone_pro_and_submit_order(String productName) throws InterruptedException {
		
		boolean productIsDisplayed = cartPage.verifyProductIsDisplayed(productName);
		Assert.assertTrue(productIsDisplayed);
		checkOutPage = cartPage.clickCheckOutBtn();
		
		checkOutPage.selectCountry("India");
		orderConfirmPage = checkOutPage.clickPlaceOrder();
	}

	@Then("Verify {string} message is displayed on order confirmation page")
	public void verify_message_is_displayed_on_order_confirmation_page(String string) {
		
		Assert.assertEquals(orderConfirmPage.verifyOrderSuccessMsg(), "THANKYOU FOR THE ORDER.");
		orderId = orderConfirmPage.getOrderId();

	}
	
	@Then("Go to orders page and verify order id")
	public void go_to_orders_page_and_verify_order_id() {
	    
		productPage = loginPage.login("sathishsuresh984@gmail.com", "Satz@984");

		OrdersPage ordersPage = productPage.clickOrders();
		ordersPage.verifyProduct(orderId, productName);
	}

}
