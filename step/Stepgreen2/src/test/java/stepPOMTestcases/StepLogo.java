package stepPOMTestcases;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import stepConfig.Login;
import stepConfig.LoginWithoutAccount;
import stepConfig.LoginWrongEmail;
import stepConfig.LoginWrongPass;
import stepConfig.Logout;
import stepConfig.Search;
import stepConfig.ClickLogo;
import stepConfig.CreatePost;
import stepConfig.DownloadApp;
import stepConfig.ForgotPassword;
import stepConfig.ForgotPasswordWrong;
import stepConfig.JoinChallenge;
import stepConfig.StartChallenge;
import stepConfig.SignUp;
import stepConfig.SignUpPassLess6;
import stepConfig.SignUpSamemail;
import stepConfig.SignUpWithoutAgree;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class StepLogo {

	protected Properties prop = new Properties();
	protected WebDriver driver=new FirefoxDriver();
	FileInputStream input;  
		@BeforeMethod 
		public void setup () throws IOException { 
			input=new FileInputStream("config.properties");
			prop.load(input);
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url"));
			
			} 
		
 

		//This site can’t be reached	
		@Test
		public void clicklogo () throws IOException
		{
		ClickLogo logo = new ClickLogo(driver);
		logo.clicklogo();
		String parentWindow = driver.getWindowHandle();
		Set<String> handles =  driver.getWindowHandles();
		   for(String windowHandle  : handles)
		       {
		       if(!windowHandle.equals(parentWindow))
		          {
		          driver.switchTo().window(windowHandle);
		          
//		         <!--Perform your operation here for new window-->
		          
		         		String Actualtext = driver.getCurrentUrl();
		  		Assert.assertEquals(Actualtext, "http://www.thessaloniki.gr/portal/page/portal/DimosThessalonikis" );
		  		System.out.println("URL matching --> Part executed");
		          
		         driver.close(); //closing child window
		         driver.switchTo().window(parentWindow); //cntrl to parent window
		          }
		       }
		
		
//		String Actualtext = driver.getCurrentUrl();
//		Assert.assertEquals(Actualtext, "http://www.thessaloniki.gr/" );
//		System.out.println("URL matching --> Part executed");
		//http://step4you.eu/
	//	 Assert.assertEquals("", driver.getTitle());
		//http://step4you.eu/
		}
//	
		

		
		@AfterMethod
		public void aftertest() { 
			driver.quit(); 
			}
		
		}	
	