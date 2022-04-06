package stepConfig;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JoinChallenge {

	WebDriver driver;
	
	protected Properties prop = new Properties();
	
public JoinChallenge(WebDriver driver){
	
	this.driver=driver;
	
}


public void join() throws IOException{
	FileInputStream input=new FileInputStream("config.properties");
	 prop.load(input);
	 
	 	driver.findElement(By.xpath(prop.getProperty("challenge"))).click();
		driver.findElement(By.xpath(prop.getProperty("availChal"))).click();
		driver.findElement(By.xpath(prop.getProperty("airPollution"))).click();

//	WebElement element = driver.findElement(By.xpath(prop.getProperty("chal1")));
//	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//	try {
//		Thread.sleep(500);
//		element.click();
//	} catch (InterruptedException e) {
//		e.printStackTrace();
//	} 
//	element.click();
driver.findElement(By.xpath(prop.getProperty("join"))).click();
//}
}
}
