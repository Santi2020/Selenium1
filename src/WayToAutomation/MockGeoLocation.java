package WayToAutomation;

import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;
//import org.openqa.selenium.devtools.v85.security.Security;

public class MockGeoLocation {

	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		
		DevTools devTools = ((ChromeDriver)driver).getDevTools();
		devTools.createSession();
		devTools.send(Emulation.setGeolocationOverride(Optional.of(51.509865) , Optional.of(-0.118092), Optional.of(100)) );
		driver.get("https://mycurrentlocation.net/");

	}

}
