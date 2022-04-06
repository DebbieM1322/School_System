package stepConfig;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class DownloadApp {

	WebDriver driver;
	protected Properties prop = new Properties();
	
	
public DownloadApp(WebDriver driver){
	
	this.driver=driver;
	
}


public void downloadappstore () throws IOException{
	
	FileInputStream input=new FileInputStream("config.properties");
	 prop.load(input);
	driver.findElement(By.xpath(prop.getProperty("downlapp"))).click();
	driver.findElement(By.xpath(prop.getProperty("appstore"))).click();
}

public void downloadwindowsapp () throws IOException{
	
	FileInputStream input=new FileInputStream("config.properties");
	 prop.load(input);
	driver.findElement(By.xpath(prop.getProperty("downlapp"))).click();
	driver.findElement(By.xpath(prop.getProperty("windowsstore"))).click();
}

public void downloadgoogleplay() throws IOException{
	
	FileInputStream input=new FileInputStream("config.properties");
	 prop.load(input);
	driver.findElement(By.xpath(prop.getProperty("downlapp"))).click();
	driver.findElement(By.xpath(prop.getProperty("googleplay"))).click();
}
}
