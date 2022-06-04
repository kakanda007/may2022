package qaautomation.may2022;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class WebTestAfterRefactor extends BaseWebTest {
	

	@Test
	public void testLogin() {
	
		
		//cara mendapatkan usernam dengan xpath
		driver.get().findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
		driver.get().findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
		driver.get().findElement(By.xpath("//button[@type='submit']")).click();
		String actualText = driver.get().findElement(By.xpath("//div[@id='flash']")).getText();
		String expectedText = "You logged into a secure area!";
		System.out.println(actualText);
		
		Assert.assertTrue(actualText.contains(expectedText));
		
		
	}
	
	@Test
	public void testPasswordFailed() {

		
		//cara mendapatkan usernam dengan xpath
		driver.get().findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
		driver.get().findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!123");
		driver.get().findElement(By.xpath("//button[@type='submit']")).click();
		String actualText = driver.get().findElement(By.xpath("//div[@id='flash']")).getText();
		String expectedText = "Your password is invalid";
		System.out.println(actualText);
		System.out.println(expectedText);
		Assert.assertTrue(actualText.contains(expectedText));

		
	}
	
	@Test
	public void testLoginFailed() {

		
		//cara mendapatkan usernam dengan xpath
		driver.get().findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith123");
		driver.get().findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
		driver.get().findElement(By.xpath("//button[@type='submit']")).click();
		String actualText = driver.get().findElement(By.xpath("//div[@id='flash']")).getText();
		String expectedText = "Your password is invalid";
		System.out.println(actualText);
		System.out.println(expectedText);
		Assert.assertTrue(actualText.contains(expectedText));

		
	}
	@Test
	public void testLoginFailedWrongUsernameandPassword() {

		
		//cara mendapatkan usernam dengan xpath
		driver.get().findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith123");
		driver.get().findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!123");
		driver.get().findElement(By.xpath("//button[@type='submit']")).click();
		String actualText = driver.get().findElement(By.xpath("//div[@id='flash']")).getText();
		String expectedText = "Your username is invalid";
		System.out.println(actualText);
		System.out.println(expectedText);
		Assert.assertTrue(actualText.contains(expectedText));

		
	}
}