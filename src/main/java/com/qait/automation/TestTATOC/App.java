package com.qait.automation.TestTATOC;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.setProperty("webdriver.chrome.driver", "/home/qainfotech/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://10.0.1.86/tatoc");
		driver.findElement(By.linkText("Basic Course")).click();
		driver.findElement(By.className("greenbox")).click();
		
		String box1color = driver.switchTo().frame("main").findElement(By.id("answer")).getAttribute("class");
		String box2color = "";
		do {
      	  box2color=driver.switchTo().frame("child").findElement(By.id("answer")).getAttribute("class");
      	  driver.switchTo().parentFrame();
      	  if(box1color.equals(box2color)) {
      		  driver.findElement(By.linkText("Proceed")).click();
      	  }
      	  else {
      		  driver.findElement(By.linkText("Repaint Box 2")).click();
      	  }
        }while(!box1color.equals(box2color));
		

		WebElement From = driver.findElement(By.id("dragbox"));	
		WebElement To=driver.findElement(By.id("dropbox"));
	
		Actions act = new Actions(driver);
		act.dragAndDrop(From, To).build().perform();
		driver.findElement(By.linkText("Proceed")).click();
		
		driver.findElement(By.linkText("Launch Popup Window")).click();
		String MainWindow = driver.getWindowHandle();	
		for(String popWindow : driver.getWindowHandles()) {
			driver.switchTo().window(popWindow);
		}
		WebElement text = driver.findElement(By.id("name"));
		text.sendKeys("gaurav");
		driver.findElement(By.id("submit")).click();
		driver.switchTo().window(MainWindow);
		driver.findElement(By.linkText("Proceed")).click();
		
		driver.findElement(By.linkText("Generate Token")).click();
		String token = driver.findElement(By.id("token")).getText();
		String[] tokens = token.split(":");
		token = tokens[tokens.length-1].trim();
		Cookie cookie = new Cookie("Token", token);
		driver.manage().addCookie(cookie);
		driver.findElement(By.linkText("Proceed")).click();		
    }
}
