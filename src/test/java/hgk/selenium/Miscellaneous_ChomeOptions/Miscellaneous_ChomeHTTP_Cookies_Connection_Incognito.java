package hgk.selenium.Miscellaneous_ChomeOptions;

import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Miscellaneous_ChomeHTTP_Cookies_Connection_Incognito 
{
@Test
public void performChromeOptions() throws InterruptedException
{
	ChromeOptions co=new ChromeOptions();
	String chromeVersion=co.getBrowserName();
	System.out.println(chromeVersion);
	co.setAcceptInsecureCerts(true);
	co.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking"));
	WebDriver driver=new ChromeDriver(co);
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("https://www.Amazon.com/");
	Thread.sleep(2000);
	Set<Cookie> cookies=driver.manage().getCookies();
	System.out.println("Cookies size before Adding Cookies:"+cookies.size());
//	for(int i=0;i<cookies.size();i++)
		for(Cookie cookie:cookies)
		{
			System.out.println(cookie.getName());
			
		}
		
//Add the cookies
		Cookie cokkies=new Cookie("HGKCookies", "123456");
		driver.manage().addCookie(cokkies);
		cookies=driver.manage().getCookies();
		System.out.println("Cookies size after Adding Cookies:"+cookies.size());
		
		
//Delete all cookies
		driver.manage().deleteAllCookies();
		
		cookies=driver.manage().getCookies();
		System.out.println("After deletion of all cookies size:"+cookies.size());
		
//Close browser
		driver.quit();
	
}
}
