package StepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefination {

	@Given("Navigate to login page")
	public void navigate_to_login_page() {
		System.out.println("Navigate to login page");

	}

	@When("^Login to application with \"(.*?)\" and password \"(.*?)\"$")
	public void login_to_application_with_and_password(String username, String password) throws Throwable {
	    System.out.println(username);
	    System.out.println(password);
	}

	@Then("Navigate to Homepage")
	public void navigate_to_homepage() {
	    System.out.println("Navigate to home page");

	}

	@And("Product are displyed")
	public void product_are_displyed() {
		System.out.println("Product are displayed");
	}

}
