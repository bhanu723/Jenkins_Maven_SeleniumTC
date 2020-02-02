package com.Learning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class MyFirstProg {

		WebDriver driver;
		
		@Test
		public void testMethod(){
			 //Launch browser 
			System.setProperty("webdriver.chrome.driver", "/Users/bhanusurendradeepala/Documents/workspace_SeleniumClasses/Practice_Maven/Selenium_API/chromedriver");
			driver = new ChromeDriver();  
			
			
		    //maximize the browser
		    driver.manage().window().maximize();
		    
		    //Implicit wait, wait for at least specified time (10 sec) to identify an element, //if can't find the element with in 10 
		    
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		 
		    //open the url or AUT 
		    driver.get("http://newtours.demoaut.com/");
		 
		    //Click on the register link: 
		    WebElement lnk_register = driver.findElement(By.linkText("REGISTER")); 
		    lnk_register.click();
		 
		    //Enter details on the provided text boxes by using sendkeys method. 
		    WebElement txtBox_firstname = driver.findElement(By.name("firstName")); 
		    txtBox_firstname.sendKeys("John"); 
		    
		    //or directly we can identify element and act on that in one line 
		    driver.findElement(By.name("lastName")).sendKeys("Clark"); 
		    driver.findElement(By.name("phone")).sendKeys("2342342341"); 
		    driver.findElement(By.name("userName")).sendKeys("sunilpatro1985@gmail.com"); 
		    
		    //close the browser
		    driver.close();
		    driver.quit();
		}
}
