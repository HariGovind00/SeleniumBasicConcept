package hgk.selenium.FreshStart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;

import hgk.selenium.BrowserInit.BrowserLoad;

public class FetchPasswordOutOfText extends BrowserLoad
{
public static void main(String [] args) throws InterruptedException
{
	browser();
	driver.get("https://rahulshettyacademy.com/locatorspractice/");
	FetchPasswordOutOfText f=new FetchPasswordOutOfText();
	String pass=f.getPassword();
	System.out.println("Returned Password is:"+pass);
}
public String getPassword() throws InterruptedException
{
	browser();
	driver.get("https://rahulshettyacademy.com/locatorspractice/");
	//CLick on forgot passs or Regular Xpath for the same ie: //a[contains(text(),'password?')]
	driver.findElement(By.linkText("Forgot your password?")).click();  
	Thread.sleep(2000);
	driver.findElement(By.cssSelector("button[class='reset-pwd-btn']")).click();
	String getText=driver.findElement(By.className("infoMsg")).getText();
	//Please use temporary password 'rahulshettyacademy' to Login.
	String Password=getText.split("'")[1].trim();
	System.out.println(Password);
	
	String Str=getText.substring(11,20);
	System.out.println(Str);
	return Password;
	
}
}
