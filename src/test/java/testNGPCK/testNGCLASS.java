package testNGPCK;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testNGCLASS {
	
	public String baseUrl = "http://not-devweb-903v:18055/flex/";
	String driverPath = "C:\\Work\\Automation Testing\\Software\\geckodriver.exe";
	public WebDriver driver;
	
	@BeforeTest
	public void testEntrance() {
		 
		System.out.println("Test Entrance");
		
	}
	
	@BeforeMethod
	public void launchBrowser() {
		System.out.println("launching firefox browser for the 2nd time");
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
		driver.get(baseUrl);
		String expectedTitle = "Parexel - IRT planning and forecasting";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("Clicking the Client Login Link");
		WebElement frameSwitch = driver.findElement(By.xpath("/html/frameset/frame")); 
		driver.switchTo().frame(frameSwitch);
		      
		driver.findElement(By.linkText("Client Login")).click();
	  
	}
	
	@Test(priority = 1)
	public void enterCredentials1( ) throws InterruptedException {
		
		driver.findElement(By.id("UserName")).click();
		driver.findElement(By.id("UserName")).sendKeys("devapp");
		driver.findElement(By.name("Submit")).click();
		Thread.sleep(3000);
		
		System.out.println("User Logged in Successfully");
		
	}
	
	@Test(priority = 2)
	public void enterCredentials2( ) throws InterruptedException {
		
		driver.findElement(By.id("UserName")).click();
		driver.findElement(By.id("UserName")).sendKeys("sbeesam");
		driver.findElement(By.id("Pswd")).click();
		driver.findElement(By.id("Pswd")).sendKeys("Welcome123");
		driver.findElement(By.name("Submit")).click();
		Thread.sleep(3000);
		
		System.out.println("User Logged in Successfully");

	}
	
	@AfterMethod
	public void clickLogout() {
		driver.findElement(By.linkText("Logout")).click();
		driver.close();
	}
	
	@AfterTest
	public void testExit() {
		
		System.out.println("Test Exit");
		
	}
	
}
