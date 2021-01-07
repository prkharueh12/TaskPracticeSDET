package taskPracticeAuto;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest_02BothInvalidLogin {
WebDriver driver;
	
	@Before
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://practice.automationtesting.in/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void testSlides () {
		String InvalidUserName = "test@gmail.com";
		String InvalidPassword = "Test1235678!";
		//My account
		driver.findElement(By.xpath("//li[@id=\"menu-item-50\"]/a")).click();
		driver.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys(InvalidUserName);
		driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys(InvalidPassword);
		driver.findElement(By.xpath("//div[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]")).click();
		
		WebElement verify = driver.findElement(By.xpath("//div[@id=\"page-36\"]/div/div[1]/ul/li/strong[1]"));
	
		if(verify.getText().contains("ERROR")) {
			System.out.println("PASS (Expected to see: ERROR)");
		}else {
			System.out.println("Failed");
		}
		
		
		
		
	}
	
	@After
	public void closeIt () {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.close();
	}
}
