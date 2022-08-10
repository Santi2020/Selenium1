package interview;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorDemo {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");
		
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript(Script, args)
		
		//Flash an element
		
		//Drawing border and taking screenshot
		WebElement element = driver.findElement(By.xpath("//*[@id=\"small-searchterms\"]"));
		JavaScriptUtil.drawBorder(element, driver);
		/*
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File tgt = new File(".//ScreenShots/JScreenshotElement.png");
		FileUtils.copyFile(src, tgt);
		*/
		//Getting title of a page
		String title = JavaScriptUtil.getTitleByJS(driver);
		System.out.println("Title = " + title);
		
		//click action
		//element.sendKeys("Sales");
		//WebElement button = driver.findElement(By.xpath("//*[@id=\"small-search-box-form\"]/button"));
		//JavaScriptUtil.clickElementByJS(button, driver);
		
		//Generate alert
		//JavaScriptUtil.generateAlert(driver , "How are you?");
			
		//refresh page
		//JavaScriptUtil.refreshBrowserByJS(driver);
		
		//scrolling down the page
		//JavaScriptUtil.scrollPageDown(driver);
		
		Thread.sleep(3000);
		//scrolling up the page
		//JavaScriptUtil.scrollPageUp(driver);
				
		//zoom in and out
		//JavaScriptUtil.zoomPageByJS(driver);
		
		//flash
		
		JavaScriptUtil.flash(element, driver);
	}

}
