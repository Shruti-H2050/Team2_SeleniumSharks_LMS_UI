package stepDefinitions;

import driverSetup.TestContextSetup;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pageObjects.ClassPage;
import pageObjects.LoginPage;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

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
        context.launchUrl();
        loginPage.Login(context.getPropUsername(),context.getPropPassword());
        Thread.sleep(2000);
        System.out.println("Admin is on Dashboard page after logged in");
    }
    @When("Admin clicks the Class Navigation bar in the Header")
    public void admin_clicks_the_class_navigation_bar_in_the_header() {
        classPage.clickClassBtn();
    }

    @Then("Admin should land on the Manage class page")
    public void admin_should_land_on_the_manage_class_page() {
        classPage.manageClassTitleDisplay();
        assertTrue(classPage.manageClassTitleDisplay());
        System.out.println("Admin is on the Manage class page");
    }

    @Then("Admin should see the {string} Title")
    public void admin_should_see_the_title(String string) {
        classPage.isLmsTitleDisplayed();
        assertTrue(classPage.isLmsTitleDisplayed());
        System.out.println("Admin should see the LMS - Learning Management System Title");
    }

    @Then("Admin should see the {string} Header")
    public void admin_should_see_the_header(String string) {
        boolean isDisplayed = classPage.manageClassTitleDisplay();
        assertTrue(isDisplayed, "The Manage Class header is not displayed.");
        System.out.println("Admin should see the Manage Class Title");
    }

    @Then("Admin should see the Searchbar in Manage class page")
    public void admin_should_see_the_searchbar_in_manage_class_page() {
        boolean isDisplayed = classPage.isSearchTextBoxDisplayed();
        assertTrue(isDisplayed, "The search bar is not displayed on the Manage class page.");
        System.out.println("Admin should see the Searchbar in Manage class page");
    }

    @Then("Admin should see the datatable heading like Batchname, class topic, class description, status, class Date, staff name, Edit\\/Delete")
    public void admin_should_see_the_datatable_heading_like_batchname_class_topic_class_description_status_class_date_staff_name_edit_delete() {
        boolean areHeadersDisplayed = classPage.areHeadersDisplayed();
        assertTrue(areHeadersDisplayed, "The headers are not displayed on the Manage class page.");
        System.out.println("Headers are displayed on the Manage class page.");
    }


    @Then("Admin should see the {string} and enabled pagination controls under the data table")
    public void admin_should_see_the_and_enabled_pagination_controls_under_the_data_table(String string) {
    classPage.checkPagination();

    }

    @Then("Admin should see the Sort icon of all the fields in the datatable")
    public void admin_should_see_the_sort_icon_of_all_the_fields_in_the_datatable() {
        classPage.verifySortIcons();
    }


    @Then("Admin should see the {string} under the Manage class page header")
    public void admin_should_see_the_under_the_manage_class_page_header(String string) {
        classPage.checkDeleteIcon();
    }

    @Then("Admin should see the Total number of classes below the data table")
    public void admin_should_see_the_total_number_of_classes_below_the_data_table() {
        String totalClassesText = classPage.getTotalClassesText();
        assertTrue(totalClassesText.contains("Total there are 7 Classes"), "The total classes text is not displayed.");
        System.out.println("Admin should see the Total number of classes below the data table");
    }

 //***********ADD NEW CLASS STEPS**********

    @Given("Admin is on the Manage class page")
    public void admin_is_on_the_manage_class_page() {

    }
    @When("Admin clicka add new class under the class menu bar.")
    public void admin_clicka_add_new_class_under_the_class_menu_bar() {

        classPage.clickAddNewClassBtn();
    }

    @Then("Admin should see a popup open for class details with empty form along with <SAVE> and <CANCEL> button and Close\\(X) Icon on the top right corner of the window")
    public void admin_should_see_a_popup_open_for_class_details_with_empty_form_along_with_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window() {
        // Verify all form fields are empty
        assertTrue(classPage.isFieldEmpty("batch name"), "Batch Name field is not empty");
        assertTrue(classPage.isFieldEmpty("class topic"), "Class Topic field is not empty");
        assertTrue(classPage.isFieldEmpty("class description"), "Class Description field is not empty");
        assertTrue(classPage.isFieldEmpty("select class dates"), "Class Date field is not empty");
        assertTrue(classPage.isFieldEmpty("no of classes"), "No of Classes field is not empty");
        assertTrue(classPage.isFieldEmpty("staff name"), "Staff Name field is not empty");
        assertTrue(classPage.isFieldEmpty("comments"), "Comments field is not empty");
        assertTrue(classPage.isFieldEmpty("notes"), "Notes field is not empty");
        assertTrue(classPage.isFieldEmpty("recording"), "Recording field is not empty");

        // Verify the presence of SAVE and CANCEL buttons and Close (X) icon
        assertTrue(classPage.isButtonPresent("save"), "Save button is not present");
        assertTrue(classPage.isButtonPresent("cancel"), "Cancel button is not present");
        assertTrue(classPage.isButtonPresent("close"), "Close (X) icon is not present");
        //Verify the presence of radio buttons
        assertFalse(classPage.isRadioBtnSelected("active"), "Active radio button is not present");
        assertFalse(classPage.isRadioBtnSelected("inactive"), "Inactive radio button is not present");



    }
    @Then("Admin should see few input fields and their respective text boxes in the class details window")
    public void admin_should_see_few_input_fields_and_their_respective_text_boxes_in_the_class_details_window() {
        int expectedFieldCount = 9; // Replace with the actual expected count
        Assert.assertEquals(classPage.fieldCount(), expectedFieldCount, "The number of fields in the class details form does not match the expected count.");

    }

    //***************NEW CLASS POPUP WINDOW****************
    @Given("Admin is on the Class Popup window")
    public void admin_is_on_the_class_popup_window() {

    }

    @When("Admin selects class date in date picker")
    public void admin_selects_class_date_in_date_picker() {

    }

    @Then("Admin should see no of class value is added automatically")
    public void admin_should_see_no_of_class_value_is_added_automatically() {

    }

    @When("Admin clicks date picker")
    public void admin_clicks_date_picker() {

    }

    @Then("Admin should see weekends dates are disabled to select")
    public void admin_should_see_weekends_dates_are_disabled_to_select() {

    }

    @When("Admin skips to add value in mandatory field and enter only the optional field")
    public void admin_skips_to_add_value_in_mandatory_field_and_enter_only_the_optional_field() {

    }

    @Then("Admin should see error message below the test field and the field will be highlighed in red color")
    public void admin_should_see_error_message_below_the_test_field_and_the_field_will_be_highlighed_in_red_color() {

    }

    @When("Admin enters invalid data in all of the  fields in the form and clicks on save button")
    public void admin_enters_invalid_data_in_all_of_the_fields_in_the_form_and_clicks_on_save_button() {

    }

    @Then("Admin gets error message and class is not created")
    public void admin_gets_error_message_and_class_is_not_created() {

    }

    @When("Admin clicks on save button without entering data")
    public void admin_clicks_on_save_button_without_entering_data() {

    }

    @Then("class won't be created and Admin gets error message")
    public void class_won_t_be_created_and_admin_gets_error_message() {

    }

    @When("Admin clicks Cancel\\/Close\\(X) Icon on Admin Details form")
    public void admin_clicks_cancel_close_x_icon_on_admin_details_form() {

    }

    @Then("Class Details popup window should be closed without saving")
    public void class_details_popup_window_should_be_closed_without_saving() {

    }

    @When("Admin clicks save button")
    public void admin_clicks_save_button() {

    }

    @Then("Admin can see the class details popup closed and adding new class")
    public void admin_can_see_the_class_details_popup_closed_and_adding_new_class() {
       ;
    }

