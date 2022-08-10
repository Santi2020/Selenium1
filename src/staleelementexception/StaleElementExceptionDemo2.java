package staleelementexception;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementExceptionDemo2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://freecrm.com/index.html");
		driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul/li[1]/a")).click();
		Thread.sleep(10000);
		try
		{
		//username
		WebElement username = driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div/form/div/div[1]/div/input"));
		username.sendKeys("admin");
		System.out.println("Entered username");
		}
		catch(StaleElementReferenceException e)
		{
			WebElement username = driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div/form/div/div[1]/div/input"));
			username.sendKeys("admin");
			System.out.println("Exception Entered username");
		}
		
		try
		{
		//password
		WebElement password = driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div/form/div/div[2]/div/input"));
		password.sendKeys("admin");
		System.out.println("Entered password");
		}
		catch(StaleElementReferenceException e)
		{
			//password
			WebElement password = driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div/form/div/div[2]/div/input"));
			password.sendKeys("admin");
			System.out.println("Exception  Entered password");
		
		}
		driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div/form/div/div[3]")).click();
		
	}

}


