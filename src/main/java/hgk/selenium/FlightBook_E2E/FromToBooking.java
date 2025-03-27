package hgk.selenium.FlightBook_E2E;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FromToBooking extends BrowserInit
{
@Test
public void departureCitySel() throws InterruptedException
{
	//From Selection
	driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
	List<WebElement>fromDestination=driver.findElements(By.cssSelector("td[class='mapbg'] li"));
	for(int i=0;i<fromDestination.size();i++)
	{
		String fromDest=fromDestination.get(i).getText().split(" ")[0].trim();
		if(fromDest.equalsIgnoreCase("Patna"))
		{
			fromDestination.get(i).findElement(By.tagName("a")).click();
			System.out.println("From Journey selected:"+fromDest);
			break;
		}
	}
}
//To Destination
@Test(dependsOnMethods = "departureCitySel")
public void arrivalCitySel() throws InterruptedException
{
	//To Selection
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	List<WebElement>toDestination=driver.findElements(By.cssSelector("td[class='mapbg'] li"));
	for(int i=0;i<toDestination.size();i++)
	{
		String toDest=toDestination.get(i).getText().split(" ")[0].trim();
		if(toDest.equalsIgnoreCase("Chennai"))
		{
			toDestination.get(i).findElement(By.tagName("a")).click();
			System.out.println("To Journey selected:"+toDest);
			break;
		}
	}
}
}
