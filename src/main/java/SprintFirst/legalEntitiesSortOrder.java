package SprintFirst;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class legalEntitiesSortOrder {
	
	 ChromeDriver driver;
	 @BeforeClass
	 public void setUp() {
			// TODO Auto-generated method stub
			ChromeOptions options = new ChromeOptions();
	        options.addArguments("--disable-notifications");
	      //  System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
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
	        List<WebElement> entities = driver.findElements(By.xpath("//span[@class='slds-truncate uiOutputDateTime']"));
	        List<String> dates = new ArrayList<String>();
	        int i =1;
	        for (WebElement entity : entities) {
	        	WebElement dateElement = entity.findElement(By.xpath("//tr["+i+"]/td[3]"));
	        	i++;
	          String date = dateElement.getText();
	          System.out.println("1_"+date);
	          dates.add(date);
	          System.out.println(dates);
	         
	        }
	        
	        // Verify that the dates are in ascending order
	        List<String> sortedDates = new ArrayList<String>(dates);
	     // Sort the list in descending order
	        Collections.sort(sortedDates, Collections.reverseOrder());
	        Assert.assertEquals(sortedDates, dates);
	 }
	 
}
