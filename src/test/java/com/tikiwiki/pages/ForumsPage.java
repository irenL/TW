package com.tikiwiki.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.tikiwiki.utilities.Driver;

public class ForumsPage {
private WebDriver driver;
	
	public ForumsPage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath = "//a[@href='#content_admin_forums1-2']")
	public WebElement ILYforumsCreateNewForumButton;
	
	@FindBy(xpath = "(//*[@id=\"name\"])[2]")
	public WebElement ILYforumsNameEntryField; 	
	
	@FindBy(xpath = "(//*[@name=\"description\"])[2]")
	public WebElement ILYforumsdescriptionEntryField;
	
	@FindBy(name = "save")
	public WebElement ILYforumsSaveButton;
	
	@FindBy(xpath="//*[@title='List']")
	public WebElement ILYforumListButton;
	
	@FindBy(xpath="//*[@id=\"forums1\"]//td[1]")
	public WebElement ILYforumTableButton;
	
	@FindBy(xpath="//*[@id='adminforums1']//td[2]")
	public WebElement ILYforumTables;
	
	@FindBy(xpath="//*[@href='#content_admin_forums1-1']")
	public WebElement ILYforumForumsButton;
	
	@FindBy(linkText="Delete")
	public WebElement ILYforumDelete;
	
	@FindBy(xpath = "//div[3]/button[2]")
	public WebElement ILYforumsPopUpOKButton;
	
		
	
	
	
	
}