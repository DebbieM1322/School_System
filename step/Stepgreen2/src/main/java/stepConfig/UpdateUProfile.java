package stepConfig;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.Locatable;



public class UpdateUProfile {

	WebDriver driver;
	protected Properties prop = new Properties();
	
	
public UpdateUProfile(WebDriver driver){
	
	this.driver=driver;
	
}

public void updateuserProf() throws IOException{
	
	FileInputStream input=new FileInputStream("config.properties");
	 prop.load(input);
	 driver.findElement(By.xpath(prop.getProperty("ico_sett"))).click();
	 driver.findElement(By.xpath(prop.getProperty("editprof"))).click();
	 driver.findElement(By.xpath(prop.getProperty("addressbtn"))).sendKeys(prop.getProperty("address"));
	 

	 JavascriptExecutor js = (JavascriptExecutor) driver;
     js.executeScript("javascript:window.scrollBy(250,350)");
     
     try {
			Thread.sleep(500);
			driver.findElement(By.xpath(prop.getProperty("saveusprof"))).click();
			js.executeScript("javascript:window.scrollBy(180,280)");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
     
     
		//element.click();
//	 driver.findElement(By.xpath(prop.getProperty("saveusprof"))).click();
	 
}

}
