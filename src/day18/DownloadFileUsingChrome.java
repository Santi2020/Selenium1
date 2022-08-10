package day18;

import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DownloadFileUsingChrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 
		 // the following piece od code is not working
		  * 
		 //to download files in a specified locatio
		 // by changing browser preferences
		  * 
		HashMap<String,Object> chromePrefs = new HashMap <String, Object> ();
		
		chromePrefs.put("profile_default_content_settings.popups", 0);
		chromePrefs.put("download.prompt_for_download", "false");
		chromePrefs.put("download.default_directory", "C:\\santoshi\\Selenium\\Test");
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		
		//DesiredCapabilities cap = DesiredCapabilities.chrome();
		DesiredCapabilities cap = DesiredCapabilities. ;
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		*/
		
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.automationtesting.in/FileDownload.html");
		
		
		//Downloads text file
		driver.findElement(By.id("textbox")).sendKeys("This is a test document");
		driver.findElement(By.id("createTxt")).click();
		driver.findElement(By.id("link-to-download")).click();
		
		if (myfileExists("C://Users//TISHAN1KA//Downloads/info.pdf"))
		{
			System.out.println("File Exists");
		}
		else
		{
			System.out.println("File does not exists");
		}
		//Downloads pdf
		driver.findElement(By.id("pdfbox")).sendKeys("This is a pdf document demo");
		driver.findElement(By.id("createPdf")).click();
		driver.findElement(By.id("pdf-link-to-download")).click();
		
		if (myfileExists("C://Users//TISHAN1KA//Downloads/info.pdf"))
		{
			System.out.println("PDF Exists");
		}
		else
		{
			System.out.println("PDF does not exists");
		}
		
	}
	
	
	static boolean myfileExists(String path)
	{
		File f = new File(path);
		if (f.exists())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
