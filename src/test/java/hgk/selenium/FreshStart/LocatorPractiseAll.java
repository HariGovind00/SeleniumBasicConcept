package hgk.selenium.FreshStart;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import hgk.selenium.BrowserInit.BrowserLoad;

public class LocatorPractiseAll extends BrowserLoad
{
	String UserInputRadio="radio3";
	String CountryKeywordsearched="Ind";
	String CountryUserSel="Indonesia";
	String UserCheckboxSelInput="Option3";
	
/////////////////////////////////////////////////////
@Test
public void radioButton() throws InterruptedException
{
//Radio button script
	browser();
	driver.get("https://rahulshettyacademy.com/AutomationPractice/#top");
	List<WebElement> radios=driver.findElements(By.cssSelector("div[id='radio-btn-example'] label"));
	for(int i=0;i<radios.size();i++)
	{
		String radio=radios.get(i).getText();
		System.out.println(radio);
		if(radio.equalsIgnoreCase(UserInputRadio))
		{
			driver.findElements(By.tagName("input")).get(i).click();
			System.out.println("Clicked radio button is:"+driver.findElements(By.tagName("label")).get(i).getText());
		}
	}
}
//////////////////////////////////////////////////
@Test
public void suggestionDropdown()
{
	browser();
	driver.get("https://rahulshettyacademy.com/AutomationPractice/#top");
	//Auto sugg field and user input searched
	driver.findElement(By.id("autocomplete")).sendKeys(CountryKeywordsearched);
	//Select all the country name menu
	List<WebElement> countryList=driver.findElements(By.className("ui-menu-item"));
	for(WebElement countryname: countryList)
	{
		String country=countryname.getText();
		System.out.println(country);
		
		if(country.equals(CountryUserSel))
		{
			countryname.findElement(By.cssSelector("div")).click();
			System.out.println("Welcome: "+country);
		}
		else
		{
			System.out.println("no match found!");
		}
	}
}

////////////////////////////////////////////////////////////
@Test
public void dropDown() throws InterruptedException
{
	browser();
	driver.get("https://rahulshettyacademy.com/AutomationPractice/#top");
	WebElement dropOpts=driver.findElement(By.name("dropdown-class-example"));
	Select selOpt=new Select(dropOpts);
	//selOpt.selectByIndex(1);
	//selOpt.selectByVisibleText("Option3");
	selOpt.selectByValue("option2");
	Thread.sleep(2000);
	
}
///////////////////////////////////////////////
@Test
public void checkBox() throws InterruptedException
{
	browser();
	driver.get("https://rahulshettyacademy.com/AutomationPractice/#top");
	List<WebElement>checkboxes=driver.findElements(By.cssSelector("div[id='checkbox-example'] label"));
	for(WebElement cb: checkboxes)
	{
		System.out.println(cb.getText());
		if(cb.getText().equals(UserCheckboxSelInput))
		{
			cb.findElement(By.cssSelector("input")).click();
			System.out.println("Welcome:"+cb.getText());
		}
		else
		{
			System.out.println("no match");
		}
		
	
	}
	Thread.sleep(2000);
}

///////////////////////////////////////////////
@Test
public void switchWin() throws InterruptedException
{
	browser();
	driver.get("https://rahulshettyacademy.com/AutomationPractice/#top");
	WebElement openWin=driver.findElement(By.id("openwindow"));
	openWin.click();
	Set<String> win=driver.getWindowHandles();
	Iterator<String> itrwin=win.iterator();
	String parent=itrwin.next();
	String child=itrwin.next();
	
	driver.switchTo().window(parent);
	Thread.sleep(2000);
	driver.switchTo().window(child);
	
	
	
}

///////////////////////////////////////////////////////

@Test
public void switchTab() throws InterruptedException
{
	browser();
	driver.get("https://rahulshettyacademy.com/AutomationPractice/#top");
	WebElement tab=driver.findElement(By.linkText("Open Tab"));
	tab.click();
	Set<String> win=driver.getWindowHandles();
	Iterator<String> itrTab=win.iterator();
//	String parentTab=itrTab.next();
//	String childTab=itrTab.next();
	while(itrTab.hasNext())
	{
		if(itrTab.next()!=null)
			{
			driver.switchTo().window(itrTab.next());
			System.out.println("Welcome:"+driver.getTitle());
			}
		else
		{
			System.out.println("no child win!!!");
		}
	Thread.sleep(2000);
	}
}

//////////////////////////////////////////////////////
@Test
public void alertWin() throws InterruptedException
{
	browser();
	driver.get("https://rahulshettyacademy.com/AutomationPractice/#top");
	driver.findElement(By.name("enter-name")).sendKeys("Hari");
	driver.findElement(By.xpath("//input[@value='Alert']")).click();
	driver.switchTo().alert().accept();
	Thread.sleep(2000);
	driver.findElement(By.name("enter-name")).sendKeys("Hary");
	driver.findElement(By.id("confirmbtn")).click();
	driver.switchTo().alert().dismiss();
	Thread.sleep(2000);
	
}
//////////////////////////////////////////////////////
@Test()
public void eleDispalyed()
{
	browser();
	driver.get("https://rahulshettyacademy.com/AutomationPractice/#top");
	//Enter the deta in text field
	driver.findElement(By.name("show-hide")).sendKeys("Hari Govind");
	String visibletext=driver.findElement(By.name("show-hide")).getAttribute("value");
	System.out.println(visibletext);
	if(visibletext.equals("Hari Govindm"))
	{
		driver.findElement(By.cssSelector("input[value='Hide']")).click();
	}
	else
	{
		driver.findElement(By.id("show-textbox")).click();
	}
	
}

//=======================================================================
@Test
public void fixedWebTable()
{
	browser();
	driver.get("https://rahulshettyacademy.com/AutomationPractice/#top");
	//Get the no of row count
	List<WebElement>rows=driver.findElements(By.xpath("//div[@class='tableFixHead']/table/tbody/tr"));
	//List<WebElement>lrows=driver.findElements(By.cssSelector(".tableFixHead tbody tr"));
	for(int i=0;i<rows.size();i++)
	{
		String data=rows.get(i).findElement(By.tagName("td")).getText();
		System.out.println(data);
			if(data.equals("Ben"))
			{
				System.out.println("Welcome:"+data);
				
			}
			else System.out.println("Sorry");
		}
	}
	
}
