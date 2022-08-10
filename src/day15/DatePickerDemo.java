package day15;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerDemo {
	
	public static WebDriver driver;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		String month ="March";
		String date ="20";
		
		
		driver.findElement(By.xpath("//*[@id=\"datepicker\"]")).click();
		//selectCurrentDate();
		//selectFutureDate(date,month);
		selectPastDate(date,month);
		/*
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]/span")).click(); // get the xpath for prev month
		String mon = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span[1]")).getText();
		System.out.println("1 " + mon);
		
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]/span")).click(); // get the xpath for prev month
		 mon = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span[1]")).getText();
		System.out.println("2 " + mon);
		
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]/span")).click(); // get the xpath for prev month
		 mon = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span[1]")).getText();
		System.out.println("3 " + mon);
		
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]/span")).click(); // get the xpath for prev month
		 mon = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span[1]")).getText();
		System.out.println("4 " + mon);
		*/
	}
	
	static void selectFutureDate(String d, String m)
	{
		Calendar cal = Calendar.getInstance();
		int currentmonth = cal.get(Calendar.MONTH)+1;
		System.out.println("Currentmonth = " + currentmonth);
		for (int i =currentmonth; i>=1;i++)
		{
			driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span")).click();
										 //*[@id="ui-datepicker-div"]/div/div/span[1]
			                                           //*[@id="ui-datepicker-div"]/div/div
			String mon = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span[1]")).getText();
			System.out.println("If " + mon + " equals " +m) ;
			if (mon.equals(m))
			{
				driver.findElement(By.linkText(d)).click();
				System.out.println("Breaking from the loop");
				break;
			}	
		}		
	}

	
	static void selectPastDate(String d , String m)
	{
		Calendar cal = Calendar.getInstance();
		int currentMonth = cal.get(Calendar.MONTH);
		
		System.out.println("currentMonth = " +currentMonth);
		
		for (int i=currentMonth;i>=1;i++)
		{
			System.out.println("Value of i =" + i + " currentMonth = " + currentMonth );
			driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]/span")).click(); // get the xpath for prev month
			                                         
			String mon = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span[1]")).getText();
			                                          //*[@id="ui-datepicker-div"]/div/div/span[1]
			System.out.println("If " + mon + " equals " +m) ;
			if (mon.equals(m))
			{
				driver.findElement(By.linkText(d)).click();
				System.out.println(mon);
				break;
			}
			
		}
	}
	
	static void selectCurrentDate()
	{
		Calendar cal = Calendar.getInstance();
		int d =cal.get(Calendar.DATE);
		String date = String.valueOf(d);
		driver.findElement(By.linkText(date)).click();
	}
	
	
}
