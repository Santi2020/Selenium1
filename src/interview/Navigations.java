package interview;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Navigations {

	public static void main(String[] args) {
	//	WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		RemoteWebDriver driver= new ChromeDriver();
		//System.out.println("Opening yahoo.com");
		//driver.get("https://yahoo.com");
		driver.get("https://demo.nopcommerce.com/register");
		
		/*
		System.out.println("Opening amazon");
		driver.navigate().to("https://demo.nopcommerce.com/register");
		
		System.out.println("Navigating back");
		driver.navigate().back();
		
		System.out.println("Navigating forward");
		driver.navigate().forward();
		
		*/
		List <WebElement> links = driver.findElements(By.xpath("/html/body/div[6]/div[4]/div[1]"));
		for(WebElement ele :links)
			System.out.println(ele.getText());
	
	}

	
	
}
