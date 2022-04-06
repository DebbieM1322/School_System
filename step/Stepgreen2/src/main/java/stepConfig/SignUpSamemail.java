package stepConfig;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpSamemail {

	WebDriver driver;
	protected Properties prop = new Properties();
	    

public SignUpSamemail(WebDriver driver){
	
	this.driver=driver;
	
}

public void signup() throws IOException{
	
	 FileInputStream input=new FileInputStream("config.properties");
		 prop.load(input);

		 driver.findElement(By.xpath(prop.getProperty("selmunic"))).sendKeys(prop.getProperty("mun"));
		 WebDriverWait wait = new WebDriverWait(driver, 5);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("thessdropd"))));
		 driver.findElement(By.xpath(prop.getProperty("selmunic"))).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath(prop.getProperty("selmunic"))).sendKeys(Keys.ENTER);
	driver.findElement(By.xpath(prop.getProperty("signupBtn"))).click();
	driver.findElement(By.xpath(prop.getProperty("name"))).sendKeys((prop.getProperty("fname")));
	driver.findElement((By.xpath(prop.getProperty("surname")))).sendKeys(((prop.getProperty("lname"))));
	driver.findElement((By.xpath(prop.getProperty("email")))).sendKeys(((prop.getProperty("uid"))));
	driver.findElement(By.xpath(prop.getProperty("postaladdr"))).sendKeys((prop.getProperty("postal")));
	driver.findElement(By.xpath(prop.getProperty("zipcode"))).sendKeys((prop.getProperty("zip")));
	driver.findElement((By.xpath(prop.getProperty("agr_terms")))).click();
	driver.findElement((By.xpath(prop.getProperty("password")))).sendKeys(((prop.getProperty("pass"))));
	driver.findElement((By.xpath(prop.getProperty("confirmpassword")))).sendKeys(((prop.getProperty("pass"))));
	driver.findElement((By.xpath(prop.getProperty("savebtn")))).click();
	
}

}
