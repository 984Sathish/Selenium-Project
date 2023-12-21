package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.AbstractComponent;

public class CartPage extends AbstractComponent {
	
	WebDriver driver;
	
	public CartPage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".cartSection h3")
	List<WebElement> cartProducts;
	
	@FindBy(css = ".totalRow button[class='btn btn-primary']")
	WebElement btnCheckout;
	
	
	public boolean verifyProductIsDisplayed(String productName) {

		boolean anyMatch = cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equals(productName));
		return anyMatch;
	}
	
	public CheckOutPage clickCheckOutBtn() {
		btnCheckout.click();
		return new CheckOutPage(driver);
	}
	
}
