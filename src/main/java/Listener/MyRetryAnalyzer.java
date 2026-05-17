package Listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import Dataproviders.ConfigUtility;

public class MyRetryAnalyzer implements IRetryAnalyzer {

  private int retryCount = 0;
  private static final int maxRetryCount =Integer.parseInt(ConfigUtility.readProperty("retry"));

  @Override
  public boolean retry(ITestResult result) {
    if (retryCount < maxRetryCount) {
      retryCount++;
      return true;
    }
    return false;
  }
}