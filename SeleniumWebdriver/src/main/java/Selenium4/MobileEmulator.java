package Selenium4;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v118.emulation.Emulation;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MobileEmulator {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();

		devTools.createSession();

		//Note: To get selenium dev tool details -> https://chromedevtools.github.io/devtools-protocol/ 

		//send commands to CDP to set device metrics
		devTools.send(Emulation.setDeviceMetricsOverride(600, 1000, 50, true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));

		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("[aria-label='Toggle navigation']")).click();
		Thread.sleep(3000);

		driver.findElement(By.linkText("Library")).click();
		
		devTools.disconnectSession();
		driver.close();


	}
}