//    @Given("Admin is on the Manage Class page")
//    public void admin_is_on_the_manage_class_page() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
    //***********EDIT CLASS STEPS**********

    @When("Admin clicks on the edit icon")
    public void admin_clicks_on_the_edit_icon() {
        classPage.areEditIconsDisplayed();
    }

    @Then("A new pop up with class details appears")
    public void a_new_pop_up_with_class_details_appears() {
        classPage.isPopupDisplayed();
    }

    @Then("Admin should see the batch name field is disabled")
    public void admin_should_see_the_batch_name_field_is_disabled() {
      classPage.verifyBatchNameFieldDisabled();
    }

    @Then("Admin should see the class topic field is disabled")
    public void admin_should_see_the_class_topic_field_is_disabled() {
       classPage.verifyClassTopicFieldDisabled();
    }

    @Given("Admin is on the Edit Class Popup window")
    public void admin_is_on_the_edit_class_popup_window() {

    }

    @When("Update the fields with valid data and click save")
    public void update_the_fields_with_valid_data_and_click_save() {

    }

    @Then("Admin gets message {string} and see the updated values in data table")
    public void admin_gets_message_and_see_the_updated_values_in_data_table(String string) {

    }

    @When("Update the fields with invalid values and click save")
    public void update_the_fields_with_invalid_values_and_click_save() {

    }

    @Then("Admin should get Error message")
    public void admin_should_get_error_message() {

    }

    @When("Update the mandatory fields with valid values and click save")
    public void update_the_mandatory_fields_with_valid_values_and_click_save() {

    }

    @When("Update the optional fields with valid values and click save")
    public void update_the_optional_fields_with_valid_values_and_click_save() {

    }

    @When("Admin enters only numbers or special char in the text fields")
    public void admin_enters_only_numbers_or_special_char_in_the_text_fields() {

    }

    @When("Admin clicks Cancel button on edit popup")
    public void admin_clicks_cancel_button_on_edit_popup() {

    }

    @Then("Admin can see the class details popup disappears and can see nothing changed for particular Class")
    public void admin_can_see_the_class_details_popup_disappears_and_can_see_nothing_changed_for_particular_class() {

    }

    @When("Admin clicks on the Batchname sort icon")
    public void admin_clicks_on_the_batchname_sort_icon() {

    }

    @Then("Admin should see Class details are sorted by Batch Name")
    public void admin_should_see_class_details_are_sorted_by_batch_name() {

    }

    @When("Admin clicks on the Class Topic sort icon")
    public void admin_clicks_on_the_class_topic_sort_icon() {

    }

    @Then("Admin should see Class details are sorted by Class Topic")
    public void admin_should_see_class_details_are_sorted_by_class_topic() {

    }

    @When("Admin clicks on the Class Descreption")
    public void admin_clicks_on_the_class_descreption() {

    }

    @Then("Admin should see Class details are sorted by Class Descreption")
    public void admin_should_see_class_details_are_sorted_by_class_descreption() {

    }

    @When("Admin clicks on the Status sort icon")
    public void admin_clicks_on_the_status_sort_icon() {

    }

    @Then("Admin should see Class details are sorted by Status")
    public void admin_should_see_class_details_are_sorted_by_status() {

    }

    @When("Admin clicks on the Class Date sort icon")
    public void admin_clicks_on_the_class_date_sort_icon() {

    }

    @Then("Admin should see Class details are sorted by Class Date")
    public void admin_should_see_class_details_are_sorted_by_class_date() {

    }

    @When("Admin clicks on the Staff Name sort icon")
    public void admin_clicks_on_the_staff_name_sort_icon() {

    }

    @Then("Admin should see Class details are sorted by Staff Name")
    public void admin_should_see_class_details_are_sorted_by_staff_name() {

    }

