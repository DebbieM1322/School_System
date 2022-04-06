package stepConfig;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class DeletePost {

	WebDriver driver;
	protected Properties prop = new Properties();
	
	
public DeletePost(WebDriver driver){
	
	this.driver=driver;
	
}

public void findPetition() throws IOException, AWTException{
	
	FileInputStream input=new FileInputStream("config.properties");
	 prop.load(input);
		driver.findElement(By.xpath(prop.getProperty("challenge"))).click();
		driver.findElement(By.xpath(prop.getProperty("availChal"))).click();
		driver.findElement(By.xpath(prop.getProperty("airPollution"))).click();
	


	 
}
public void deletePost() throws IOException, AWTException{
	
	FileInputStream input=new FileInputStream("config.properties");
	 prop.load(input);
	 driver.findElement(By.xpath(prop.getProperty("setting_post"))).click();
	 driver.findElement(By.xpath(prop.getProperty("delete"))).click();
	 
	 //gia click enter sto pop up
	WebDriverWait driverw= new WebDriverWait(driver,10);
	driverw.until(ExpectedConditions.alertIsPresent());
	 driver.switchTo().alert().accept();


	 
}

}
