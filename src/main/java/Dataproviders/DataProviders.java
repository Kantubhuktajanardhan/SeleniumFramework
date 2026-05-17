package Dataproviders;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.aventstack.chaintest.plugins.ChainTestListener;

public class DataProviders {
	

	@DataProvider(name = "Excel")
    public static Object[][] data() throws IOException {
		ChainTestListener.log("LOG:INFO - DataProvider Getting Ready For Test Data");
    	Object[][] arr= ExcelUtility.getData("Users","Data");
    	ChainTestListener.log("LOG:INFO - DataProvider Ready With Test Data");
    	return arr;
    }

}
