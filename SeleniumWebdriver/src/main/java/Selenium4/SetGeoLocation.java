package Selenium4;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v118.emulation.Emulation;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SetGeoLocation {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		DevTools devTools = driver.getDevTools();
		devTools.createSession();

		Map<String, Object> map = new HashedMap<String, Object>();
		map.put("latitude", 40);
		map.put("longitude", 3);
		map.put("accuracy", 1);

		driver.executeCdpCommand("Emulation.setGeolocationOverride", map);

		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("netflix", Keys.ENTER);
		
		devTools.disconnectSession();
		driver.close();
	}

}
