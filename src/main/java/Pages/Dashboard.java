package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dashboard {
	
	WebDriver driver;
	public Dashboard(WebDriver driver)
	{
		this.driver=driver;
	}
	
    By menu=By.xpath("//img[@alt='menu']");
	
	By signout=By.xpath("//button[normalize-space()='Sign out']");
	
	By welcomeMsg=By.xpath("//h4");
	
	public String getWelcomeText()
	{
		String msg=driver.findElement(welcomeMsg).getText();
		
		return msg;
	}
		
	public void logoutFromApplication()
	{
		driver.findElement(menu).click();
		
		driver.findElement(signout).click();
	}

}
