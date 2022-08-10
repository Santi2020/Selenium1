package interview;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoCompleteGooglePlacesDropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.get("https://www.twoplugs.com/newsearchserviceneed");
		
		WebElement searchBox = driver.findElement(By.id("autocomplete"));
		searchBox.clear();
		searchBox.sendKeys("Toronto");
		String text;
		do {
			searchBox.sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(5000);
			text= searchBox.getAttribute("value");
			if(text.equals("Toronto, OH, USA")) {
				System.out.println("Found");
				searchBox.sendKeys(Keys.ENTER);
				break;
			}
		}while(!text.isEmpty());
	}

}
