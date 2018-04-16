package com.tikiwiki.step_definitions;

import static org.testng.Assert.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.tikiwiki.pages.MainPage;
import com.tikiwiki.pages.WikiPage;
import com.tikiwiki.utilities.BrowserUtils;
import com.tikiwiki.utilities.Driver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WikiStepDefs {

	WebDriver driver = Driver.getDriver();
	WikiPage wikiPage = new WikiPage();
	MainPage mainPage = new MainPage();

	@When("^I click on the Create a Wiki Page$")
	public void i_click_on_the_Create_a_Wiki_Page() {
		wikiPage.createWikiPageFromMenu.click();
	}

	@Then("^I type in the input field \"([^\"]*)\"$")
	public void i_type_in_the_input_field(String page_name) {
		wikiPage.inputFieldCreateWikiPage.sendKeys(page_name);
	}

	@Then("^I click on Create Page$")
	public void i_click_on_Create_Page() {
		wikiPage.buttonCreatePage.click();
	}

	@Then("^I type to Input field \"([^\"]*)\" text:$")
	public void i_type_to_Input_field_text(String page_text) {
		wikiPage.inputFieldEditPage.sendKeys(page_text);
		BrowserUtils.waitFor(2);
	}

	@Then("^I click on save button$")
	public void i_click_on_save_button() {
		wikiPage.saveEditPage.click();
	}

	@Then("^I should see new page for \"([^\"]*)\"$")
	public void i_should_see_new_page_for(String page_name) {
		boolean newPageCreated = BrowserUtils.isElementCreated(driver, page_name);
		assertTrue(newPageCreated);
	}
	
	@When("^I click on List Pages$")
	public void i_click_on_List_Pages() {
		wikiPage.listPagesFromMenu.click();
	}

	@Then("^I will see table of list pages$")
	public void i_will_see_table_of_list_pages() {
		 wikiPage.tableOfListPages.isDisplayed();
	}

	@Then("^I find new created page \"([^\"]*)\" from list pages$")
	public void i_find_new_created_page_from_list_pages(String pageName) {
	  boolean foundPage = BrowserUtils.isElementInTable(wikiPage.eachRowFromTableOfListPages, pageName );
	  assertTrue(foundPage);
	}

	@Then("^I delete \"([^\"]*)\"$")
	public void i_delete(String pageName) {
		wikiPage.clickCheckbox(pageName);
		BrowserUtils.waitFor(3);
		wikiPage.selectAction.click();
		Select select = new Select(wikiPage.selectAction);
		select.selectByVisibleText("Remove");
		BrowserUtils.waitFor(1);
		wikiPage.buttonOK.click();
		BrowserUtils.waitFor(2);
		wikiPage.buttonDeleteFromConfirmWindow.click();
		BrowserUtils.waitFor(2);
}

	
	@Then("^I check if \"([^\"]*)\" was deleted from table of list pages$")
	public void i_check_if_was_deleted_from_table_of_list_pages(String pageName) {
		boolean foundPage = BrowserUtils.isElementInTable(wikiPage.eachRowFromTableOfListPages, pageName );
		  assertFalse(foundPage);
	}
}
