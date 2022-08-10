package day14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitDemo {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait mywait = new WebDriverWait(driver,10000);
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.switchTo().frame(0);
		
		WebElement username = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"RESULT_TextField-1\"]")));
		username.sendKeys("NEW NAME");
		
		WebElement pwd = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"RESULT_TextField-2\"]")));
		pwd.sendKeys("MY NEW PASSWORD");
		//driver.findElement(By.xpath("//*[@id=\"RESULT_TextField-2\"]")).sendKeys("Bandi");
		
	}

}
