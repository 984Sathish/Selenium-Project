package ClientApplication;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.CartPage;
import Pages.CheckOutPage;
import Pages.OrderConfirmPage;
import Pages.OrdersPage;
import Pages.ProductPage;
import TestComponent.BaseTest;

public class POMClientAppEnd2EndFlow extends BaseTest{

	static String orderId;
	static String productName; 

	@Test

	public void purchaseOrder() throws InterruptedException, IOException {

		//login
		ProductPage productPage = loginPage.login("sathishsuresh984@gmail.com", "Satz@984");

		//add product to cart
		productName = "ADIDAS ORIGINAL";	
		//ProductPage productPage = new ProductPage(driver);
		productPage.addProductToCart(productName);

		//click cart btn
		CartPage cartPage = productPage.clickToCart();

		//verify product in cart

		//	CartPage cartPage = new CartPage(driver);
		boolean productIsDisplayed = cartPage.verifyProductIsDisplayed(productName);

		Assert.assertTrue(productIsDisplayed);

		//checkout
		CheckOutPage checkOutPage = cartPage.clickCheckOutBtn();

		//select country
		checkOutPage.selectCountry("India");

		//place order	
		OrderConfirmPage orderConfirmPage = checkOutPage.clickPlaceOrder();

		//verify success message
		Assert.assertEquals(orderConfirmPage.verifyOrderSuccessMsg(), "THANKYOU FOR THE ORDER.");

		orderId = orderConfirmPage.getOrderId();

	}

	@Test(dependsOnMethods = {"purchaseOrder"})
	public void VerifyOrder() {

		ProductPage productPage = loginPage.login("sathishsuresh984@gmail.com", "Satz@984");

		OrdersPage ordersPage = productPage.clickOrders();
		ordersPage.verifyProduct(orderId, productName);


	}
}

