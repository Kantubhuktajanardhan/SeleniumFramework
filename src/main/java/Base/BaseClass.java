package Base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.aventstack.chaintest.plugins.ChainTestListener;

import Dataproviders.ConfigUtility;
import Factory.BrowserFactory;

public class BaseClass {
  
	public WebDriver driver;
	
	@BeforeClass
	public void setup()
	{	
		ChainTestListener.log("LOG:INFO - Setting up browser");
		driver=BrowserFactory.startBrowser(ConfigUtility.readProperty("Browser"), ConfigUtility.readProperty("qaenv"));		
	}
	
	@AfterClass
	public void tearDown()
	{	 		
		ChainTestListener.log("LOG:INFO - Closing the browser");
		driver.quit();
	}
}
