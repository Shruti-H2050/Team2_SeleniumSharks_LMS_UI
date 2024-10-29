package stepDefinitions;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;

import driverSetup.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasePage;
import pageObjects.ClassPage;
import pageObjects.LoginPage;

public class Class_steps {
	
	   private TestContextSetup context;// pico
	    private LoginPage loginPage;
	    private ClassPage classPage;

	    public Class_steps(TestContextSetup context) {
	        this.context = context;
	        this.classPage = context.getClassPage();
	        this.loginPage = context.getLoginPage();

	    }
	@Given("Admin is on the dashboard page after login")
	public void admin_is_on_the_dashboard_page_after_login() throws InterruptedException {
		 context.launchBrowser();
	        context.launchLoginUrl();
	        loginPage.Login(context.getPropUsername(),context.getPropPassword());
	       // loginPage.Login("Sdet@gmail.com", "LmsHackathon@2024");
	       // Thread.sleep(2000);
	        System.out.println("Admin is on Dashboard page after logged in");
	    
	}

	@When("Admin clicks the Class Navigation bar in the Header")
	public void admin_clicks_the_class_navigation_bar_in_the_header() {
		  classPage.clickClassBtn();
	}

	@Given("Admin is on the Manage Class page")
	public void admin_is_on_the_manage_class_page() {
		 classPage.manageClassTitleDisplay();
	        Assert.assertTrue(classPage.manageClassTitleDisplay());
	        System.out.println("Admin is on the Manage class page");
	}

	@When("Admin clicks on the delete icon")
	public void admin_clicks_on_the_delete_icon() {
		classPage.justClick();
		classPage.clickdeleteIcons();
	}

	@Then("Admin should see a confirmation popup with <YES> and <NO> button")
	public void admin_should_see_a_confirmation_popup_with_yes_and_no_button() {
		classPage.confirmDialog();
	}

	@Given("Admin is on Confirm Deletion alert")
	public void admin_is_on_confirm_deletion_alert() {
		classPage.justClick();
		classPage.clickdeleteIcons();
		classPage.confirmDialog();
	}

	@When("Admin clicks yes option")
	public void admin_clicks_yes_option() {
		classPage.clickDeletYesBtn();
	}

	@Then("Admin gets a message {string} alert and do not see that Class in the data table")
	public void admin_gets_a_message_alert_and_do_not_see_that_class_in_the_data_table(String string) {
		classPage.deleteSuccessMessage();
	}

	@When("Admin clicks no option")
	public void admin_clicks_no_option() {
		classPage.clickDeletNoBtn();
	}

	@Then("Admin can see the deletion alert disappears without deleting")
	public void admin_can_see_the_deletion_alert_disappears_without_deleting() {
	   context.getClassURL();
	}

	@When("Admin clicks on close button")
	public void admin_clicks_on_close_button() {
	    classPage.deletealertcross();
	}

	@Then("Admin can see the deletion alert disappears without any changes")
	public void admin_can_see_the_deletion_alert_disappears_without_any_changes() {
	   context.getClassURL();
	   Assert.assertTrue(classPage.searchbox());
	}

	@Given("Admin is in Manage Class page")
	public void admin_is_in_manage_class_page() {
	   
	}

	@When("Admin clicks any checkbox in the data table")
	public void admin_clicks_any_checkbox_in_the_data_table() {
		classPage.checkboxSelected();
	}

	@Then("Admin should see common delete option enabled under header Manage class")
	public void admin_should_see_common_delete_option_enabled_under_header_manage_class() {
		classPage.headerdeleteIcon();
	}

	@When("Admin clicks <YES> button on the alert")
	public void admin_clicks_yes_button_on_the_alert() {
		classPage.clickDeletYesBtn();
	}

	@When("Admin clicks <No> button on the alert")
	public void admin_clicks_no_button_on_the_alert() {
		classPage.clickDeletNoBtn();
	}

	@Then("Admin should land on Manage class page and can see the selected class is deleted from the data table")
	public void admin_should_land_on_manage_class_page_and_can_see_the_selected_class_is_deleted_from_the_data_table() {
	   context.getClassURL();
	}

	@Then("Admin should land on Manage class page and can see the selected class is not deleted from the data table")
	public void admin_should_land_on_manage_class_page_and_can_see_the_selected_class_is_not_deleted_from_the_data_table() {
		 context.getClassURL();
	}



}


