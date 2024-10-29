@Team2_SeleniumSharks_LMS_UI
Feature: In Program module Navigation

  @Navigation
  Scenario: Verify that Admin is able to navigate to Program module
    Given Admin is logged in to LMS Portal
    And Admin is on dashboard page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should be navigated to Program module

  @MenuBar1
  Scenario: Verify any broken links on program page
    Given Admin is logged in to LMS Portal
    And Admin is on dashboard page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should not have any broken links for Program module

  @MenuBar2
  Scenario: Verify heading in menu bar
    Given Admin is logged in to LMS Portal
    And Admin is on dashboard page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see the heading LMS - Learning Management System

  @MenuBar3
  Scenario: Verify other modules name displayed in menu bar
    Given Admin is logged in to LMS Portal
    And Admin is on dashboard page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see the module names as in order Program, Batch, Class, Logout

  @MenuBar4
  Scenario: Verify Logout displayed in menu bar
    Given Admin is logged in to LMS Portal
    And Admin is on dashboard page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see Logout in menu bar

  @MenuBar5
  Scenario: Verify sub menu displayed in program menu bar
    Given Admin is logged in to LMS Portal
    And Admin is on dashboard page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see sub menu in menu bar as Add New Program

  @ManageProgramPageValidation1
  Scenario: Verify heading in manage program
    Given Admin is logged in to LMS Portal
    And Admin is on dashboard page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see the heading Manage Program

  @ManageProgramPageValidation2
  Scenario: Verify view details of programs
    Given Admin is logged in to LMS Portal
    And Admin is on dashboard page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should able to see Program name, description, and status for each program

  @ManageProgramPageValidation3
  Scenario: Verify the Multiple Delete button state
    Given Admin is logged in to LMS Portal
    And Admin is on dashboard page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see a Delete button in left top is disabled

  @ManageProgramPageValidation4
  Scenario: Verify the Search button
    Given Admin is logged in to LMS Portal
    And Admin is on dashboard page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see Search bar with text as "Search..."

  @ManageProgramPageValidation5
  Scenario: Verify column header name of data table
    Given Admin is logged in to LMS Portal
    And Admin is on dashboard page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see data table with column header on the Manage Program Page as Program Name, Program Description, Program Status, Edit/Delete

  @ManageProgramPageValidation6
  Scenario: Verify checkbox default state beside Program Name column header
    Given Admin is logged in to LMS Portal
    And Admin is on dashboard page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see checkbox default state as unchecked beside Program Name column header as

  @ManageProgramPageValidation7
  Scenario: Verify checkboxes default state beside each Program names in the data table
    Given Admin is logged in to LMS Portal
    And Admin is on dashboard page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see check box default state as unchecked on the left side in all rows against program name

  @ManageProgramPageValidation8
  Scenario: Verify Sort icon in manage program
    Given Admin is logged in to LMS Portal
    And Admin is on dashboard page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see the sort arrow icon beside to each column header except Edit and Delete

  @ManageProgramPageValidation9
  Scenario: Verify edit and delete icon in manage program
    Given Admin is logged in to LMS Portal
    And Admin is on dashboard page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see the Edit and Delete buttons on each row of the data table

  @ManageProgramPageValidation10
  Scenario: Verify pagination icons below data table in manage program
    Given Admin is logged in to LMS Portal
    And Admin is on dashboard page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see the text as Showing x to y of z entries along with Pagination icon below the table. x- starting record number on that page, y-ending record number on that page, z-Total number of records

  @ManageProgramPageValidation11
  Scenario: Verify footer message in manage program
    Given Admin is logged in to LMS Portal
    And Admin is on dashboard page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see the footer as In total there are z programs. z- Total number of records

  @MenuBarProgramAddNewProgram1
  Scenario: Verify title of the pop up window
    Given Admin is on program module after reaching dashboard
    And Admin is on Program module
    When Admin clicks on New Program under the Program menu bar
    Then Admin should see window title as Program Details

  @MenuBarProgramAddNewProgram2
  Scenario: Verify mandatory fields with red "*" mark
    Given Admin is on program module after reaching dashboard
    And Admin is on Program module
    When Admin clicks on New Program under the Program menu bar
    Then Admin should see red star mark beside mandatory field Name

  @MenuBarProgramAddNewProgram3
  Scenario: Verify empty form submission
    Given Admin is on program module after reaching dashboard
    And Admin is on Program details form
    When Admin clicks save button without entering mandatory
    Then Admin gets message field is required

  @MenuBarProgramAddNewProgram4
  Scenario: Verify cancel button
    Given Admin is on program module after reaching dashboard
    And Admin is on Program details form
    When Admin clicks Cancel button
    Then Admin can see Program Details form disappears

  @MenuBarProgramAddNewProgram5
  Scenario: Verify enter program name
    Given Admin is on program module after reaching dashboard
    And Admin is on Program details form
    When Admin enters the Name in the text box
    Then Admin can see the text entered

  @MenuBarProgramAddNewProgram6
  Scenario: Verify enter description
    Given Admin is on program module after reaching dashboard
    And Admin is on Program details form
    When Admin enters the Description in text box
    Then Admin can see the text entered in description box

  @MenuBarProgramAddNewProgram7
  Scenario: Verify select Status
    Given Admin is on program module after reaching dashboard
    And Admin is on Program details form
    When Admin selects the status of the program by clicking on the radio button Active/InActive
    Then Admin can see Active/Inactive status selected

  @MenuBarProgramAddNewProgram8
  Scenario Outline: Verify Admin is able to save the program details
    Given Admin is on program module after reaching dashboard
    And Admin is on Program details form
    When Admin enter valid details for mandatory fields <ProgramName>,<ProgramDescription>,<ProgramStatus> and Click on save button
    Then Admin gets message <Message>

    Examples: 
      | ProgramName        | ProgramDescription | ProgramStatus | Message      |
      | "proDetailsNameU"  | "proDetails Desc"  | "Active"      | "Successful" |
      | "proDetailsNameV"  | "proDetails Desc"  | "Inactive"    | "Successful" |
      | "proDetailsName6 " | "proDetails Desc"  | "Active"      | "Failed"     |
      | "proDetailsName6 " | "proDetails Desc"  | "Inactive"    | "Failed"     |

  @MenuBarProgramAddNewProgram9
  Scenario: Verify cancel program details
    Given Admin is on program module after reaching dashboard
    And Admin is on Program details form
    When Admin clicks Cancel button
    Then Admin can see program details form disappear

  @MenuBarProgramAddNewProgram10
  Scenario: Verify added Program is created
    Given Admin is on program module after reaching dashboard
    And Admin is on Program module
    When Admin searches with newly created Program Name
    Then Records of the newly created Program Name is displayed and match the data entered

  @MenuBarProgramAddNewProgram11
  Scenario: Verify close window with "X"
    Given Admin is on program module after reaching dashboard
    And Admin is on Program details form
    When Admin Click on Cross button
    Then Admin can see program details form disappear

  #------------------------ EDIT PROGRAM ----------------------------
  @EditProgram
  Scenario: Verify Edit option
    Given Admin is logged in to LMS Portal
    And Admin is on Program module
    When Admin clicks on Edit option for particular program
    Then Admin lands on Program details form

  @EditProgram
  Scenario: Verify title of the pop up window
    Given Admin is logged in to LMS Portal
    And Admin is on Program module
    When Admin clicks on Edit option for particular program
    Then Admin should see window title as Program Details

  @EditProgram
  Scenario: Verify mandatory fields with red ASTERISK mark
    Given Admin is logged in to LMS Portal
    And Admin is on Program module
    When Admin clicks on Edit option for particular program
    Then Admin should see red ASTERISK mark beside mandatory field Name

  @EditProgram
  Scenario: Verify edit Program Name
    Given Admin is logged in to LMS Portal
    And Admin is on Program module
    When Admin edits the program name and click on save button
    Then Updated program name is seen by the Admin

  @EditProgram
  Scenario: Verify edit Description
    Given Admin is logged in to LMS Portal
    And Admin is on Program module
    When Admin edits the description text and click on save button
    Then Admin can see the description is updated

  @EditProgram
  Scenario: Verify edit Status
    Given Admin is logged in to LMS Portal
    And Admin is on Program module
    When Admin can change the status of the program and click on save button
    Then Status updated can be viewed by the Admin

  @EditProgram
  Scenario: Verify Admin is able to click Cancel
    Given Admin is logged in to LMS Portal
    And Admin is on Program module
    When Admin click on cancel button
    Then Admin can see the Program details form disappear

  @EditProgram
  Scenario: Verify edited Program details
    Given Admin is logged in to LMS Portal
    And Admin is on Program module
    When Admin searches with newly updated Program Name
    Then Admin verifies that the details are correctly updated.

  @EditProgram
  Scenario: Verify close the window with X
    Given Admin is logged in to LMS Portal
    And Admin is on Program module
    When Admin Click on X button
    Then Admin can see the Program details form disappear

  #--------------------------DELETE PROGRAM ---------------------------------------
  @DeleteProgram
  Scenario: Verify delete feature
    Given Admin is logged in to LMS Portal
    And Admin is on Program module
    When Admin clicks on delete button for a program
    Then Admin will get confirm deletion popup

  @DeleteProgram
  Scenario: Verify Admin is able to click YES
    Given Admin is logged in to LMS Portal
    And Admin is on Program module
    And Admin clicks on delete button for a program
    When Admin clicks on YES button
    Then Admin can see Successful Program Deleted message

  @DeleteProgram1
  Scenario: Verify Admin is able to search deleted program
    Given Admin is logged in to LMS Portal
    And Admin is on Program module
    And Admin deletes a Program
    When Admin Searches for Deleted Program name
    Then There should be zero results.

  @DeleteProgram
  Scenario: Verify Admin is able to click NO
    Given Admin is logged in to LMS Portal
    And Admin is on Program Confirm Deletion Page after selecting a program to delete
    When Admin clicks on NO button
    Then Admin can see the Program details form disappear

  @DeleteProgram
  Scenario: Verify Admin is able to close the window with X
    Given Admin is logged in to LMS Portal
    And Admin is on Program Confirm Deletion Page after selecting a program to delete
    When Admin Click on X button of Confirm Delete window
    Then Admin can see the Program details form disappear

  @MultipleDelete
  Scenario: Verify Admin is able to select multiple programs
    Given Admin is logged in to LMS Portal
    And Admin is on Program module
    When Admin selects more than one program by clicking on the checkbox
    Then Programs get selected

  @MultipleDelete
  Scenario: Verify Admin is able to delete Multiple programs
    Given Admin is logged in to LMS Portal
    And Admin is on Program module
    And Admin selects more than one program by clicking on the checkbox
    When Admin clicks on the delete button on the left top of the program page
    Then Admin will get confirm deletion popup

  @MultipleDelete
  Scenario: Verify Admin is able to click YES
    Given Admin is logged in to LMS Portal
    And Admin is on Program Confirm Deletion Page after selecting multiple program to delete
    When Admin clicks on YES button
    Then Admin can see Successful Program Deleted message

  @MultipleDelete
  Scenario: Verify Admin is able to deleted program
    Given Admin is logged in to LMS Portal
    And Admin is on Program module
    When Admin Searches for Deleted Program names
    Then There should be zero results.

  @MultipleDelete
  Scenario: Verify Admin is able to click NO
    Given Admin is logged in to LMS Portal
    And Admin is on Program Confirm Deletion Page after selecting multiple program to delete
    When Admin clicks on NO button
    Then Admin can see Programs are still selected and not deleted

  @MultipleDelete
  Scenario: Verify Admin is able to close the window with X
    Given Admin is logged in to LMS Portal
    And Admin is on Program Confirm Deletion Page after selecting multiple program to delete
    When Admin Click on X button of Confirm Delete window
    Then Admin can see Confirm Deletion form disappear

  #------------------------------SEARCH PROGRAM--------------------------------------
  @Search
  Scenario: Verify Admin is able to search results found for program name
    Given Admin is logged in to LMS Portal
    And Admin is on Program module
    And Admin creates a new Program with a name
    When Admin enter the program to search By program name
    Then Admin should able to see Program name Description and Status for searched program name

  @Search
  Scenario: Verify Admin is able to search results found for program description
    Given Admin is logged in to LMS Portal
    And Admin is on Program module
    When Admin enter the program to search By program description
    Then Admin should able to see Program name Description and Status for searched program description

  @Search
  Scenario: Verify Admin is able to search results not found
    Given Admin is logged in to LMS Portal
    And Admin is on Program module
    When Admin enter the program to search By program name that does not exist
    Then There should be zero results.

  @Search
  Scenario: Verify Admin is able to search with partial program name
    Given Admin is logged in to LMS Portal
    And Admin is on Program module
    When Admin enter the program to search By partial name of program
    Then Admin should able to see partial Program name Description and Status for searched program name

  #------------------------------SORTING PROGRAM--------------------------------------
  @Sorting
  Scenario: Verify sorting of  Program name in Ascending order/Descending order
    Given Admin is logged in to LMS Portal
    And Admin is on Program module
    When Admin clicks on Arrow next to program Name
    Then Admin See the Program Name is sorted in Ascending order/Descending order
    When Admin clicks on Arrow next to program Name
    Then Admin See the Program Name is sorted in Ascending order/Descending order

  @Sorting
  Scenario: Verify sorting of  Program Description in  Ascending order/Descending order
    Given Admin is logged in to LMS Portal
    And Admin is on Program module
    When Admin clicks on Arrow next to Program Description
    Then Admin See the program Description is sorted in Ascending order/Descending order
    When Admin clicks on Arrow next to Program Description
    Then Admin See the program Description is sorted in Ascending order/Descending order

  @Sorting
  Scenario: Verify sorting of   Program status in Ascending order/Descending order
    Given Admin is logged in to LMS Portal
    And Admin is on Program module
    When Admin clicks on Arrow next to Program status
    Then Use See the  Program Status is sorted in Ascending order/Descending order
    When Admin clicks on Arrow next to Program status
    Then Use See the  Program Status is sorted in Ascending order/Descending order

  #-----------------------------PAGINATION-------------------------------------
  @Pagination
  Scenario: Verify Admin is able to click Next page link
    Given Admin is logged in to LMS Portal
    And Admin is on Program module
    When Admin clicks Next page link on the program table
    Then Admin should see the Pagination has NEXT active link

  @Pagination
  Scenario: Verify Admin is able to click Last page link
    Given Admin is logged in to LMS Portal
    And Admin is on Program module
    When Admin clicks Last page link
    Then Admin should see the last page record on the table with Next page link are disabled

  @Pagination
  Scenario: Verify Admin is able to click Previous page link
    Given Admin is logged in to LMS Portal
    And Admin is on last page of Program module table
    When Admin clicks Previous page link
    Then Admin should see the previous page record on the table with pagination has previous page link

  @Pagination
  Scenario: Verify Admin is able to click First page link
    Given Admin is logged in to LMS Portal
    And Admin is on Previous Program page
    When Admin clicks First page link
    Then Admin should see the very first page record on the table with Previous page link are disabled

  @Pagination
  Scenario: Verify count of Programs displayed in Footer Message
    Given Admin is logged in to LMS Portal
    And Admin is on Program module
    Then Count of programs in footer should match total programs
  #-----------------------------------------------END------------------------------------------------------------------

