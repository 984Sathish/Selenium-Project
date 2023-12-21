package Selenium4;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v118.network.Network;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetNetworkLog {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		DevTools devTools = driver.getDevTools();
		devTools.createSession();

		//network enable
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

		//get request details
		devTools.addListener(Network.requestWillBeSent(), request -> {

			System.out.println("Request Url: "+request.getRequest().getUrl()); 
		});

		//get response details
		devTools.addListener(Network.responseReceived(), response -> {

			System.out.println("Response Url: "+response.getResponse().getUrl());  
			System.out.println("Request Url: "+response.getResponse().getStatus()); 

		});

		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink='/library']")).click();

		devTools.disconnectSession();
		driver.close();
	}

}
