package com.tikiwiki.step_definitions;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.tikiwiki.pages.ArticlesPage;
import com.tikiwiki.pages.MainPage;
import com.tikiwiki.utilities.BrowserUtils;
import com.tikiwiki.utilities.Driver;


import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ArticlesStepDefs {

	WebDriver driver = Driver.getDriver();
	MainPage mainPage = new MainPage();
	ArticlesPage articlesPage = new ArticlesPage();
	
	
	@When("^I click on the New Articles$")
	public void i_click_on_the_New_Articles() {
		articlesPage.newArticlesFromMenu.click();
	}

	@Then("^I type in Title input field \"([^\"]*)\"$")
	public void i_type_in_Title_input_field(String title) {
		articlesPage.inputFieldTitle.sendKeys(title);
	}

	@Then("^I type in Heading input field \"([^\"]*)\"$")
	public void i_type_in_Heading_input_field(String heading) {
	  articlesPage.inputFieldHeading.sendKeys(heading);
	}

	@Then("^I type in Body input field \"([^\"]*)\"$")
	public void i_type_in_Body_input_field(String body) {
	   articlesPage.inputFieldBody.sendKeys(body);
	}

	@Then("^I click on button save$")
	public void i_click_on_button_save() {
	    articlesPage.buttonSaveFromNewArticle.click();
	}

	@Then("^I should see new Article for \"([^\"]*)\"$")
	public void i_should_see_new_Article_for(String title) {
		boolean newArticleCreated = BrowserUtils.isElementCreated(driver, title);
	    assertTrue(newArticleCreated);
	}
	
	@When("^I click on the List Articles$")
	public void i_click_on_the_List_Articles() {
	  articlesPage.listArticlesFromMenu.click();
	}

	@Then("^I type in search input field \"([^\"]*)\"$")
	public void i_type_in_search_input_field(String article) {
	    articlesPage.searchInputFieldFromListArticles.sendKeys(article + Keys.ENTER );
	}

	@Then("^I should see in table of Article list only articles that contains \"([^\"]*)\"$")
	public void i_should_see_in_table_of_Article_list_only_articles_that_contains(String article) {
	    boolean containsArticleName = BrowserUtils.isElementInTable(articlesPage.tableOfListArticles, article);
	    BrowserUtils.waitFor(3);
	    assertTrue(containsArticleName);
	}
}
