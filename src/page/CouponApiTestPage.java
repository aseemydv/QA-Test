package page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CouponApiTestPage {
	WebDriver wd;
	List<String> links=new ArrayList<String>();
	HashMap<String, String> hm=new HashMap<>();
	String PHPerr="Fatal error";
	int i=0;

  public CouponApiTestPage(WebDriver wd) {
	this.wd=wd;
  }  
  
  public void runTests(String webUrl) {
	  wd.navigate().to(webUrl);
	  List<WebElement> allLinks=wd.findElements(By.tagName("a"));
	  for (Iterator<WebElement> iterator = allLinks.iterator(); iterator.hasNext();) {
		WebElement we = (WebElement) iterator.next();
		links.add(we.getAttribute("href").toString());
		hm.put(we.getAttribute("href").toString(), we.getText());		
	  }	  
	}
  
  public void checkTitle(){
	  for(String itr:links){	  
		  wd.navigate().to(itr);		  
		  if(wd.getPageSource().contains("<title>")){
			  if((wd.findElement(By.tagName("title")).getText().length())==0){				  
				  System.out.println("No TITLE on :"+hm.get(itr));
			  }			  
		  }
		  else {			  
			  System.out.println("No TITLE TAG on :"+hm.get(itr));
		  }	  
	  }	
  }
  public void altText(){
	  for(String itr:links){
		  wd.navigate().to(itr);
		  if(wd.getPageSource().contains("img")){
			  System.out.println("IMG exists on : "+hm.get(itr));
			  if((wd.findElement(By.tagName("img")).getAttribute("alt").length())==0){				  
				  System.out.println("No ALT TEXT on :"+hm.get(itr));
			  }
		  }  
	  }	
  }
  public void Err404(){
	  for(String itr:links){
		  wd.navigate().to(itr);
		  if(wd.getTitle().contains("404")){
			  System.out.println("404 ERROR on :"+hm.get(itr));	
		  }	  
	  }	
  }
  public void PHPerr(){
	  for(String itr:links){
		  wd.navigate().to(itr);
		  if(wd.getPageSource().contains(PHPerr)){
			  System.out.println("PHP ERROR on :"+hm.get(itr));
		  }	  
	  }	
  }
  
}

