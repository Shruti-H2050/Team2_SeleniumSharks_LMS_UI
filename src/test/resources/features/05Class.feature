Feature: Class Page Validation

  Background: Admin logged on the Dashboard page
    Given Admin is on the dashboard page after login
    When Admin clicks the Class Navigation bar in the Header
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

