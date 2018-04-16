#Iryna Liakhovych
@wikipage
Feature: Create And Delete New Wiki pages

  @createWP @ft
  Scenario Outline: Create page
    Given I login to TikiWiki
    When I click to Wiki menu
    And I see the menu options for Wiki:
      | Wiki Home          |
      | Last Changes       |
      | List Pages         |
      | Create a Wiki Page |
      | Structures         |
    And I click on the Create a Wiki Page
    Then I type in the input field "<page_name>"
    And I click on Create Page
    Then I type to Input field "<page_text>" text:
    And I click on save button
    Then I should see new page for "<page_name>"
    And I logout from TikiWiki

    Examples: 
      | page_name       | page_text            |
      | DefecTeam_Page1 | Welcome To Our Page1 |
      | DefecTeam Page2 | Welcome To Our Page2 |

  @deleteWP @smoke @ft
  Scenario Outline: Delete New Created Page
    Given I login to TikiWiki
    When I click to Wiki menu
    And I see the menu options for Wiki:
      | Wiki Home          |
      | Last Changes       |
      | List Pages         |
      | Create a Wiki Page |
      | Structures         |
    And I click on the Create a Wiki Page
    Then I type in the input field "<page_name>"
    And I click on Create Page
    And I click on save button
    When I click to Wiki menu
    And I click on List Pages
    Then I will see table of list pages
    And I find new created page "<page_name>" from list pages
    Then I delete "<page_name>"
    And I check if "<page_name>" was deleted from table of list pages
    And I logout from TikiWiki

    Examples: 
      | page_name         |
      | DefecTeam_NewPage |
