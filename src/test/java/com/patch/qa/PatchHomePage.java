package com.patch.qa;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PatchHomePage {
	
		@Test
		public void PatchTest() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://www.patch.com");
		
		//Page title
		System.out.println("Page title : "+ driver.getTitle());
		//Page description
		String des = driver.findElement(By.xpath("//meta[@name='description']")).getAttribute("content");
		System.out.println("Page description : "+ des);
		
		//og tags
		List<WebElement>  og_tags = driver.findElements(By.xpath("//meta[starts-with(@property,'og:')]"));
		for (WebElement text : og_tags) {
			System.out.println("og_tags: "+text.getAttribute("content"));	
		}
		
		//google_analytics
		List<WebElement> google_analytics= (List<WebElement>) driver.findElements(By.xpath("//script[starts-with(@type,'text/javascript')]")); 
		for (WebElement text : google_analytics) {
		System.out.println("google_analytics: "+text.getAttribute("src"));
		}
		
		//City Names in Zip Code 10001
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("10001");
		Thread.sleep(1000);
		WebElement  zipCode = driver.findElement(By.xpath("//div[2]/div[1]/div[1]/div[1]/ul[1]"));
		//html[1]/body[1]/div[1]/header[1]/nav[1]/div[2]/div[1]/div[1]/div[1]/ul[1]
		System.out.println("City Names in Zip Code 10001: " + zipCode.getText());
		
		driver.close();
		
		}
	}

/*	
	Extra Credit:
	1. Our thumbnail images should lazy load when they come into view. How would you verify this functionality?
		 Answer: I will wait until the thumbnail images/ element to load (using WebDriverWait)
	
	2. The “Live on Patch” widget in the right rail animates through a list of trending stories. How would you verify this functionality?
		 Answer: I will wait and capture all the widget and take first 20 unique widget by using HastSet (which takes unique value)

 */
