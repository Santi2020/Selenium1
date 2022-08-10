package robotAPI;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RobotAPIDemo {
	public static void  main(String[] args) throws AWTException, InterruptedException
	{
		// firefox browser
		System.setProperty("webdriver.gecko.driver", "C://Drivers//geckodriver-v0.30.0-win64/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		//driver.get("http://spreadsheetpage.com/index.php/site/file/yearly_calendar_woorkbook");
		driver.get("https://www.vertex42.com/Files/download2/themed.php?file=2022-calendar.xlsx");
		
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div/div[2]/div[1]/div[1]/a")).click();
		
		//driver.findElement(By.xpath("//*[@id=\"cc_gotit\"]")).click();
		Robot robot = new Robot();
		/*
		 * Action to be performed
		 * 1 time down arrow
		 * 3 times tab
		 * enter
		 */
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
		
		Set<String> wnd = driver.getWindowHandles();
	      // window handles iteration
	      Iterator<String> i = wnd.iterator();
	      String prntw = i.next();
	      String popwnd = i.next();
	      // switching pop up window handle id
	      driver.switchTo().window(popwnd);
	      System.out.println("Page title of popup: "+ driver.getTitle());
	      // closes pop up window
	      driver.close();
	      // switching parent window handle id
	      driver.switchTo().window(prntw);
	      System.out.println("Page title of parent window: "+ driver.getTitle());
	      //driver.quit();

	}
}



