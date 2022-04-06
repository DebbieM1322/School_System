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



public class EditasAnalyst {

	WebDriver driver;
	protected Properties prop = new Properties();
	
	
public EditasAnalyst(WebDriver driver){
	
	this.driver=driver;
	
}


public void typeUsername() throws IOException{
	FileInputStream input=new FileInputStream("config.properties");
	 prop.load(input);
	driver.findElement(By.xpath(prop.getProperty("usernamexpath"))).sendKeys(prop.getProperty("analystuser"));
	
}

public void typePassword() throws IOException{
	
	FileInputStream input=new FileInputStream("config.properties");
	 prop.load(input);
	driver.findElement(By.xpath(prop.getProperty("passwordxpath"))).sendKeys(prop.getProperty("pass"));
	
}

public void clickLoginBtn() throws IOException{
	
	FileInputStream input=new FileInputStream("config.properties");
	 prop.load(input);
	driver.findElement(By.xpath(prop.getProperty("login2Btnxpath"))).click();
	
}
public void LOginAsAnalyst() throws IOException{
	
	FileInputStream input=new FileInputStream("config.properties");
	 prop.load(input);
	 driver.findElement(By.xpath(prop.getProperty("selmunic"))).sendKeys(prop.getProperty("mun"));
	 WebDriverWait wait = new WebDriverWait(driver, 5);
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("thessdropd"))));
	 driver.findElement(By.xpath(prop.getProperty("selmunic"))).sendKeys(Keys.ARROW_DOWN);
	driver.findElement(By.xpath(prop.getProperty("selmunic"))).sendKeys(Keys.ENTER);
	driver.findElement(By.xpath(prop.getProperty("loginxpath"))).click();
	
}

public void editAnalystpost() throws IOException{
	
	FileInputStream input=new FileInputStream("config.properties");
	 prop.load(input);
	
	 driver.findElement(By.xpath(prop.getProperty("oldbuldi_petition"))).click();
	 driver.findElement(By.xpath(prop.getProperty("setting_post"))).click();
	 driver.findElement(By.xpath(prop.getProperty("edit"))).click();
	 driver.findElement(By.xpath(prop.getProperty("textp"))).clear();
	 driver.findElement(By.xpath(prop.getProperty("textp"))).sendKeys(prop.getProperty("posttext2"));
	 driver.findElement(By.xpath(prop.getProperty("savepost"))).click();
	
}
//public void waitforTIme(){
//	
//	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//	
//}
}
