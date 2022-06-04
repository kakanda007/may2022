package qaautomation.may2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class WebTest {

	@Test
	public void testLogin() {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/login");
		
		//cara mendapatkan usernam dengan xpath
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actualText = driver.findElement(By.xpath("//div[@id='flash']")).getText();
		String expectedText = "You logged into a secure area!";
		System.out.println(actualText);
		
		Assert.assertTrue(actualText.contains(expectedText));
		driver.quit();
		
	}
	
	@Test
	public void testPasswordFailed() {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/login");
		
		//cara mendapatkan usernam dengan xpath
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actualText = driver.findElement(By.xpath("//div[@id='flash']")).getText();
		String expectedText = "Your password is invalid";
		System.out.println(actualText);
		System.out.println(expectedText);
		Assert.assertTrue(actualText.contains(expectedText));
		driver.quit();
		
	}
	
	@Test
	public void testLoginFailed() {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/login");
		
		//cara mendapatkan usernam dengan xpath
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith123");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actualText = driver.findElement(By.xpath("//div[@id='flash']")).getText();
		String expectedText = "Your username is invalid";
		System.out.println(actualText);
		System.out.println(expectedText);
		Assert.assertTrue(actualText.contains(expectedText));
		driver.quit();
		
	}
	@Test
	public void testLoginFailedWrongUsernameandPassword() {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/login");
		
		//cara mendapatkan usernam dengan xpath
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith123");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actualText = driver.findElement(By.xpath("//div[@id='flash']")).getText();
		String expectedText = "Your username is invalid";
		System.out.println(actualText);
		System.out.println(expectedText);
		Assert.assertTrue(actualText.contains(expectedText));
		driver.quit();
		
	}
}