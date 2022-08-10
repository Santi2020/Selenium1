package headlessbrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HeadlessFireFox {
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C://Drivers//geckodriver-v0.30.0-win64/geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions();
		options.setHeadless(true);
				
		WebDriver driver = new FirefoxDriver(options);
		
		driver.get("https://demo.nopcommerce.com/");
		System.out.println("Title = " +driver.getTitle());
	}
}


