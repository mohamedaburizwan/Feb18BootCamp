package SprintFirst;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CreateLegalEntityDataprovider {
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
	
	 @Test(dataProvider = "data-provider")
	 public void createLegalEntityTest1(String username, String password) {
		 
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://login.salesforce.com/");
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("Login")).click();
        driver.findElement(By.xpath("//button[@type='button']//preceding::div[@role='navigation']")).click();
        driver.findElement(By.xpath("//button[@class='slds-button' and @type='button']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Legal Entities");
        driver.findElement(By.xpath("//mark[text()='Legal Entities']")).click();
        driver.findElement(By.xpath("//div[text()='New']")).click();
        driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Rizwan");
        driver.findElement(By.xpath("//input[@name='CompanyName']")).sendKeys("HCL");
        driver.findElement(By.xpath("//textarea[@name='street']")).sendKeys("33 Fakkir Street");
      //  driver.findElement(By.xpath("//textarea[@id='input-249']")).sendKeys("Description");
        driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys("600013");
        driver.findElement(By.xpath("//input[@name='province']")).sendKeys("TN");
        driver.findElement(By.xpath("//div[@role='none']")).click();
        driver.findElement(By.xpath("//span[@title='Active']")).click();
        driver.findElement(By.xpath("//button[text()='Save']")).click();        
	}

	 @DataProvider (name = "data-provider")
     public Object[][] dpMethod(){
	 return new Object[][] {
		 {"aburizwan@india.com", "Water@790"}
     }	;
	 }
}
