package day17;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");
		
		//Create javescriptExecutor and type cast it
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		/*
		// Approach 1 == move number of pixel
		//js.executeScript("window.scrollby(0,4000)", ""); //not working for me
		js.executeScript("javascript:window.scrollBy(0,100)");
		
		for (int i =1;i<=3;i++)
		{
			Thread.sleep(3000);
			js.executeScript("javascript:window.scrollBy(0,"+(i*1000)+")");
			
		}
		*/
		
		//Approach 2 -- scrolldown Till we find certain element on the web page
		
		//WebElement flag = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[2]/table[1]/tbody/tr[86]/td[2]"));
		//js.executeScript("arguments[0].scrollIntoView();", flag);
		
		
		//
		WebElement flag = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[2]/table[2]/tbody/tr[82]/td[2]"));
		js.executeScript("arguments[0].scrollIntoView();", flag);
		
		//Approach 3 - scoll to the end of the page
		js.executeScript("javascript:window.scrollBy(0,document.body.scrollHeight)");
		
	}

}


