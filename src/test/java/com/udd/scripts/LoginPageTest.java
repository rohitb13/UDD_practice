package com.udd.scripts;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.udd.testbase.TestBase;



public class LoginPageTest extends TestBase {
	
	
	
	@Test(testName="To verify login with valid user ",description="To verify that UDD shall allow login for valid users.")
	public void loginWithValidValue()  
	{
		driver.get(url);
		logger.info("Naviating to "+url);
	    homePage=loginPage.login(username, password);
		logger.info("Logging in as user "+username);
		assertEquals("Unified Design Dictionary",homePage.getHeaderOfProject());
		Assert.assertTrue(true);
	}
	
	

}
