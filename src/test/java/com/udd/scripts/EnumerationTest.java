package com.udd.scripts;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.udd.testbase.TestBase;
import com.udd.utility.Constant;
import com.udd.utility.ExcelManager;
import com.udd.utility.TestDataProvider;

public class EnumerationTest extends TestBase{
	
	protected String shortname;
	protected String txt;
	protected String value;
	protected String datatype;
	
	
	
	@BeforeMethod
	public void enumCreation() throws Exception
	{
		ExcelManager.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Enum");
		driver.get(url);
		logger.info("Naviating to "+url);
		homePage=loginPage.login(username, password);
		logger.info("Logging in as user "+username);
		assertEquals("Unified Design Dictionary",homePage.getHeaderOfProject());
		homePage.activateplugin(username,password);
		Thread.sleep(5000);
		workspacePage.selectworkspace(wsname);
		Thread.sleep(5000);
		grPanePage.clickSideBar();
	    grPanePage.selectGRElement(grElement);
		grPanePage.addElement(grElement);
		ExcelManager.setCellData("Pass", 2, 11);	
	}
	
	@Test(priority=1,testName="22078: To verify UDD shall allow to create Enum with datatype ADT ",description="To verify that UDD shall allow User to create new Enumeration of type ADT  from GR pane.",dataProviderClass=TestDataProvider.class,dataProvider="getADTEnumData")
	public void createADTEnum(String enumdatatype,String enumshortname ,String enumtext, String enumvalue) throws Exception 
	{
		shortname=enumshortname;
		txt=enumtext;
		value=enumvalue;
		datatype=enumdatatype;
		enumerationPage.enterEnumDataForADTIDT(datatype, shortname, txt, value);
		ExcelManager.setCellData("Pass", 3, 11);
		ExcelManager.setCellData("Pass", 4, 11);
		System.out.println(workspacePage.getMessage());
		Thread.sleep(2000);
		Assert.assertEquals(workspacePage.getMessage()," Enumeration created successfully.");
		//workspacePage.checkUnresolvedEnum(shortname);
		ExcelManager.setCellData("Pass", 5, 11);
		//assertEquals(shortname,workspacePage.checkUnresolvedEnum(shortname));	
        
	}
	
	/*@Test(priority=2,testName="22081: To verify UDD shall allow to create Enum with datatype IDT ",description="To verify that UDD shall allow User to create new Enumeration of type IDT  from GR pane.",dataProviderClass=TestDataProvider.class,dataProvider="getIDTEnumData")
	public void createIDTEnum(String enumdatatype,String enumshortname ,String enumtext, String enumvalue) throws InterruptedException 
	{
		shortname=enumshortname;
		txt=enumtext;
		value=enumvalue;
		datatype=enumdatatype;
		enumerationPage.enterEnumDataForADTIDT(datatype, shortname, txt, value);
		assertEquals(workspacePage.getMessage()," Enumeration created successfully.");
		//assertEquals("Current Workspace",workspacePage.checkUnresolvedEnum(shortname));
		Assert.assertTrue(true);
	}
	
	@Test(priority=3,testName="22082: To verify UDD shall allow to create Enum with Using BITMASK ",description="To verify that UDD shall allow User to create new Enumeration-Bit Mask from GR pane.",dataProviderClass=TestDataProvider.class,dataProvider="getBitmaskEnumData")
	public void createBitmaskEnum(String enumshortname ,String enumtext, String enumvalue) throws InterruptedException 
	{
		shortname=enumshortname;
		txt=enumtext;
		value=enumvalue;
		enumerationPage.enterEnumDataForBitmask(shortname, txt, value);
		assertEquals(workspacePage.getMessage()," Enumeration created successfully.");
		//assertEquals("Current Workspace",workspacePage.checkUnresolvedEnum(shortname));
		Assert.assertTrue(true);
	}
	
	*/
	
	
	

}
