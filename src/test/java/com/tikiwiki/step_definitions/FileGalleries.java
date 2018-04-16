package com.tikiwiki.step_definitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tikiwiki.pages.FileGalleriesPage;
import com.tikiwiki.pages.MainPage;
import com.tikiwiki.utilities.BrowserUtils;
import com.tikiwiki.utilities.ConfigurationReader;
import com.tikiwiki.utilities.Driver;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FileGalleries {
	WebDriver driver = Driver.getDriver();
	MainPage mainPage = new MainPage();
	FileGalleriesPage fileGallPage = new FileGalleriesPage();
	
	
	@Given("^I login to TikiWiki$")
	public void i_login_to_TikiWiki() {
	   driver.get(ConfigurationReader.getProperty("url"));
	   BrowserUtils.waitForVisibility(mainPage.logInLink, 5);
	   mainPage.logInLink.click();
	   mainPage.usernameInput.sendKeys(ConfigurationReader.getProperty("username"));
	   mainPage.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
	   mainPage.logInButton.click();
	}

	@When("^I click to (Home|Search|Categories|Tags|Calendar|Wiki|Articles|Blogs|Forums|File Galleries|Spreadsheets|Trackers|Surveys|Newsletters|Settings) menu$")
	public void i_click_to_File_Galleries_menu(String menu) {
		switch(menu) {
		case "Home": 
			mainPage.home.click();
		    break;
		case "Search":
			mainPage.search.click();
		    break;
		case "Categories":
			mainPage.categories.click();
		    break;
		case "Tags":
			mainPage.tags.click();
		    break;
		case "Calendar":
			mainPage.calendar.click();
		    break;
		case "Wiki":
			mainPage.wiki.click();
			BrowserUtils.waitFor(2);
		    break;
		case "Articles":
			mainPage.articles.click();
			BrowserUtils.waitFor(2);
		    break;
		case "Blogs":
			mainPage.ILYhomeBlogsLink.click();
			BrowserUtils.waitFor(2);
		    break;
		case "Forums":
			mainPage.ILYhomeForumsListLink.click();
			BrowserUtils.waitFor(2);
			break;
		case "File Galleries":
			mainPage.fileGalleries.click();
		    break;
		case "Spreadsheets":
			mainPage.spreadsheets.click();
		    break;
		case "Trackers":
			mainPage.trackers.click();
		    break;
		case "Surveys":
			mainPage.surveys.click();
		    break;
		case "Newsletters":
			mainPage.newsletters.click();
		    break;
		case "Settings":
			mainPage.settings.click();
		    break;
		}
	}

	@When("^I see the menu options for (Home|Search|Categories|Tags|Calendar|Wiki|Articles|Blogs|Forums|File Galleries|Spreadsheets|Trackers|Surveys|Newsletters|Settings):$")
	public void i_see_the_menu_options(String menu, List<String> options) {
		List<WebElement> leftMenuOptions = mainPage.leftMenuOptions(menu);
	    List<String> leftMenuOptionsString = BrowserUtils.getElementsText(leftMenuOptions);
	    
	    assertEquals(leftMenuOptionsString.size(), options.size(), "Number of expected menu options didn't match");
	  
	    for (int i = 0; i < leftMenuOptionsString.size(); i++) {
			assertEquals(leftMenuOptionsString.get(i), options.get(i));
		}
	}

	@When("^I upload a file \"([^\"]*)\" with a \"([^\"]*)\"$")
	public void i_upload_a_file_name_with_a_src_test_resources_testdata_defect_jpg(String file, String filepath) {
	   BrowserUtils.waitFor(2);
		fileGallPage.uploadFileLink.click();
	   
	   fileGallPage.chooseFiles.sendKeys(System.getProperty("user.dir")+filepath);
	   assertTrue(fileGallPage.cbox.getText().contains(file), "Uploaded filename missmatch checkbox");
	   
	}

	@Then("^I verify the \"([^\"]*)\" in File Galleries$")
	public void i_verify_the_name_in_File_Galleries(String filename) {
	   mainPage.fileGalleries.click();
	   fileGallPage.listGalleriesLink.click();
	   assertTrue(fileGallPage.firstFileName.getText().equalsIgnoreCase(filename),"Uploaded filename different from 1st filename in the File Galleries List");
	}

	@Then("^I logout from TikiWiki$")
	public void i_logout_from_TikiWiki() {
		mainPage.logOutLink.click();
		mainPage.logOutButton.click();
	}


	@When("^I delete \"([^\"]*)\" from File Galleries$")
	public void i_delete_from_File_Galleries(String filename) {
		mainPage.fileGalleries.click();
		fileGallPage.listGalleriesLink.click();
		String xpathfileToDelete = "//a[.='" +filename+ "']/..//..//a[@class='fgalname tips']";
		BrowserUtils.hover(driver.findElement(By.xpath(xpathfileToDelete)));
		driver.findElement(By.linkText("Delete")).click();
		fileGallPage.confirmActionButton.click();
		
		try{
			if(fileGallPage.rbox_1.isDisplayed()) {
				fileGallPage.goBack.click();
				fileGallPage.confirmActionButton.click();
				}
		}catch(NoSuchElementException e) {
			return;
		}	
	}

	@Then("^I verify the \"([^\"]*)\" is not in File Galleries$")
	public void i_verify_the_is_not_in_File_Galleries(String filename) {
	//	assertTrue(!fileGallPage.firstFileName.getText().equals(filename));
		assertTrue(fileGallPage.noRecordsFoundText.isDisplayed(), "No records found. is not displayed");
	}

}
