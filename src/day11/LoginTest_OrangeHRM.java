package day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LoginTest_OrangeHRM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		
		// firefox browser
		System.setProperty("webdriver.gecko.driver", "C://Drivers//geckodriver-v0.30.0-win64/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();

		//System.setProperty("webdriver.ie.driver", "C://Drivers//IEDriverServer_Win32_4.0.0/IEDriverServer.exe");
		//WebDriver driver = new InternetExplorerDriver();


		//System.setProperty("webdriver.edge.driver", "C://Drivers//edgedriver_win64/msedgedriver.exe");
		//WebDriver driver = new EdgeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com");
		
		//WebElement usernametxt = driver.findElement(By.id("txtUsername"));
		//usernametxt.sendKeys("Admin");
		
		//id="txtUsername" 
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.name("Submit")).click();
		
		String act_title = driver.getTitle();
		String exp_title = "OrangeHRM";
		if (act_title.equals(exp_title))
		{
			System.out.println("Test passed");
		}
		else
		{
			System.out.println("Test Failed");
		}
		
		//driver.close();
		
	
	}

}
