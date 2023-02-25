package testSuites;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseHooks;

public class TestLegalEntity extends BaseHooks {

	BaseHooks object = new BaseHooks();
	
	@Test(priority = 1, dataProvider = "productSelectData")
	public void login(String username, String password) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("Login")).click();
	}

	@Test(priority = 2)
	public void createLegalEntity() throws InterruptedException  {
		
		driver.findElement(By.xpath("//button[@type='button']//preceding::div[@role='navigation']")).click();
		driver.findElement(By.xpath("//button[@class='slds-button' and @type='button']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Legal Entities");
		driver.findElement(By.xpath("//mark[text()='Legal Entities']")).click();
		driver.findElement(By.xpath("//div[text()='New']")).click();
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Rizwan");
		driver.findElement(By.xpath("//input[@name='CompanyName']")).sendKeys("HCL");
		driver.findElement(By.xpath("//textarea[@name='street']")).sendKeys("33 Fakkir Street");
		driver.findElement(By.xpath("//label[text()='Description']/following::textarea[1]")).sendKeys("Description");
		driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys("600013");
		driver.findElement(By.xpath("//input[@name='province']")).sendKeys("TN");
		WebElement statusDrop = driver.findElement(By.xpath("//label[text()='Status']/following::button[1]"));
		driver.executeScript("arguments[0].click();", statusDrop);
		driver.executeScript("arguments[0].click();", statusDrop);
		//Thread.sleep(50000);
		//WebElement activeButton = driver.findElement(By.xpath("//span[@class='slds-media__body']/following::span[text()='Active']"));
		//driver.executeScript("arguments[0].click();", activeButton);
		/*
		 * WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(4))
		 * .until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * "//span[text()='Active']/parent::span"))); firstResult.click();
		 */
		driver.findElement(By.xpath("//button[text()='Save']")).click();
	
	}

	@Test(priority = 3)
	public void editLegalEntity() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		/*
		 *

		 * JavascriptExecutor executor = (JavascriptExecutor) driver;
		 * executor.executeScript("arguments[0].click();", firstResult);
		 * executor.executeScript("arguments[0].click();", firstResult);
		 * executor.executeScript("arguments[0].click();", firstResult);
		 */
		WebElement viewAllButton = driver.findElement(By.xpath("//div[@class='slds-r5']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", viewAllButton);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Legal Entities");
		driver.findElement(By.xpath("//mark[text()='Legal Entities']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//td/following::a[@role='button']")).click();
		driver.findElement(By.xpath("//li[@role='presentation']")).click();
		driver.findElement(By.xpath("//input[@name='CompanyName']")).clear();
		driver.findElement(By.xpath("//input[@name='CompanyName']")).sendKeys("TestLeaf	");
		driver.findElement(By.xpath("//label[text()='Description']/following::textarea[1]")).sendKeys("SalesForce");
		WebElement statusDrop = driver.findElement(By.xpath("//label[text()='Status']/following::button[1]"));
		driver.executeScript("arguments[0].click();", statusDrop);
		driver.findElement(By.xpath("//span[@title='Active']")).click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();
	}

	@Test(enabled = false)
	public void sortLegalEntity() throws InterruptedException {
		List<WebElement> entities = driver.findElements(By.xpath("//span[@class='slds-truncate uiOutputDateTime']"));
		List<String> dates = new ArrayList<String>();
		int i = 1;
		for (WebElement entity : entities) {
			WebElement dateElement = entity.findElement(By.xpath("//tr[" + i + "]/td[3]"));
			i++;
			String date = dateElement.getText();
			System.out.println("1_" + date);
			dates.add(date);
			System.out.println(dates);

		}
		// Verify that the dates are in ascending order
		List<String> sortedDates = new ArrayList<String>(dates);
		// Sort the list in descending order
		Collections.sort(sortedDates, Collections.reverseOrder());
		Assert.assertEquals(sortedDates, dates);
	}

	@Test(enabled = false)
	public void deleteLegalEntity() throws InterruptedException {

		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(@class,'forceVirtualActionMarker')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//li[@role='presentation'])[2]")).click();
		driver.findElement(By.xpath("//span[text()='Delete']")).click();

	}
	 @Test(priority = 6,enabled = false)
	
	 public void MandatoryLegalEntityTest() throws InterruptedException {
		 
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
       System.out.println("Added");
}

}
