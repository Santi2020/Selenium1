package interview;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerDemo1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.redbus.in/");
		String year="2022";
		String month = "Oct";
		String date ="12";
		
		driver.findElement(By.id("onward_cal")).click();
		while(true) {
			String monthYear = driver.findElement(By.xpath("//*[@id=\"rb-calendar_onward_cal\"]/table/tbody/tr[1]/td[2]")).getText();
			System.out.println("Month title = " + monthYear );
			
			String  arr[]= monthYear.split(" ");
			String mon = arr[0];
			String yr = arr[1];
			if(year.equals(yr) && (month.equalsIgnoreCase(mon))) {
				break;
			}
			else {
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id=\"rb-calendar_onward_cal\"]/table/tbody/tr[1]/td[3]/button")).click();
			}
		}
		
		
		//Date Selection
		List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='rb-monthTable first last']//tr//td"));
		for(WebElement element : allDates) {
			String day = element.getText();
			System.out.println("Text =" +element.getText());
			if (day.equals(date)) {
				System.out.println("Date found " );
				element.click();
				break;
			}
		}
		
		/*
		for (int row =3;row<8;row++) {
			for(int col = 1; col<=7;col++) {
				String day  = driver.findElement(By.xpath("//*[@id=\"rb-calendar_onward_cal\"]/table/tbody/tr["+row+"]/td["+col+"]")).getText();
				System.out.println("Day = " + day);
				if (day.equals(date)) {
					System.out.println("Expected date match found");
					break;
				}
			}
		}
		*/
	}

}
