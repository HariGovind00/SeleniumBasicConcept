package hgk.selenium.FlightBook_E2E;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CalendarTicketBook extends TravelMode {
	
	
	@Test(priority = 1)
	public void journeyTicketBookCalendar() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// cal click
		driver.findElement(By.name("ctl00$mainContent$view_date1")).click();
		// Month
		String mm = driver.findElement(By.cssSelector("span[class='ui-datepicker-month']")).getText();
		// Year
		String yyyy = driver.findElement(By.cssSelector("span[class='ui-datepicker-year']")).getText();
		while (!(mm.equalsIgnoreCase("March") && yyyy.equalsIgnoreCase("2025"))) {

			driver.findElement(By.cssSelector(".ui-datepicker-next.ui-corner-all")).click();
			mm = driver.findElement(By.cssSelector("span[class='ui-datepicker-month']")).getText();
			yyyy = driver.findElement(By.cssSelector("span[class='ui-datepicker-year']")).getText();

		}
		System.out.println("Selected Date:" + driver.findElement(By.xpath("//a[text()='18']")).getText() + "/" + mm + "/" + yyyy);
		driver.findElement(By.xpath("//a[text()='19']")).click();
		Thread.sleep(2000);

	}
	
@Test(priority = 2)
public void returnTicketBookCalendar() throws InterruptedException
{
	
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.name("ctl00$mainContent$view_date2")).click();
		
		// Month
		String mm = driver.findElement(By.cssSelector("span[class='ui-datepicker-month']")).getText();
		// Year
		String yyyy = driver.findElement(By.cssSelector("span[class='ui-datepicker-year']")).getText();
		while (!(mm.equalsIgnoreCase("May") && yyyy.equalsIgnoreCase("2025"))) {

			driver.findElement(By.cssSelector(".ui-datepicker-next.ui-corner-all")).click();
			mm = driver.findElement(By.cssSelector("span[class='ui-datepicker-month']")).getText();
			yyyy = driver.findElement(By.cssSelector("span[class='ui-datepicker-year']")).getText();

		}
		System.out.println("Selected Date:" + driver.findElement(By.xpath("//a[text()='5']")).getText() + "/" + mm + "/" + yyyy);
		driver.findElement(By.xpath("//a[text()='5']")).click();
		Thread.sleep(2000);

	}
}
