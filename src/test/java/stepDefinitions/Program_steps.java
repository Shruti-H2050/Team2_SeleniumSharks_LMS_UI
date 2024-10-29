package stepDefinitions;

import org.testng.Assert;

import driverSetup.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import pageObjects.ProgramPage;

public class Program_steps {

	private TestContextSetup context;// pico
	private LoginPage loginPage;
	private ProgramPage programPage;

	public Program_steps(TestContextSetup context) {
		this.context = context;
		this.programPage = context.getProgramPage();
		this.loginPage = context.getLoginPage();
	}

	@Given("Admin is logged in to LMS Portal")
	public void admin_is_logged_in_to_lms_portal() {
		context.launchBrowser();
		context.launchUrl();
		loginPage.Login(context.getPropUsername(),context.getPropPassword());
	}

	@Given("Admin is on dashboard page after Login")
	public void admin_is_on_dashboard_page_after_login() throws InterruptedException {
		Thread.sleep(3000);
//	    String currentUrl = context.getDriver().getCurrentUrl();
//	    System.out.println("Current page url: "+currentUrl);
//	    Assert.assertEquals(currentUrl, "https://lms-frontend-hackathon-oct24-173fe394c071.herokuapp.com/");
		System.out.println("Admin is on Dashboard page after logged in");
	}

	@When("Admin clicks Program on the navigation bar")
	public void admin_clicks_program_on_the_navigation_bar() {
		programPage.clickProgramBtn();;
	}

	@Then("Admin should be navigated to Program module")
	public void admin_should_be_navigated_to_program_module() {
		boolean status = programPage.manageProgramTitleDisplay();
		Assert.assertTrue(status);
	}

}
