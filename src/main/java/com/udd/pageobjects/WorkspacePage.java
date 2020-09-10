package com.udd.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WorkspacePage {
	
	private WebDriver driver;
	public WorkspacePage(WebDriver driver) {
	
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//li[contains(@class,'uib-tab nav-item ng-scope ng-isolate-scope active')]/a/uib-tab-heading/img")
	private WebElement activetab;
	
	@FindBy(xpath="//div/h5[text()=' Unresolved Changes (Workspace) ']//following::span[text()=' Enumeration ']/i")
	private WebElement enumplus;
	
	@FindBy(xpath="//div[@ng-click='openLogger()']")
	private WebElement getmessage;
	
	
	public void selectworkspace(String workspacename)
	{
		System.out.println(workspacename);
		String xpathWS="//span[contains(text(),' "+workspacename+" ')]";
		System.out.println(xpathWS);
		driver.findElement(By.xpath(xpathWS)).click();
		
	}
	
	public String checkcurrenttab() 
	{
		String currentActiveTab=activetab.getAttribute("title");
		System.out.println(currentActiveTab);
		return currentActiveTab;
	}
	
	public void checkUnresolvedEnum(String enumname)
	{      
		String xpathEnumName = "//div/div/h5[text()=' Unresolved Changes (Workspace) ']//following::div/h5/span[text()=' Enumeration ']//following::span/span[@title='"+enumname+"']/text()[1]";
		enumplus.click();
		String actualenum1 = driver.findElement(By.xpath(xpathEnumName)).getText();
		System.out.println("this is actual test : "+actualenum1);
		
		//return actualenum;	
			
	}
	
	public String getMessage()
	{
		String message=getmessage.getText();
		return message;
	}
}
	


