package interview;

import java.time.Duration;

import java.util.List;
import java.util.NoSuchElementException;
//import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class FluentWaitDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//Fluent wait declaration
		Wait <WebDriver> mywait = new FluentWait<WebDriver> (driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
				
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("selenium") ;
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		
		
		//driver.findElement(By.xpath("//h3[text()='Selenium']")).click();
		
		//Usage of fluent wait
		WebElement element = mywait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//h3[text()='Selenium']"));
			}
		}) ;
		
		System.out.println("Clicking the element");
		element.click();
		System.out.println("Done");
	}

}
