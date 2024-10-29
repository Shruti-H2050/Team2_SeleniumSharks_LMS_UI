package stepDefinitions;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import driverSetup.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import pageObjects.ProgramPage;

public class Program2_steps {

	private TestContextSetup context;
	private LoginPage loginPage;
	private ProgramPage programPage;
	private String nameCheck;

	public Program2_steps(TestContextSetup context) {
		this.context = context;
		this.programPage = context.getProgramPage();
		this.loginPage = context.getLoginPage();
	}

//	@Given("Admin is logged in to LMS Portal")
//	public void admin_is_logged_in_to_lms_portal() {
//		context.launchBrowser();
//		context.launchUrl();
//		loginPage.Login(context.getPropUsername(), context.getPropPassword());
//	}

//	@When("Admin clicks Program on the navigation bar")
//	public void admin_clicks_program_on_the_navigation_bar() {
//		programPage.clickProgramBtn();
//	}

//	@Then("Admin should be navigated to Program module")
//	public void admin_should_be_navigated_to_program_module() {
//		boolean status = programPage.manageProgramTitleDisplay();
//		Assert.assertTrue(status);
//	}

//	@Given("Admin is on Program module")
//	public void admin_is_on_program_module() {
//		programPage.clickProgramBtn();
//	}

	@When("Admin clicks on Edit option for particular program")
	public void admin_clicks_on_edit_option_for_particular_program() {
		programPage.justClick();
		programPage.clickEditIcon();
	}

	@Then("Admin lands on Program details form")
	public void admin_lands_on_program_details_form() {
		Assert.assertTrue(programPage.programDetailsTitleDisplay(), "Program details page is not displayed...");
	}

	@Then("Admin should see window title as Program Details")
	public void admin_should_see_window_title_as_program_details() {
		Assert.assertTrue(programPage.programDetailsTitleDisplay(),
				"Window title of Program Details pop-up is Incorrect");
	}

	@Then("Admin should see red ASTERISK mark beside mandatory field Name")
	public void admin_should_see_red_mark_beside_mandatory_field_name() {
		Assert.assertTrue(programPage.programDetailsNameAsteriskDisplay(), "Asterisk symbol is not displayed...");
	}

	@When("Admin edits the program name and click on save button")
	public void admin_edits_the_program_name_and_click_on_save_button() {
		programPage.justClick();
		programPage.clickEditIcon();
		programPage.enterProgramName("Edited Program Name");
		programPage.programDetailsSaveClick();
	}

	@Then("Updated program name is seen by the Admin")
	public void updated_program_name_is_seen_by_the_admin() {
		Assert.assertEquals(programPage.row1ProgramName(), "Edited Program Name", "Program name is not Updated....");
	}

	@When("Admin edits the description text and click on save button")
	public void admin_edits_the_description_text_and_click_on_save_button() {
		programPage.justClick();
		programPage.clickEditIcon();
		programPage.enterProgramDescription("Edited Description");
		programPage.programDetailsSaveClick();
	}

	@Then("Admin can see the description is updated")
	public void admin_can_see_the_description_is_updated() {
		Assert.assertEquals(programPage.row1ProgramDescription(), "Edited Description", "Description is not updated..");
	}

	@When("Admin can change the status of the program and click on save button")
	public void admin_can_change_the_status_of_the_program_and_click_on_save_button() {
		programPage.justClick();
		programPage.clickEditIcon();
		programPage.clickInactiveRadoBtn();
		programPage.programDetailsSaveClick();
	}

	@Then("Status updated can be viewed by the Admin")
	public void status_updated_can_be_viewed_by_the_admin() {
		Assert.assertEquals(programPage.row1ProgramStatus(), "Inactive", "Status is not updated....");
	}

	@When("Admin click on cancel button")
	public void admin_click_on_cancel_button() throws InterruptedException {
		programPage.justClick();
		programPage.clickEditIcon();
		programPage.clickCancel();
	}

	@Then("Admin can see the Program details form disappear")
	public void admin_can_see_the_program_details_form_disappears() {
		Assert.assertTrue(programPage.manageProgramTitleDisplay(), "Program Details form is not Closed....");
	}

