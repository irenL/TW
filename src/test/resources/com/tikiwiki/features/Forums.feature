#Author: ilyas
@forums
Feature: Create and Delete Forums

  @create_forums @ft @smoke
  Scenario Outline: Creating new forums by reading from the tables
    Given I login to TikiWiki
    When I click to Forums menu
    And I see the menu options for Forums:
      | List Forums  |
      | Admin Forums |
    And I am creating new forums with "<Name>" and "<Description>"
    And I must be able to see "<Name>" in the forums list table
    Then I logout from TikiWiki

    Examples: 
      | Name       | Description |
      | ForumTiki1 | Desc1       |
      | ForumTiki2 | Desc2       |

  @delete_forums @ft
  Scenario Outline: Deleting forums from the
    Given I login to TikiWiki
    When I click to Forums menu
    And I see the menu options for Forums:
      | List Forums  |
      | Admin Forums |
    When I delete "<Name>"forums
    Then I verify "<Name>"s are not in the List
    Then I logout from TikiWiki

    Examples: 
      | Name       |
      | ForumTiki1 |
