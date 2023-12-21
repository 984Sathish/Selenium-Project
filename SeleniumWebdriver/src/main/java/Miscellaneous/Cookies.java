package Miscellaneous;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Cookies {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		
		//driver.manage().deleteCookie(cookiesName);  --> delete specific cookies 
		
		//driver.manage().addCookie(cookiesName);  --> add specific cookies

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		
	}

}
