package interview;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DatePickerDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		//Clicl the date text box
		driver.findElement(By.name("dob")).click() ;
		
		//Get the month
		Select month_drp = new Select(driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/div/select[1]")));
		month_drp.selectByVisibleText("Oct");
		
		Select year_drp = new Select (driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/div/select[2]")));
		year_drp.selectByVisibleText("2022");
		//System.out.println("Current Month =" + month + " Current Year =" + year);
		
		String date = "12";
		List <WebElement> date_list= driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		for(WebElement ele : date_list) {
			if (ele.getText().equals(date)) {
				ele.click();
				break;
			}
		}	
	}
	
}
