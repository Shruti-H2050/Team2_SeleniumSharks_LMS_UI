package stepDefinitions;

import java.util.List;
import java.util.NoSuchElementException;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

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

	// ---------------@Navigation------Login-------------
	@Given("Admin is logged in to LMS Portal")
	public void admin_is_logged_in_to_lms_portal() {
		context.launchBrowser();
		context.launchLoginUrl();
		loginPage.Login(context.getPropUsername(), context.getPropPassword());
	}

	@Given("Admin is on dashboard page after Login")
	public void admin_is_on_dashboard_page_after_login() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Admin is on Dashboard page after logged in");
	}

	@When("Admin clicks Program on the navigation bar")
	public void admin_clicks_program_on_the_navigation_bar() {
		programPage.getProgramBtn().click();
	}

	@Then("Admin should be navigated to Program module")
	public void admin_should_be_navigated_to_program_module() {
		boolean manageProgramTitleDisplay = programPage.getManageProgramTitle().isDisplayed();
		System.out.println(
				"Admin is able to see Manage Program title which indicates admin is navigated to Program module: "
						+ manageProgramTitleDisplay);
		Assert.assertTrue(manageProgramTitleDisplay, "Admin is not able to navigated to Program module");
	}

	// ---------------------@MenuBar1-----broken link------------------
	@Then("Admin should not have any broken links for Program module")
	public void admin_should_not_have_any_broken_links_for_program_module() {
		System.out.println("Checked all links for the Program module");
		// Call the method to find and validate broken links
		programPage.findBrokenLinks(programPage.getProgramPageLinks());
	}

	// ---------------------@MenuBar2---------------------
	@Then("Admin should see the heading LMS - Learning Management System")
	public void admin_should_see_the_heading_lms_learning_management_system() {
		boolean manageProgramPageLmsTitleDisplay = programPage.getManageProgramPageLmsTitle().isDisplayed();
		System.out.println(
				"Admin is able to see heading LMS - Learning Management System: " + manageProgramPageLmsTitleDisplay);
		Assert.assertTrue(manageProgramPageLmsTitleDisplay,
				"Admin is not able to see the heading LMS - Learning Management System");
	}

	// ---------------------@MenuBar3---------------------
	@Then("Admin should see the module names as in order Program, Batch, Class, Logout")
	public void admin_should_see_the_module_names_as_in_order_program_batch_class_logout() {
		List<String> expectedOrderOfModuleNames = List.of("Program", "Batch", "Class", "Logout");
		System.out.println("expectedOrderOfModuleNames: " + expectedOrderOfModuleNames);
		List<String> currentOrderOfModuleNames = programPage.getListOfModuleBtnTexts();
		System.out.println("currentOrderOfModuleNames: " + currentOrderOfModuleNames);
		System.out.println("Admin is able to see the module names as in order Program, Batch, Class, Logout");
		Assert.assertEquals(currentOrderOfModuleNames, expectedOrderOfModuleNames,
				"The module names are not in the expected order.");
	}

	// ---------------------@MenuBar4---------------------
	@Then("Admin should see Logout in menu bar")
	public void admin_should_see_logout_in_menu_bar() {
		boolean logoutBtnDisplay = programPage.getLogoutBtn().isDisplayed();
		System.out.println("Admin is able to see Logout in menu bar: " + logoutBtnDisplay);
		Assert.assertTrue(logoutBtnDisplay, "Admin is not able to see Logout in menu bar");
	}

	// ---------------------@MenuBar5----------------------
	@Then("Admin should see sub menu in menu bar as Add New Program")
	public void admin_should_see_sub_menu_in_menu_bar_as_add_new_program() {
		boolean addNewProgramBtnDisplay = programPage.getAddNewProgramBtn().isDisplayed();
		System.out.println("Admin is able to see sub menu in menu bar as Add New Program: " + addNewProgramBtnDisplay);
		Assert.assertTrue(addNewProgramBtnDisplay,
				"Admin is not be able to see sub menu in menu bar as Add New Program");
	}

	// ----------------@ManageProgramPageValidation1-----------
	@Then("Admin should see the heading Manage Program")
	public void admin_should_see_the_heading_manage_program() {
		boolean manageProgramTitledisplay = programPage.getManageProgramTitle().isDisplayed();
		System.out.println("Admin is able to see the heading Manage Program: " + manageProgramTitledisplay);
		Assert.assertTrue(manageProgramTitledisplay, "Admin is not able to see the heading Manage Program");
	}

	// -----------------@ManageProgramPageValidation2-----------
	@Then("Admin should able to see Program name, description, and status for each program")
	public void admin_should_able_to_see_program_name_description_and_status_for_each_program() {
		programPage.getAddNewProgramBtn().click();
		System.out.println("Admin is able to see Program name, description, and status for each program: "
				+ programPage.programDetailsPopupDisplay());
		Assert.assertTrue(programPage.programDetailsPopupDisplay(),
				"Admin is not able to see Program name, description, and status for each program");
	}

	// -----------------@ManageProgramPageValidation3-----------
	@Then("Admin should see a Delete button in left top is disabled")
	public void admin_should_see_a_delete_button_in_left_top_is_disabled() {
		boolean disabledDeleteBtn = !programPage.getProgramPageDisabledDeleteBtn().isEnabled();
		System.out.println("Admin is able to see a Delete button in left top is disabled: " + disabledDeleteBtn);
		Assert.assertTrue(disabledDeleteBtn, "Admin is able to see a Delete button in left top is not disabled");
	}

	// -----------------@ManageProgramPageValidation4-----------
	@Then("Admin should see Search bar with text as {string}")
	public void admin_should_see_search_bar_with_text_as(String searchBoxWithtext) {
		String searchBoxDisplayedWithText = programPage.getSearchTextBox().getAttribute("placeholder");
		System.out.println("Search bar text displayed with: " + searchBoxDisplayedWithText);
		Assert.assertEquals(searchBoxDisplayedWithText, searchBoxWithtext,
				"Admin is not able to see Search bar with text as Search");
		System.out.println("Admin is able to see Search bar with text as Search");
	}

	// -----------------@ManageProgramPageValidation5-----------
	@Then("Admin should see data table with column header on the Manage Program Page as Program Name, Program Description, Program Status, Edit\\/Delete")
	public void admin_should_see_data_table_with_column_header_on_the_manage_program_page_as_program_name_program_description_program_status_edit_delete() {
		System.out.println(
				"Admin is able to see data table with column header on the Manage Program Page as Program Name, Program Description, Program Status, Edit/Delete: "
						+ programPage.ppdataTableHeaderDisplay());
		Assert.assertTrue(programPage.ppdataTableHeaderDisplay(),
				"Admin is not able to see data table with column header on the Manage Program Page as Program Name, Program Description, Program Status, Edit/Delete");
	}

	// -----------------@ManageProgramPageValidation6-----------
	@Then("Admin should see checkbox default state as unchecked beside Program Name column header as")
	public void admin_should_see_checkbox_default_state_as_unchecked_beside_program_name_column_header_as() {
		boolean ppDataTableheaderCheckBoxUnChecked = !programPage.getPpDataTableheaderCheckBox().isSelected();
		System.out
				.println("Admin is able to see checkbox default state as unchecked beside Program Name column header: "
						+ ppDataTableheaderCheckBoxUnChecked);
		Assert.assertTrue(ppDataTableheaderCheckBoxUnChecked,
				"Checkbox beside Program Name in header is checked, but it should be unchecked as default");
	}

	// -----------------@ManageProgramPageValidation7-----------
	@Then("Admin should see check box default state as unchecked on the left side in all rows against program name")
	public void admin_should_see_check_box_default_state_as_unchecked_on_the_left_side_in_all_rows_against_program_name() {
		System.out.println(
				"Admin is able to see check box default state as unchecked on the left side in all rows against program name: "
						+ programPage.ppRowCheckBoxUnchecked());
		Assert.assertTrue(programPage.ppRowCheckBoxUnchecked(),
				"Some checkboxes are checked, but it should be unchecked as default");
	}

	// -----------------@ManageProgramPageValidation8-----------
	@Then("Admin should see the sort arrow icon beside to each column header except Edit and Delete")
	public void admin_should_see_the_sort_arrow_icon_beside_to_each_column_header_except_edit_and_delete() {
		System.out.println(
				"Admin is able to see the sort arrow icon beside to each column header except Edit and Delete: "
						+ programPage.ppSortIconDispay());
		Assert.assertTrue(programPage.ppSortIconDispay(),
				"Admin is not able to see the sort arrow icon beside to each column header except Edit and Delete");
	}

	// -----------------@ManageProgramPageValidation9-----------
	@Then("Admin should see the Edit and Delete buttons on each row of the data table")
	public void admin_should_see_the_edit_and_delete_buttons_on_each_row_of_the_data_table() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Admin is able to see the Edit and Delete buttons on each row of the data table: "
				+ programPage.dataTableEditDeleteIconDisplay());
		Assert.assertTrue(programPage.dataTableEditDeleteIconDisplay(),
				"Admin is not able to see the Edit and Delete buttons on each row of the data table");
	}

	// ----------------@ManageProgramPageValidation10-------------------------
	@Then("Admin should see the text as Showing x to y of z entries along with Pagination icon below the table. x- starting record number on that page, y-ending record number on that page, z-Total number of records")
	public void admin_should_see_the_text_as_showing_x_to_y_of_z_entries_along_with_pagination_icon_below_the_table_x_starting_record_number_on_that_page_y_ending_record_number_on_that_page_z_total_number_of_records() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		boolean paginationBarTextDisplay = programPage.getPaginationBar().isDisplayed();
		String paginationBarText = programPage.getPaginationBar().getText();
		System.out.println("Pagination bar text: " + paginationBarText);
		System.out.println(
				"Admin is able to see the text as Showing x to y of z entries along with Pagination icon below the table: "
						+ paginationBarTextDisplay);
		Assert.assertTrue(paginationBarTextDisplay,
				"Admin is not able to see the text as Showing x to y of z entries along with Pagination icon below the table");
	}

	// -----------------@ManageProgramPageValidation11-----------
	@Then("Admin should see the footer as In total there are z programs. z- Total number of records")
	public void admin_should_see_the_footer_as_in_total_there_are_z_programs_z_total_number_of_records() {
		programPage.justClick();
		programPage.waitForElementVisibility(programPage.getFooterText());
		boolean ppFooterTextDisplay = programPage.footerValidation("program");
		System.out.println("Admin is able to see the footer as In total there are z programs: " + ppFooterTextDisplay);
		Assert.assertTrue(ppFooterTextDisplay, "Admin is not able to see the footer as In total there are z programs");
	}

	// -----------------@MenuBarProgramAddNewProgram1-------------
	@Given("Admin is on program module after reaching dashboard")
	public void admin_is_on_program_module_after_reaching_dashboard() {
		context.launchBrowser();
		context.launchLoginUrl();
		loginPage.Login(context.getPropUsername(), context.getPropPassword());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		programPage.getProgramBtn().click();
		System.out.println("Admin is on program module after reaching dashboard");
	}

	@Given("Admin is on Program module")
	public void admin_is_on_program_module() {
		System.out.println("Admin is on program module");
	}

	@When("Admin clicks on New Program under the Program menu bar")
	public void admin_clicks_on_new_program_under_the_program_menu_bar() {
		programPage.getAddNewProgramBtn().click();
	}

	@Then("Admin should see pop up window for program details")
	public void admin_should_see_pop_up_window_for_program_details() {

	}

	// ---------------@MenuBarProgramAddNewProgram2-------------
	@Then("Admin should see window title as Program Details")
	public void admin_should_see_window_title_as_program_details() {
		boolean programDetailsPopupDisplay = programPage.getProgramDetailsTitle().isDisplayed();
		System.out.println("Admin is able to see window title as Program Details: " + programDetailsPopupDisplay);
		Assert.assertTrue(programDetailsPopupDisplay, "Admin is not able to see window title as Program Details");
	}

	// ---------------@MenuBarProgramAddNewProgram3-------------
	@Then("Admin should see red star mark beside mandatory field Name")
	public void admin_should_see_red_star_mark_beside_mandatory_field_name() {
		boolean programNameRedStarDisplay = programPage.getProgramDetailsNameRedStar().isDisplayed();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(
				"Admin is able to see red star mark beside mandatory field Name: " + programNameRedStarDisplay);
		Assert.assertTrue(programNameRedStarDisplay,
				"Admin is not able to see red star mark beside mandatory field Name");
	}

	// ---------------@MenuBarProgramAddNewProgram4-------------
	@Given("Admin is on Program details form")
	public void admin_is_on_program_details_form() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		programPage.getAddNewProgramBtn().click();
		System.out.println("Admin is on Program details form");
	}

	@When("Admin clicks save button without entering mandatory")
	public void admin_clicks_save_button_without_entering_mandatory() {
		programPage.getProgramDetailsSaveBtn().click();
	}

	@Then("Admin gets message field is required")
	public void admin_gets_message_field_is_required() {
		boolean fieldTextdisplay = programPage.programDetailsRedFieldTextDisplay();
		System.out.println("Admin gets message field is required: " + fieldTextdisplay);
		Assert.assertTrue(fieldTextdisplay, "Admin is not getting any message field is required");
	}

	// ---------------@MenuBarProgramAddNewProgram5-------------
	@When("Admin clicks Cancel button")
	public void admin_clicks_cancel_button() {
		programPage.getProgramDetailsCancelButton().click();
	}

	@Then("Admin can see Program Details form disappears")
	public void admin_can_see_program_details_form_disappears() {
		System.out.println("Admin can see Program Details form disappear");// + disappearProgramDetailsPopup);
	}

	// ---------------@MenuBarProgramAddNewProgram6-------------
	@When("Admin enters the Name in the text box")
	public void admin_enters_the_name_in_the_text_box() {
		programPage.getProgramdetailsNameBox().sendKeys("pDName");
	}

	@Then("Admin can see the text entered")
	public void admin_can_see_the_text_entered() {
		System.out.println("Attribute value which Admin entered in Name box: "
				+ programPage.getProgramdetailsNameBox().getAttribute("ng-reflect-model"));
		boolean nameBoxText = !programPage.getProgramdetailsNameBox().getAttribute("ng-reflect-model").isBlank();
		System.out.println("Admin can see the text entered: " + nameBoxText);
		Assert.assertTrue(nameBoxText, "Admin can see the text is not entered");
	}

	// ---------------@MenuBarProgramAddNewProgram7-------------
	@When("Admin enters the Description in text box")
	public void admin_enters_the_description_in_text_box() {
		programPage.getProgramdetailsDescriptionBox().sendKeys("pDDescription");
	}

	@Then("Admin can see the text entered in description box")
	public void admin_can_see_the_text_entered_in_description_box() {
		System.out.println("Attribute value which Admin entered in Description box: "
				+ programPage.getProgramdetailsDescriptionBox().getAttribute("ng-reflect-model"));
		boolean descriptionBoxText = !programPage.getProgramdetailsDescriptionBox().getAttribute("ng-reflect-model")
				.isBlank();
		System.out.println("Admin can see the text entered in description box: " + descriptionBoxText);
		Assert.assertTrue(descriptionBoxText, "Admin can see the text is not entered in description box");
	}

	// ---------------@MenuBarProgramAddNewProgram8-------------
	@When("Admin selects the status of the program by clicking on the radio button Active\\/InActive")
	public void admin_selects_the_status_of_the_program_by_clicking_on_the_radio_button_active_in_active() {
		programPage.getActiveRadioButton().click();
	}

	@Then("Admin can see Active\\/Inactive status selected")
	public void admin_can_see_active_inactive_status_selected() {
		String radioBtnValue = programPage.getActiveRadioButton().getAttribute("ng-reflect-input-id");
		System.out.println("Attribute value to check Status radio button: " + radioBtnValue);
		Assert.assertEquals(radioBtnValue, "Active", "Admin can see the status radio button is not selected any");
	}

	// ---------------@MenuBarProgramAddNewProgram9-------------
	@When("Admin enter valid details for mandatory fields {string},{string},{string} and Click on save button")
	public void admin_enter_valid_details_for_mandatory_fields_and_click_on_save_button(String pName, String pDesc,
			String pStatus) {
		programPage.getProgramdetailsNameBox().sendKeys(pName);
		programPage.getProgramdetailsDescriptionBox().sendKeys(pDesc);
		String activeBtnText = programPage.getActiveRadioButton().getText();
		if (activeBtnText.equalsIgnoreCase(pStatus)) {
			programPage.getActiveRadioButton().click();
		} else {
			programPage.getInactiveRadioButton().click();
		}
		programPage.getProgramDetailsSaveBtn().click();
	}

	@Then("Admin gets message {string}")
	public void admin_gets_message(String msg) {
		programPage.justClick();
		programPage.waitForElementVisibility(programPage.getProgramPageMessage());

		SoftAssert softAssert = new SoftAssert();

		try {
			boolean messageDisplay = programPage.getProgramPageMessage().isDisplayed();
			System.out.println("Admin gets message successful Program created: " + messageDisplay);
			softAssert.assertTrue(messageDisplay, "Success message should be displayed");
		} catch (NoSuchElementException e) {
			softAssert.fail("Success message not found: " + e.getMessage());
		}
		softAssert.assertAll();
	}

	@When("Admin Click on cancel button")
	public void admin_click_on_cancel_button() {

	}

	@Then("Admin can see program details form disappear")
	public void admin_can_see_program_details_form_disappear() {

	}

	@When("Admin searches with newly created Program Name")
	public void admin_searches_with_newly_created_program_name() {

	}

	@Then("Records of the newly created Program Name is displayed and match the data entered")
	public void records_of_the_newly_created_program_name_is_displayed_and_match_the_data_entered() {

	}

	@When("Admin Click on Cross button")
	public void admin_click_on_cross_button() {

	}

}
