@Team2_SeleniumSharks_LMS_UI
Feature: In Program module Navigation

  Background: 
    Given Admin is logged in to LMS Portal

  @Navigation
  Scenario: Verify that Admin is able to navigate to Program module
    Given Admin is on dashboard page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should be navigated to Program module

  #Scenario: Verify after login Admin lands on dashboard page
  #Given Admin is in loginPage
  #When Admin enter valid credentials and clicks login button
  #Then Admin should see dashboard
  
  @SortingProgramName
  Scenario: Verify sorting of  Program name in Ascending order/Descending order
    Given Admin is on Program module
    When Admin clicks on Arrow next to program Name
    Then Admin See the Program Name is sorted in Ascending order/Descending order
		When Admin clicks on Arrow next to program Name
    Then Admin See the Program Name is sorted in Ascending order/Descending order
		
  @SortingProgramDescription
  Scenario: Verify sorting of  Program Description in  Ascending order/Descending order
    Given Admin is on Program module
    When Admin clicks on Arrow next to Program Description
    Then Admin See the program Description is sorted in Ascending order/Descending order
		When Admin clicks on Arrow next to Program Description
    Then Admin See the program Description is sorted in Ascending order/Descending order
		
  @SortingProgramstatus
  Scenario: Verify sorting of   Program status in Ascending order/Descending order
    Given Admin is on Program module
    When Admin clicks on Arrow next to Program status
    Then Use See the  Program Status is sorted in Ascending order/Descending order
		When Admin clicks on Arrow next to Program status
    Then Use See the  Program Status is sorted in Ascending order/Descending order
		