Feature: Search media releases
  Description: Test to be able to search media releases based on Ministers provided and reset filter

  @mediaReleases
  Scenario Outline: Search media releases by selecting ministers from the category and clearing filter
    Given User launches the website
    When User selects the "<Ministers>" from the accordion
    And User clicks on apply filters button
    And User verifies the item cards
    And User clicks on Clear all filters link
    Then User verifies that the filters are cleared

    Examples:
      | Ministers                 |
      | The Premier               |
      | Deputy Premier, Treasurer |
