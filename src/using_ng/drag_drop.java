package using_ng;

import static org.testng.AssertJUnit.assertTrue;
import static org.testng.AssertJUnit.assertArrayEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class drag_drop {
	@Test
	public void radioCheck() throws InterruptedException{
		WindowsUtils.tryToKillByName("firefox.exe");		
		WebDriver wd=new FirefoxDriver();
		wd.manage().window().maximize();
		wd.get("http://toolsqa.com/automation-practice-form/");
		WebElement chk2=wd.findElement(By.id("sex-1"));
		List<WebElement> chk=wd.findElements(By.name("exp"));

		if(!chk2.isSelected())
			chk2.click();
		
		
		boolean sel=chk.get(1).isSelected();
		if(sel==false){
			chk.get(0).click();
		}
//		assertTrue(chk.isSelected());
		Thread.sleep(3000);
		wd.close();
	}
	/*@Test
	public void arrCheck() {
		List<String> bef_chk=Arrays.asList(new String[]{"red","green","blue"});
		List<String> aft_chk=new ArrayList<String>();
		aft_chk.add("red");
		aft_chk.add("blue");
		aft_chk.add("green");
		assertArrayEquals(bef_chk.toArray(),aft_chk.toArray());
	}*/
  /*@Test
  public void f() {
	  WebDriver wd=new FirefoxDriver();
	  wd.manage().window().maximize();
	  wd.get("http://html5demos.com/drag");
	  WebElement src=wd.findElement(By.id("one"));
	  WebElement dest=wd.findElement(By.id("bin"));
	  Actions act=new Actions(wd);
	  act.dragAndDrop(src, dest).perform();
  }*/
}
