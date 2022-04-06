package stepPOMTestcases;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import stepConfig.SignUp;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class StepSignUp {

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
		
 
		@Test
		public void verifyValidSignup() throws IOException{ 
			
			SignUp signup= new SignUp(driver);	
			signup.signup();
			Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Δεν έχεις προσκεκληθεί σε κάποια Συζήτηση του οργανισμού Thessaloniki City. Επικοινώνησε με trond@admin.com μέσω email για να δηλώσεις συμμετοχή. "));
			
		}

		
		@AfterMethod
		public void aftertest() { 
			driver.quit(); 
			}
		
		}	
	