package stepPOMTestcases;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import stepConfig.SignUpPassLess6;
import stepConfig.SignUpSamemail;
import stepConfig.SignUpWithoutAgree;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class StepSignUpWrong {

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
		
 
	//	
//  	///passed
		@Test
		public void verifySignupLess6() throws IOException{
 
		
			SignUpPassLess6 signup= new SignUpPassLess6(driver);	
			signup.signup();
			Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Συμπλήρωσε τα στοιχεία σου:"));
		
		}	
//	
		////passed alla den deixnei oti to mail einai idio
		@Test
		public void verifySignupSamemail() throws IOException{
 
		
			SignUpSamemail signup= new SignUpSamemail(driver);	
			signup.signup();
			Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Συμπλήρωσε τα στοιχεία σου:"));
		
		}
		

		//passed  	
		@Test
		public void verifySignupWihoutAgree() throws IOException{
 
		
			SignUpWithoutAgree signup= new SignUpWithoutAgree(driver);	
			signup.signup();
			Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Συμπλήρωσε τα στοιχεία σου:"));
		
		}	
	
//	
		
		@AfterSuite
		public void aftertest() { 
			driver.quit(); 
			}
		
		}	
	