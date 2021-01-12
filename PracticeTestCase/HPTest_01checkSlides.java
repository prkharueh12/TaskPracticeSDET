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

public class HPTest_01checkSlides {
/*1) Open the browser
2) Enter the URL “http://practice.automationtesting.in/”
3) Click on Shop Menu
4) Now click on Home menu button
5) Test whether the Home page has Three Sliders only
6) The Home page must contains only three sliders*/
	
WebDriver driver;
	
	@Before
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://practice.automationtesting.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void testSlides () throws InterruptedException {
		WebElement shopButton = driver.findElement(By.xpath("//header/div[2]/nav/ul//li[@id = 'menu-item-40']"));
		shopButton.click();

		WebElement homeButton = driver.findElement(By.xpath("//div/nav//a [@href= 'http://practice.automationtesting.in']"));
		homeButton.click();
		
		
		// move to next slides
		WebElement arrow = driver.findElement(By.xpath("//div[@id=\"n2-ss-6\"]/div[3]//img[@class='n2-ow']"));
		//get Attribute from the pics text
		WebElement pic1 = driver.findElement(By.xpath("//div[@id=\"n2-ss-6\"]/div/div/div//div[@data-id='36']"));
		String p1 = pic1.getAttribute("data-id");
		System.out.println(p1 + " This is slide 1");
		arrow.click();
		Thread.sleep(5000);
		
		WebElement pic2 = driver.findElement(By.xpath("//div[@id=\"n2-ss-6\"]/div/div/div//div[@data-id='35']"));
		String p2 = pic2.getAttribute("data-id" );
		System.out.println(p2 +" This is slide 2");
		arrow.click();
		Thread.sleep(5000);
		
		WebElement pic3 = driver.findElement(By.xpath("//div[@id=\"n2-ss-6\"]/div/div/div//div[@data-id='34']"));
		String p3 = pic3.getAttribute("data-id");
		System.out.println(p3+" This is slide 3");
		arrow.click();
		Thread.sleep(5000);
		
		WebElement picChk = driver.findElement(By.xpath("//div[@id=\"n2-ss-6-align\"]/div/div/div/div/div//div[@data-slide-duration='0']"));
		String chkSlide = picChk.getAttribute("data-id");
		System.out.println(chkSlide);
		
		
		if(chkSlide.equals(p1)) {
		System.out.println("(PASS!! Expected: There are only 3 slides)");
		}else {
			System.out.println("FAIL! There are more than 3 slides.");
		}
			
	}
	
	@After
	public void closeIt () throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
	}
} // end class
