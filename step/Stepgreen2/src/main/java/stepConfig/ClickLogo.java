package stepConfig;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class ClickLogo {

	WebDriver driver;
	protected Properties prop = new Properties();
	
	
public ClickLogo(WebDriver driver){
	
	this.driver=driver;
	
}

public void clicklogo() throws IOException{
	
	FileInputStream input=new FileInputStream("config.properties");
	 prop.load(input);
	 driver.findElement(By.xpath(prop.getProperty("selmunic"))).sendKeys(prop.getProperty("mun"));
	 WebDriverWait wait = new WebDriverWait(driver, 5);
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("thessdropd"))));
	 driver.findElement(By.xpath(prop.getProperty("selmunic"))).sendKeys(Keys.ARROW_DOWN);
	driver.findElement(By.xpath(prop.getProperty("selmunic"))).sendKeys(Keys.ENTER);
	driver.findElement(By.xpath(prop.getProperty("logo"))).click();
}

}
