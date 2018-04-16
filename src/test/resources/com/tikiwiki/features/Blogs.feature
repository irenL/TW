#Author: ilyas

@blogs
Feature: Create and Delete Blogs
 

  @create_blogs
  Scenario Outline: Creating new blogs
    Given I login to TikiWiki
    When I click to Blogs menu
    And I see the menu options for Blogs:
      |List Blogs |
      |Create Blog|
      |New Blog Post|
      |List Blog Posts|
        
    And I am creating new blogs with "<Title>" and "<Description>"
    Then I must be able to see "<Title>" in the blog list table
    Then I logout from TikiWiki
Examples:
|Title ||Description|
|Blog1 ||BlogDescription1|
|Blog2 ||BlogDescription2|
       
      @delete_blogs
  Scenario Outline: Deleting blogs from the list 
    Given I login to TikiWiki
		When I click to Blogs menu
    And I see the menu options for Blogs:
      |List Blogs |
      |Create Blog|
      |New Blog Post|
      |List Blog Posts|
    When I delete "<Title>" blogs
    Then I verify that "<Title>"s are not in the List
    Then I logout from TikiWiki

    Examples: 
      | Title |
      | Blog1 |
