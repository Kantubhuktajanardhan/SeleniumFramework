package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.chaintest.plugins.ChainTestListener;

import Base.BaseClass;
import Dataproviders.DataProviders;
import Pages.Dashboard;
import Pages.loginPage;

public class ApplicationLogin extends BaseClass {
    
	loginPage login;	
	Dashboard dashboard;
	
	@Test(priority = 1,dataProvider = "Excel",dataProviderClass = DataProviders.class)
	public void loginWithValidCredentials(String user,String pass)
	{
		login = new loginPage(driver);
		
		dashboard=login.loginToApplication(user,pass);
		
		ChainTestListener.log("LOG:INFO - User logged into application");
	
		Assert.assertTrue(dashboard.getWelcomeText().contains("Welcome"),"User Login Failed");
		
		ChainTestListener.log("LOG:PASS - User is able to login into application ");
		
	
	}
	
	@Test(dependsOnMethods = "loginWithValidCredentials",priority = 2)
	public void logoutFromApplication()
	{
		dashboard.logoutFromApplication();
		
		ChainTestListener.log("LOG:INFO - User logged out of application");
		
		Assert.assertTrue(login.isSignInPresent(),"Logout Failed");

	}
	
	@Test(priority = 3)
	public void verifyFooterLinks()
	{
		int count=login.footerlinkscount();
		
		Assert.assertEquals(count, 4 ,"footer links mismatched");
		ChainTestListener.log("LOG:INFO - Footer Links Count Matched");
		
	}
	
	@Test(priority = 3)
	public void verifyNewUserLinks()
	{
		boolean status=login.isSignuplinkPresent();
		
		Assert.assertTrue(status);
		
		ChainTestListener.log("LOG:INFO - New User Link Found");
		
	}

}
