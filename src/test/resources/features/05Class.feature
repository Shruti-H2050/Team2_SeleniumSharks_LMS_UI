Feature: Class Page Validation

  Background: Admin logged on the Dashboard page
    Given Admin is on the dashboard page after login
    When Admin clicks the Class Navigation bar in the Header


  Scenario: Validating the class manage page
    Then Admin should land on the Manage class page

  Scenario: Validating the Title in the Manage class page
    Then Admin should see the "LMS-Learning Management System" Title

  Scenario: Validating the Header in the Manage class page
    Then Admin should see the "Manage Class" Header

  Scenario: Validating Search bar in class page
    Then Admin should see the Searchbar in Manage class page

  Scenario: Validating the data table headers in the class page
    Then Admin should see the datatable heading like Batchname, class topic, class description, status, class Date, staff name, Edit/Delete

  Scenario: Validating the text and pagination icon in the class page
    Then Admin should see the "showing x to y of z entries" and enabled pagination controls under the data table

  Scenario: Validate the sort icon of all the fields in the datatable
    Then Admin should see the Sort icon of all the fields in the datatable

  Scenario: Validating the Delete button under the Manage class
    Then Admin should see the "Delete button" under the Manage class page header

  Scenario: Validate the total number of classes in the manage class page
    Then Admin should see the Total number of classes below the data table

  #***********ADD NEW CLASS**********

@AddNewClass1
 Scenario: Validate Class Details Popup window
  Given Admin is on the Manage class page
  When Admin clicka add new class under the class menu bar.
  Then Admin should see a popup open for class details with empty form along with <SAVE> and <CANCEL> button and Close(X) Icon on the top right corner of the window
@AddNewClass2
 Scenario:Validate input fields and their text boxes in Class details form
  Given Admin is on the Manage class page
  When Admin clicka add new class under the class menu bar.
  Then Admin should see few input fields and their respective text boxes in the class details window

  #*********** NEW CLASS POPUP WINDOW **********

  @NewClassPopup1
 Scenario: Check if class is created when only mandatory fields are entered with valid data
    Given Admin is on the Class Popup window
    When Admin enters mandatory fields in the form and clicks on save button
    Then Admin gets message Class added Successfully

  @NewClassPopup2
  Scenario:Check no classes value added when selecting class dates
  Given Admin is on the Class Popup window
  When Admin selects class date in date picker
  Then Admin should see no of class value is added automatically

  @NewClassPopup3
  Scenario:Check weekend dates are disabled in calender
  Given Admin is on the Class Popup window
  When Admin clicks date picker
  Then Admin should see weekends dates are disabled to select

  @NewClassPopup4
  Scenario:Check if class is created when only optional fields are entered with valid data
    Given Admin is on the Class Popup window
    When Admin skips to add value in mandatory field and enter only the optional field
    Then Admin should see error message below the test field and the field will be highlighed in red color

  @NewClassPopup5
  Scenario:check if class is created when invalid data is entered in all of the fields
    Given Admin is on the Class Popup window
    When Admin enters invalid data in all of the  fields in the form and clicks on save button
    Then Admin gets error message and class is not created

  @NewClassPopup6
  Scenario:Empty form submission
    Given Admin is on the Class Popup window
    When Admin clicks on save button without entering data
    Then class won't be created and Admin gets error message

  @NewClassPopup7
  Scenario:Validate Cancel/Close(X) icon on class Details form
    Given Admin is on the Class Popup window
    When Admin clicks Cancel/Close(X) Icon on Admin Details form
    Then Class Details popup window should be closed without saving

  @NewClassPopup8
  Scenario:Validate Save button on class Details form
    Given Admin is on the Class Popup window
    When Admin clicks save button
    Then Admin can see the class details popup closed and adding new class

   #***********EDIT CLASS**********
  @EditClass1
  Scenario:Validate row level edit icon
   When Admin clicks on the edit icon
   Then A new pop up with class details appears

  @EditClass2
  Scenario:Check disabled  batch name
  When Admin clicks on the edit icon
  Then Admin should see the batch name field is disabled

  @EditClass3
  Scenario:Check disabled class topic
  When Admin clicks on the edit icon
  Then Admin should see the class topic field is disabled

    @EditClass4
  Scenario:Check if the fields are updated with valid data
  Given Admin is on the Edit Class Popup window
  When Update the fields with valid data and click save
  Then Admin gets message "class details updated Successfully " and see the updated values in data table

  @EditClass5
  Scenario:Check if the fields are updated with invalid values
  Given Admin is on the Edit Class Popup window
  When Update the fields with invalid values and click save
  Then Admin should get Error message

  @EditClass6
  Scenario:Check if the mandatory fields are updated with valid data
 Given Admin is on the Edit Class Popup window
 When  Update the mandatory fields with valid values and click save
 Then  Admin gets message "Class details updated Successfully " and see the updated values in data table

 @EditClass7
  Scenario:Check if the optional fields are updated with valid data
  Given Admin is on the Edit Class Popup window
  When Update the optional fields with valid values and click save
  Then Admin gets message "Class details updated Successfully " and see the updated values in data table

  @EditClass8
  Scenario:Validate invalid values in the text fields
 Given Admin is on the Edit Class Popup window
 When Admin enters only numbers or special char in the text fields
 Then Admin should get Error message

  @EditClass9
  Scenario:Validate Cancel button on Edit popup
  Given Admin is on the Edit Class Popup window
  When Admin clicks Cancel button on edit popup
  Then Admin can see the class details popup disappears and can see nothing changed for particular Class

