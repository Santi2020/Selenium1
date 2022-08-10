package day15;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Windows.html");
		driver.manage().window().maximize();
		//String handlevalue = driver.getWindowHandle();
		//System.out.println(handlevalue);
		driver.findElement(By.xpath("//*[@id=\"Tabbed\"]/a/button")).click();
		Set <String> handlevalues = driver.getWindowHandles();
		for(String hv :handlevalues)
		{
			//System.out.println(hv);
			String title = driver.switchTo().window(hv).getTitle();
			System.out.println("Title = " + title);
			if (title.equals("Selenium"))
			{
				driver.findElement(By.xpath("//*[@id=\"main_navbar\"]/ul/li[7]/a/span")).click();
				//driver.close();
			}
			
		}
		
		//driver.quit();
		//driver.close();
		
	}

}
