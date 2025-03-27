package hgk.selenium.FlightBook_E2E;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CurrencyDropdown extends BrowserInit
{
String userCurSel="AED";
	
@Test
public void currencyDropdownOpt() 
{
	WebElement currencyOptions=driver.findElement(By.xpath("//select[contains(@name,'DropDownListCurrency')]"));
	currencyOptions.click();
	
	Select selOpt=new Select(currencyOptions);
	//EDselOpt.selectByIndex(3);
	//selOpt.selectByValue("INR");
	selOpt.selectByVisibleText(userCurSel);
	String val=selOpt.getFirstSelectedOption().getText();
	System.out.println("Selected Currency is:"+val);
	
	
}
}
