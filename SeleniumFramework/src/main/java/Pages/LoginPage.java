package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.AbstractComponent;

public class LoginPage extends AbstractComponent {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(id = "userEmail") 
	WebElement fldUsername;

	@FindBy(id = "userPassword") 
	WebElement fldpassword;

	@FindBy(id = "login") 
	WebElement btnLogin;

	@FindBy(css = "[aria-label='Login Successfully']")
	WebElement loginMsg;

	@FindBy(css = "[class*='flyInOut']")
	WebElement loginErrMsg;


	public void NavigateToUrl() {
		driver.get("https://rahulshettyacademy.com/client");
	}

	public ProductPage login(String username, String password) {
		fldUsername.sendKeys(username);
		fldpassword.sendKeys(password);
		btnLogin.click();
		waitForElementToBeInvisible(loginMsg);

		return new ProductPage(driver);
	}

	public String getErrorMsg() {
		waitForElementIsVisible(loginErrMsg);
		return loginErrMsg.getText();
	}



}
