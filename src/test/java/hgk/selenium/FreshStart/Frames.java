package hgk.selenium.FreshStart;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Frames
{
public static void main(String [] args)
{
	WebDriver driver=new EdgeDriver();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("https://the-internet.herokuapp.com/nested_frames");
	
	driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-top']")));
	
	//Middle text retrival
	driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-middle']")));
	System.out.println("Retrived data is:"+driver.findElement(By.xpath("//div[text()='MIDDLE']")).getText());
	driver.close();
}
}
