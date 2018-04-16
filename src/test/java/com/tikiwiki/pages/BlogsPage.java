package com.tikiwiki.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tikiwiki.utilities.Driver;

public class BlogsPage {
private WebDriver driver;
	
	public BlogsPage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(id = "blog-title")
	public WebElement ILYblogTitleEntryField; 
	
	@FindBy(id = "blog-desc")
	public WebElement ILYblogDescriptionEntryField;
	
	@FindBy(name = "save")
	public WebElement ILYblogSaveButton;
	
	@FindBy(xpath = "//tr[2]//span")
	public WebElement ILYblogHooverOverLink;

	//!!! ADD click on delete button
	
	@FindBy(xpath ="//*[.='Confirm action']")
	public WebElement ILYblogConfirmActionButton;
	
	
	
	
	
}