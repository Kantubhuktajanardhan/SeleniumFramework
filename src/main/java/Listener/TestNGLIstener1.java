package Listener;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.chaintest.plugins.ChainTestListener;

import Factory.BrowserFactory;
import helper.Utility;

public class TestNGLIstener1 implements ITestListener {
   
	public void onTestSuccess(ITestResult result) 
	 {	    
		 ChainTestListener.log("LOG:PASS - Testcase Passed");
		 
	 }
	 public void onTestFailure(ITestResult result) 
	 {
		 		 
		 String screenshot=Utility.captureScreenshot(BrowserFactory.getDriver());		 
		 ChainTestListener.embed(screenshot, "image/png");
		 ChainTestListener.log("LOG:FAIL - Testcase Failed "+result.getMethod().getMethodName()+" "+result.getThrowable().getMessage());
		 
	 }
	 
	 public void onTestSkipped(ITestResult result) 
	 {
		 ChainTestListener.log("LOG:SKIPPED - Test Skipped "+result.getMethod().getMethodName());

	 }
}
