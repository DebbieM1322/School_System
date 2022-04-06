package stepConfig;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//store all locator and methods
public class Logout {

	WebDriver driver;
	protected Properties prop = new Properties();

public Logout(WebDriver driver){
	
	this.driver=driver;
	
}

public void clickLogout() throws IOException{
	
	FileInputStream input=new FileInputStream("config.properties");
	 prop.load(input);

	driver.findElement(By.xpath(prop.getProperty("ico_sett"))).click();
	driver.findElement(By.xpath(prop.getProperty("logout"))).click();
	
}

}
