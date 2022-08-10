package day20;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleIntersetCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		//data  driven testing using microspft excel
		//session 20 time stamp 22.33
		driver.get("https://www.easycalculation.com/simple-interest.php");
		String path="C://santoshi//Selenium//Test//easy_calculate_SI.xlsx";
	}

}
