package datepickers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickersDemo1 {

	public static void main(String[] args) throws InterruptedException {
		String month ="May 2023";
		String day ="15";
		
		System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://phptravels.net/");
		driver.findElement(By.xpath("//*[@id=\"checkin\"]")).click();
		Thread.sleep(2000);
		String dpMonth="";
		while(true)
		{
			try 
			{
				WebElement dpMonthElement =driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[3]/div[1]/table/thead/tr[1]/th[2]")) ;
				dpMonth = dpMonthElement.getText();
				System.out.println("Month = " +dpMonth);
			}
			catch(Exception e)
			{
				System.out.println("1st exception "+ e.getMessage());
			}
			
			
			if (dpMonth.equals(month))
			{
				break;
			}
			else
			{
				driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[3]/div[1]/table/thead/tr[1]/th[3]/i")).click();
			    
			}
		}
		
		Thread.sleep(2000);
		try
		{			
			System.out.println("Now clicking the date");
			driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[3]/div[1]/table/tbody/tr/td[contains(text(),"+day+")]")).click();
		}
		catch(Exception e)
		{
			System.out.println("Date Selection error "+e.getMessage());
		}
			
	}

}
