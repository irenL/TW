#Author: Ahmed Allaberdiyev
@dev @file_galleries
Feature: Upload and Delete File

  @upload_file @smoke @ft 
  Scenario Outline: Upload file
    Given I login to TikiWiki
    When I click to File Galleries menu
    And I see the menu options for File Galleries:
      | List Galleries |
      | Upload File    |
    When I upload a file "<filename>" with a "<filepath>"
    Then I verify the "<filename>" in File Galleries
    And I logout from TikiWiki

    Examples: 
      | filename | filepath                                 |
      | defect2  | /src/test/resources/testdata/defect2.jpg |
      | defect   | /src/test/resources/testdata/defect.jpg  |

  @delete_file @ft
  Scenario: Delete file
    Given I login to TikiWiki
    When I click to File Galleries menu
    And I see the menu options for File Galleries:
      | List Galleries |
      | Upload File    |
    And I delete "Defect" from File Galleries
    Then I verify the "Defect" is not in File Galleries
    And I logout from TikiWiki
