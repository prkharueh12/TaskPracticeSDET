package hwIntroSelenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TCB5_1076_EbaySearch {
	
		
		/*
		Task:
		Go to amazon  https://www.amazon.com/
		then  Go to Ebay   https://www.ebay.com/
		Enter a search term - “shoes”
		Click on search button
		Verify title contains search term
		*/



		WebDriver driver; 
		
		@Before
		public void beforeMethod() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://www.amazon.com/");
			driver.get("https://www.ebay.com/");
			driver.manage().window().maximize();
		}
		
		@Test 
		public void searchShoes () {
			driver.findElement(By.id("gh-ac")).sendKeys("shoes");
			driver.findElement(By.id("gh-btn")).click();
			String titleSearch = driver.getTitle();
			System.out.println(titleSearch);
		}
		
		@After
		public void closeIt ( ) {
			driver.close();
		}
		
}

