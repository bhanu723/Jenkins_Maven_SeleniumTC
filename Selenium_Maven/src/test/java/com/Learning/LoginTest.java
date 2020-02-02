package com.Learning;

	 
	import java.util.concurrent.TimeUnit; 
	import org.openqa.selenium.By;
	import  org.openqa.selenium.WebDriver; 
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
//  import org.openqa.selenium.firefox.FirefoxDriver; 
	import org.openqa.selenium.support.ui.Select;
    import org.testng.annotations.Test;
	 
	public class LoginTest{ 
		
    WebDriver driver;
	 

   // https://github.com/bhanu723/Jenkins_Maven_Selenium.git
    	
    @Test
    public void loginValidation(){
    	
	    //Launch firefox 
    	/*System.setProperty("webdriver.gecko.driver", "/Users/bhanusurendradeepala/Documents/workspace_SeleniumClasses/Practice_Maven/Selenium_API/geckodriver");  
	     driver = new FirefoxDriver();   */
	     
	     System.setProperty("webdriver.chrome.driver", "/Users/bhanusurendradeepala/Documents/workspace_SeleniumClasses/Practice_Maven/Selenium_API/chromedriver");
			driver = new ChromeDriver();  
			
    /*	System.setProperty("webdriver.chrome.driver", "/Users/bhanusurendradeepala/Documents/workspace_SeleniumClasses/Practice_Maven/Selenium_API/chromedriver");
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("window-size=1400,800");
    	options.addArguments("headless");
    	driver = new ChromeDriver(options); */
	    
	    //maximize the browser
	    //driver.manage().window().maximize();
	    
	    //Implicit wait, wait for at least some time (10 sec) to identify an element, //if can't find the element with in 10 
	    
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
	 
	    //open the url or AUT 
	    driver.get("http://newtours.demoaut.com/");
	    
	    
	 
	    //Click on the register link: WebElement lnk_register = 
	    driver.findElement(By.linkText("REGISTER")).click();
	 
	    //Enter details on the provided text boxes by using sendkeys method. 
	    WebElement txtBox_firstname = driver.findElement(By.name("firstName")); 
	    txtBox_firstname.sendKeys("John"); 
	    
	    //or directly we can identify element and act on that in one line 
	    driver.findElement(By.name("lastName")).sendKeys("Clark"); 
	    driver.findElement(By.name("phone")).sendKeys("2342342341"); 
	    driver.findElement(By.name("userName")).sendKeys("sunilpatro1985@gmail.com"); 
	 
	    //Enter mailing information as above //Select the country, create a select 
	   // object and then work on that object 
	    Select s = new Select(driver.findElement(By.name("country"))); 
	    s.selectByVisibleText("INDIA"); 
	 
	    //Enter user name and password 
	    driver.findElement(By.name("email")).sendKeys("12345"); 
	    driver.findElement(By.name("password")).sendKeys("12345"); 
	    driver.findElement(By.name("confirmPassword")).sendKeys("12345"); 
	    
	    //click on submit 
	    driver.findElement(By.xpath("//input[@name='register']")).click();
	 
	    driver.findElement(By.linkText("Home")).click();
	 
	    //Enter the username and password and click on the submit button. 
	    driver.findElement(By.name("userName")).sendKeys("12345"); 
	    driver.findElement(By.name("password")).sendKeys("12345"); 
	    driver.findElement(By.xpath("//input[@name='login']")).click();
	 
	    //verify if login successful 
	    WebElement form_findflight = driver.findElement(By.xpath("//form[@name='findflight']")); 
	  
	    if(form_findflight.isDisplayed()) 
	    { 
	       System.out.println("Login successful!"); 
	       
	    } 
	  driver.close();
	  driver.quit();
	  
	}
}
