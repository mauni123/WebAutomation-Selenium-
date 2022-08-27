package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {
	
	public WebDriver driver;
	
	By email = By.id("user_email");
	By submit = By.xpath("//input[@value='Send Me Instruction']");
	
	public ForgotPassword(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public WebElement email()
	{
		return driver.findElement(email);
	}
	
	public WebElement submit()
	{
		return driver.findElement(submit);
	}

}
