package day17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ResizingDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/resizable/");
		Thread.sleep(3000);
		driver.switchTo().frame(0);
		
		WebElement resize_element = driver.findElement(By.xpath("//*[@id=\"resizable\"]/div[3]")); //get the resiable element present in the bottom right corner
		Actions act =new Actions(driver);
		Thread.sleep(3000);
		act.moveToElement(resize_element).dragAndDropBy(resize_element, 60, 70).build().perform();		
		
	}

}
