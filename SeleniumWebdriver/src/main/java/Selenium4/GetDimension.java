package Selenium4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetDimension {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/angularpractice/");

		WebElement fldName = driver.findElement(By.cssSelector("input[name='name']"));

		//get height
		int heightOfElement = fldName.getRect().getDimension().getHeight();
		System.out.println("Height: "+heightOfElement);

		//get width
		int widthOfElement = fldName.getRect().getDimension().getWidth();
		System.out.println("Width: "+widthOfElement);

		driver.quit();
	}

}
