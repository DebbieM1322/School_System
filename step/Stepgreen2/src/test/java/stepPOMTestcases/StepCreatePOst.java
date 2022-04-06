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
import stepConfig.DeletePost;
import stepConfig.DownloadApp;
import stepConfig.ForgotPassword;
import stepConfig.ForgotPasswordWrong;
import stepConfig.JoinChallenge;
import stepConfig.StartChallenge;
import stepConfig.SignUp;
import stepConfig.SignUpPassLess6;
import stepConfig.SignUpSamemail;
import stepConfig.SignUpWithoutAgree;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class StepCreatePOst {

	protected Properties prop = new Properties();
	protected WebDriver driver=new FirefoxDriver();
	String dat = new String();
	FileInputStream input;  
		@BeforeMethod 
		public void setup () throws IOException { 
			input=new FileInputStream("config.properties");
			prop.load(input);
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url"));
			} 
		
 
//		
//	//done
		@Test
	public void createPost() throws IOException, AWTException{
		
		Login login= new Login(driver);
		login.LOgin();
		login.typeUsername();
		login.typePassword();
		login.clickLoginBtn();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Select any of the challenges below to start your participation"));
		
		CreatePost createp= new CreatePost(driver,dat);
		createp.createpost();
		Assert.assertTrue(driver.findElement(By.xpath(prop.getProperty("posts"))).getText().contains(dat));
		
		DeletePost delete= new DeletePost(driver);
		delete.deletePost();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 WebElement herbBtn = driver.findElement(By.linkText(dat));
	     Assert.assertEquals(true, !(herbBtn.isDisplayed()));
		
	}
		
		@AfterMethod
		public void aftertest() { 
			driver.quit(); 
			}
		
		}	
	