	@When("Admin searches with newly updated Program Name")
	public void admin_searches_with_newly_updated_program_name() throws InterruptedException {
		programPage.justClick();
		programPage.clickEditIcon();
		programPage.enterProgramName("searchdata");
		programPage.programDetailsSaveClick();
		programPage.searchProgramDetails("searchdata");
	}

	@Then("Admin verifies that the details are correctly updated.")
	public void admin_verifies_that_the_details_are_correctly_updated() {
		Assert.assertEquals(programPage.row1ProgramName(), "search data", "Modified data is not updated.....");
	}

	@When("Admin Click on X button")
	public void admin_click_on_x_button() {
		programPage.justClick();
		programPage.clickEditIcon();
		programPage.click_X_CloseIcon();
	}

	@When("Admin clicks on delete button for a program")
	public void admin_clicks_on_delete_button_for_a_program() {
		programPage.justClick();
		programPage.clickDeleteIcon();
	}

	@Then("Admin will get confirm deletion popup")
	public void admin_will_get_confirm_deletion_popup() {
		Assert.assertTrue(programPage.confirmDeletePageTitleDisplay(), "Confirm Delete Page did not pop-up...");
	}

	@When("Admin clicks on YES button")
	public void admin_clicks_on_yes_button() {
		programPage.clickConfirmDeleteYESBtn();
	}

	@Then("Admin can see Successful Program Deleted message")
	public void admin_can_see_successful_program_deleted_message() {
		Assert.assertTrue(programPage.deleteSuccessfulMsgDisplay(),
				"Successful Program Deleted message did not pop-up....");
	}

	@Given("Admin deletes a Program")
	public void admin_deletes_a_program() {
		programPage.addNewProgram("VSVSDelete", "VSVSDelete");
		programPage.deleteProgram("VSDelete");
	}

	@When("Admin Searches for Deleted Program name")
	public void admin_searches_for_deleted_program_name() {
		programPage.searchProgramDetails("VSVSDelete");
	}

	@Then("There should be zero results.")
	public void there_should_be_zero_results() throws InterruptedException {
		Assert.assertTrue(programPage.NoProgDisplayOnSearch(), "The program is not deleted.....");
	}

	@Given("Admin is on Program Confirm Deletion Page after selecting a program to delete")
	public void admin_is_on_program_confirm_deletion_page_after_selecting_a_program_to_delete()
			throws InterruptedException {
		programPage.clickProgramBtn();
		programPage.addNewProgram("VSSVProg", "VSSVProg");
		programPage.searchProgramDetails("VSSVProg");
		programPage.clickDeleteIcon();
	}

	@When("Admin clicks on NO button")
	public void admin_clicks_on_no_button() {
		programPage.clickConfirmDeleteNOBtn();
	}

	@When("Admin Click on X button of Confirm Delete window")
	public void admin_click_on_x_button_of_confirm_delete_window() {
		programPage.clickIconXConfirmDeletePage();
	}

	@When("Admin selects more than one program by clicking on the checkbox")
	public void admin_selects_more_than_one_program_by_clicking_on_the_checkbox() {
		programPage.justClick();
		// -----To Select Top 3 Boxes----
		for (int i = 1; i <= 2; i++) {
			programPage.clickMultipleCheckBoxesOfProgramTable(i);
		}
	}

	@Then("Programs get selected")
	public void programs_get_selected() {
		for (int i = 1; i <= 2; i++) {
			boolean checked = programPage.checkBoxesSelectedStatus(i);
			Assert.assertTrue(checked);
		}
	}

	@When("Admin clicks on the delete button on the left top of the program page")
	public void admin_clicks_on_the_delete_button_on_the_left_top_of_the_program_page() {
		programPage.clickTopLeftDeleteIcon();
	}

	@Given("Admin is on Program Confirm Deletion Page after selecting multiple program to delete")
	public void admin_is_on_program_confirm_deletion_page_after_selecting_multiple_program_to_delete() {
		programPage.clickProgramBtn();
		programPage.justClick();
		// -------------To Select Top 3 Check Boxes-----------------
		for (int i = 1; i <= 3; i++) {
			programPage.clickMultipleCheckBoxesOfProgramTable(i);
		}
		programPage.clickTopLeftDeleteIcon();
	}

	@Then("Admin can see Programs are still selected and not deleted")
	public void admin_can_see_programs_are_still_selected_and_not_deleted() {
		for (int i = 1; i <= 3; i++) {
			boolean checked = programPage.checkBoxesSelectedStatus(i);
			Assert.assertTrue(checked);
		}
	}

