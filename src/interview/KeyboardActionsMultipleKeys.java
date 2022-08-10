package interview;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActionsMultipleKeys {

	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://text-compare.com/");
		
		WebElement source = driver.findElement(By.xpath("//*[@id=\"inputText1\"]"));
		WebElement target = driver.findElement(By.xpath("//*[@id=\"inputText2\"]"));
		source.sendKeys("Welcome to the keyboard methods");
		
		Actions act = new Actions(driver);
		//press control A
		act.keyDown(Keys.CONTROL);
		act.sendKeys("a");
		act.keyUp(Keys.CONTROL);
		act.perform();
		
		//press control C
		act.keyDown(Keys.CONTROL);
		act.sendKeys("c");
		act.keyUp(Keys.CONTROL);
		act.perform();
		
		//press tab
		act.sendKeys(Keys.TAB);
		act.perform();
				
		//press control v --paste
		act.keyDown(Keys.CONTROL);
		act.sendKeys("v");
		act.keyUp(Keys.CONTROL);
		act.perform();
		
		//compare text
		if (source.getAttribute("value").equals(target.getAttribute("value"))) {
			System.out.println("Text copied successfully");
		}
		else {
			System.out.println("Text copied failed");
		}
			
		
	}

}
