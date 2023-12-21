package WaitSynchronization;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class FluentWaitClass {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

		driver.findElement(By.cssSelector("#start button")).click();

		//Fluent wait declaration
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)

		.withTimeout(Duration.ofSeconds(30)) //max wait time
		.pollingEvery(Duration.ofSeconds(3)) //Polling time(refresh to check)
		.ignoring(NoSuchElementException.class);

		//implement until method 
		WebElement element = fluentWait.until(new Function<WebDriver, WebElement>() {

			//actual wait mechanism
			public WebElement apply(WebDriver driver) {

				if(driver.findElement(By.cssSelector("#finish h4")).isDisplayed()) {
					return driver.findElement(By.cssSelector("#finish h4"));
				}
				else {
					
					return null;
				}
			}
				
		});

		System.out.println(element.getText()); 
		
		}

	}


