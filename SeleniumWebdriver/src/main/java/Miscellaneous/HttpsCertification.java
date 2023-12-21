package Miscellaneous;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HttpsCertification {

	
	public static void main(String[] args) {
		
		//handle https certification
		ChromeOptions option = new ChromeOptions();
		option.setAcceptInsecureCerts(true);
		
		WebDriverManager.chromedriver().setup();

		//pass the object to chrome driver
		WebDriver driver = new ChromeDriver(option);
		
		driver.get("https://expired.badssl.com/");
		
		
	}
}

