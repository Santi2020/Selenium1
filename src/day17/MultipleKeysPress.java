package day17;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MultipleKeysPress {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		//Thread.sleep(5000);
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//*[@id=\"RESULT_TextField-1\"]")).sendKeys("Hello   ");
		Thread.sleep(5000);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.CONTROL+"a").build().perform();
		System.out.println("Done");

	}

}
