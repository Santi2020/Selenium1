package extentreportingdemo;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class NopCommerceTest {
	public WebDriver driver;
	
	public ExtentHtmlReporter htmlReporter; // Look and feel of the report
	public ExtentReports extent;
	public ExtentTest extentTestobj;
	
	@BeforeTest
	public void setExtent()
	{
		System.out.println("Starting SetExtent");
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/myReport.html"); //location of thee report
		htmlReporter.config().setDocumentTitle("Automation Report"); //Title of the report
		htmlReporter.config().setReportName("Functionsl report"); //Name of the report
		htmlReporter.config().setTheme(Theme.DARK);
		
		
		extent =new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Hostname", "LocalHost");
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Tester Name", "My name");
		extent.setSystemInfo("browser", "chrome");
		
	}
	
	@AfterTest
	public void endReport()
	{
		System.out.println("Starting endReport");
		extent.flush();
	}
	
	
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");

/*		
		System.out.println("Starting Setup method");
		System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver_win32/chromedriver.exe");
		
		System.out.println("Starting Setup method step 2");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Starting Setup method step 3");
		driver.manage().window().maximize();
		
		
		System.out.println("Starting Setup method step 4");
		driver.get("https://demo.nopcommerce.com/");
		
		System.out.println("Starting Setup method all done");
		*/
	}
	
	@Test
	public void nopCommerceTitleTest()
	{
		System.out.println("Starting nopCommerce");
		extentTestobj = extent.createTest("nopCommerceTitleTest");
		String title = driver.getTitle();
		System.out.println("Title = " + title);
		Assert.assertEquals(title, "1nopCommerce demo store");
	}
	
	@Test
	public void nopCommerceLogoTest()
	{
		System.out.println("Starting NopcommerceLogoTest");
		extentTestobj = extent.createTest("nopCommerceLogoTest");
		Boolean logoDisplayed = driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[2]/div[1]/a/img")).isDisplayed() ;
		Assert.assertTrue(logoDisplayed);
	}
	
	@Test
	public void nopCommerceLoginTest()
	{
		System.out.println("Starting nopCommerceLoginTest");
		extentTestobj = extent.createTest("nopCommerceLoginTest");
		
		
		extentTestobj.createNode("Login with valid input");
		Assert.assertTrue(true);
		
		
		extentTestobj.createNode("Login with invalid input");
		Assert.assertTrue(true);
		//driver.findElement(By.linkText("Log in")).click();
		
		//driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys("admin");
		//driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys("admin");
		Assert.assertTrue(true);
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{
		System.out.println("Starting tearDown");
		if (result.getStatus() == ITestResult.FAILURE)
		{
			extentTestobj.log(Status.FAIL, "Failed Test case " + result.getName()); // to add name in the extent report
			extentTestobj.log(Status.FAIL ,"Failed Test case " + result.getThrowable()); // to add error/exception in the extent report
			
			String screenshotpath = NopCommerceTest.getScreenShot(driver, result.getName());
			extentTestobj.addScreenCaptureFromPath(screenshotpath); // adding screenshot
		}else if (result.getStatus() == ITestResult.SKIP)
		{
			extentTestobj.log(Status.SKIP , "Skipped Test case " + result.getName());
			
		}else if (result.getStatus() == ITestResult.SUCCESS ) {
			extentTestobj.log(Status.PASS, "Passed Test case " + result.getName());
		}
	}
	
	public static String getScreenShot(WebDriver driver, String screenshotname) throws IOException
	{
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		String destination = System.getProperty("user.dir")+"/Screenshots/" + screenshotname + dateName+".png";
		File finalDestination = new File (destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
		
		
	}
}
