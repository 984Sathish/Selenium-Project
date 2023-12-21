package Selenium4;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v118.fetch.Fetch;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MockRequest {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		DevTools devTools = driver.getDevTools();
		devTools.createSession();

		//send command - fetch.enable
		devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));

		//add listener to paused the request to mock
		devTools.addListener(Fetch.requestPaused(), request -> {

			if(request.getRequest().getUrl().contains("AuthorName=shetty")) {

				String mockUrl = request.getRequest().getUrl().replace("=shetty", "=BadGuy");

				System.out.println(mockUrl);

				//add listener to continue the request after mocked
				devTools.send(Fetch.continueRequest(
						request.getRequestId(), 
						Optional.of(mockUrl), 
						Optional.of(request.getRequest().getMethod()),
						Optional.empty(), Optional.empty(), Optional.empty()));
			}

			else {

				devTools.send(Fetch.continueRequest(
						request.getRequestId(), 
						Optional.of(request.getRequest().getUrl()), 
						Optional.of(request.getRequest().getMethod()),
						Optional.empty(), Optional.empty(), Optional.empty()));
			}


		});
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink='/library']")).click();
		
		Thread.sleep(3000);
		String msg = driver.findElement(By.tagName("p")).getText();
		System.out.println(msg);
		
		devTools.disconnectSession();
		driver.close();

		
	}

}
