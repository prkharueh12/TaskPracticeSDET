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

public class LoginTest_05PasswordMasked {
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
		
		String emptyPassword = "TestABC123!!";
		//My account
		driver.findElement(By.xpath("//li[@id=\"menu-item-50\"]/a")).click();
		
		driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys(emptyPassword);
	
		
		WebElement password = driver.findElement(By.xpath("//input[@id=\"password\"]"));
	
		if(password.getAttribute("Type").equalsIgnoreCase("password")) {
			System.out.println("PASS (Password has been masked.)");
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
