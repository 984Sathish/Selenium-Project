package ClientApplication;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.CartPage;
import Pages.CheckOutPage;
import Pages.OrderConfirmPage;
import Pages.OrdersPage;
import Pages.ProductPage;
import TestComponent.BaseTest;

public class POMClientAppDataProvider extends BaseTest{

	static String orderId;
	static String productName; 
	
	@Test(dataProvider = "getData")

	public void purchaseOrder(String username, String password, String product) throws InterruptedException, IOException {

		//login
		ProductPage productPage = loginPage.login(username, password);

		//add product to cart
		productName = product;	
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
	
	//creating data provider -> Object[][] accepts any type of data value.
	@DataProvider
	public Object[][] getData(){
		
		return new Object[][]  {{"sathishsuresh984@gmail.com", "Satz@984", "IPHONE 13 PRO"}, 
    	{"sathishsuresh984@gmail.com", "Satz@984", "ADIDAS ORIGINAL" } };
	}
}

