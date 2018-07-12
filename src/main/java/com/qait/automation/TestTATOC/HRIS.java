package com.qait.automation.TestTATOC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HRIS {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/home/qainfotech/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://hris.qainfotech.com/login.php");
		driver.findElement(By.id("txtUserName")).sendKeys("gauravshukla");
		driver.findElement(By.id("txtPassword")).sendKeys("");
		driver.findElement(By.id("txtUserName")).submit();
		
		
		
		
	WebElement date = driver.findElement(By.id("dv_2018-06-11"));
	String time = date.findElement(By.className("emp_time")).getText();
	System.out.println(time);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
