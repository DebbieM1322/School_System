package stepConfig;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class StartChallenge {

	WebDriver driver;
	protected Properties prop = new Properties();
	
	
	
public StartChallenge(WebDriver driver){
	
	this.driver=driver;
	
}


public void createChall() throws IOException{
	
	FileInputStream input=new FileInputStream("config.properties");
	prop.load(input);
	 
	driver.findElement(By.xpath(prop.getProperty("challengeicon"))).click();
	driver.findElement(By.xpath(prop.getProperty("startchallenge"))).click();
	driver.findElement(By.xpath(prop.getProperty("trensponding"))).click();
	driver.findElement(By.xpath(prop.getProperty("title"))).sendKeys(prop.getProperty("chaltitle"));
	driver.findElement(By.xpath(prop.getProperty("describechal"))).sendKeys(prop.getProperty("chalpurpose"));
	driver.findElement(By.xpath(prop.getProperty("describemotiv"))).sendKeys(prop.getProperty("chalmotiv"));
//selects current date
//	driver.findElement(By.xpath(prop.getProperty("current_day"))).click();
	driver.findElement(By.xpath(prop.getProperty("done"))).click();
	
}

//public void slectChall() throws IOException{
//	FileInputStream input=new FileInputStream("config.properties");
//	 prop.load(input);
//	driver.findElement(By.xpath(prop.getProperty("challenge"))).click();
//	
//	 List<WebElement> rows=datepicker.findElements(By.tagName("tr"));  
//		List<WebElement> columns=datepicker.findElements(By.tagName("td"));
// 
//	    
//	for (WebElement cell: columns){  
//	//Select 20th Date   
//	if (cell.getText().equals("20")){  
//	cell.findElement(By.linkText("20")).click();  
//	break;  
//	 }  
//	}   
//	                   }
//	
//	driver.findElement(By.xpath(prop.getProperty("selyourChallenge"))).click();
//	driver.findElement(By.xpath(prop.getProperty("like"))).click();
//	
//}



}
