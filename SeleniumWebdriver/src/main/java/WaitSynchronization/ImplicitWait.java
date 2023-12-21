package WaitSynchronization;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import dev.failsafe.Timeout;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWait {

	public static void main(String[] args) {


		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		//Driver wait 10 seconds to element present.
		//dynamically wait for the element present
		//one time global declaration is enough. It will use all test cases.

	}
}
