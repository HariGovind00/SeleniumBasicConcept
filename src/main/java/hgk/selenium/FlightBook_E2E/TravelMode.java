package hgk.selenium.FlightBook_E2E;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TravelMode extends BrowserInit
{
@Test(priority = 0)
public void travelModeSel() throws InterruptedException
{
	List<WebElement>travelModeSel=driver.findElements(By.cssSelector("table[id='ctl00_mainContent_rbtnl_Trip'] td"));
	for(int i=0;i<travelModeSel.size();i++)
	{
		String travelDetails=travelModeSel.get(i).getText();
		
		if(travelDetails.equalsIgnoreCase("Round Trip"))
		{
			switch(travelDetails)
			{
				case "One Way":
					System.out.println("Welcome:"+travelDetails);
					travelModeSel.get(i).findElement(By.cssSelector("input[type='radio']")).click();
					break;
					
				case "Round Trip":
					System.out.println("Welcome:"+travelDetails);
					travelModeSel.get(i).findElement(By.cssSelector("input[type='radio']")).click();
					break;
				case "Multicity":
					System.out.println("Welcome:"+travelDetails);
					travelModeSel.get(i).findElement(By.cssSelector("input[type='radio']")).click();
					driver.findElement(By.id("MultiCityModelAlert")).click();
					break;
				
				default:
					System.out.println("Sorry no match found!!!");
					
		
			}
		
	}
	Thread.sleep(2000);
}
}
}
