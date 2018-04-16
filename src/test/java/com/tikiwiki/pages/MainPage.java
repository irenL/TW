package com.tikiwiki.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tikiwiki.utilities.ConfigurationReader;
import com.tikiwiki.utilities.Driver;

public class MainPage {
	private WebDriver driver;

	public MainPage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//*[@href='#menu_option266']")
	public WebElement ILYhomeBlogsLink;
	
	@FindBy(xpath = "//*[@href='tiki-list_blogs.php']")
	public WebElement ILYhomeBlogListBlogButton;

	@FindBy(xpath = "//*[@href='tiki-edit_blog.php']")
	public WebElement ILYhomeBlogCreateBlogButton;
	
	@FindBy(xpath = "//*[@href='tiki-blog_post.php']")
	public WebElement ILYhomeBlogNewBlogPostButton;

	@FindBy(xpath = "//*[@href='tiki-list_posts.php']")
	public WebElement ILYhomeBlogListBlogPostButton;

	@FindBy(xpath = "//*[@href='#menu_option272']")
	public WebElement ILYhomeForumsListLink;

	@FindBy(xpath = "//*[@href='tiki-forums.php']")
	public WebElement ILYhomeForumsForumListButton;
	
	@FindBy(xpath = "//*[@href='tiki-admin_forums.php']")
	public WebElement ILYhomeForumsAdminForumsButton;
	//===================================================================
	@FindBy(xpath="//button[@type='button'][contains(text(),'Log in')]")
	public WebElement logInLink;
	
	@FindBy(xpath="//button[@type='submit'][contains(text(),'Log in')]")
	public WebElement logInButton;
	
	@FindBy(id="login-user_1")
	public WebElement usernameInput;
	
	@FindBy(id="login-pass_1")
	public WebElement passwordInput;
	
	@FindBy(xpath="//button[@type='button'][contains(text(),'Log out')]")
	public WebElement logOutLink;
	
	@FindBy(xpath="//a[@title='Log out']")
	public WebElement logOutButton;

	public WebElement home;

	public WebElement search;

	public WebElement categories;

	public WebElement tags;

	public WebElement calendar;

	@FindBy(xpath="//a[@href='#menu_option231']")
	public WebElement wiki;

	@FindBy(xpath="//a[@href='#menu_option250']")
	public WebElement articles;

	@FindBy(xpath = "//*[@href='#menu_option266']")
	public WebElement blogs;

	@FindBy(xpath = "//*[@href='#menu_option272']")
	public WebElement forums;

	@FindBy(xpath="//a[contains(text(),'File Galleries')]")
	public WebElement fileGalleries;

	@FindBy(xpath="//a[contains(text(),'Spreadsheets')]")
	public WebElement spreadsheets;

	public WebElement trackers;

	public WebElement surveys;

	public WebElement newsletters;

	public WebElement settings;

	public List<WebElement> leftMenuOptions(String menu) {
		String xpath = "//a[contains(text(),'" +menu+ "')]/..//li";
		return driver.findElements(By.xpath(xpath));
	}







	
	
}

	
