package hgk.selenium.FlightBook_E2E;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AutoSugDropdown extends BrowserInit
{

	String userAugSugInput="Ind";
//@Test
public void autoSugCountry() throws InterruptedException
{
	driver.findElement(By.id("autosuggest")).sendKeys(userAugSugInput);
	//Get the list of country for above keyword input
	List<WebElement> countrylist=driver.findElements(By.cssSelector(".ui-menu-item"));
	for(int i=0;i<countrylist.size();i++)
	{
		String countries=countrylist.get(i).getText();
		System.out.println(countries);
		if(countries.equalsIgnoreCase("British Indian Ocean Territory"))
		{
			System.out.println("Welcome:"+countries);
			Thread.sleep(2000);
			countrylist.get(i).findElement(By.tagName("a")).click();
			
		}
		
	}
}

}
