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
	
	@Given("Admin is on Program module")
	public void admin_is_on_program_module() {
	
		programPage.clickProgramBtn();;
		
	}

	@When("Admin clicks on Arrow next to program Name")
	public void admin_clicks_on_arrow_next_to_program_name() {
		programPage.sortProgramName.click();
	}

	@Then("Admin See the Program Name is sorted in Ascending order\\/Descending order")
	public void admin_see_the_program_name_is_sorted_in_ascending_order_descending_order() {
		
		Assert.assertTrue(programPage.sortProgramName(),"Program Name is not sorted Ascending order\\/Descending order");
	}

	@When("Admin clicks on Arrow next to Program Description")
	public void admin_clicks_on_arrow_next_to_program_description() {
		programPage.programDesHeader.click();
	   
	}

	@Then("Admin See the program Description is sorted in Ascending order\\/Descending order")
	public void admin_see_the_program_description_is_sorted_in_ascending_order_descending_order() {
		Assert.assertTrue(programPage.sortProgramDesc(),"Program Description is not sorted Ascending order\\/Descending order");
	}

	@When("Admin clicks on Arrow next to Program status")
	public void admin_clicks_on_arrow_next_to_program_status() {
		programPage.programStatusHeader.click();
	}

	@Then("Use See the  Program Status is sorted in Ascending order\\/Descending order")
	public void use_see_the_program_status_is_sorted_in_ascending_order_descending_order() {
		Assert.assertTrue(programPage.sortProgramStatus(),"Program Status is not sorted Ascending order\\/Descending order");
	}


}
