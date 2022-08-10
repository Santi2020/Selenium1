package day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SignInTest {
	
	void chromeTest()
	{
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		test_elements(driver);
	}
	
	void firefoxTest()
	{
		System.setProperty("webdriver.gecko.driver", "C://Drivers//geckodriver-v0.30.0-win64/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		test_elements(driver);
	}
	
	
	void edgeTest()
	{
		System.setProperty("webdriver.edge.driver", "C://Drivers//edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		test_elements(driver);
	}
	
	
	void test_elements(WebDriver driver)
	{
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		
		driver.findElement(By.id("btnLogin")).click();
		
		String page_title = driver.getTitle();
		String test_title = "OrangeHRMs";
		if (page_title.equals(test_title))
		{
			System.out.println("Title Matched"); 
		}
		else
		{
			System.out.println("Title not matched");
		}
		
		driver.close();

	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SignInTest test_obj = new SignInTest();
		//test_obj.chromeTest();
		
		//test_obj.firefoxTest();
		test_obj.edgeTest();
		
	}

}
