package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	By noThanks = By.xpath("//button[text()='NO THANKS']");
	By signIn = By.linkText("Login");
	By title = By.xpath("//div[@class='text-center']//h2");
	By navigation = By.xpath("//nav[@class='navbar-collapse collapse']");
	
	//life of the driver
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public LoginPage getLogin()
	{
	   driver.findElement(signIn).click();
	   LoginPage l = new LoginPage(driver);
	   return l;
	}
	
	public WebElement noThanks()
	{
		return driver.findElement(noThanks);
	}
	
	public WebElement title()
	{
		return driver.findElement(title);
	}
	
	public WebElement navigation()
	{
		return driver.findElement(navigation);
	}

}
