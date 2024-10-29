@Team2_SeleniumSharks_LMS_UI
Feature: In Program module Navigation

  Background: 
    Given Admin is logged in to LMS Portal

  #------------------------ EDIT PROGRAM ----------------------------
  @EditProgram
  Scenario: Verify Edit option
    Given Admin is on Program module
    When Admin clicks on Edit option for particular program
    Then Admin lands on Program details form

  @EditProgram
  Scenario: Verify title of the pop up window
    Given Admin is on Program module
    When Admin clicks on Edit option for particular program
    Then Admin should see window title as Program Details

  @EditProgram
  Scenario: Verify mandatory fields with red ASTERISK mark
    Given Admin is on Program module
    When Admin clicks on Edit option for particular program
    Then Admin should see red ASTERISK mark beside mandatory field Name

  @EditProgram
  Scenario: Verify edit Program Name
    Given Admin is on Program module
    When Admin edits the program name and click on save button
    Then Updated program name is seen by the Admin

  @EditProgram
  Scenario: Verify edit Description
    Given Admin is on Program module
    When Admin edits the description text and click on save button
    Then Admin can see the description is updated

  @EditProgram
  Scenario: Verify edit Status
    Given Admin is on Program module
    When Admin can change the status of the program and click on save button
    Then Status updated can be viewed by the Admin

  @EditProgram
  Scenario: Verify Admin is able to click Cancel
    Given Admin is on Program module
    When Admin click on cancel button
    Then Admin can see the Program details form disappears

  @EditProgram
  Scenario: Verify edited Program details
    Given Admin is on Program module
    When Admin searches with newly updated Program Name
    Then Admin verifies that the details are correctly updated.

  @EditProgram
  Scenario: Verify close the window with X
    Given Admin is on Program module
    When Admin Click on X button
    Then Admin can see the Program details form disappears

  #--------------------------DELETE PROGRAM ---------------------------------------
  @DeleteProgram
  Scenario: Verify delete feature
    Given Admin is on Program module
    When Admin clicks on delete button for a program
    Then Admin will get confirm deletion popup

  @DeleteProgram
  Scenario: Verify Admin is able to click YES
    Given Admin is on Program module
    And Admin clicks on delete button for a program
    When Admin clicks on YES button
    Then Admin can see Successful Program Deleted message

  @DeleteProgram1
  Scenario: Verify Admin is able to search deleted program
    Given Admin is on Program module
    And Admin deletes a Program
    When Admin Searches for Deleted Program name
    Then There should be zero results.

  @DeleteProgram
  Scenario: Verify Admin is able to click NO
    Given Admin is on Program Confirm Deletion Page after selecting a program to delete
    When Admin clicks on NO button
    Then Admin can see the Program details form disappears
    
  @DeleteProgram
  Scenario: Verify Admin is able to close the window with X
    Given Admin is on Program Confirm Deletion Page after selecting a program to delete
    When Admin Click on X button of Confirm Delete window
    Then Admin can see the Program details form disappears

  @MultipleDelete
  Scenario: Verify Admin is able to select multiple programs
    Given Admin is on Program module
    When Admin selects more than one program by clicking on the checkbox
    Then Programs get selected

  @MultipleDelete
  Scenario: Verify Admin is able to delete Multiple programs
    Given Admin is on Program module
    And Admin selects more than one program by clicking on the checkbox
    When Admin clicks on the delete button on the left top of the program page
    Then Admin will get confirm deletion popup

  @MultipleDelete
  Scenario: Verify Admin is able to click YES
    Given Admin is on Program Confirm Deletion Page after selecting multiple program to delete
    When Admin clicks on YES button
    Then Admin can see Successful Program Deleted message

  @MultipleDelete
  Scenario: Verify Admin is able to deleted program
    Given Admin is on Program module
    When Admin Searches for Deleted Program names
    Then There should be zero results.

  @MultipleDelete
  Scenario: Verify Admin is able to click NO
    Given Admin is on Program Confirm Deletion Page after selecting multiple program to delete
    When Admin clicks on NO button
    Then Admin can see Programs are still selected and not deleted

  @MultipleDelete
  Scenario: Verify Admin is able to close the window with X
    Given Admin is on Program Confirm Deletion Page after selecting multiple program to delete
    When Admin Click on X button of Confirm Delete window
    Then Admin can see Confirm Deletion form disappear

  #------------------------------SEARCH PROGRAM--------------------------------------
  @Search
  Scenario: Verify Admin is able to search results found for program name
    Given Admin is on Program module
    And Admin creates a new Program with a name
    When Admin enter the program to search By program name
    Then Admin should able to see Program name Description and Status for searched program name

  @Search
  Scenario: Verify Admin is able to search results found for program description
    Given Admin is on Program module
    When Admin enter the program to search By program description
    Then Admin should able to see Program name Description and Status for searched program description

  @Search
  Scenario: Verify Admin is able to search results not found
    Given Admin is on Program module
    When Admin enter the program to search By program name that does not exist
    Then There should be zero results.

  @Search
  Scenario: Verify Admin is able to search with partial program name
    Given Admin is on Program module
    When Admin enter the program to search By partial name of program
    Then Admin should able to see partial Program name Description and Status for searched program name

  #------------------------------SORTING PROGRAM--------------------------------------
  @Sorting
  Scenario: Verify sorting of  Program name in Ascending order/Descending order
    Given Admin is on Program module
    When Admin clicks on Arrow next to program Name
    Then Admin See the Program Name is sorted in Ascending order/Descending order
		When Admin clicks on Arrow next to program Name
    Then Admin See the Program Name is sorted in Ascending order/Descending order
  
  @Sorting
  Scenario: Verify sorting of  Program Description in  Ascending order/Descending order
    Given Admin is on Program module
    When Admin clicks on Arrow next to Program Description
    Then Admin See the program Description is sorted in Ascending order/Descending order
		When Admin clicks on Arrow next to Program Description
    Then Admin See the program Description is sorted in Ascending order/Descending order
		
  @Sorting
  Scenario: Verify sorting of   Program status in Ascending order/Descending order
    Given Admin is on Program module
    When Admin clicks on Arrow next to Program status
    Then Use See the  Program Status is sorted in Ascending order/Descending order
		When Admin clicks on Arrow next to Program status
    Then Use See the  Program Status is sorted in Ascending order/Descending order

  #-----------------------------PAGINATION-------------------------------------
 	 @Pagination
  Scenario: Verify Admin is able to click Next page link
    Given Admin is on Program module
    When Admin clicks Next page link on the program table
    Then Admin should see the Pagination has NEXT active link

  @Pagination
  Scenario: Verify Admin is able to click Last page link
    Given Admin is on Program module
    When Admin clicks Last page link
    Then Admin should see the last page record on the table with Next page link are disabled

  @Pagination
  Scenario: Verify Admin is able to click Previous page link
    Given Admin is on last page of Program module table
    When Admin clicks Previous page link
    Then Admin should see the previous page record on the table with pagination has previous page link

  @Pagination
  Scenario: Verify Admin is able to click First page link
    Given Admin is on Previous Program page
    When Admin clicks First page link
    Then Admin should see the very first page record on the table with Previous page link are disabled

	@Pagination
  Scenario: Verify count of Programs displayed in Footer Message
    Given Admin is on Program module	
    Then Count of programs in footer should match total programs

  #-----------------------------------------------END------------------------------------------------------------------

