package day14;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWaitDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		//Thread.sleep(5000);
		
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//*[@id=\"RESULT_TextField-1\"]")).sendKeys("Tisha Anika");
		driver.findElement(By.xpath("//*[@id=\"RESULT_TextField-2\"]")).sendKeys("Bandi");
		driver.findElement(By.xpath("//*[@id=\"RESULT_TextField-3\"]")).sendKeys("22334455");
		driver.findElement(By.xpath("//*[@id=\"RESULT_TextField-4\"]")).sendKeys("United States of America");
		driver.findElement(By.xpath("//*[@id=\"RESULT_TextField-5\"]")).sendKeys("Livermore");
		driver.findElement(By.xpath("//*[@id=\"RESULT_TextField-6\"]")).sendKeys("abcde@gmail.com");
		

	}

}