	@Then("Admin can see Confirm Deletion form disappear")
	public void admin_can_see_confirm_deletion_form_disappear() {
		Assert.assertTrue(programPage.manageProgramTitleDisplay(), "Confirm delete pop-up is not Closed....");
	}

	@When("Admin Searches for Deleted Program names")
	public void admin_searches_for_deleted_program_names() {
		programPage.justClick();
		programPage.searchProgramDetails("ProgramVJDelete");
	}

	@When("Admin enter the program to search By program name")
	public void admin_enter_the_program_to_search_by_program_name() {
		programPage.justClick();
		programPage.searchProgramDetails(nameCheck);
	}

	@When("Admin clicks Next page link on the program table")
	public void admin_clicks_next_page_link_on_the_program_table() {
		programPage.justClick();
		programPage.clickSingleRightArrowPagination();
	}

	@Then("Admin should see the Pagination has NEXT active link")
	public void admin_should_see_the_pagination_has_next_active_link() {
		Assert.assertTrue(programPage.SingleRightArrowEnabled(), "The NEXT link is NOT Enabled......");
	}

	@When("Admin clicks Last page link")
	public void admin_clicks_last_page_link() throws InterruptedException {
		programPage.justClick();
		Thread.sleep(3000);
		programPage.clickDoubleRightArrowPagination();
	}

	@Then("Admin should see the last page record on the table with Next page link are disabled")
	public void admin_should_see_the_last_page_record_on_the_table_with_next_page_link_are_disabled() {
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(programPage.SingleRightArrowEnabled(), false, "The NEXT link is NOT Disabled......");
		sa.assertEquals(programPage.doubleRightArrowEnabled(), false, "The LAST PAGE link is NOT Disabled......");
		sa.assertTrue(programPage.currentPageValidation("last"),
				"The Right Double Arrow Link DOES NOT takes to last page of Program Webtable..");
		sa.assertAll();
	}

	@Given("Admin is on last page of Program module table")
	public void admin_is_on_last_page_of_program_module_table() throws InterruptedException {
		programPage.clickProgramBtn();
		programPage.justClick();
		Thread.sleep(3000);
		programPage.clickDoubleRightArrowPagination();
		Thread.sleep(3000);
	}

	@When("Admin clicks Previous page link")
	public void admin_clicks_previous_page_link() throws InterruptedException {
		programPage.clickSingleLeftArrowPagination();
		Thread.sleep(3000);
	}

	@Then("Admin should see the previous page record on the table with pagination has previous page link")
	public void admin_should_see_the_previous_page_record_on_the_table_with_pagination_has_previous_page_link() {
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(programPage.SingleLeftArrowEnabled(), true, "The PREVIOUS link NOT Enabled........");
		sa.assertEquals(programPage.doubleLeftArrowEnabled(), true, "The LEFT DOUBLE ARROW link is NOT Enabled......");
		sa.assertTrue(programPage.currentPageValidation("priorLast"),
				"We are NOT at page PRIOR to last page of Program Webtable..");
		sa.assertAll();
	}

	@Given("Admin is on Previous Program page")
	public void admin_is_on_previous_program_page() throws InterruptedException {
		programPage.clickProgramBtn();
		programPage.justClick();
		Thread.sleep(3000);
		programPage.clickDoubleRightArrowPagination();
		Thread.sleep(3000);
		programPage.clickSingleLeftArrowPagination();
	}

	@When("Admin clicks First page link")
	public void admin_clicks_first_page_link() {
		programPage.clickDoubleLeftArrowPagination();
	}

	@Then("Admin should see the very first page record on the table with Previous page link are disabled")
	public void admin_should_see_the_very_first_page_record_on_the_table_with_previous_page_link_are_disabled() {
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(programPage.SingleLeftArrowEnabled(), false, "The PREVIOUS link is NOT Disabled........");
		sa.assertEquals(programPage.doubleLeftArrowEnabled(), false,
				"The LEFT DOUBLE ARROW link is NOT Disabled......");
		sa.assertTrue(programPage.currentPageValidation("first"), "We are NOT at FIRST page of Program Webtable..");
		sa.assertAll();
	}

