package hwIntroSelenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TCB5_1084_OrageHRMLogin {

	/*	1. Go on OrangeHRM (https://opensource-demo.orangehrmlive.com/index.php/dashboard)
		2. Login with valid credentials ( Username : Admin | Password : admin123 )
		3. Confirm you're logged in by getting the current URL, 
		and using the Java Substring to extract the page name and that is equal to "dashboard"*/
	
	WebDriver driver; 
	String verifyURL;
	String page = "dashborad";
	int pageLength = page.length();
	
	@Before
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
	}
	
	@Test 
	public void validLoginTest () {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		 verifyURL = driver.getCurrentUrl();
		System.out.println(verifyURL);
		
		System.out.println(verifyURL.substring(verifyURL.length()-pageLength, verifyURL.length()));
			
		
	}
	
	@After
	public void closeIt () {
		driver.close();
	}

}//end class
