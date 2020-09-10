package com.udd.scripts;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.udd.testbase.TestBase;



public class WorkspaceTest extends TestBase {
	

	
	@Test(testName="To verify user allow to select given workspace",description="To verify that UDD shall allow to select given workspace.")
	public void selectCurrentWorkspace() throws InterruptedException 
	{
		driver.get(url);
		logger.info("Naviating to "+url);
		homePage=loginPage.login(username, password);
		logger.info("Logging in as user "+username);
		assertEquals("Unified Design Dictionary",homePage.getHeaderOfProject());
		homePage.activateplugin(username,password);
		Thread.sleep(5000);
		workspacePage.selectworkspace(wsname);
		assertEquals("Current Workspace",workspacePage.checkcurrenttab());
		Assert.assertTrue(true);
		
	}
	
	
	
	
	

}
