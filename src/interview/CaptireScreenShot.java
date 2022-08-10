package interview;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptireScreenShot {

	public static void main(String[] args) throws IOException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");
		
		
		//full page screenshot
		/*
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source	=ts.getScreenshotAs(OutputType.FILE);
		File target =new File(".//ScreenShots//homepage.png");
		FileUtils.copyFile(source, target);
		*/
		
		/*
		// Screenshot of scction/portion of the page
		WebElement section = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[4]"));
		File source	=section.getScreenshotAs(OutputType.FILE);
		File target =new File(".//ScreenShots//featuredproduct.png");
		FileUtils.copyFile(source, target);
		*/
		

		// Screenshot of specific webelement
		WebElement webelement = driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[2]/div[1]/a/img"));
		File source	=webelement.getScreenshotAs(OutputType.FILE);
		File target =new File(".//ScreenShots//logo.png");
		FileUtils.copyFile(source, target);
		//driver.close();
		

	}

}
