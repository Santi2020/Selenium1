package interview;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticationWithPopups {

	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("http://the-internet.herokuapp.com/basic_auth");
		
		//syntax
		//http://user:password@the-internet.herokuapp.com/basic_auth
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
	}

}