//***********DELETE CLASS************


    @When("Admin clicks on the delete icon")
    public void admin_clicks_on_the_delete_icon() {

    }

    @Then("Admin should see a confirmation popup with <YES> and <NO> button")
    public void admin_should_see_a_confirmation_popup_with_yes_and_no_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("Admin is on Confirm Deletion alert")
    public void admin_is_on_confirm_deletion_alert() {

    }

    @When("Admin clicks yes option")
    public void admin_clicks_yes_option() {

    }

    @Then("Admin gets a message {string} alert and do not see that Class in the data table")
    public void admin_gets_a_message_alert_and_do_not_see_that_class_in_the_data_table(String string) {

    }

    @When("Admin clicks no option")
    public void admin_clicks_no_option() {

    }

    @Then("Admin can see the deletion alert disappears without deleting")
    public void admin_can_see_the_deletion_alert_disappears_without_deleting() {

    }

    @When("Admin clicks on close button")
    public void admin_clicks_on_close_button() {

    }

    @Then("Admin can see the deletion alert disappears without any changes")
    public void admin_can_see_the_deletion_alert_disappears_without_any_changes() {

    }

//**********************************DELETE MULTIPLE CLASS*****************************************

    @When("Admin clicks any checkbox in the data table")
    public void admin_clicks_any_checkbox_in_the_data_table() {

    }

    @Then("Admin should see common delete option enabled under header Manage class")
    public void admin_should_see_common_delete_option_enabled_under_header_manage_class() {

    }


    @When("Admin clicks <YES> button on the alert")
    public void admin_clicks_yes_button_on_the_alert() {

    }

    @When("Admin clicks <No> button on the alert")
    public void admin_clicks_no_button_on_the_alert() {

    }

    @Then("Admin should land on Manage class page and can see the selected class is deleted from the data table")
    public void admin_should_land_on_manage_class_page_and_can_see_the_selected_class_is_deleted_from_the_data_table() {

    }

    @Then("Admin should land on Manage class page and can see the selected class is not deleted from the data table")
    public void admin_should_land_on_manage_class_page_and_can_see_the_selected_class_is_not_deleted_from_the_data_table() {

    }

