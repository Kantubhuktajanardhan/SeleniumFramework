package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
	
	WebDriver driver;
	
	public loginPage(WebDriver driver)
	{
	   this.driver=driver;
	}
	
	By email=By.xpath("//input[@id='email1']");  
	By password=By.xpath("//input[@id='password1']");
	By signInButton=By.xpath("//button[contains(text(),'Sign in')]");
	By footerlinks=By.xpath("//div[contains(@class,'footer')]//a");
	By SignIn=By.xpath("//h2[text()='Sign In']");
	By Signuplink=By.xpath("//a[contains(text(),'Signup')]");
	
	public boolean isSignInPresent()
	{
		return driver.findElement(SignIn).isDisplayed();
	}
	
	public int footerlinkscount()
	{
		return driver.findElements(footerlinks).size();
	}
	
	public boolean isSignuplinkPresent()
	{
		return driver.findElement(Signuplink).isDisplayed();
	}
	
	public Dashboard loginToApplication(String username,String pwd)
	{
		driver.findElement(email).sendKeys(username);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signInButton).click();
		
		Dashboard dashboard=new Dashboard(driver);
		
		return dashboard;
	}
	

}
