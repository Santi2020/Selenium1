package day17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickDemo2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("http://api.jquery.com/dblclick/");
		Thread.sleep(1000);
		//Switch to frams
		driver.switchTo().frame(0);
		WebElement square = driver.findElement(By.xpath("/html/body/div"));
		
		Thread.sleep(3000);
		//System.out.print("DONE" + square.getText());
		Actions act = new Actions(driver);
		act.doubleClick(square).build().perform();
		
		Thread.sleep(3000);
		act.doubleClick(square).build().perform();
		
		Thread.sleep(3000);
		act.doubleClick(square).build().perform();
		
		System.out.print("DONE");
		
	}

}