	@Then("Count of programs in footer should match total programs")
	public void count_of_programs_in_footer_should_match_total_programs() throws InterruptedException {
		programPage.justClick();
		Assert.assertTrue(programPage.paginationValidation(),
				"Number of programs displayed on Footer message is INCORRECT");
	}

	@When("Admin clicks on Arrow next to program Name")
	public void admin_clicks_on_arrow_next_to_program_name() {
		programPage.justClick();
		programPage.sortProgramName.click();
	}

	@Then("Admin See the Program Name is sorted in Ascending order\\/Descending order")
	public void admin_see_the_program_name_is_sorted_in_ascending_order_descending_order() {

		Assert.assertTrue(programPage.sortProgramName(),
				"Program Name is not sorted Ascending order\\/Descending order");
	}

	@When("Admin clicks on Arrow next to Program Description")
	public void admin_clicks_on_arrow_next_to_program_description() {
		programPage.justClick();
		programPage.programDesHeader.click();

	}

	@Then("Admin See the program Description is sorted in Ascending order\\/Descending order")
	public void admin_see_the_program_description_is_sorted_in_ascending_order_descending_order() {
		Assert.assertTrue(programPage.sortProgramDesc(),
				"Program Description is not sorted Ascending order\\/Descending order");
	}

	@When("Admin clicks on Arrow next to Program status")
	public void admin_clicks_on_arrow_next_to_program_status() {
		programPage.justClick();
		programPage.programStatusHeader.click();
	}

	@Then("Use See the  Program Status is sorted in Ascending order\\/Descending order")
	public void use_see_the_program_status_is_sorted_in_ascending_order_descending_order() {
		Assert.assertTrue(programPage.sortProgramStatus(),
				"Program Status is not sorted Ascending order\\/Descending order");
	}

	@Given("Admin creates a new Program with a name")
	public void admin_creates_a_new_program_with_a_name() {
		nameCheck = RandomStringUtils.randomAlphabetic(7);
		programPage.addNewProgram(nameCheck, "Description");
	}

	@Then("Admin should able to see Program name Description and Status for searched program name")
	public void admin_should_able_to_see_program_name_description_and_status_for_searched_program_name()
			throws InterruptedException {
		Thread.sleep(3000);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(programPage.row1ProgramName(), nameCheck, "Program Name is not matching");
		sa.assertEquals(programPage.row1ProgramDescription().isEmpty(), false);
		sa.assertEquals(programPage.row1ProgramStatus().isEmpty(), false);
		sa.assertAll();
	}

	@When("Admin enter the program to search By program description")
	public void admin_enter_the_program_to_search_by_program_description() {
		programPage.justClick();
		programPage.searchProgramDetails("description");
	}

	@Then("Admin should able to see Program name Description and Status for searched program description")
	public void admin_should_able_to_see_program_name_description_and_status_for_searched_program_description() throws InterruptedException {
		Thread.sleep(3000);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(programPage.row1ProgramDescription(), "description", "Program Description is not matching");
		sa.assertEquals(programPage.row1ProgramName().isEmpty(), false);
		sa.assertEquals(programPage.row1ProgramStatus().isEmpty(), false);
		sa.assertAll();
	}
	
	@When("Admin enter the program to search By program name that does not exist")
	public void admin_enter_the_program_to_search_by_program_name_that_does_not_exist() {
		programPage.justClick();
		programPage.searchProgramDetails("kdjfhdjkdhf");
	}
	
	@When("Admin enter the program to search By partial name of program")
	public void admin_enter_the_program_to_search_by_partial_name_of_program() {
		programPage.justClick();
		programPage.searchProgramDetails("TeamTwo");
	}
	
	@Then("Admin should able to see partial Program name Description and Status for searched program name")
	public void admin_should_able_to_see_partial_program_name_description_and_status_for_searched_program_name() throws InterruptedException {
		Thread.sleep(1000);
		SoftAssert sa = new SoftAssert();
		String ProgName = programPage.row1ProgramName();
		String partialName = ProgName.substring(0,7);
		sa.assertEquals(partialName, "TeamTwo","Program Name is not matching");
		sa.assertEquals(programPage.row1ProgramDescription().isEmpty(), false);
		sa.assertEquals(programPage.row1ProgramStatus().isEmpty(), false);
		sa.assertAll();
	}


}