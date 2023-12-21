package Miscellaneous;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddExtension {

	public static void main(String[] args) {
		
		
		ChromeOptions option = new ChromeOptions();
		
		//set proxy
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("ipaddress:4444");  //sample proxy
		
		option.setCapability("proxy", proxy);
	
		Map<String, Object> hashMap = new HashMap<String, Object>();
		
		hashMap.put("download.default_directory", "/directory/path");
		
		option.setExperimentalOption("hashMap", hashMap);  //sample option
		
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		
	}
}
