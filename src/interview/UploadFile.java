package interview;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadFile {

	public static void main(String[] args) throws AWTException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		driver.get("https://www.monsterindia.com/rio/login");
		
		//click upload resume
		driver.findElement(By.xpath("//*[@id=\"ssoDefault\"]/div/div/div/div[2]/div[2]/div[1]/div[2]/div/a")).click();		
		
		//using sendkeys method upload the file 
		//driver.findElement(By.xpath("//*[@id=\"file-upload\"]")).sendKeys("C:\\Users\\TISHAN1KA\\eclipse-workspace\\Selenium1\\Downloads\\Test.doc");

		//using Robot class method
		WebElement uploadButton = driver.findElement(By.xpath("//*[@id=\"file-upload\"]"));
		JavascriptExecutor js =  (JavascriptExecutor) driver;
		
		//perform click action on the button
		js.executeScript("arguments[0].click();", uploadButton);
		
		/*
		 * Copy the path to the clipboard
		 * control + V
		 * click on open button
		 * */
		 Robot rb = new Robot();
		 rb.delay(2000);
		 //Copy the path to the clipboard
		 StringSelection ss = new StringSelection("C:\\Users\\TISHAN1KA\\eclipse-workspace\\Selenium1\\Downloads\\Test");
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		 
		 rb.keyPress(KeyEvent.VK_CONTROL); // press control
		 rb.keyPress(KeyEvent.VK_V); // press v
		 
		 rb.keyRelease(KeyEvent.VK_CONTROL);
		 rb.keyRelease(KeyEvent.VK_V);
		 
		 rb.keyPress(KeyEvent.VK_ENTER);
		 rb.keyRelease(KeyEvent.VK_ENTER);
		 
		 
	}

}
