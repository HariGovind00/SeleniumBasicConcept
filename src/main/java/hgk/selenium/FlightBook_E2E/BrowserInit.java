package hgk.selenium.FlightBook_E2E;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrowserInit {
	public WebDriver driver;

	@BeforeTest
	public void browserLoad() {
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Please select the browser to run Script...");
		String browserName = sc1.nextLine();
		switch (browserName) {
		case "chrome":
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
			break;

		case "edge":
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
			break;

		default:
			System.out.println("No browser append running.");
		}
	}

	@AfterClass
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();

	}
}
