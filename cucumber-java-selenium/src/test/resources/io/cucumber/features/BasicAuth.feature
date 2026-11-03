Feature: The Internet | Basic Auth

  This feature covers Basic Auth scenario on The Internet

  @TEST_TI_0001
  Scenario: Basic Auth allows validated access
    Given the browser navigates to the base URL
    When user 'admin' logged in 
    And header 'Basic Auth' should be displayed
    Then confirmation message on successful authentication should be displayed
