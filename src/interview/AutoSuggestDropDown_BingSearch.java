package interview;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestDropDown_BingSearch {

	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.get("https://www.bing.com");
		
		driver.findElement(By.id("sb_form_q")).sendKeys("selenium");
		
		List <WebElement> list =driver.findElements(By.xpath("//li[@class='sa_sg']//span"));
		System.out.println("Size of the Auto suggestion  = " + list.size());
		
		for(WebElement element :list) {
			if (element.getText().equalsIgnoreCase("Selenium ide")) {
				System.out.println("Link found");
				element.click();
				break;
			}
		}
	}

}
