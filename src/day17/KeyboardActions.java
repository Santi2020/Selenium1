package day17;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActions {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/key_presses");
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();
		
		Thread.sleep(2000);
		act.sendKeys(Keys.ESCAPE).build().perform();
		
		Thread.sleep(2000);
		act.sendKeys(Keys.BACK_SPACE).build().perform();
		
		//Thread.sleep(2000);
		//act.sendKeys(Keys.CONTROL+"A"+"S").build().perform();
		
	}

}
