package com.qait.automation.TestTATOC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestHRIS {
	
	WebDriver driver = new ChromeDriver();
	
	@Test
	public void openingURL() {
		driver.get("http://10.0.1.86/tatoc");
		Assert.assertTrue(driver.findElement(By.linkText("Basic Course")).getText().equals("Basic Course"));
		openingBasicCourse();
	}
	
	@Test
	public void openingBasicCourse() {
		driver.findElement(By.linkText("Basic Course")).click();
	//	Assert.assertTrue(condition);
	}
	

}
