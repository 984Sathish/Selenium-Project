package Selenium4;

import java.util.List;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetConsoleLogs {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.in/");
		Thread.sleep(3000);

		//get console logs
		LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
		List<LogEntry> logList = logEntries.getAll();

		for(LogEntry log: logList) {
			System.out.println(log.getMessage());
		}

		driver.close();
	}

}
