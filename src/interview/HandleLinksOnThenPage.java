package interview;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleLinksOnThenPage {

	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in");
		//driver.findElement(By.linkText("Today's Deals")).click() ;
		//driver.findElement(By.partialLinkText("Tod")).click();
		
		//How to capture all the links
		List <WebElement> links =  driver.findElements(By.tagName("a"));
		/*
		System.out.println("No of Links on the page = " + links.size());
		for (WebElement ele : links) {
			System.out.println("Link =" + ele.getText());	
		}
		*/
		
		System.out.println("=".repeat(50));
		System.out.println("Using regular array");
		for (int i =0; i<links.size(); i++) {
			String text = links.get(i).getText();
			String href =links.get(i).getAttribute("href");
			System.out.println("href = " + href);
		}
	}

}
