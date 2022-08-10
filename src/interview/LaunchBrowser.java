package interview;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {
	
	
	public static void main(String[] args) {
		
		//launch chrome
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver();
		driver.get("https://www.yahoo.com/");
		String title = driver.getTitle();
		System.out.println("Title = " + title);
		
		String URL = driver.getCurrentUrl();
		System.out.println("URL = " + URL);
		
		
		String pagesource = driver.getPageSource();
		System.out.println("pagesource = " + pagesource);
		
		/*
		//Firefox
		System.setProperty("webdriver.gecko.driver", "C://Drivers//geckodriver-v0.30.0-win64/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.yahoo.com/");
		
		//Edge
		System.setProperty("webdriver.edge.driver", "C://Drivers//edgedriver_win64/msedgedriver.exe");
		//WebDriver 
		driver = new EdgeDriver();
		*/
		
		//Using webdriver manager
		//WebDriverManager.chromedriver.setup();
		//WebDriver driver = new ChromeDriver();
		//driver.get("https://www.yahoo.com/");
	}
}


