package ClientApplication;

import java.io.IOException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.CartPage;
import Pages.CheckOutPage;
import Pages.OrderConfirmPage;
import Pages.OrdersPage;
import Pages.ProductPage;
import TestComponent.BaseTest;

public class POMClientAppWithHashMap extends BaseTest{

	static String orderId;
	static String productName; 

	@Test(dataProvider = "getData")

	public void purchaseOrder(HashMap<String, String> hashMap) throws InterruptedException, IOException {

		//login
		ProductPage productPage = loginPage.login(hashMap.get("username"), hashMap.get("password"));

		//add product to cart
		productName = hashMap.get("product");	
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

		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("username", "sathishsuresh984@gmail.com");
		map1.put("password", "Satz@984");
		map1.put("product", "IPHONE 13 PRO");

		HashMap<String, String> map2 = new HashMap<String, String>();
		map2.put("username", "sathishsuresh984@gmail.com");
		map2.put("password", "Satz@984");
		map2.put("product", "ADIDAS ORIGINAL");

		return new Object[][]  {{map1}, {map2} };
	}
}

