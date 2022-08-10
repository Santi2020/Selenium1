package interview;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardActions {

	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://automationpractice.com/index.php");
		Actions act = new Actions(driver);
		driver.findElement(By.xpath("//*[@id=\"search_query_top\"]")).sendKeys("ABcDEF") ;
		
		act.sendKeys(Keys.BACK_SPACE ).perform();
		act.sendKeys(Keys.ESCAPE).perform();
		act.sendKeys(Keys.BACK_SPACE).perform();
		act.sendKeys(Keys.ARROW_LEFT).perform();
		

	}

}
