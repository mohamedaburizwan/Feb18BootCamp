package SprintFirst;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class editLegalEntity   {
	
	 ChromeDriver driver;
	 @BeforeClass
	 public void setUp() {
			// TODO Auto-generated method stub
			ChromeOptions options = new ChromeOptions();
	        options.addArguments("--disable-notifications");
	        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	        driver = new ChromeDriver(options);
	        driver.manage().window().maximize();
	 }
	
	@Test
	@Parameters({"username","password"})
	public void editLegalEnityTest(String username, String password) throws InterruptedException {
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://login.salesforce.com/");
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("Login")).click();
        driver.findElement(By.xpath("//button[@type='button']//preceding::div[@role='navigation']")).click();
        driver.findElement(By.xpath("//button[@class='slds-button' and @type='button']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Legal Entities");
        driver.findElement(By.xpath("//mark[text()='Legal Entities']")).click();
        Thread.sleep(3000);
	    driver.findElement(By.xpath("//div[contains(@class,'forceVirtualActionMarker')]")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//li[@role='presentation']")).click();
	    driver.findElement(By.xpath("//input[@name='CompanyName']")).clear();
	    driver.findElement(By.xpath("//input[@name='CompanyName']")).sendKeys("TestLeaf	");
	    driver.findElement(By.xpath("//label[text()='Description']/following::textarea[1]")).sendKeys("SalesForce");
	    WebElement statusDrop = driver.findElement(By.xpath("//label[text()='Status']/following::button[1]"));
        driver.executeScript("arguments[0].click();", statusDrop);
	    driver.findElement(By.xpath("//span[@title='Active']")).click();
        driver.findElement(By.xpath("//button[text()='Save']")).click();        
	

	    
	}
	 }

