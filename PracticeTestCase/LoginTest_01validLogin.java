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

public class LoginTest_01validLogin {
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
		String userName = "Uyghurkid@gmail.com";
		String password = "HardWorkBeatsTalent123!";
		//My account
		driver.findElement(By.xpath("//li[@id=\"menu-item-50\"]/a")).click();
		driver.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys(password);
		driver.findElement(By.xpath("//div[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]")).click();
		
		WebElement signOutText = driver.findElement(By.xpath("//div[@class='woocommerce-MyAccount-content']/p[1]/a"));
		
		if(signOutText.getText().contains("Sign out")) {
			System.out.println("Succesfull Login");
		}else {
			System.out.println("Invalid");
		}
		
		
		
		
	}
	
	@After
	public void closeIt () {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.close();
	}
} //end class
