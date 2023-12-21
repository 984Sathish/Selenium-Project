package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import Utils.AbstractComponent;

public class OrdersPage extends AbstractComponent{

	WebDriver driver;

	public OrdersPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	} 


	@FindBy(css  = "tbody tr")
	WebElement tableBody;

	@FindBy(css = "tbody tr")
	List<WebElement> table;



	public void verifyProduct(String orderId, String productName) {

		waitForElementIsVisible(tableBody);
		
		for (int i = 0; i < table.size(); i++) {

			String orderIdtext = table.get(i).findElement(By.tagName("th")).getText();
//			System.out.println(orderIdtext);
//			System.out.println(orderId);
			if(orderIdtext.equals(orderId)) {

				String ActualprodName = table.get(i).findElement(By.cssSelector("td:nth-child(3)")).getText();
				//System.out.println(ActualprodName);
				Assert.assertEquals(ActualprodName, productName.toLowerCase());
				break;
			}

		}

	}
}
