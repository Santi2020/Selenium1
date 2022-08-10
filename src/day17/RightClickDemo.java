package day17;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		Actions act = new Actions(driver);
		
		WebElement rclickbtn = driver.findElement(By.xpath("/html/body/div/section/div/div/div/p/span"));
		act.contextClick(rclickbtn).build().perform(); // perform right click 
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/ul/li[3]")).click() ; // Capture the xpath of copy
		
		Alert alert = driver.switchTo().alert();
		Thread.sleep(3000);
		String str = alert.getText();
		System.out.println(str);
		alert.accept();
		
		
		
		
	}

}
