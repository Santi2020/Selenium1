package day18;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class DownloadFileUsingFireFox 
{

	public static void main(String[] args) {
	//System.setProperty("webdriver.gecko.driver" , "C://Drivers//geckodriver-v0.30.0-win64/geckodriver.exe");

	//===============
		/*
		FirefoxProfile profile=new FirefoxProfile();
		
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/plain,application/pdf"); // set Mime type according to your file format
		profile.setPreference("browser.download.manager.showWhenStarting", false);
				
		//download files in desired location
		profile.setPreference("browser.download.dir","C:\\santoshi\\Selenium\\downloads");
		profile.setPreference("browser.download.folderList", 2); 
		profile.setPreference("pdfjs.disabled", true); // only for pdf file
		
		FirefoxOptions option=new FirefoxOptions();
		option.setProfile(profile);
	*/
	//==============
		
		
		System.setProperty("webdriver.gecko.driver", "C://Drivers//geckodriver-v0.30.0-win64/geckodriver.exe");
	WebDriver driver = new FirefoxDriver();
	
	//driver.manage().window().maximize();
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


