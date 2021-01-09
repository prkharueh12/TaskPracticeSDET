package hwIntroSelenium;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TCBS_1109_WoodenSpoonNumber {
	
	 WebDriver driver;
		
		@Before
		public  void beforeMethod() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://www.ebay.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		}
		
		
			@Test
			
			public  void secondNameMatchTest () {
				//searching
			String searchWord = "wooden spoon";
			
			//initialize all web element : search box, All tab, numResult
			WebElement searchBox =  driver.findElement(By.xpath("//header[@id= 'gh']/table/tbody/tr/td[5]/form/table/tbody/tr/td/div/div//input[@id='gh-ac']"));
			//call it and hit enter
			searchBox.sendKeys(searchWord, Keys.ENTER);
			
			WebElement numResult1 =  driver.findElement(By.xpath("//div[@id= 'mainContent']/div/div/div[2]/div/div/h1//span[@class ='BOLD'][1]"));
			String originNumRe = numResult1.getText();
			System.out.println("Before result: "+originNumRe);
			
			
			WebElement allTab =  driver.findElement(By.xpath("//div[@id= 'x-refine__group__0']/ul/li/a//span"));
			allTab.click();
			
			WebElement numResult2 =  driver.findElement(By.xpath("//div[@id= 'mainContent']/div/div/div[2]/div/div/h1//span[@class ='BOLD'][1]"));
			String allTbNumRe = numResult2.getText();
			System.out.println("After click All result: "+allTbNumRe);
			
			//convert String to int
			NumberFormat format = NumberFormat.getInstance(Locale.US);
			  Number digitBefore = 0;
			  Number digitAfter = 0;
			  try {
				  digitBefore = format.parse(originNumRe);
				  digitAfter = format.parse(allTbNumRe);
			  } catch (ParseException e) {
			   e.printStackTrace();
			  }

			int beforeNum = digitBefore.intValue();
			int afterNum = digitAfter.intValue();
//			System.out.println(beforeNum);
//			System.out.println(afterNum);
			
			if (beforeNum < afterNum ) {
				System.out.println("PASS (Expected: All tab result number ("+ afterNum + ") is greater than original result number ("+beforeNum+").)");
			}else {
				System.out.println("*****FAIL!!*****");
			}
			
			// navigate back
			driver.navigate().back();
			//Verify search word still exists.
			WebElement backOutput = driver.findElement(By.xpath("//header[@id= 'gh']/table/tbody/tr/td[5]/form/table/tbody/tr/td/div/div//input[@value='wooden spoon']"));
			String verifyTextSearch = backOutput.getAttribute("value");
	
			if (verifyTextSearch.equalsIgnoreCase(searchWord)) {
				System.out.println("PASS (Expected to see the original search: "+searchWord +  " = After navigate back: "+ verifyTextSearch);
			}else {
				System.out.println("*****FAIL!!*****");
			}
			
			// navigate back to the Home page
			driver.navigate().back();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			
			//verify search box is blank
			WebElement homepageOutput = driver.findElement(By.xpath("//header[@id= 'gh']/table/tbody/tr/td[5]/form/table/tbody/tr/td/div/div//input[1][@placeholder = 'Search for anything']"));
			String verifyTextHomepage = homepageOutput.getAttribute("value");
			System.out.println(verifyTextHomepage);
			
			if (!verifyTextHomepage.equalsIgnoreCase(searchWord)) {
				System.out.println("PASS (Epected: a blank search box)");
			}else {
				System.out.println("*****FAIL!!*****");
			}
			
} //end test
			@After
			public  void closeIt () throws InterruptedException {
				Thread.sleep(5000);
				driver.close();
			}
			
} // end class
			
