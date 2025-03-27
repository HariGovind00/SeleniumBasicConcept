package hgk.selenium.FreshStart;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class GetURLData
{
public static void main(String[] args)
{
WebDriver driver=new EdgeDriver();
driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
driver.manage().window().maximize();
driver.get("https://rahulshettyacademy.com/AutomationPractice/");
String getURL=driver.getCurrentUrl();
System.out.println(getURL);
Actions ac=new Actions(driver);
ac.moveToElement(driver.findElement(By.id("mousehover"))).click().moveToElement(driver.findElement(By.cssSelector("a[href='#top']"))).click().build().perform();
String updatedURL=driver.getCurrentUrl().split("#")[1].trim();
System.out.println("Fetched URL after Split is:"+updatedURL);
driver.close();


}
}
