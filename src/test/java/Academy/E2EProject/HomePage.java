package Academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base{
	
	public WebDriver driver;
	
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver =initializeDriver();
        
	}
	
	@Test(dataProvider="testData")
	public void basePageNavigation(String username, String password) throws IOException
	{
		
		driver.get(prop.getProperty("url"));
		//LandingPage object
		LandingPage lp = new LandingPage(driver);
		
		try {
		if(lp.noThanks().isDisplayed())
			lp.noThanks().click();
		}catch(Exception e){}
		
		
		
		
		LoginPage l = lp.getLogin();
		
		
		l.getEmail().sendKeys(username);
		l.getPassword().sendKeys(password);
		l.login().click();
		
		ForgotPassword fp = l.forgotPassword();
		
		fp.email().sendKeys("xxx");
		fp.submit().click();
		
		log.info("Successfull validation");
	}
	
	@DataProvider(name="testData")
	public Object[][] getData()
	{
		//Row stand for how many different data types should run
		//Columns stands for how many values per each test
		Object[][] data = new Object[2][2];
		
		data[0][0] = "nonrestricteduser.com";
        data[0][1] = "23454";
        
        data[1][0] = "restricteduser.com";
        data[1][1] = "345243";
        
        return data;
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}

}
