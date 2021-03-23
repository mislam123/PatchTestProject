package com.patch.qa;

import java.awt.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AAA_PatchHomePage {
	
	//https://smeesheady.medium.com/webdriver-java-how-to-capture-meta-tags-in-a-web-page-and-verify-its-content-becb3be8c139
	//https://sqa.stackexchange.com/questions/6859/how-do-you-block-google-analytics-from-selenium-automated-visits
	
	/*
	var options = new ChromeOptions();
	options.Proxy = proxy;
	options.AddExtension(Path.GetFullPath("chrome-ga-optout-extension.crx"));
	var driver = new ChromeDriver(options);
	 
	 */
		@Test
		public void assertTest() throws Exception {
			
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://www.patch.com");
		
		Thread.sleep(1000);
		WebElement  widget = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/section[1]/aside[1]/div[1]/section[1]/div[1]/div[1]/div[2]"));
		Thread.sleep(1000);
		System.out.println("Live on Patch: " + widget.getText());
		
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("10001");
		Thread.sleep(1000);
		
		System.out.println("Start");
		//String  zipCode = ((WebElement) driver.findElements(By.xpath("//a[@class='autocomplete__btn']"))).getText();
		String  zipCode = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/header[1]/nav[1]/div[2]/div[1]/div[1]/div[1]/ul[1]")).getText();
		
		System.out.println(zipCode);
		
		driver.findElement(By.xpath("//div[2]/div[1]/div[1]/label[1]/input[1]")).click();
		Thread.sleep(10);
		//triggered Google Analytics event
		System.out.println("triggered Google Analytics event");
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		
		
		System.out.println("End");
		
		
		
		driver.close();
		}

		private JavascriptExecutor getDriver() {
			// TODO Auto-generated method stub
			return null;
		}
		}



