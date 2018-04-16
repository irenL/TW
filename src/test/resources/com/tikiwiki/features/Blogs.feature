#Author: ilyas

@blogs
Feature: Create and Delete Blogs

Background:  Given I login to TikiWiki

  @create_blogs
  Scenario Outline: Creating new blogs from the excel sheet
   
    When I click to blogs menu
    And I see the menu options for blogs:
      |List Blogs |
      |Create Blog|
      |New Blog Post|
      |List Blog Post|
        
    And I create new blogs
    Then I must be able to see them in the blog list table
    Then I logout

       
      @delete_forums
  Scenario: Deleting blogss from the 
   
		When I click to Blogs menu
    And I see the menu options for blogs:
      |List Blogs |
      |Create Blog|
      |New Blog Post|
      |List Blog Post|
    When I delete blogs
    Then I verify blogs are not in the List
    Then I logout
