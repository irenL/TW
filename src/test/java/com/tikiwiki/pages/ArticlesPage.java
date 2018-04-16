package com.tikiwiki.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tikiwiki.utilities.Driver;

public class ArticlesPage {

private WebDriver driver;
	
	public ArticlesPage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[@href='tiki-edit_article.php']")
	public WebElement newArticlesFromMenu; 
	
	@FindBy(xpath="//input[@name='title']")
	public WebElement inputFieldTitle;
	
	@FindBy(xpath="//textarea[@id='subheading']")
	public WebElement inputFieldHeading;
	
	@FindBy(xpath="//textarea[@id='body']")
	public WebElement inputFieldBody;
	
	@FindBy(xpath="//input[@name='save']")
	public WebElement buttonSaveFromNewArticle;
	
	@FindBy(xpath="//a[@href='tiki-list_articles.php']")
	public WebElement listArticlesFromMenu;
	
	@FindBy(xpath="//input[@id='find']")
	public WebElement searchInputFieldFromListArticles;
	
	@FindBy(xpath="//form[@name='checkform']//tr")
	public List<WebElement> tableOfListArticles;
	


	
}
