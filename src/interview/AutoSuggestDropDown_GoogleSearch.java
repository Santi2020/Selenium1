package interview;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestDropDown_GoogleSearch {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.get("https://www.google.com");
		
		driver.findElement(By.name("q")).sendKeys("java tutorial");
		Thread.sleep(3000);
		List <WebElement> list =driver.findElements(By.xpath("//li[@class='sbct']//div[@role='option']//div[1]//span"));
		System.out.println("Size of the Auto suggestion  = " + list.size());

		
		for(WebElement element :list) {
			if (element.getText().contains("pdf")) {
				System.out.println("Link found");
				element.click();
				break;
			}
		}

	}

}
