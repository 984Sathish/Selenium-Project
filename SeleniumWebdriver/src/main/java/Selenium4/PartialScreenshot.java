package Selenium4;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PartialScreenshot {
	
	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/angularpractice/");

		WebElement fldName = driver.findElement(By.cssSelector("input[name='name']"));
		fldName.sendKeys("JohnWick");
		
		//get element screenshot
		File fileScreenshot = fldName.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(fileScreenshot, new File("logo.png"));
		
		driver.quit();
	}

}
