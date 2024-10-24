package stepDefinitions;

import org.testng.Assert;

import driverSetup.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;

public class Login_steps {

	private TestContextSetup context;// pico
	private LoginPage loginPage;

	public Login_steps(TestContextSetup context) {
		this.context = context;
		this.loginPage = context.getLoginPage();
	}

	@Given("Admin launch the browser")
	public void admin_launch_the_browser() {

		context.launchBrowser();
		//context.launchUrl();
		
	}

	@When("Admin gives the correct LMS portal URL")
	public void admin_gives_the_correct_lms_portal_url() {
		context.launchUrl();

		String currentUrl = context.getDriver().getCurrentUrl();
		System.out.println("currentUrl: "+currentUrl);
//		Assert.assertTrue(false);//remove later
		
		Assert.assertEquals(currentUrl, context.getBaseClass().getUrl(),
				"The current URL does not match the expected URL");
	}

	@Then("Admin should land on the login page")
	public void admin_should_land_on_the_login_page() {

		String loginPageTitle = context.getDriver().getTitle();
		Assert.assertNotNull(loginPageTitle, loginPageTitle);
		System.out.println("Login page title: " + loginPageTitle);
	}

}
