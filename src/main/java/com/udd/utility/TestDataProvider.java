package com.udd.utility;

import org.testng.annotations.DataProvider;

public class TestDataProvider {
	
	
	@DataProvider
	public static Object[][] getADTEnumData()
	{
		String[][] enumADTData={{"string:AS","ENUMADT01","ENUMADT01","1"}};
		return enumADTData;
	}
	

	@DataProvider
	public static Object[][] getIDTEnumData()
	{
		String[][] enumIDTData={{"string:IS","ENUMIDT02","ENUMIDT02","1"}};
		return enumIDTData;
	}
	
	@DataProvider
	public static Object[][] getBitmaskEnumData()
	{
		String[][] enumBitmaskData={{"ENUMBitmask01","ENUMBitmask01","1"}};
		return enumBitmaskData;
	}

}
