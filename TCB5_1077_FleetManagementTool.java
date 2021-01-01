package hwIntroSelenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TCB5_1077_FleetManagementTool {
		/*
		User story: As a user, I should be able to login VyTrack app.

		test case1: login successfully
		1. go to VyTrack login page
		2. write username   data: storemanager52
		3.write password           UserUser123
		4. click login button
		5.Verify that the user is on the homepage

		test cases2: login invalid cridential
		1. go to login page
		2.write invalid usr name
		3.write invalid password
		4. click login bttn
		5.verify that user see error message "Invalid user name or password."
		*/

	WebDriver driver; 
	String successLogin = "Dashboard";
	
	@Before
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://app.vytrack.com/user/login");
		driver.manage().window().maximize();
	}
	
	@Test 
	public void validLoginTest () {
		driver.findElement(By.id("prependedInput")).sendKeys("storemanager52");
		driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
		driver.findElement(By.id("_submit")).click();
		String verifyHP = driver.getTitle();
		if (verifyHP.equals(successLogin)) {
			System.out.println("User is on the homepage");
		}
	}
	
	@Test 
	public void invalidLoginTest () {
		driver.findElement(By.id("prependedInput")).sendKeys("test123");
		driver.findElement(By.id("prependedInput2")).sendKeys("password123");
		driver.findElement(By.id("_submit")).click();
		String verifyHP = driver.getTitle();
		if (!verifyHP.equals(successLogin)) {
			System.out.println("Invalid user name or password.");
		}
	}
	
	@After
	public void closeIt () {
		driver.close();
	}

}// end class
