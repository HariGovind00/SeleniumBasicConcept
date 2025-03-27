package hgk.selenium.FreshStart;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import hgk.selenium.BrowserInit.BrowserLoad;

public class ActionsMoverHover extends BrowserLoad
{
ActionsMoverHover() 
{
	super();
}


@Test(enabled = false)
public static void AmazonMouseHover() throws InterruptedException
{
	
	browser();
	System.out.println("Starting Action Mover Hover script loading...");
	driver.get("https://www.amazon.in/");
	WebElement language=driver.findElement(By.className("icp-nav-link-inner"));
	Actions act=new Actions(driver);
	act.moveToElement(language).sendKeys(Keys.ENTER).build().perform();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[contains(@href,'hi_IN')]")).click();
	
}
@Test
public static void accountLogin() throws InterruptedException
{
	browser();
	driver.get("https://www.flipkart.com/");
	Actions action=new Actions(driver);
	//WebElement signIn=driver.findElement(By.id("nav-link-accountList"));
	WebElement electronic=driver.findElement(By.xpath("//div[@aria-label='Electronics']"));
	action.moveToElement(electronic).perform();
	WebElement computers=driver.findElement(By.xpath("//a[text()='Computer Peripherals']"));
	action.moveToElement(computers).sendKeys(Keys.ENTER).click().perform();
	
}
}
