package stepConfig;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;




public class EditPost {

	WebDriver driver;
	protected Properties prop = new Properties();
	
	
public EditPost(WebDriver driver,String dat){
	
	this.driver=driver;
	
}
public void findPetition() throws IOException, AWTException{
	
	FileInputStream input=new FileInputStream("config.properties");
	 prop.load(input);
		driver.findElement(By.xpath(prop.getProperty("challenge"))).click();
		driver.findElement(By.xpath(prop.getProperty("availChal"))).click();
		driver.findElement(By.xpath(prop.getProperty("airPollution"))).click();
	


	 
}
public void editpost() throws IOException{
	
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
		
		driver.findElement(By.xpath(prop.getProperty("setting_post"))).click();
		driver.findElement(By.xpath(prop.getProperty("edit"))).click();
		driver.findElement(By.xpath(prop.getProperty("textp"))).clear();
		driver.findElement(By.xpath(prop.getProperty("textp"))).sendKeys(dat);
		driver.findElement(By.xpath(prop.getProperty("savepost"))).click();
	 
}

}
