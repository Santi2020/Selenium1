package WayToAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.security.Security;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BadSSL {

	public static void main(String[] args) {
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver();
		//System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		
		DevTools devTools = ((ChromeDriver)driver).getDevTools();
		devTools.createSession();
		devTools.send(Security.enable());
		devTools.send(Security.setIgnoreCertificateErrors(true));
		driver.get("https://expired.badssl.com");
		//driver.get("https://www.google.com/");
	}
}
