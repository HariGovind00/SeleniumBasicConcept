package hgk.selenium.FreshStart;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class ActionsClass {
	public WebDriver driver;
	@Test
	public void test() throws InterruptedException 
	{
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(3000);
		// Action for mouse hover or mouse click
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.id("mousehover"))).sendKeys(Keys.ENTER).build().perform();
		//Reload
			//driver.findElement(By.xpath("//a[text()='Reload']")).click();
		//Top
			driver.findElement(By.xpath("//a[@href='#top']")).click();
		
			//ActionsClass ac=new ActionsClass();
			//ac.closeBrowser(driver);
			
			
	}
@Test(dependsOnMethods = "test")
public void closeBrowser() throws InterruptedException
{
	Thread.sleep(2000);
	driver.close();
}
}
