package FailedOrNotYet;
//package stepPOMTestcases;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//import stepConfig.Login;
//import stepConfig.LoginWithoutAccount;
//import stepConfig.LoginWrongEmail;
//import stepConfig.LoginWrongPass;
//import stepConfig.Logout;
//import stepConfig.Search;
//import stepConfig.ClickLogo;
//import stepConfig.CreatePost;
//import stepConfig.DownloadApp;
//import stepConfig.ForgotPassword;
//import stepConfig.ForgotPasswordWrong;
//import stepConfig.JoinChallenge;
//import stepConfig.StartChallenge;
//import stepConfig.SignUp;
//import stepConfig.SignUpPassLess6;
//import stepConfig.SignUpSamemail;
//import stepConfig.SignUpWithoutAgree;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.Properties;
//import java.util.concurrent.TimeUnit;
//
//import org.junit.Assert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//
//public class StepAllInOne {
//
//	protected Properties prop = new Properties();
//	protected WebDriver driver=new FirefoxDriver();
//	FileInputStream input;  
//		@BeforeMethod 
//		public void setup () throws IOException { 
//			input=new FileInputStream("config.properties");
//			prop.load(input);
//			driver.manage().window().maximize();
////			driver.get("url");
//			driver.get("http://step.green/");
//			} 
//		
////  //passed
//////		@Test
//////		public void verifyValidLogin() throws IOException{
//////		
//////			Login login= new Login(driver);
//////			login.LOgin();
//////			login.typeUsername();
//////			login.typePassword();
//////			login.clickLoginBtn();
//////			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//////			Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Select any of the challenges below to start your participation"));
//////			//login.waitforTIme();
//////			Logout logout= new Logout(driver);
//////			logout.clickLogout();
//////			Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Ο λόγος σου, η δύναμη του τόπου σου!"));
//////		
//////		}
//////		
////		
//		
//	  
////		@Test
////		public void verifyLoginwithoutaccount() throws IOException{
////		
////			LoginWithoutAccount login= new LoginWithoutAccount(driver);
////			login.LOgin();
////			login.typeUsername();
////			login.typePassword();
////			login.clickLoginBtn();
////			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
////			Assert.assertTrue(driver.findElement(By.xpath(prop.getProperty("loginpane"))).isDisplayed());
////			//login.waitforTIme();
////		
////			
////		}
////	  
////		@Test
////		public void verifyLoginwrongEmail () throws IOException{
////			
////			LoginWrongEmail loginwrong=new LoginWrongEmail(driver);
////			loginwrong.LOgin();
////			loginwrong.typeUsername();
////			loginwrong.typePassword();
////			loginwrong.clickLoginBtn();
////			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
////			Assert.assertTrue(driver.findElement(By.xpath(prop.getProperty("loginpane"))).isDisplayed());		
////		}
//////	  
////		@Test	
////		public void verifyLoginwrongPass () throws IOException{
////			
////			LoginWrongPass loginwrong=new LoginWrongPass(driver);
////			loginwrong.LOgin();
////			loginwrong.typeUsername();
////			loginwrong.typePassword();
////			loginwrong.clickLoginBtn();
////			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
////			Assert.assertTrue(driver.findElement(By.xpath(prop.getProperty("loginpane"))).isDisplayed());
////		}
////	
////		
////		
////	  
////		@Test
////		public void verifyValidSignup() throws IOException{ 
////			
////			SignUp signup= new SignUp(driver);	
////			signup.signup();
////			Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Δεν έχεις προσκεκληθεί σε κάποια Συζήτηση του οργανισμού Thessaloniki City. Επικοινώνησε με trond@admin.com μέσω email για να δηλώσεις συμμετοχή. "));
////			
////		}
////	//	
//////  	///passed
////		@Test
////		public void verifySignupLess6() throws IOException{
//// 
////		
////			SignUpPassLess6 signup= new SignUpPassLess6(driver);	
////			signup.signup();
////			Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Συμπλήρωσε τα στοιχεία σου:"));
////		
////		}	
//////	
////		////passed alla den deixnei oti to mail einai idio
////		@Test
////		public void verifySignupSamemail() throws IOException{
//// 
////		
////			SignUpSamemail signup= new SignUpSamemail(driver);	
////			signup.signup();
////			Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Συμπλήρωσε τα στοιχεία σου:"));
////		
////		}
////		
////
////		//passed  	
////		@Test
////		public void verifySignupWihoutAgree() throws IOException{
//// 
////		
////			SignUpWithoutAgree signup= new SignUpWithoutAgree(driver);	
////			signup.signup();
////			Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Συμπλήρωσε τα στοιχεία σου:"));
////		
////		}	
//	
////	
//		//passed	
//		@Test
//		public void forgotPassword () throws IOException{
//		
//			ForgotPassword forgot= new ForgotPassword(driver);
//			forgot.forgotpass();
////			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//			WebDriverWait wait = new WebDriverWait(driver, 5);
//			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("loginpane"))));
//			Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Συνδέσου για να συνεχίσεις"));
//		}
//	
//		
////  //passed
//		@Test
//		public void forgotPasswordWrong () throws IOException{
//		
//			ForgotPasswordWrong forgot= new ForgotPasswordWrong(driver);
//			forgot.forgotpass();
//			Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Forgot password"));
//	
//		}
//		
//  
//////		
////	 	@Test
////	public void challengeTest() throws IOException{
////	  
////		
////	 	Login login= new Login(driver);
////	 	login.LOgin();
////	 	login.typeUsername();
////	 	login.typePassword();
////	 	login.clickLoginBtn();
////	 	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
////	 	StartChallenge start= new StartChallenge(driver);
////		start.createChall();	
////		Assert.assertTrue((driver.findElement(By.xpath(prop.getProperty("textarea"))).isDisplayed()));
////	 	
////	 }
////	 	
//  //passed
////		@Test
////	public void joinChal() throws IOException{
////				
////		Login login= new Login(driver);
////	 	login.LOgin();
////	 	login.typeUsername();
////	 	login.typePassword();
////	 	login.clickLoginBtn();
////	 	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
////	 	Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Select any of the challenges below to start your participation"));
////	 	JoinChallenge join= new JoinChallenge(driver); 
////	 	join.join();
////	 	//assert true otan vriskei to leave challenge  
////		Assert.assertTrue((driver.findElement(By.xpath(prop.getProperty("leavechall"))).isDisplayed()));
////		Logout logout= new Logout(driver);
////		logout.clickLogout();
////		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Ο λόγος σου, η δύναμη του τόπου σου!"));
////	
////	 }
////		
//
////		//This site can’t be reached	
////		@Test
////		public void clicklogo () throws IOException
////		{
////		ClickLogo logo = new ClickLogo(driver);
////		logo.clicklogo();
////		//http://step4you.eu/
////	//	 Assert.assertEquals("", driver.getTitle());
////		//http://step4you.eu/
////		}
////	
//		
////		
////  //passed
////		@Test
////		public void search() throws IOException{
////			
////			Login login= new Login(driver);
////			login.LOgin();
////			login.typeUsername();
////			login.typePassword();
////			login.clickLoginBtn();
////			driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
////			Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Select any of the challenges below to start your participation"));
////			
////			Search search = new Search(driver);
////			search.search();
////			Assert.assertTrue(driver.findElement(By.xpath(prop.getProperty("searchresults"))).isDisplayed());				
////		
////			Logout logout= new Logout(driver);
////			logout.clickLogout();
////			Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Ο λόγος σου, η δύναμη του τόπου σου!"));
////		
////		}
////		
////	//done
////		@Test
////	public void createPost() throws IOException{
////		
////		Login login= new Login(driver);
////		login.LOgin();
////		login.typeUsername();
////		login.typePassword();
////		login.clickLoginBtn();
////		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
////		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Select any of the challenges below to start your participation"));
////		
////		CreatePost createp= new CreatePost(driver);
////		createp.createpost();
////		Assert.assertTrue(driver.findElement(By.xpath(prop.getProperty("posts"))).getText().contains(prop.getProperty("postText")));
//////		
////		
////	}
//		
////		@AfterSuite
////		public void aftertest() { 
////			driver.quit(); 
////			}
//		
//		}	
//	