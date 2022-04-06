package stepPOMTestcases;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import stepConfig.Login;
import stepConfig.EditPost;
import stepConfig.EditasAnalyst;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class EditAnalystPost {

	protected Properties prop = new Properties();
	protected WebDriver driver=new FirefoxDriver();
	FileInputStream input;  
		@BeforeMethod 
		public void setup () throws IOException { 
			input=new FileInputStream("config.properties");
			prop.load(input);
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url"));
		//	driver.get("http://step.green/");
			} 
		
 
//		
//	//done
		@Test
	public void editAnalystPost() throws IOException{
		
		EditasAnalyst editan= new EditasAnalyst(driver);
		editan.LOginAsAnalyst();
		editan.typeUsername();
		editan.typePassword();
		editan.clickLoginBtn();
		editan.editAnalystpost();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertTrue(driver.findElement(By.xpath(prop.getProperty("posts"))).getText().contains(prop.getProperty("posttext2")));
//		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
		
		@AfterMethod
		public void aftertest() { 
			driver.quit(); 
			}
		
		}	
	