package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.AbstractComponent;

public class CheckOutPage extends AbstractComponent{

WebDriver driver;
	
	public CheckOutPage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(css = "[placeholder='Select Country']")
	WebElement fldCountry;
	
	@FindBy(xpath = "//span[text()=' India']")
	WebElement btnSuggestion;
	
	@FindBy(xpath = "//a[text()='Place Order ']")
	WebElement btnPlaceOrder;

	
	public void selectCountry(String countryName) throws InterruptedException {
		
		Actions actions = new Actions(driver);
		actions.sendKeys(fldCountry, countryName).build().perform();  
		btnSuggestion.click();
		scrollToBottom();
	}
	
	public OrderConfirmPage clickPlaceOrder() {
		btnPlaceOrder.click();
		return new OrderConfirmPage(driver);
		
	}
	
}
