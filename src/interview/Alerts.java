package interview;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		
		//javascript with OK button
		//driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button")).click();
		//Thread.sleep(5000);
		//driver.switchTo().alert().accept();
		
		//Alert window with ok and cancel
		//driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button")).click();
		//Thread.sleep(5000);
		//driver.switchTo().alert().accept();
		//driver.switchTo().alert().dismiss();
		
		//Alert window with input box, capture text from alert
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button")).click();
		Thread.sleep(3000);
		Alert  alertWindow = driver.switchTo().alert();
		System.out.println("Alert window test = " + alertWindow.getText());
		alertWindow.sendKeys("Hello");
		Thread.sleep(3000);
		alertWindow.accept();		
	}

}
