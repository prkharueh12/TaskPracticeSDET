package hwIntroSelenium;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TCBS_1119_HardAlert {
	
	WebDriver driver;

	@Before
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}
	
	@Test

	public void clickThirdBox() throws InterruptedException {
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,300)");
		
		
		WebElement promptBox = driver.findElement(By.xpath("//div[@class = 'panel panel-primary'][3]/div[2]//button[@class = 'btn btn-default btn-lg']"));
		
		WebElement verifyTxt = driver.findElement(By.xpath("//div[@class = 'panel panel-primary'][3]/div[2]//p[@id= 'prompt-demo']"));
		String beforeClickTxt = verifyTxt.getText();
		System.out.println("The text before clicking :" + beforeClickTxt);
		
		// declare action object with driver inside
		Actions act = new Actions (driver);
		act.click(promptBox).perform();
		Thread.sleep(2000);
		
		//enter name and accept
		String myName = "Ronaldonho";
		driver.switchTo().alert().sendKeys(myName);
		driver.switchTo().alert().accept();
		
		//verify text displayed
		String expectedTxt = verifyTxt.getText();
		System.out.println("The text after entering name :" + expectedTxt);
		Assert.assertTrue(verifyTxt.isDisplayed());

		Assert.assertNotEquals(beforeClickTxt, expectedTxt);
	
	}

	
	@After
	public void closeIt() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	
	 
}
}//end class
