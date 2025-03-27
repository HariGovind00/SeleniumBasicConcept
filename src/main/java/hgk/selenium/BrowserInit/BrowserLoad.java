package hgk.selenium.BrowserInit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;

public class BrowserLoad
{
    public static WebDriver driver;
    public BrowserLoad()
	{
		this.driver=driver;
	}
	
public static void browser()
{
	System.out.println("Hello Browser");
    driver=new EdgeDriver();
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
}
@AfterMethod
public void closeBrowser() throws InterruptedException
{
	Thread.sleep(3000);
	driver.quit();
	
}
}
