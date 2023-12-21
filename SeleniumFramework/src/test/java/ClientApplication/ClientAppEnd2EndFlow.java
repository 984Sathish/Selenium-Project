package ClientApplication;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClientAppEnd2EndFlow {

	@Test
	public void OrderPurchase() throws InterruptedException{

		//web driver setup
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		//max window
		driver.manage().window().maximize();

		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//navigate to url
		driver.get("https://rahulshettyacademy.com/client");

		//login
		driver.findElement(By.id("userEmail")).sendKeys("sathishsuresh984@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Satz@984");
		driver.findElement(By.id("login")).click();

		//explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.invisibilityOf(
				driver.findElement(By.cssSelector("[aria-label='Login Successfully']"))));


		//add product to cart
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector(".mb-3")));
		List<WebElement> productElements = driver.findElements(By.cssSelector(".mb-3"));


		String productName = "ADIDAS ORIGINAL";
		WebElement productElement = productElements.stream().filter(product -> 
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);

		productElement.findElement(By.cssSelector(".card-body button:last-of-type")).click();


		//add product to cart
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("[aria-label='Product Added To Cart']")));

		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

		//add to cart 
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

		//verify product in cart
		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));

		boolean anyMatch = cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equals(productName));
		Assert.assertTrue(anyMatch);

		//checkout
		driver.findElement(By.cssSelector(".totalRow button[class='btn btn-primary']")).click();

		//select country
		Actions actions = new Actions(driver);

		actions.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "India").build().perform();  
		driver.findElement(By.xpath("//span[text()=' India']")).click();

		//scroll to bottom of page
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, document.body.scrollHeight)"); 
		Thread.sleep(2000);

		//place order	
		driver.findElement(By.xpath("//a[text()='Place Order ']")).click();

		//verify success message
		String textMsg = driver.findElement(By.className("hero-primary")).getText();

		Assert.assertEquals(textMsg, "THANKYOU FOR THE ORDER.");

		driver.quit();

	}
}
