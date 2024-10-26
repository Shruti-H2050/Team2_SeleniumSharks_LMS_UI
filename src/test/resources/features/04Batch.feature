Feature: Batch Page Navigation 

Background: 
Given Admin is logged in to LMS Portal

@batchNavigation
Scenario: Verify Admin Navigate to Batch page successfully
Given Admin is on the Dashboard Page
When Admin Clicks on the Batch menu from the header
Then Admin should be in the Manage Batch Page

Scenario: Validate "Title" in Batch Page
Given Admin is on the Dashboard Page
When Admin Clicks on the Batch menu from the header
Then Admin should see the "LMS-Learning Management System" Title

Scenario: Validate "heading" in the Batch Page
Given Admin is on the Dashboard Page
When Admin Clicks on the Batch menu from the header
Then Admin should see the "Manage Batch" Heading

Scenario: Validate disabled "Delete Icon" under the header in the Batch Page
Given Admin is on the Dashboard Page
When Admin Clicks on the Batch menu from the header
Then Admin should see the disabled "Delete Icon" under the header

#Scenario: Validate pagination in the Batch Page
#Given Admin is on the Dashboard Page
#When Admin Clicks on the Batch menu from the header
#Then Admin should see the enabled pagination controls under the data table

#Scenario: Validate edit icon in each data rows
#Given Admin is on the Dashboard Page
#When Admin Clicks on the Batch menu from the header
#Then Admin should see the edit icon in each row

#Scenario: validate delete icon in each data rows
#Given Admin is on the Dashboard Page
#When Admin Clicks on the Batch menu from the header
#Then Admin should see the delete icon in each row

#Scenario: Validate Datatable headers
#Given Admin is on the Dashboard Page
#When Admin Clicks on the Batch menu from the header
#Then Admin should see the datatable headers Batch name, Batch Description,Batch Status, No Of classes, Program Name, Edit/Delete

#Scenario: Validate "Checkbox" in the Datatable header row
#Given Admin is on the Dashboard Page
#When Admin Clicks on the Batch menu from the header
#Then Admin should see the checkbox  in the datatable header row

#Scenario: Validate "sort icon" next to all the datatable header
#Given Admin is on the Dashboard Page
#When Admin Clicks on the Batch menu from the header
#Then Admin should see the sort icon next to all Datatable headers

##########################ADD NEW BATCH FEATURE#######################################
@addNewBtach1
Scenario: Verify sub menu displayed in batch menu bar
Given Admin is on batch page
When Admin Clicks on the Batch menu from the header 
Then Admin should see sub menu in menu bar as "Add New Batch"
@addNewBtach2
Scenario: Validate Admin able to click on the Add new Batch Option
Given Admin is on the Dashboard Page
When Admin clicks on "Add New batch" under the "batch" menu bar
Then Admin should see the Batch Details pop up window