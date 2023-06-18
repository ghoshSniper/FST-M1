package sel_Project;

import static org.testng.Assert.fail;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dev.failsafe.Timeout;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test9 {

	// Declare the WebDriver object
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		// Set up the Firefox driver
		WebDriverManager.firefoxdriver().setup();
		//Create a new instance of the Firefox driver
		driver = new FirefoxDriver();
		//Open browser
		driver.get("https://alchemy.hguy.co/lms");
	}

	@Test
	public void TestCase9() throws InterruptedException {
		driver.findElement(By.xpath("//*[text()='My Account']")).click();
		Thread.sleep(2000);
		String myAccountTitle = driver.findElement(By.xpath("//h1[@class='uagb-ifb-title']")).getText();
		System.out.println(myAccountTitle);
		if(!(myAccountTitle.trim().equals("My Account")))
		{
			fail("Account name is not matching");
		}
		driver.findElement(By.xpath("//*[text()='Login']")).click();
		WebElement userID = driver.findElement(By.xpath("//*[@id='user_login']"));
		userID.sendKeys("root");
		WebElement password = driver.findElement(By.xpath("//*[@id='user_pass']"));
		password.sendKeys("pa$$w0rd");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(2000));
		wait.until((ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@type='submit']")))));
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='All Courses']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='entry-content clear']//div[@class='ld-course-list-items row']/div[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(text(),' Developing Strategy')]//parent::*/div[1]")).click();
		String textURL = driver.getTitle();
		System.out.println(textURL);
		if(!(textURL.equals("Developing Strategy – Alchemy LMS")))
		{
			fail("Page title is not matching");
		}

		String buttonText = driver.findElement(By.xpath("//*[text()='Back to Course']/parent::*/div[2]")).getText();
		if (!buttonText.equals("Next Lesson"))
		{
			driver.findElement(By.xpath("//*[text()='Back to Course']/parent::*/div[2]")).click();
		}

		else
		{
			System.out.println("Marking already completed.");
			
		}
	}




	@AfterMethod
	public void afterMethod() throws InterruptedException {
		//Close the browser
		driver.quit();
	}

}
