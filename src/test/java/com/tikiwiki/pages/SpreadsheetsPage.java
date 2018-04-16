package com.tikiwiki.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tikiwiki.utilities.Driver;

public class SpreadsheetsPage {
	private WebDriver driver;

	public SpreadsheetsPage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[contains(text(),'List Sheets')]")
	public WebElement listSheetsLink;
	
	@FindBy(linkText="Create")
	public WebElement createTabButton;
	
	@FindBy(linkText="List")
	public WebElement listTabButton;
	
	@FindBy(name="title")
	public WebElement sheetTitle;
	
	@FindBy(name="edit")
	public WebElement saveButton;
	
	public WebElement edit_button;
	
	@FindBy(xpath="//tr[2]/td[2]")
	public WebElement cellA1;
	
	@FindBy(xpath="//tr[2]/td[3]")
	public WebElement cellB1;
	
	public WebElement save_button;
	
	@FindBy(xpath="(//a[contains(text(),'Spreadsheets')])[2]")
	public WebElement spreadsheets;
	
	public WebElement find;
	
	@FindBy(linkText="Delete")
	public WebElement deleteInEditIcon;
	
	@FindBy(linkText="Confirm action")
	public WebElement confirmActionButton;
	
	public WebElement rbox_1;
	
	@FindBy(linkText="Go back")
	public WebElement goBack;
	
	
	@FindBy(xpath="//td[.='No records found.']")
	public WebElement noRecordsFoundText;

	
}
