package DemoPractices;

import static io.restassured.RestAssured.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.path.json.JsonPath;

public class OAuthTest {

	public static void main(String[] args) throws InterruptedException {


		/*WebDriver driver;

		  //code for create instance of chrome driver using Web driver manager
		  WebDriverManager.chromedriver().setup();

		  //create new chrome driver instancce 
		  driver = new ChromeDriver();



		  driver.get(
		  "https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php"
		  ); driver.findElement(By.id("identifierId")).sendKeys(
		  "sathishsuresh984@gmail.com");
		  driver.findElement(By.id("identifierId")).sendKeys(Keys.ENTER);

		  driver.findElement(By.cssSelector("[type='password']")).sendKeys("09840894");
		  driver.findElement(By.cssSelector("[type='password']")).sendKeys(Keys.ENTER);

		  Thread.sleep(3000); String url = driver.getCurrentUrl();


		 */
		String url = "https://rahulshettyacademy.com/getCourse.php?code=4%2F0AfJohXnZGwgxK7V7UyyDzoLiv4lnQxC3u8XhwylAMEbPf68XJ1PNxSU4sAJfWzarcTqPFg&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=none";
		String AuthCode = url.split("code=")[1].split("&scope")[0];
		System.out.println(AuthCode);


		//get access token
		String response = given().urlEncodingEnabled(false)
				.queryParam("code", AuthCode)
				.queryParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.queryParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
				.queryParam("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
				.queryParam("grant_type", "authorization_code")
				.when().post("https://www.googleapis.com/oauth2/v4/token")
				.then().log().all().extract().response().asString();

		JsonPath json = new JsonPath(response);

		String accessToken = json.getString("access_token");
		System.out.println("Access Token : "+accessToken);


		//get course
		given()
		.queryParam("access_token", accessToken)
		.when().get("https://rahulshettyacademy.com/getCourse.php")
		.then().assertThat().statusCode(200)
		.log().all().extract();
		
		
		






	}

}
