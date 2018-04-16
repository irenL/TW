package com.tikiwiki.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tikiwiki.utilities.BrowserUtils;
import com.tikiwiki.utilities.Driver;

public class WikiPage {

	private WebDriver driver;

	public WikiPage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@href='tiki-listpages.php?cookietab=2#tab2']")
	public WebElement createWikiPageFromMenu;

	@FindBy(xpath = "//input[@id='pagename']")
	public WebElement inputFieldCreateWikiPage;

	@FindBy(xpath = "//input[@name='quickedit']")
	public WebElement buttonCreatePage;

	@FindBy(xpath = "//textarea[@id='editwiki']")
	public WebElement inputFieldEditPage;

	@FindBy(xpath = "//input[@name='save']")
	public WebElement saveEditPage;

	@FindBy(xpath = "//a[@href='tiki-listpages.php?cookietab=1#tab1']")
	public WebElement listPagesFromMenu;

	@FindBy(id = "listpages1")
	public WebElement tableOfListPages;

	@FindBy(xpath = "//table[@id='listpages1']//tbody/tr")
	public List<WebElement> eachRowFromTableOfListPages;

	@FindBy(xpath = "//tr/td/input")
	public List<WebElement> rowElementsFromTable;

	@FindBy(xpath = "//select[@id='submit_mult']")
	public WebElement selectAction;

	@FindBy(xpath = "//button[@type='submit'][contains(text(),'OK')]")
	public WebElement buttonOK;

	@FindBy(xpath = "//button[@type='submit'][contains(text(),'Delete')]")
	public WebElement buttonDeleteFromConfirmWindow;

	@FindBy(xpath = "//a[contains(text(),'Tiki Wiki CMS Groupware ')]")
	public WebElement scrollDownElement;

	public void clickCheckbox(String name) {
		for (int i = 0; i < eachRowFromTableOfListPages.size(); i++) {
			if (eachRowFromTableOfListPages.get(i).getText().contains(name)) {
				eachRowFromTableOfListPages.get(i).findElement(By.xpath("//tr/td/input")).click();

			}
		}
	}

}
