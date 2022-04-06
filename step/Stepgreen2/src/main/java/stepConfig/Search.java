package stepConfig;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class Search {

	WebDriver driver;
	protected Properties prop = new Properties();
	
	
public Search(WebDriver driver){
	
	this.driver=driver;
	
}

public void search() throws IOException{
	
	FileInputStream input=new FileInputStream("config.properties");
	 prop.load(input);
	driver.findElement(By.xpath(prop.getProperty("searchtext"))).sendKeys(prop.getProperty("search"));
	driver.findElement(By.xpath(prop.getProperty("searchbtn"))).click();
}

}
