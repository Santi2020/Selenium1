package staleelementexception;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementExceptionDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://pavanonlinetrainings.com/");
		WebElement link = driver.findElement(By.xpath("//*[@id=\"masthead\"]/div/div/div/div/nav/ul/li[3]/a"));
		link.click();
		driver.findElement(By.xpath("//*[@id=\"masthead\"]/div/div/div/div/nav/ul/li[3]/ul/li/a")).click();
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);
		try
		{
		link.click();
		}
		catch(StaleElementReferenceException e)
		{
		    link = driver.findElement(By.xpath("//*[@id=\"masthead\"]/div/div/div/div/nav/ul/li[3]/a"));
			link.click();
		}
	}

}



