package interview;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingCokkies {

	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");
		//How to capture cookies from the browser
		
		Set <Cookie> cookies = driver.manage().getCookies();
		System.out.println("No of cookies created =" + cookies.size());		

		//How to add cookie to the browser
		Cookie cookieObj = new Cookie("MyNewCookie","User");
		driver.manage().addCookie(cookieObj);
		
		cookies = driver.manage().getCookies();
		System.out.println("No of cookies after adding =" + cookies.size());
		
		//How to print cookies from the browser
		for(Cookie c : cookies ) {
			System.out.println("Cookie Name =" + c.getName());
			System.out.println("Cookie Value =" + c.getValue());
			System.out.println("Cookie expiry =" + c.getExpiry());
			System.out.println("Cookie domain =" + c.getDomain());
			System.out.println("Cookie Path =" + c.getPath());
			System.out.println("Cookie SameSite =" + c.getSameSite());
			System.out.println("Cookie Class =" + c.getClass());
			System.out.println("=".repeat(50) );
		}
		
		//How to delete specific cookie from the browser
		//driver.manage().deleteCookie(cookieObj);
		driver.manage().deleteCookieNamed("MyNewCookie");
		cookies = driver.manage().getCookies();
		System.out.println("No of cookies after deletion =" + cookies.size());
		
		//How to delete all the cookies from the browser
		driver.manage().deleteAllCookies();
		cookies = driver.manage().getCookies();
		System.out.println("After deleting all cookies =" + cookies.size());
		
		
	}

}
