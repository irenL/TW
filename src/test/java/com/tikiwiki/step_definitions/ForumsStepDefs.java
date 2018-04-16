package com.tikiwiki.step_definitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.tikiwiki.pages.BlogsPage;
import com.tikiwiki.pages.ForumsPage;
import com.tikiwiki.pages.MainPage;
import com.tikiwiki.utilities.BrowserUtils;
import com.tikiwiki.utilities.Driver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ForumsStepDefs {


	WebDriver driver = Driver.getDriver();
	BlogsPage blogs=new BlogsPage();
	ForumsPage forums=new ForumsPage();
	MainPage main=new MainPage();
	
	
	@When("^I click to forums menu$")
	public void i_click_to_forums_menu() {
		main.ILYhomeForumsListLink.click();
		}
	 
	@When("^I am creating new forums with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_am_creating_new_forums_with_and(String Name, String Description) {
		main.ILYhomeForumsAdminForumsButton.click();
		BrowserUtils.waitFor(1);
		forums.ILYforumsCreateNewForumButton.click();
		BrowserUtils.waitFor(1);
		forums.ILYforumsNameEntryField.sendKeys(Name);
		forums.ILYforumsdescriptionEntryField.sendKeys(Description);
		forums.ILYforumsSaveButton.click();
	}
	
	@Then("^I must be able to see \"([^\"]*)\" in the forums list table$")
	public void i_must_be_able_to_see_in_the_forums_list_table(String Name) {
		main.ILYhomeForumsListLink.click();
		BrowserUtils.waitFor(1);
		main.ILYhomeForumsAdminForumsButton.click();
		BrowserUtils.waitFor(1);
		forums.ILYforumListButton.click();
		BrowserUtils.waitFor(1);
		Assert.assertTrue(forums.ILYforumTableButton.getText().contains(Name));
	}

	@Then("^I logout$")
	public void i_logout() {
	   
	}

	@When("^I delete \"([^\"]*)\"forums$")
	public void i_delete_forums(String Name) {
		main.ILYhomeForumsAdminForumsButton.click();
		BrowserUtils.waitFor(1);
		WebElement deleteButton =driver.findElement((By.xpath("//tr//a[.='" + Name+ "']/../../td[@class='action']//span")));
		BrowserUtils.hover(deleteButton);
		BrowserUtils.waitFor(1);
		forums.ILYforumDelete.click();
		BrowserUtils.waitFor(2);
		forums.ILYforumsPopUpOKButton.click();
		BrowserUtils.waitFor(2);
				
		
	}

	@Then("^I verify \"([^\"]*)\"s are not in the List$")
	public void i_verify_forums_are_not_in_the_List(String Name) {
		Assert.assertTrue(!forums.ILYforumTables.getText().contains("ForumTiki1"));
		
	}
	
}
