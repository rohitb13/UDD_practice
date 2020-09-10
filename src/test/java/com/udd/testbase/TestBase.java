package com.udd.testbase;


import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.udd.pageobjects.EnumerationPage;
import com.udd.pageobjects.GRPanePage;
import com.udd.pageobjects.HomePage;
import com.udd.pageobjects.LoginPage;
import com.udd.pageobjects.WorkspacePage;
import com.udd.utility.Constant;
import com.udd.utility.ExcelManager;
import com.udd.utility.ExtentTestManager;
import com.udd.utility.LogInitilizer;
import com.udd.utility.PropertyFileReader;


public class TestBase {
	
	protected PropertyFileReader propFile;
	protected String url;
	protected String username;
	protected String password;
	protected String wsname;
	protected String grElement;
	protected HomePage homePage;
	protected WorkspacePage workspacePage;
	protected EnumerationPage enumerationPage;
	protected GRPanePage grPanePage;
	protected WebDriver driver;
	protected LoginPage loginPage;
	protected Logger logger;
	static ExtentTest exlogger;
	
	@BeforeClass
	public void setupTest() throws Exception{
		propFile=new PropertyFileReader("qa.properties");
		url=propFile.getValue("url");
		username=propFile.getValue("username");
		password=propFile.getValue("password");
		wsname=propFile.getValue("workspacename");
		grElement=propFile.getValue("grelement");
		System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
		logger=LogInitilizer.getLogger();
	}
	

	@BeforeMethod
	public void testCondition(Method method)
	{
		Test test=method.getAnnotation(Test.class);
		exlogger=ExtentTestManager.startTest(test.testName());
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS); 
		loginPage=new LoginPage(driver);
		workspacePage = new WorkspacePage(driver);
		grPanePage = new GRPanePage(driver);
		enumerationPage=new EnumerationPage(driver);
	}

	@AfterMethod
	public void teardown(ITestResult result) throws InterruptedException
	{
		
		if(result.isSuccess()) {
			exlogger.log(LogStatus.PASS, "Testcase passed");
		}else {
			exlogger.log(LogStatus.FAIL, "Testcase FAIL");
		}
		//extent.endTest(logger);
		ExtentTestManager.endTest();
		Thread.sleep(3000);
		/*homePage.clickprofile();
		homePage.clicklogout();
		driver.quit();*/
		
	}
	

	
		
	

}
