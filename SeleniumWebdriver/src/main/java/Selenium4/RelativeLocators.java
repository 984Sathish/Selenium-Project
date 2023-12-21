package Selenium4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocators {

	public static void main(String[] args) {
		

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		//above
		WebElement fldName = driver.findElement(By.cssSelector("input[name='name']"));
		String text = driver.findElement(with(By.tagName("label")).above(fldName)).getText();
		System.out.println(text);
		
		//below
		WebElement labelDob = driver.findElement(By.cssSelector("[for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(labelDob)).click();
		
		
		//left of
		WebElement labelCheckbox = driver.findElement(By.cssSelector("[for='exampleCheck1']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(labelCheckbox)).click();
		
		//right of
		WebElement btnradio = driver.findElement(By.id("inlineRadio1"));
		String text1 = driver.findElement(with(By.tagName("label")).toRightOf(btnradio)).getText();
		System.out.println(text1);
		
		driver.quit();
	}
}
