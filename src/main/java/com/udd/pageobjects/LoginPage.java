package com.udd.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage {
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(id="username")
	private WebElement username;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(xpath="//*[@id=\"loginForm\"]/button")
	private WebElement loginsubmit;

	public HomePage login(String uname,String pass)
	{
		username.sendKeys(uname);
		password.sendKeys(pass);
		loginsubmit.click();
		return new HomePage(driver);
	}
}