//**********************************SEARCH CLASS*****************************************

    @Then("Admin should see Class details are searched by Batch Name")
    public void admin_should_see_class_details_are_searched_by_batch_name() {

    }

    @When("Admin enter the Class Topic in search textbox")
    public void admin_enter_the_class_topic_in_search_textbox() {

    }

    @Then("Admin should see Class details are searched by Class Topic")
    public void admin_should_see_class_details_are_searched_by_class_topic() {

    }

    @When("Admin enter the Staff Name in search textbox")
    public void admin_enter_the_staff_name_in_search_textbox() {

    }

    @Then("Admin should see Class details are searched by Staff Name")
    public void admin_should_see_class_details_are_searched_by_staff_name() {

    }

//*************************PAGINATION*****************************************************

@When("Admin clicks {string} link on the class table")
public void admin_clicks_link_on_the_class_table(String page) {
    switch (page) {
        case "Next page":
            classPage.clickNextPage();
            break;
        case "Last page":
            classPage.clickLastPage();
            break;
        case "Previous page":
            classPage.clickPreviousPage();
            break;
        case "First page":
            classPage.clickFirstPage();
            break;
    }
}
    @Then("Admin should see the next page record on the table  with Pagination has next active link enabled")
    public void admin_should_see_the_next_page_record_on_the_table_with_pagination_has_next_active_link_enabled() {
        Assert.assertEquals(classPage.isNextPageActive(), true);
        System.out.println("Admin should see the next page record on the table  with Pagination has next active link enabled");
    }
    @Then("Admin should see the last page record on the table with Next page link are disabled")
    public void admin_should_see_the_last_page_record_on_the_table_with_next_page_link_are_disabled() {
        Assert.assertEquals(classPage.isNextPageActive(), false);
        System.out.println("Admin should see the last page record on the table with Next page link are disabled");
    }


    @Given("Admin is on last page of Manage class page")
    public void admin_is_on_last_page_of_manage_class_page() {
        classPage.clickLastPage();
    }

    @Then("Admin should see the previous page record on the table with previous page link")
    public void admin_should_see_the_previous_page_record_on_the_table_with_previous_page_link() {
        Assert.assertEquals(classPage.isPreviousPageActive(), false);
        System.out.println("Admin should see the previous page record on the table with previous page link");
    }

    @Then("Admin should see the first page record on the table with  Previous page link are disabled")
    public void admin_should_see_the_first_page_record_on_the_table_with_previous_page_link_are_disabled() {
        Assert.assertEquals(!classPage.isPreviousPageActive(), true);
        System.out.println("Admin should see the first page record on the table with  Previous page link are disabled");
    }




