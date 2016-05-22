package using_ng;

import static org.testng.AssertJUnit.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.webdriven.commands.Click;

public class NewTest {
  WebDriver dr;
  //@BeforeTest
  @Test
  public void testW3Table() {
//	  System.setProperty("webdriver.chrome.driver","E:\\Seleni-yummm\\chromeDriver\\chromedriver.exe");
//	  WebDriver dr=new ChromeDriver();
	  WebDriver dr=new FirefoxDriver();
	  dr.get("http://www.w3schools.com/html/html_tables.asp");
	  dr.manage().window().maximize();
	  WebDriverWait wait=new WebDriverWait(dr, 20);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("chapter")));
//	  System.out.println(dr);
//	  System.out.println(dr.getPageSource());
	  System.out.println(dr.findElement(By.partialLinkText("Previous")));
	  WebElement next=dr.findElement(By.partialLinkText("Next Chapter"));
	  String nmsg=next.getText();
	  System.out.println(nmsg);
	  assertTrue(nmsg.contains("Chapter"));
	  WebElement tab=dr.findElement(By.className("w3-table-all"));
	  List<WebElement> rows=tab.findElements(By.tagName("tr"));	  
//	  assertEquals(5,rows.size());
	  for(WebElement data:rows){
		  List<WebElement> cols=data.findElements(By.tagName("td"));
		  for(WebElement col:cols){
			  System.out.println(col.getText()+"\t");
		  }
		  System.out.println();
	  }

	  Actions anyvar=new Actions(dr);
	  anyvar.click(rows.get(1)).keyDown(Keys.CONTROL).click(rows.get(3)).keyUp(Keys.CONTROL).build().perform();
	  dr.close();
  }

  
}
