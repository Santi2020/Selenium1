package interview;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DownloadPDFfile {

	public static void main(String[] args) {
		String location = System.getProperty("user.dir")+ "\\Downloads\\";
		// Chrome
		/*
		HashMap preferences = new HashMap();
		preferences.put("plugins.always_open_pdf_externally", true);
		preferences.put("download.default_directory", location);
		ChromeOptions options  = new ChromeOptions();
		options.setExperimentalOption("prefs", preferences);
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver(options);
		*/
		
		/*
		// Edge
		HashMap preferences = new HashMap();
		preferences.put("download.default_directory", location);
		preferences.put("plugins.always_open_pdf_externally", true);
		EdgeOptions options  = new EdgeOptions();
		options.setExperimentalOption("prefs", preferences);
		WebDriver driver;
		System.setProperty("webdriver.edge.driver", "C://Drivers//edgedriver_win64/msedgedriver.exe");
		//WebDriverManager.chromedriver().setup();
		driver = new EdgeDriver(options);
		*/
			
		// FireFox
		FirefoxProfile profile= new FirefoxProfile();
		profile.setPreference("pdfjs.disabled", true);
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf,application/msword ");
		profile.setPreference("browser.download.folderList", 2); // 0= destop 1=download folder  2= desired location
		profile.setPreference("browser.download.dir", location);
		
		//FirefoxOptions = new FirefoxOptions();
		FirefoxOptions options= new FirefoxOptions();
		options.setProfile(profile);
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", "C://Drivers//geckodriver-v0.30.0-win64/geckodriver.exe");
		//WebDriverManager.chromedriver().setup();
		driver = new FirefoxDriver(options);
		
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://file-examples.com/index.php/sample-documents-download/sample-pdf-download/");
		driver.findElement(By.xpath("//*[@id=\"table-files\"]/tbody/tr[1]/td[5]/a")).click();
           
		System.out.println("Done");
		System.out.println("Done. location =" + location);
	}

}
