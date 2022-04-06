package stepConfig;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreatePost {

	WebDriver driver;
	
	protected Properties prop = new Properties();
	
public CreatePost(WebDriver driver,String dat){
	
	this.driver=driver;
	
}


public void createpost() throws IOException{
	FileInputStream input=new FileInputStream("config.properties");
	 prop.load(input);
	 Random ran = new Random();
		int top = 4;
		char data = ' ';
		String dat = "";

		for (int i=0; i<=top; i++) {
		  data = (char)(ran.nextInt(25)+97);
		  dat = data + dat;
		}
		System.out.println(dat);
	 	driver.findElement(By.xpath(prop.getProperty("challenge"))).click();
		driver.findElement(By.xpath(prop.getProperty("availChal"))).click();
		driver.findElement(By.xpath(prop.getProperty("airPollution"))).click();
//		driver.findElement(By.xpath(prop.getProperty("createpostbtn"))).click();
		driver.findElement(By.xpath(prop.getProperty("orientpost"))).click();
		driver.findElement(By.xpath(prop.getProperty("textp"))).sendKeys(dat);
		driver.findElement(By.xpath(prop.getProperty("savepost"))).click();
}
}
