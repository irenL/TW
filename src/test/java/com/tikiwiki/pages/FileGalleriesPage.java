package com.tikiwiki.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tikiwiki.utilities.Driver;

public class FileGalleriesPage {
	private WebDriver driver;

	public FileGalleriesPage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	
public WebElement rbox_1;
	
	@FindBy(linkText="Go back")
	public WebElement goBack;
	
	@FindBy(xpath="(//a[contains(text(),'File Galleries')])[3]")
	public WebElement fileGalleries;
	
	@FindBy(xpath="//a[contains(text(),'List Galleries')]")
	public WebElement listGalleriesLink;
	
	@FindBy(xpath="//a[contains(text(),'Upload File')]")
	public WebElement uploadFileLink;
	
	
	@FindBy(id="fileupload")
	public WebElement chooseFiles;
	
	@FindBy(xpath="//a[@class='cboxElement'][3]")
	public WebElement cbox;
	
	@FindBy(xpath="(//a[@class='fgalname'])[1]")
	public WebElement firstFileName;
	
	@FindBy(linkText="Confirm action")
	public WebElement confirmActionButton;
	
	@FindBy(xpath="//td[.='No records found.']")
	public WebElement noRecordsFoundText;

}
