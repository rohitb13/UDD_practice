package com.udd.pageobjects;

import java.awt.Window;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	private WebDriver driver;
	
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//p[@class='pull-right headerProductName ng-binding']")
	private WebElement headerTxt;
	
	@FindBy(xpath="//img[contains(@src,'images/header/user-icon.14026176.png')]")
	private WebElement profileimage;
	
	@FindBy(xpath="//ul/li/div/div/label/a")
	private WebElement logout;
	
	@FindBy(xpath="//span[contains(text(),'Plugin')]")
	private WebElement plugin;
	
	@FindBy(xpath="//span[contains(text(),'RTC')]")
	private WebElement rtc;
	
	@FindBy(xpath="//ul/li/a[contains(text(),'Activate UDD client')]")
	private WebElement activateUddClient;
	
	
	@FindBy(xpath="//ul/li/a[contains(@ng-click,'onPluginLogin()')]")
	private WebElement uddLogin;
	
	
	@FindBy(xpath="//ul/li/a[contains(@ng-click,'openRtcLoginModal()')]")
	private WebElement rtcLogin;
	

	@FindBy(xpath="//button[contains(@ng-click,'dismiss()')]")
	private WebElement closePopup;
	
	
	@FindBy(xpath="//button[contains(@id,'details-button')]")
	private WebElement Advanced;
	
	@FindBy(xpath="//div/p/a[contains(@id,'proceed-link')]")
	private WebElement proceedLink;
	
	@FindBy(id="pluginLoginName")
	private WebElement pluginUsername;
	
	@FindBy(id="password")
	private WebElement pluginPassword;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement closebutton;
	
	
	
	public String getHeaderOfProject()
	{
		return headerTxt.getText();
	}
	
	public void clickprofile() 
	{
		profileimage.click();
	}
	
	public void clicklogout()
	{
		logout.click();
		
	}
	
	public void activateplugin(String uname, String password) throws InterruptedException 
	{
	    Actions actions = new Actions(driver);
		actions.moveToElement(plugin).click().build().perform();
		activateUddClient.click();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Advanced.click();
		proceedLink.click();
		driver.close();
		driver.switchTo().window(tabs.get(0));
		actions.moveToElement(rtc).click().build().perform();
		rtcLogin.click();
		closePopup.click();
		actions.moveToElement(plugin).click().build().perform();
		uddLogin.click();
		pluginUsername.sendKeys(uname);
		pluginPassword.sendKeys(password);
		Thread.sleep(2000);
		closebutton.click();
		
	
		
	}
	
	
	
	
	
}

