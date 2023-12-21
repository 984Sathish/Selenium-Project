package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.AbstractComponent;

public class ProductPage extends AbstractComponent {

	WebDriver driver;

	public ProductPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".mb-3")
	List<WebElement> product;

	@FindBy(css = ".ng-animating")
	WebElement spinner;
	
	@FindBy(css = "[routerlink*='cart']")
	WebElement btnCart;

	By productsBy = By.cssSelector(".mb-3");
	By addtoCart = By.cssSelector(".card-body button:last-of-type");
	By addCartMsg = By.cssSelector("[aria-label='Product Added To Cart']");

	public List<WebElement> getProductList() {

		waitForElementToBeVisible(productsBy);
		return product;	
	}

	public WebElement getProductByName(String productName) {

		WebElement productElement = getProductList().stream().filter(product ->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return productElement;
	}

	public void addProductToCart(String productName) {
		WebElement productByName = getProductByName(productName);
		productByName.findElement(addtoCart).click();
		
		waitForElementToBeVisible(addCartMsg);
		waitForElementToBeInvisible(spinner);
		
	}
	

}
