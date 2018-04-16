package com.tikiwiki.step_definitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.tikiwiki.utilities.BrowserUtils;
import com.tikiwiki.utilities.Driver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import com.tikiwiki.pages.MainPage;
import com.tikiwiki.pages.SpreadsheetsPage;

public class Spreadsheets {
	WebDriver driver = Driver.getDriver();
	MainPage mainPage = new MainPage();
	SpreadsheetsPage sheetPage = new SpreadsheetsPage();

	@When("^I delete sheet \"([^\"]*)\"$")
	public void i_delete_sheet(String sheetname) {
		sheetPage.spreadsheets.click();
		sheetPage.listSheetsLink.click();
		sheetPage.find.sendKeys(sheetname+Keys.ENTER);
		WebElement editIcon =driver.findElement((By.xpath("//tr//a[.='" + sheetname+ "']/../../td[@class='action']//span")));
		BrowserUtils.hover(editIcon);
		sheetPage.deleteInEditIcon.click();
		sheetPage.confirmActionButton.click();
		try{
			if(sheetPage.rbox_1.isDisplayed()) {
				sheetPage.goBack.click();
				sheetPage.confirmActionButton.click();
				}
		}catch(NoSuchElementException e) {
			return;
		}	
	}

	@Then("^I verify \"([^\"]*)\" is not in the List$")
	public void i_verify_is_not_in_the_List(String sheetname) {
		sheetPage.spreadsheets.click();
		sheetPage.listSheetsLink.click();
		sheetPage.find.sendKeys(sheetname+Keys.ENTER);
		assertTrue(sheetPage.noRecordsFoundText.isDisplayed(), "No records found. is not displayed");
	}

	@When("^I create a sheet \"([^\"]*)\"$")
	public void i_create_a_sheet_DefecTeamSheet(String sheetname) {
		sheetPage.listSheetsLink.click();
		sheetPage.createTabButton.click();
		sheetPage.sheetTitle.sendKeys(sheetname);
		sheetPage.saveButton.click();
	}

	@When("^I add \"([^\"]*)\" and \"([^\"]*)\" to the sheet\"([^\"]*)\"$")
	public void i_add_and_to_the_sheet(String data1, String data2, String sheetname) {
		sheetPage.spreadsheets.click();
		sheetPage.listSheetsLink.click();
		sheetPage.find.sendKeys(sheetname+Keys.ENTER);
		driver.findElement(By.xpath("//a[.='" + sheetname + "']")).click();
		sheetPage.edit_button.click();
		Actions action = new Actions(driver);
		action.moveToElement(sheetPage.cellA1).click().sendKeys(Keys.DELETE).sendKeys(data1).build().perform();
		action.moveToElement(sheetPage.cellB1).click().sendKeys(Keys.DELETE).sendKeys(data2).build().perform();
		sheetPage.save_button.click();
		BrowserUtils.waitFor(2);
	}

	@Then("^I verify the \"([^\"]*)\" and  \"([^\"]*)\" on the sheet \"([^\"]*)\"$")
	public void i_verify_the_and_on_the_sheet(String data1, String data2, String sheetname) {
		BrowserUtils.waitFor(2);
		sheetPage.spreadsheets.click();
		sheetPage.listSheetsLink.click();
		sheetPage.find.sendKeys(sheetname+Keys.ENTER);
		driver.findElement(By.xpath("//a[.='" + sheetname + "']")).click();
		assertEquals(sheetPage.cellA1.getText(), data1, "CellA1 contains different data");
		assertEquals(sheetPage.cellB1.getText(), data2, "CellB1 contains different data");
	}

	
	
}
