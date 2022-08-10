package datepickers;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickersDemo2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.expedia.ca/");
		driver.findElement(By.xpath("//*[@id=\"d1-btn\"]")).click();
		
		String month = "May 2022";
		String exp_date ="15";
		Thread.sleep(2000);
		/*
		while(true)
		{
			String displayed_month ="";
			driver.findElement(By.xpath("//*[@id=\"app-layer-datepicker-check-in-out-start\"]/div[2]/div/div/div[2]/div/div[1]/h2")).click();
			                        //driver.findElement(By.xpath("//*[@id=\"app-layer-datepicker-check-in-out-start\"]/div[2]/div/div/div[2]/div/div[1]/h2"))
			System.out.println("displayed_month = " + displayed_month);
			if (displayed_month.equals(month)	)
			{		
				break;
			}
			else
			{
				driver.findElement(By.xpath("//*[@id=\"wizard-hotel-pwa-v2-1\"]/div[2]/div[2]/div/div/div[1]/div/div[2]/div/div[2]/div[1]/button[2]")).click();
			}
		}
		*/
		
		System.out.println("getting dates");
		List <WebElement> allDates = driver.findElements(By.xpath("//*[@id=\"app-layer-datepicker-check-in-out-end\"]/div[2]/div/div/div[2]/div/div[1]/table/tbody/tr/td/button"));
		
		for(WebElement ele : allDates)
		{
			System.out.println("value =" + ele.getText());
			String date_text=ele.getText();
			String date[] = date_text.split("\n");
			if (date[1].equals(exp_date))
			{
				ele.click();
				break;
			}			
		}
		System.out.println("ending dates");
	}
	
}	

