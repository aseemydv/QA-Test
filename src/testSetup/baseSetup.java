package testSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.CouponApiTestPage;

public class baseSetup {
	
	 private WebDriver driver;
	 String openUrl;
	 CouponApiTestPage catp1,catp2,catp3,catp4;
	  static String chromePath="E:\\Seleni-yummm\\chromeDriver\\";
	  static String iePath="E:\\Seleni-yummm\\IeDriver\\";
	  private void setBrowser(String browserName) {
		  switch(browserName){
		  case "chrome": 
			  driver=initChrome();
			  break;
		  case "firefox":
			  driver=initFirefox();
			  break;
		  case "internet explorer":
			  driver=initIE();
			  break;
		  case "safari":
			  driver=initSafari();
			  break;
		  default: 
			  System.out.println("Browser Name "+browserName+" is invalid.\nBrowser chosen: Firefox");  
		  	  driver=initFirefox();
		  	  break;
		  }
	  }
		 private static WebDriver initChrome(){
			 System.out.println("Launching Chrome...");
			 System.setProperty("webdriver.chrome.driver",chromePath+"chromedriver.exe");
			 WebDriver wd=new ChromeDriver();
			 wd.manage().window().maximize();
			 return wd;
		 }
		 private static WebDriver initFirefox(){
			 System.out.println("Launching Firefox...");		
			 WebDriver wd=new FirefoxDriver();
			 wd.manage().window().maximize();
			 return wd;
		 }
		 private static WebDriver initIE(){
			 System.out.println("Launching Internet Explorer...");
			 System.setProperty("webdriver.ie.driver",iePath+"iedriver.exe");
			 WebDriver wd=new InternetExplorerDriver();
			 wd.manage().window().maximize();
			 return wd;
		 }
		 private static WebDriver initSafari(){
			 System.out.println("Launching Safari...");		 
			 WebDriver wd=new SafariDriver();
			 wd.manage().window().maximize();
			 return wd;
		 }
	
  @Parameters({"browserName","webUrl"})
  @BeforeClass
  public void initSetup(String browserName,String webUrl) {
	  openUrl=webUrl;
	  setBrowser(browserName);
  }
  @Test(priority=3)
  public void Error404(){
	  System.out.println("Checking for 404 Error... ");
	  System.out.println("-------------------------");
	  catp1=new CouponApiTestPage(driver);
	  catp1.runTests(openUrl);
	  catp1.Err404();	  
  }
  
  @Test(priority=1)
  public void imgAltValue(){
	  System.out.println("Checking for Alternative Text on Image... ");
	  System.out.println("-----------------------------------------");
	  catp2=new CouponApiTestPage(driver);
	  catp2.runTests(openUrl);
	  catp2.altText();
  }
  
  @Test(priority=0)
  public void PageTitle(){
	  System.out.println("Checking for Page Title... ");
	  System.out.println("--------------------------");
	  catp3=new CouponApiTestPage(driver);
	  catp3.runTests(openUrl);
	  catp3.checkTitle();
  }
  
  @Test(priority=2)
  public void phpError(){
	  System.out.println("Checking for PHP Error... ");
	  System.out.println("-------------------------");
	  catp4=new CouponApiTestPage(driver);
	  catp4.runTests(openUrl);
	  catp4.PHPerr();
	  
  }
  @AfterClass
  public void tearDown() {
	  driver.quit();
  }

}