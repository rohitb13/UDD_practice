package com.udd.testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.udd.pageobjects.LoginPage;
import com.udd.utility.PropertyFileReader;


public class DemoTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		PropertyFileReader propFile=new PropertyFileReader("qa.properties");
		String url=propFile.getValue("url");
		String username=propFile.getValue("username");
		String password=propFile.getValue("password");
		
				
				//.getResourceAsStream("/chromedriver.exe");
		
		System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get(url);
		LoginPage page=new LoginPage(driver);
		page.login(username, password);

		Thread.sleep(10000);
		

		
		
	}

}
