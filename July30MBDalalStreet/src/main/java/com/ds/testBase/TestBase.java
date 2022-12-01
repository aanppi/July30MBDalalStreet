package com.ds.testBase;

import java.time.Duration;
import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.ds.pageLayer.LoginPage;



import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
       public static WebDriver driver; 
       public Logger logger;
	   public LoginPage login;
	   

     @BeforeClass
     
     public void start()
     {
    	  logger=Logger.getLogger("DalalStreet Auto framework");
    	 PropertyConfigurator.configure("log4j.properties");
    	 
    	 logger.info("framework execution started");
     }
     
     @AfterClass
     public void end()
     {
    	 logger.info("framework execution completed");
     }
      
	 @BeforeMethod  
	public void setUp() throws InterruptedException {
		String br="Chrome";
		 
		if(br.equalsIgnoreCase("chrome")) {
		    WebDriverManager.chromedriver().setup();
		   driver= new ChromeDriver();
		}
		else if(br.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(br.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
		  driver=  new EdgeDriver();
		}
		else {
			System.out.println("Enter a browser name");
		}
		
		driver.get("https://apps.dalalstreet.ai/login");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		logger.info("url launched,maximized,deleted cookies,implicitly waited");
		
		
		//---------object creation--------
		
		login=new LoginPage(); 
		
		logger.info("Object created");

		
		
		//-----------Login Functionality---------
		
		login.enterEmail("amarwaghmare573@gmail.com");
		login.enterPassword("Test@1234");
		login.clickOnLoginButton();
		Thread.sleep(5000);
		logger.info("login successfully");
		
	}

	 
	 

	// @AfterMethod
	 //public void tearDown() {
		// driver.quit();
	 //}
}
