package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import SprintFirst.dataProvider;
import dataProvider.DataProvider;

public class BaseHooks extends DataProvider{

	 public ChromeDriver driver;
	 @Test (dataProvider = "productSelectData")
	 public void login(String username, String password) throws InterruptedException {
		  	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.get("https://login.salesforce.com/");
	        driver.findElement(By.id("username")).sendKeys(username);
	        driver.findElement(By.id("password")).sendKeys(password);
	        driver.findElement(By.id("Login")).click();
	        Thread.sleep(50000);		
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 }
	
	@AfterTest
	public void closeBrowser() {
	//	driver.quit();	
	}
	
	@BeforeClass
	public void setUp() {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
 }
	}

