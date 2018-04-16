#Author: Ahmed Allaberdiyev
@spreadsheets
Feature: Create and Delete Spreadsheets

  @create_sheet @smoke @ft
  Scenario Outline: Create Spreadsheet
    Given I login to TikiWiki
    When I click to Spreadsheets menu
    And I see the menu options for Spreadsheets:
      | List Sheets |
    And I create a sheet "<sheetname>"
    When I add "<data1>" and "<data2>" to the sheet"<sheetname>"
    Then I verify the "<data1>" and  "<data2>" on the sheet "<sheetname>"
    Then I logout from TikiWiki

    Examples: 
      | sheetname       | data1                 | data2                 |
      | DefecTeamSheet1 | inputData1            | inputData2            |
      | DefecTeamSheet2 | inputData1 for sheet2 | inputData2 for sheet2 |

  @delete_sheet @ft
  Scenario: Delete Spreadsheet
    Given I login to TikiWiki
    When I click to Spreadsheets menu
    And I see the menu options for Spreadsheets:
      | List Sheets |
    And I create a sheet "SheetToDelete"
    When I delete sheet "SheetToDelete"
    Then I verify "SheetToDelete" is not in the List
