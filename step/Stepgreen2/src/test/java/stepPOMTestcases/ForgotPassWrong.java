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
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ForgotPassWrong {

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
	
		
//  //passed
		@Test
		public void forgotPasswordWrong () throws IOException{
		
			ForgotPasswordWrong forgot= new ForgotPasswordWrong(driver);
			forgot.forgotpass();
			Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Forgot password"));
	
		}
		

		
		@AfterMethod
		public void aftertest() { 
			driver.quit(); 
			}
		
		}	
	