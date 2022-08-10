package day20;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import day19.XLUtils;

public class LoginTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		String path="C://santoshi//Selenium//Test/Orange_loginTest.xlsx";
		String sheet = "Sheet1";
				
		int rowcount = XLUtils.getRowCount(path, sheet);
		for (int i=1; i<=rowcount ; i++)
		{
			String username = XLUtils.getCellData(path, sheet, i, 0);
			String password = XLUtils.getCellData(path, sheet, i, 1);
			
			//xpath of username
			driver.findElement(By.xpath("//*[@id=\"txtUsername\"]")).sendKeys(username);
			
			//xpath of password
			driver.findElement(By.xpath("//*[@id=\"txtPassword\"]")).sendKeys(password);
			
			//click login
			driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
			Thread.sleep(3000);
			
			String result="failed";
			if(driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/index.php/dashboard"))
			{
				System.out.println( "Username =" +username +" Password = " +password + " Result = " + "Passed");
				result="Passed";
				XLUtils.setCellData(path, sheet, i, 2, result);
			}
			else
			{
				System.out.println( "Username =" +username +" Password = " +password + " Result = " +"Failed");
				result="Failed";
				XLUtils.setCellData(path, sheet, i, 2, result);
			}
			
			//go back to main page
			//driver.findElement(By.xpath("//*[@id=\"mainMenuLeftArrow\"]"));
			Thread.sleep(3000);
			if (result.equals("Passed"))
			{	
				driver.navigate().back();
			}
		}
		driver.close();
	}

}
