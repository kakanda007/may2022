package qaautomation.may2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FocusTest {
	@Test
	public void testLogin() {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://ajep.focusolusi.id/login");
		
		//cara mendapatkan usernam dengan xpath
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("teamit");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("focus");
		driver.findElement(By.xpath("//button[normalize-space()='Log In']")).click();
		String actualText = driver.findElement(By.xpath("//div[contains(text(),'Tugas Yang Tertunda')]")).getText();
		String expectedText = "Logo";
		System.out.println(actualText);
		System.out.println(expectedText);
		Assert.assertTrue(actualText.contains(expectedText));
		driver.quit();
	}
}
