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
	
