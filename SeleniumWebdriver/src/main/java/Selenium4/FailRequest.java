package Selenium4;

import static org.testng.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v118.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v118.network.model.ErrorReason;
import org.openqa.selenium.devtools.v118.fetch.Fetch;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FailRequest {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		DevTools devTools = driver.getDevTools();
		devTools.createSession();

		List<RequestPattern> requestPattern = Arrays.asList(new RequestPattern(
				Optional.of("*GetBook*"), 
				Optional.empty(), 
				Optional.empty()
				));

		devTools.send(Fetch.enable(Optional.of(requestPattern), Optional.empty()));
		devTools.addListener(Fetch.requestPaused(), request -> {

			devTools.send(Fetch.failRequest(request.getRequestId(), ErrorReason.FAILED));
		});
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink='/library']")).click();
		
		int rowSize = driver.findElements(By.cssSelector("table tr")).size();
		assertEquals(rowSize, 1);
		
		devTools.disconnectSession();
		driver.close();
	}

}
