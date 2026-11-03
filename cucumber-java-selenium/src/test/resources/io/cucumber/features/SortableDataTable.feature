Feature: The Internet | Sortable Data Table

  This feature covers sortable data table handling on The Internet

  @TEST_TI_0001
  Scenario: Sortable Data Tables - Table 1 displays the expected 4 results
    Given the browser navigates to the base URL
    When the 'Sortable Data Tables' link is opened
    And header 'Data Tables' should be displayed
    Then table 1 should display below rows
      | Last Name | First Name | Email                 | Due     | Web Site                 |
	  | Smith     | John       | jsmith@gmail.com      | $50.00  | http://www.jsmith.com    |
	  | Bach      | Frank      | fbach@yahoo.com       | $51.00  | http://www.frank.com     |
	  | Doe       | Jason      | jdoe@hotmail.com      | $100.00 | http://www.jdoe.com      |
	  | Conway    | Tim        | tconway@earthlink.net | $50.00  | http://www.timconway.com |