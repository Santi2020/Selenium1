package day14;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CountingLinks {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.switchTo().frame(0);
		
		List <WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("=================================================");
		System.out.println("No of links on the page = " + links.size());
		int i=1;
		for (WebElement ele:links)
		{
			System.out.println(+i +" Name = "+ele.getAttribute("name") + " Link = "+ ele.getAttribute("link")  +" " +ele.getText());
			i+=1;
		}
		
		//System.out.println(driver.getPageSource());

	}

}