//****************************************NAVIGATION BAR*************************************************

    @When("Admin clicks on Class link on Manage Class page")
    public void admin_clicks_on_class_link_on_manage_class_page() {

    }

    @Then("Admin is re-directed to class page")
    public void admin_is_re_directed_to_class_page() {

    }

    @When("Admin clicks on any module link on Manage Class page")
    public void admin_clicks_on_any_module_link_on_manage_class_page() {

    }

    @Then("Admin is re-directed to which module link they clicked")
    public void admin_is_re_directed_to_which_module_link_they_clicked() {

    }

    @When("Logout link on navigation bar")
    public void logout_link_on_navigation_bar() {

    }

    @Then("Admin is re-directed to Login page")
    public void admin_is_re_directed_to_login_page() {

    }



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

	@Given("Admin is on the Edit Class Popup window")
	public void admin_is_on_the_edit_class_popup_window() {
		classPage.justClick();
		classPage.editDialog();
	}
	@When("Admin clicks Cancel button on edit popup")
	public void admin_clicks_cancel_button_on_edit_popup() {
	   
	}
	@Then("Admin can see the class details popup disappears and can see nothing changed for particular Class")
	public void admin_can_see_the_class_details_popup_disappears_and_can_see_nothing_changed_for_particular_class() {
	   
	}
	@When("Admin clicks on the edit icon")
	public void admin_clicks_on_the_edit_icon() {
		classPage.justClick();
		classPage.clickeditIcon();
	}
	@Then("A new pop up with class details appears")
	public void a_new_pop_up_with_class_details_appears() {
	   classPage.editDialog();
	}
	
	@Then("Admin should see the batch name field is disabled")
	public void admin_should_see_the_batch_name_field_is_disabled() {
		classPage.pgmFieldDisabledforediting();
	}
	
	@When("Update the fields with invalid values and click save")
	public void update_the_fields_with_invalid_values_and_click_save() {
	  
	}
	@Then("Admin should get Error message")
	public void admin_should_get_error_message() {
	    
	}
	
	@When("Update the mandatory fields with valid values and click save")
	public void update_the_mandatory_fields_with_valid_values_and_click_save() {
	    
	}
	
	
	@Then("Admin should see the class topic field is disabled")
	public void admin_should_see_the_class_topic_field_is_disabled() {
		classPage.classTopicFieldDisabledforediting();
	}
	
	@When("Update the optional fields with valid values and click save")
	public void update_the_optional_fields_with_valid_values_and_click_save() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@When("Update the fields with valid data and click save")
	public void update_the_fields_with_valid_data_and_click_save() {
		classPage.classDescField();
		classPage.classCmntsField();
		classPage.clickSave();
	}
	@Then("Admin gets message {string} and see the updated values in data table")
	public void admin_gets_message_and_see_the_updated_values_in_data_table(String string) {
	    
	}
	
	@When("Admin enters only numbers or special char in the text fields")
	public void admin_enters_only_numbers_or_special_char_in_the_text_fields() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
}

