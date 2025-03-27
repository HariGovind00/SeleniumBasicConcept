package hgk.selenium.FlightBook_E2E;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SubmitClass extends BrowserInit
{
@Test
public void bookFlightSubmitBtn()
{
	driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
}
}
