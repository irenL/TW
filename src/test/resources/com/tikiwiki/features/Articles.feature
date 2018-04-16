#Iryna Liakhovych
@article @ft
Feature: Create And Delete New Articles

  @createArt  
  Scenario Outline: Create Article
    Given I login to TikiWiki
    When I click to Articles menu
    And I see the menu options for Articles:
      | Articles Home |
      | List Articles |
      | New Article   |
      | Admin Topics  |
      | Admin Types   |
    And I click on the New Articles
    Then I type in Title input field "<title_text>"
    And I type in Heading input field "<heading_text>"
    And I type in Body input field " <body_text>"
    Then I click on button save
    And I should see new Article for "<title_text>"
    And I logout from TikiWiki

    Examples: 
      | title_text          | heading_text    | body_text                 |
      | Favorite Recipe     | Tiramisu        | Tiramisu Recipe           |
      | Todays News         | World           | Easter Sunday Celebrating |
      | This Day In History | History Stories | Oldest Human Footprints   |

  @searchArt @smoke 
  Scenario Outline: Search Article
    Given I login to TikiWiki
    When I click to Articles menu
    And I see the menu options for Articles:
      | Articles Home |
      | List Articles |
      | New Article   |
      | Admin Topics  |
      | Admin Types   |
    And I click on the New Articles
    Then I type in Title input field "<title_text>"
    Then I click on button save
     And I should see new Article for "<title_text>"
    When I click to Articles menu
    And I click on the List Articles
    Then I type in search input field "<search_text>"
    And I should see in table of Article list only articles that contains "<search_text>"
    And I logout from TikiWiki

    Examples: 
      | search_text         | title_text          |
      | This Day In History | This Day In History |
