package hgk.selenium.FlightBook_E2E;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class PassengersDropdown extends BrowserInit
{
	int Adult=2;
	int Child=1;
	int Infant=1;
@Test
public void passengersCount() throws InterruptedException
{	
	Thread.sleep(2000);
	
	driver.findElement(By.cssSelector("div[id='divpaxinfo']")).click();
	//To ge the category of the passenger: label[class='guestlbl']
	List<WebElement>passCategory=driver.findElements(By.cssSelector("label[class='guestlbl']"));
	for(int i=0;i<passCategory.size();i++)
	{
		String passSelCategory=passCategory.get(i).getText();
		if(passSelCategory.equalsIgnoreCase("Adult"))
		{
			for(int j=0;j<Adult;j++)
			{
				//System.out.println("Adult:"+j);
				driver.findElement(By.cssSelector("span[id*='hrefIncAdt']")).click();

			}
		}
		else if(passSelCategory.equalsIgnoreCase("Child"))
		{
			for(int k=0;k<Child;k++)
			{
				//System.out.println("Child:"+k);
				driver.findElement(By.cssSelector("span[id*='hrefIncChd']")).click();

			}
		}
		else if(passSelCategory.equalsIgnoreCase("Infant"))
		{
			for(int l=0;l<Infant;l++)
			{
				//System.out.println("Infant:"+driver.findElement(By.xpath("//div[@class='ad-row-right']/span[2]")).getText());
				driver.findElement(By.cssSelector("span[id*='hrefIncInf']")).click();

			}
		}
	}
	driver.findElement(By.className("buttonN")).click();
	Thread.sleep(2000);
	
	
}
}
