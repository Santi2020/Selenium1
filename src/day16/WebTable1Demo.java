package day16;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable1Demo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		//int rows = driver.findElements(By.tagName("tr")).size();
		//System.out.println("First method...Size= " +rows);
		
		int rows = driver.findElements(By.xpath("//*[@id=\"HTML1\"]/div[1]/table/tbody/tr")).size();
		System.out.println("First method.No of rows..Size= " +rows);
		
		int cols = driver.findElements(By.xpath("//*[@id=\"HTML1\"]/div[1]/table/tbody/tr[1]/th")).size();
		System.out.println("No of columns...Size= " +cols);
		
		System.out.println("BookName" +  "     "	+"Author	"+  "     " +"Subject  " +  "     "+"Price");
		for(int i=2; i<=rows;i++)
		{
			for(int j=1;j<=cols;j++)
			{
				String value =driver.findElement(By.xpath("//*[@id=\"HTML1\"]/div[1]/table/tbody/tr["+i+"]/td["+j+"]")).getText();
				System.out.print( value +"     ");
			}
			System.out.println("");
		}
		
		
		
		
	}

}
