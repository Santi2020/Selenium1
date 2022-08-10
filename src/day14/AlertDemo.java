package day14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		//driver.switchTo().frame(0);
		driver.findElement(By.xpath("//*[@id=\"HTML9\"]/div[1]/button")).click();
		Thread.sleep(5000);
		//driver.switchTo().alert().accept();
		
		driver.switchTo().alert().dismiss();
	}

}
