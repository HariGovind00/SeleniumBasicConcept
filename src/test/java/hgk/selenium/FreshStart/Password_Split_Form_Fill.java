package hgk.selenium.FreshStart;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Password_Split_Form_Fill {
	WebDriver driver = new ChromeDriver();
	Set<String> windows;
	Iterator<String> itrWin;
	String parentWin;
	String childWin;
	String username;

	@Test
	public void formPage() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		WebElement passPagelink = driver.findElement(By.className("blinkingText"));
		passPagelink.click();
		windows = driver.getWindowHandles();
		itrWin = windows.iterator();
		parentWin = itrWin.next();
		childWin = itrWin.next();
		// driver.switchTo().window(childWin);
		Thread.sleep(3000);
		driver.switchTo().window(parentWin);
		username = usernameFetch();
		System.out.println("Username is:" + username);
		// fillForm();

	}

//Get the String text to split username out of it.
	@Test(dependsOnMethods = "formPage")
	public String usernameFetch() throws InterruptedException {

		driver.switchTo().window(childWin);
		// Get the String text to split password out of it.
		String Statement = driver.findElement(By.cssSelector("p[class='im-para red']")).getText();
		// Please email us at mentor@rahulshettyacademy.com with below template to
		// receive response
		System.out.println(Statement);
		String fetchUsername = Statement.split("@")[1].split(".com")[0].trim();
		System.out.println(fetchUsername);
		Thread.sleep(2000);
		return fetchUsername;
	}

////Customer Form Fill
	@Test(dependsOnMethods = "formPage")
	public void fillForm() throws InterruptedException {
		Thread.sleep(2000);
		driver.switchTo().window(parentWin);
		System.out.println("Final username is:" + username);
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys("learning");
		// Radio selection
		List<WebElement> radios = driver.findElements(By.className("customradio"));
		for (int i = 0; i < radios.size(); i++) {
			String radioOpt = radios.get(i).getText();
			System.out.println(radioOpt);
			if (radioOpt.equalsIgnoreCase("User")) {
				System.out.println("Welcome:" + radioOpt);
				driver.findElements(By.xpath("//span[@class='checkmark']")).get(i).click();
				Thread.sleep(2000);
				driver.findElement(By.id("okayBtn")).click();

			}
		}
		// Dropdown sel
		// CSS=>select[class='form-control']
		// xPath=form[@id='login-form']/div[5]/select
		// cssSelector=form[id='login-form'] div:nth-child(5) select
		WebElement dropdown = driver.findElement(By.cssSelector("form[id='login-form'] div:nth-child(5) select"));
		dropdown.click();
		Select sel = new Select(dropdown);
		sel.selectByIndex(2);
		// Click on Terms and Conditions.
		driver.findElement(By.id("terms")).click();
		// Sign in button click
		driver.findElement(By.cssSelector("input[value='Sign In']")).click();
		Thread.sleep(3000);
		String curl = driver.getCurrentUrl();
		System.out.println("Current URL is:" + curl);
		Assert.assertEquals("https://rahulshettyacademy.com/angularpractice/shop", curl);
	}

	@AfterClass
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

}
