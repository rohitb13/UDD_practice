package com.udd.pageobjects;

import static org.testng.Assert.assertEquals;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EnumerationPage {
	
	private WebDriver driver;
	
	
	public EnumerationPage(WebDriver driver)
	{
		this.driver=driver;
	    PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(id="short")
	private WebElement shortName;
	
	@FindBy(id="longName")
	private WebElement longName;
	
	@FindBy(id="description")
	private WebElement description;
	
	@FindBy(id="categoryId")
	private WebElement categoryId;
	
	@FindBy(name="shortName_1")
	private WebElement enumshortnm;
	
	@FindBy(name="bitmaskShortName_1")
	private WebElement bitmaskShortName;
	
	@FindBy(name="enumDescription_1")
	private WebElement enumdesc;
	
	@FindBy(name="bitmaskDescription_1")
	private WebElement bitmaskDescription;
	
	@FindBy(name="enumValue_1")
	private WebElement enumvalue;
	
	@FindBy(name="bitmaskSize_1")
	private WebElement bitmaskSize;
	
	@FindBy(xpath="//div/button[@type='submit']")
	private WebElement saveEnumButton;
	
	@FindBy(xpath="//div/input[@type='checkbox']")
	private WebElement checkbox;
	
	@FindBy(xpath="//div/label[contains(text(),'Bit Mask')]")
	private WebElement bitMask;
	
	@FindBy(xpath="//span/button[@type='button']")
	private WebElement newButton;
	
		
	
	
	
	public void enterEnumDataForADTIDT(String datatypenm,String shortname,String text,String value) throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions prtab = new Actions(driver);
		try
		{
			shortName.sendKeys(shortname);
			prtab.sendKeys((longName),Keys.TAB).build().perform();;
			longName.sendKeys(shortname);
			description.sendKeys(shortname);
			Select datatype = new Select(categoryId);
			datatype.selectByValue(datatypenm);
			enumshortnm.clear();
			enumshortnm.sendKeys(text);
			enumdesc.sendKeys(text);
			enumvalue.sendKeys(value);
			js.executeScript("arguments[0].scrollIntoView();", saveEnumButton);
			Thread.sleep(3000);
			saveEnumButton.click();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	
	}
	
	public void enterEnumDataForBitmask(String shortname,String text,String value)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions prtab = new Actions(driver);
		try
		{
		shortName.sendKeys(shortname);
		longName.sendKeys(shortname);
		description.sendKeys(shortname);
		System.out.println(bitMask.getText());
			if(bitMask.getText().equals("Bit Mask"))
			{
				checkbox.click();
				newButton.click();
				bitmaskShortName.sendKeys(text);
				bitmaskDescription.sendKeys(text);
				bitmaskSize.sendKeys(value);
				js.executeScript("arguments[0].scrollIntoView();", saveEnumButton);
				Thread.sleep(3000);
				saveEnumButton.click();
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	
	
	
	
	
	

}
