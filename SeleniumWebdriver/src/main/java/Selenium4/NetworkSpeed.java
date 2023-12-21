package Selenium4;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v118.network.model.ConnectionType;
import org.openqa.selenium.devtools.v118.network.Network;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NetworkSpeed {
	
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		//enable network
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
		//input for network conditions
		Boolean offline = false;
		Number latency = 3000;
		Number downloadThroughput = 20000;
		Number uploadThroughput = 100000;
		
		//emulate network conditions
		devTools.send(Network.emulateNetworkConditions(offline, latency, downloadThroughput, uploadThroughput, Optional.of(ConnectionType.WIFI)));
		
		long startTime = System.currentTimeMillis();
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink='/library']")).click();
		
		long endTime = System.currentTimeMillis();
		
		//get execution time in ms
		Long time = endTime - startTime;
		System.out.println("Execution time(ms): "+time );
		
		devTools.disconnectSession();
		driver.close();
	}

}
