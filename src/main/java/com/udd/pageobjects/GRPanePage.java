package com.udd.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.udd.utility.ExcelManager;



public class GRPanePage {
	
	private WebDriver driver;
	
	public GRPanePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div/img[contains(@src,'images/left-arrow.dc58c57c.png')]")
	private WebElement sideBar;
	
	@FindBy(xpath="//span[contains(text(),'Unit')]")
	private WebElement grMenuDropdown;
	
	@FindBy(xpath="//div[@ng-repeat=\"enumCategory in enumCatList\"]/div/h3/span[@class=\"data-interface-label ng-binding\"]")
	private WebElement elementcatagory;
	
	
	
	
	public void clickSideBar()
	{
		WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(sideBar)).click();
		//sideBar.click();
		System.out.println("click sidebar");
	}
	
	public void selectGRElement(String grElement)
	{
		switch(grElement)
		{
		case "Enumeration":
			try
			{
				grMenuDropdown.click();
				String xpathGRE="//div[contains(text(),'"+grElement+"')]";
				driver.findElement(By.xpath(xpathGRE)).click();
				List<WebElement> el = driver.findElements(By.xpath("//div[@ng-repeat=\"enumCategory in enumCatList\"]/div/h3/span[@class=\"data-interface-label ng-binding\"]"));
				for (int i=0; i<el.size();i++)
				{
					System.out.println(el.get(i).getText());
                    if(el.get(i).getText().equals("Application Data type")||el.get(i).getText().equals("Implementation Data Type"))
                    {
                    	ExcelManager.setCellData("Pass", 1, 11);
                    }
                    else
                    {
                    	ExcelManager.setCellData("Fail", 1, 11);
                    }
		        	//all_elements_text.add(el.get(i).getText());	
				}
			
			}
			catch(Exception e)
			{
				
			}
				
		}
		

	
		
	}
	
	public void addElement(String grElement)
	{
		String xpathAddGRE="//button[contains(@title,'Add "+grElement+"')]";
		driver.findElement(By.xpath(xpathAddGRE)).click();
		
	}

}
