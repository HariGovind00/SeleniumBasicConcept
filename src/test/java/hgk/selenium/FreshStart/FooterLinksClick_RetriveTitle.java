package hgk.selenium.FreshStart;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FooterLinksClick_RetriveTitle 
{
@Test
public static void linksClickFetchTitle() throws InterruptedException
{
WebDriver driver=new ChromeDriver();
driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
driver.manage().window().maximize();
driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//scroll the page
JavascriptExecutor js=(JavascriptExecutor)driver;
js.executeScript("window.scrollTo(0, 2000)");
//Fetch all the links from the footer
List<WebElement>links=driver.findElements(By.cssSelector("#gf-BIG li"));
System.out.println("Total link present in footer is:"+links.size());
for(int i=0;i<links.size();i++)
{
	String link=links.get(i).getText();
	System.out.println(link);
	String linkClickKeys=Keys.chord(Keys.CONTROL,Keys.ENTER);
	links.get(i).findElement(By.tagName("a")).sendKeys(linkClickKeys);
}
Set<String>win=driver.getWindowHandles();
Iterator<String> itrwin=win.iterator();
 while(itrwin.hasNext())

 {
	
	 driver.switchTo().window(itrwin.next());
	 System.out.println(driver.getTitle());
	 
 }

Thread.sleep(3000);
driver.quit();
}
}
