package Utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.CartPage;
import Pages.OrdersPage;

public class AbstractComponent {

	WebDriver driver;

	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[routerlink*='cart']")
	WebElement btnCart;

	@FindBy(css = "[routerlink*='myorders']")
	WebElement btnOrders;

	public void waitForElementToBeVisible(By findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public void waitForElementToBeInvisible(WebElement webElement) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));		
		wait.until(ExpectedConditions.invisibilityOf(webElement));
	}

	public void scrollToBottom() throws InterruptedException {
		//scroll to bottom of page
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, document.body.scrollHeight)"); 
		Thread.sleep(2000);
	}

	public void waitForElementIsVisible(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(element));
	}


	public CartPage clickToCart() {
		btnCart.click();
		return new CartPage(driver);
	}

	public OrdersPage clickOrders() {
		btnOrders.click(); 
		return new OrdersPage(driver);
	}

}
