package SeleniumAssignments;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_1 {
	
	WebDriver d;
	String url="https://accounts.google.com/signup";

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\SELENIUM\\chromedriver.exe");
		d=new ChromeDriver();
		d.get(url);
		d.manage().window().maximize();
	}

	@After
	public void tearDown() throws Exception {
		d.quit();
	}

	@Test
	public void test() throws InterruptedException {
		//Checking First Name text field
		d.findElement(By.id("firstName")).sendKeys("Sayali");

		//Checking First Name text field
		d.findElement(By.id("lastName")).sendKeys("Gosavi");
		
		//Checking Username text field
		WebElement username = d.findElement(By.id("username"));
		username.sendKeys("SayaliGosavi545");
		System.out.println("Username : "+username.getAttribute("value"));

		//Checking Password text field
		d.findElement(By.name("Passwd")).sendKeys("Sayali@1234");

		//Checking Confirm password text field
		d.findElement(By.name("ConfirmPasswd")).sendKeys("Sayali@1234");
	
		//Clicking on Next Button
		d.findElement(By.xpath("//*[@id=\"accountDetailsNext\"]/span/span")).click();
		
		Thread.sleep(2000);
		//Checking whether next page is coming
		String actualHeading = d.findElement(By.id("headingText")).getText();
		Assert.assertTrue(actualHeading.equals("Verifying your phone number"));
		System.out.println("Actual Heading is : "+actualHeading);	
	}
}
