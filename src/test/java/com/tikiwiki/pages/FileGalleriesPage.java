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

}
