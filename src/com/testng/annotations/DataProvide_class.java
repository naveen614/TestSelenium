package com.testng.annotations;

import org.testng.annotations.DataProvider;

public class DataProvide_class {
	
	@DataProvider(name="TestData")//Data provider name
	
	
	//Dataprovider method name
	public static Object[][] getData(){
	
		return new Object[][]{
				//Number of rows will indicate to how many times the test should be run
				
				//Number of collumns will indicate what are the data types we are passing
				{"nqatest_gvinay24", "netzero"},
		
				{"nqatest_gvinay25", "netzero"},
				{"nqatest_gvinay32", "netzero"},
				{"nqatest_gvinay5", "netzero1"}
			
		};
		
	}

}
