package hgk.selenium.FreshStart;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebTable 
{
@Test
public void tableData()
{
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	//scroll page
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.scrollTo(0,1200)");
	//Fetch the no of rows present in the table
	int rows=driver.findElements(By.cssSelector("table[name='courses'] tr")).size();
	System.out.println("Rows:"+rows);
	int column=driver.findElements(By.cssSelector("table[name='courses'] th")).size();
	System.out.println("Column:"+column);
	//second row data
	System.out.println(driver.findElement(By.cssSelector("table[name='courses'] tr:nth-child(3)")).getText());
	//Skip the top heading row and display all other data
	List<WebElement>rowsData=driver.findElements(By.cssSelector("table[name='courses'] tr"));
	for(int i=1;i<rowsData.size();i++)
	{
		System.out.println(rowsData.get(i).getText());
	}
	driver.close();
}

}
