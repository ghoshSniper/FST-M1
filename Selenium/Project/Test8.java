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

public class Test8 {
	
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
    public void TestCase8() throws InterruptedException {
    	
    	driver.findElement(By.xpath("//a[text()='Contact']")).click();
    	Thread.sleep(2000);
    	WebElement userID = driver.findElement(By.xpath("//*[@name='wpforms[fields][0]']"));
    	userID.sendKeys("Albert Einstein");
    	WebElement password = driver.findElement(By.xpath("//*[@name='wpforms[fields][1]']"));
    	password.sendKeys("einsteinRocks@lightyr.com");
    	WebElement subject = driver.findElement(By.xpath("//*[@name='wpforms[fields][3]']"));
    	subject.sendKeys("E is equal MC squared!");
    	WebElement description = driver.findElement(By.xpath("//*[@name='wpforms[fields][2]']"));
    	description.sendKeys("I won Nobel for this.");
    	
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(2000));
    	wait.until((ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@type='submit']")))));
    	driver.findElement(By.xpath("//button[@type='submit']")).click();
    	Thread.sleep(2000);
    	String text = driver.findElement(By.xpath("//*[@id='wpforms-confirmation-8']")).getText();
    	Assert.assertEquals(text, "Thanks for contacting us! We will be in touch with you shortly.");
   }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        //Close the browser
    	driver.quit();
    }

}