#***********SORT CLASS************
@SortClass1
Scenario: Sort Class by Batch name
Given Admin is on the Manage Class page
When Admin clicks on the Batchname sort icon
Then Admin should see Class details are sorted by Batch Name

@SortClass2
Scenario: Sort Class by Class Topic
Given Admin is on the Manage Class page
When Admin clicks on the Class Topic sort icon
Then Admin should see Class details are sorted by Class Topic

@SortClass3
Scenario: Sort Class by Class Descreption
Given Admin is on the Manage Class page
When Admin clicks on the Class Descreption
Then Admin should see Class details are sorted by Class Descreption

@SortClass4
Scenario:Sort Class by Status
Given Admin is on the Manage Class page
When Admin clicks on the Status sort icon
Then Admin should see Class details are sorted by Status

@SortClass5
Scenario: Sort Class by Class Date
Given Admin is on the Manage Class page
When Admin clicks on the Class Date sort icon
Then Admin should see Class details are sorted by Class Date

@SortClass6
Scenario: Sort Class by Staff Name
Given Admin is on the Manage Class page
When Admin clicks on the Staff Name sort icon
Then Admin should see Class details are sorted by Staff Name


#**********************SEARCH BOX******************
@SearchBox1
Scenario: Search class by Batch Name
Given  Admin is on the Manage class page
When Admin enter the Batch Name in search textbox
Then Admin should see Class details are searched by Batch Name

@SearchBox2
Scenario: Search class by Class Topic
 Given Admin is on the Manage class page
 When Admin enter the Class Topic in search textbox
 Then Admin should see Class details are searched by Class Topic

@SearchBox3
Scenario: Search class by Staff Name
Given Admin is on the Manage class page
When Admin enter the Staff Name in search textbox
Then Admin should see Class details are searched by Staff Name

#**********************PAGINATION******************
@Pagination1
Scenario: Verify Next page link(>)
When Admin clicks "Next page" link on the class table
Then Admin should see the next page record on the table  with Pagination has next active link enabled

@Pagination2
Scenario: Verify Last page link(>>)
When Admin clicks "Last page" link on the class table
Then Admin should see the last page record on the table with Next page link are disabled

@Pagination3
Scenario: Verify Admin is able to click 'Previous page' link
  Given Admin is on last page of Manage class page
  When Admin clicks "Previous page" link on the class table
  Then Admin should see the previous page record on the table with previous page link

  @Pagination4
Scenario: Verify Admin is able to click First page link
Given Admin is on last page of Manage class page
When Admin clicks "First page" link on the class table
Then Admin should see the first page record on the table with  Previous page link are disabled

#**********************NAVIGATION BAR******************
@NavigationValidation1
Scenario: Class link on navigation bar
Given Admin is on Manage Class page
When Admin clicks on Class link on Manage Class page
Then Admin is re-directed to class page

@NavigationValidation2
Scenario: Class link to other module on navigation bar
Given Admin is on Manage Class page
When Admin clicks on any module link on Manage Class page
Then Admin is re-directed to which module link they clicked

@NavigationValidation3
Scenario:Logout link on navigation bar
Given Admin is on Manage Class page
When Logout link on navigation bar
Then Admin is re-directed to Login page

#  #***********DELETE CLASS************
@DeleteClass1
Scenario: Validate row level delete icon
 Given Admin is on the Manage Class page
 When Admin clicks on the delete icon
 Then Admin should see a confirmation popup with <YES> and <NO> button

 @DeleteClass2
Scenario: Click Yes on deletion window
 Given Admin is on Confirm Deletion alert
 When Admin clicks yes option
 Then Admin gets a message "Successful Class Deleted" alert and do not see that Class in the data table

 @DeleteClass3
 Scenario: Click No on deletion window
 Given Admin is on Confirm Deletion alert
 When Admin clicks no option
 Then Admin can see the deletion alert disappears without deleting

 @DeleteClass4
Scenario: Validate Close(X) icon on Confirm Deletion alert
 Given Admin is on Confirm Deletion alert
 When Admin clicks on close button
 Then Admin can see the deletion alert disappears without any changes

#***********DELETE MULTIPLE CLASS************
 @DeleteMultipleClass1
  Scenario:Validate Common Delete button enabled after clicking on any checkbox
 Given  Admin is on the Manage Class page
 When Admin clicks any checkbox in the data table
 Then Admin should see common delete option enabled under header Manage class

  @DeleteMultipleClass2
  Scenario: Validate multiple class deletion by selecting Single checkbox
Given Admin is on Confirm Deletion alert
When Admin clicks <YES> button on the alert
Then Admin should land on Manage class page and can see the selected class is not deleted from the data table

@DeleteMultipleClass3
 Scenario: Validate multiple class deletion by selecting multiple check boxes
Given Admin is on Confirm Deletion alert
  When Admin clicks <No> button on the alert
  Then Admin should land on Manage class page and can see the selected class is not deleted from the data table


