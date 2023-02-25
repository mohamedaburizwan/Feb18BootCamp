package SprintFirst;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class leWithoutMandatoryField {
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
	 public void createLegalEntityTest(String username, String password) throws InterruptedException {
		 
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
       driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("");
       driver.findElement(By.xpath("//input[@name='CompanyName']")).sendKeys("HCL");
       driver.findElement(By.xpath("//textarea[@name='street']")).sendKeys("33 Fakkir Street");
       driver.findElement(By.xpath("//label[text()='Description']/following::textarea[1]")).sendKeys("Description");
       driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys("600013");
       driver.findElement(By.xpath("//input[@name='province']")).sendKeys("TN");
       WebElement statusDrop = driver.findElement(By.xpath("//label[text()='Status']/following::button[1]"));
       driver.executeScript("arguments[0].click();", statusDrop);
       Thread.sleep(5000);
    // driver.findElement(By.xpath("//span[@title='Active']")).click();
       driver.findElement(By.xpath("//button[text()='Save']")).click();   
       WebElement errorMessage = driver.findElement(By.xpath("//div[@class='genericNotification']"));
       String genericText= errorMessage.getText().trim();
       System.out.println(genericText);
       WebElement listerrorField = driver.findElement(By.xpath("//ul[contains(@class,'errorsList')]//li"));
       String errorFieldText= listerrorField.getText().trim();
       System.out.println(errorFieldText);
       assertEquals(genericText, "Review the following fields");
       assertEquals(errorFieldText, "Name");
}
}