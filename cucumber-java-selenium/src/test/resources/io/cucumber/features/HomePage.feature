Feature: The Internet | Link Validation

  This feature covers validation of links on The Internet landing page

#This test is expected to fail due to mismatch on current examples on The Internet landing page versus 
#the list provided on the assessment instructions
   @TEST_TI_0001
  Scenario: Homepage has a list of links to Expected examples
    Given the browser navigates to the base URL
    And  header 'Welcome to the-internet' should be displayed
    Then source list should match the links on the page
