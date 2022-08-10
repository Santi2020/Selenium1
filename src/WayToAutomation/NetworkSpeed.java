package WayToAutomation;

import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v96.network.Network;
//import org.openqa.selenium.devtools.v94.network.Network;
import org.openqa.selenium.devtools.v96.network.model.ConnectionType;

import com.google.common.collect.ImmutableList;

public class NetworkSpeed {

	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		
		DevTools devTools = ((ChromeDriver)driver).getDevTools();
		devTools.createSession();
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devTools.send(Network.emulateNetworkConditions(false, 100, 20000, 10000, Optional.of(ConnectionType.CELLULAR4G) ));
		driver.get("https://www.way2automation.com/");
		
		//driver.manage().window().

	}

}
