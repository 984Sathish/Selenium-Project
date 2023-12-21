package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.AbstractComponent;

public class OrderConfirmPage  extends AbstractComponent {

	WebDriver driver;

	public OrderConfirmPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	} 
	
	@FindBy(className = "hero-primary")
	WebElement msgOrdered;
	
	@FindBy(css = "tr.ng-star-inserted label")
	WebElement orderId;
	
	public String verifyOrderSuccessMsg() {
		return msgOrdered.getText();
	}
	
	public String getOrderId() {
		
		String textOrderId = orderId.getText();
		String orderId = textOrderId.split(" ")[1].trim();
		return orderId;
	}

}
