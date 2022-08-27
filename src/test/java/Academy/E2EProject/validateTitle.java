package Academy.E2EProject;

import java.io.IOException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import pageObjects.LandingPage;
import resources.base;

public class validateTitle extends base {
	
	public WebDriver driver;
	
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver =initializeDriver();
		
		log.info("Driver is initialized");
		
        driver.get(prop.getProperty("url"));
        
        log.info("Navigated to home page");
	}
	
	@Test
	public void validateTitle() throws IOException
	{
		
		
		LandingPage lp = new LandingPage(driver);
		lp.noThanks().click();
		
		String title = lp.title().getText();
		//compare the text from the browser with actual text
		System.out.println(title);
		
		Assert.assertEquals(title, "FEATURED COURSES123");
		
		log.info("Successfully validated text message");
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}

}
