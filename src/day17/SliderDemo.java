package day17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/slider/");
		driver.switchTo().frame(0);
		WebElement slider = driver.findElement(By.xpath("//*[@id=\"slider\"]/span"));
		
		Actions act = new Actions(driver);
		act.moveToElement(slider).dragAndDropBy(slider, 100, 0).build().perform();
		Thread.sleep(5000);
		act.moveToElement(slider).dragAndDropBy(slider, 100, 0).build().perform();
		Thread.sleep(5000);
		act.moveToElement(slider).dragAndDropBy(slider, 100, 0).build().perform();
		Thread.sleep(5000);
		
		act.moveToElement(slider).dragAndDropBy(slider, 100, 0).build().perform();
		Thread.sleep(5000);
		
		act.moveToElement(slider).dragAndDropBy(slider, 100, 0).build().perform();
		Thread.sleep(5000);
		
		act.moveToElement(slider).dragAndDropBy(slider, 100, 0).build().perform();
		Thread.sleep(5000);
		
		act.moveToElement(slider).dragAndDropBy(slider, 100, 0).build().perform();
		Thread.sleep(5000);
		
	}

}
