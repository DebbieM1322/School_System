package FailedOrNotYet;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import stepConfig.Login;
import stepConfig.StartChallenge;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class StepStartChall {

	protected Properties prop = new Properties();
	protected WebDriver driver=new FirefoxDriver();
	FileInputStream input;  
		@BeforeMethod 
		public void setup () throws IOException { 
			input=new FileInputStream("config.properties");
			prop.load(input);
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url"));
			//				driver.get("http://step.green/");
			} 
		
 
////		
	 	@Test
	public void challengeTest() throws IOException{
	  
		
	 	Login login= new Login(driver);
	 	login.LOgin();
	 	login.typeUsername();
	 	login.typePassword();
	 	login.clickLoginBtn();
	 	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	 	StartChallenge start= new StartChallenge(driver);
		start.createChall();	
		Assert.assertTrue((driver.findElement(By.xpath(prop.getProperty("textarea"))).isDisplayed()));
	 	
	 }
//	 	
  
		
		@AfterSuite
		public void aftertest() { 
			driver.quit(); 
			}
		
		}	
	