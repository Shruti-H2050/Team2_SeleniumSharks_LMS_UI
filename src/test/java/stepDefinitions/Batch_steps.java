package stepDefinitions;

import driverSetup.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BatchPage;
import pageObjects.LoginPage;

public class Batch_steps {

	private TestContextSetup context;// pico
	private LoginPage loginPage;
	private BatchPage batchPage;
	
	public Batch_steps(TestContextSetup context) {
		this.context = context;
		this.loginPage = context.getLoginPage();
		this.batchPage = context.getBatchPage();
		
		
	}
	
	@Given("Admin is on the Dashboard Page")
	public void admin_is_on_the_dashboard_page() {
		batchPage.checkDashBoard();
	}

	@When("Admin Clicks on the Batch menu from the header")
	public void admin_clicks_on_the_batch_menu_from_the_header() {
		batchPage.clickheaderBatchButton();
	}

	@Then("Admin should be in the Manage Batch Page")
	public void admin_should_be_in_the_manage_batch_page() {
	   context.getbatchURL();
	}
	@Then("Admin should see the {string} Title")
	public void admin_should_see_the_title(String titleLMS) {
	batchPage.checkLMSTitle(titleLMS);
	   
	}
	@Then("Admin should see the {string} Heading")
	public void admin_should_see_the_heading(String mngBatTitle) {
	   batchPage.checkManageBatchTitle(mngBatTitle);
	}
	@Then("Admin should see the disabled {string} under the header")
	public void admin_should_see_the_disabled_under_the_header(String string) {
	   batchPage.checkDeleteIcon();
	}
	@Then("Admin should see the enabled pagination controls under the data table")
	public void admin_should_see_the_enabled_pagination_controls_under_the_data_table() {
	    batchPage.checkPagination();
	}
	@Then("Admin should see the edit icon in each row")
	public void admin_should_see_the_edit_icon_in_each_row() {
		batchPage.checkEditIconOnEachRow();
	}
	
	@Then("Admin should see the delete icon in each row")
	public void admin_should_see_the_delete_icon_in_each_row() {
		batchPage.checkDeleteIconOnEachRow();
	}
	@Then("Admin should see the datatable headers Batch name, Batch Description,Batch Status, No Of classes, Program Name, Edit\\/Delete")
	public void admin_should_see_the_datatable_headers_batch_name_batch_description_batch_status_no_of_classes_program_name_edit_delete() {
	   batchPage.checkBatchNameHeader();
	   batchPage.checkBatchDescHeader();
	   batchPage.checkBatchStatusHeader();
	   batchPage.checkNoOfClassesHeader();
	   batchPage.checkPgMNameHeader();
	   batchPage.checkEditDeleteHeader();
	}

	@Then("Admin should see the checkbox  in the datatable header row")
	public void admin_should_see_the_checkbox_in_the_datatable_header_row() {
	   batchPage.checkHeaderCheckBox();
	}

	@Then("Admin should see the sort icon next to all Datatable headers")
	public void admin_should_see_the_sort_icon_next_to_all_datatable_headers() {
		batchPage.checkSortIcons();
	}
	@Given("Admin is on batch page")
	public void admin_is_on_batch_page() {
		 context.getbatchURL();
	}

	@Then("Admin should see sub menu in menu bar as {string}")
	public void admin_should_see_sub_menu_in_menu_bar_as(String addNewBtText) {
		batchPage.checkAddNewBatchBtn(addNewBtText);
	}

	@When("Admin clicks on {string} under the {string} menu bar")
	public void admin_clicks_on_under_the_menu_bar(String string, String string2) {
	   batchPage.clickAddNewBatchBtn();
	}

	@Then("Admin should see the Batch Details pop up window")
	public void admin_should_see_the_batch_details_pop_up_window() {
		batchPage.checkbatchDtlsPopup();
	}


}
