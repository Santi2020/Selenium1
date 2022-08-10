package interview;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PermissionPopupNotification {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		//options.addArguments("--enable-notifications");
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.get("https://www.redbus.in/");
		

	}

}
