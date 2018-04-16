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

public class BlogStepDefs {

	WebDriver driver = Driver.getDriver();
	BlogsPage blogs=new BlogsPage();
	ForumsPage forums=new ForumsPage();
	MainPage main=new MainPage();
	
	@When("^I am creating new blogs with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_am_creating_new_blogs_with_and(String Title, String Description) {
	  
	   main.ILYhomeBlogCreateBlogButton.click();
	   BrowserUtils.waitFor(1);
	   blogs.ILYblogTitleEntryField.sendKeys(Title);
	   blogs.ILYblogDescriptionEntryField.sendKeys(Description);
	   blogs.ILYblogSaveButton.click();
	 }

	@Then("^I must be able to see \"([^\"]*)\" in the blog list table$")
	public void i_must_be_able_to_see_them_in_the_blog_list_table(String Title) {
		main.ILYhomeBlogsLink.click();
		BrowserUtils.waitFor(1);
		main.ILYhomeBlogListBlogButton.click();
		BrowserUtils.waitFor(1);
		Assert.assertTrue(blogs.ILYBlogsTableButton.getText().contains(Title));
	}

	@When("^I delete \"([^\"]*)\" blogs$")
	public void i_delete_blogs(String Description) {
		
		main.ILYhomeBlogListBlogButton.click();
		BrowserUtils.waitFor(1);
		WebElement deleteButton2 =driver.findElement((By.xpath("//*[contains(text(), '" + Description+ "')]/../../td[@class='action']//span")));
		BrowserUtils.hover(deleteButton2);
		BrowserUtils.waitFor(1);
		blogs.ILYBlogsRemove.click();
		BrowserUtils.waitFor(1);
		blogs.ILYblogConfirmActionButton.click();
		
	}

	@Then("^I verify that \"([^\"]*)\"s are not in the List$")
	public void i_verify_that_s_are_not_in_the_List(String Titles) {
		Assert.assertTrue(!blogs.ILYblogListNames.getText().contains("Blog1"));
	}
}
