package interview;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SizeAndLocationOfWebElement {

	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		WebElement logo = driver.findElement(By.xpath("//*[@id=\"divLogo\"]/img"));
		System.out.println("Size = " +logo.getSize());
		
		//get Location Method 1
		System.out.println("Method 1 " );
		System.out.println("location(x,y) = " +logo.getLocation());
		System.out.println("location of x = " +logo.getLocation().getX() );
		System.out.println("location of y = " +logo.getLocation().getY() );
	
		//get Location Method 2
		System.out.println("Method 2 " );
		System.out.println("location(x) = " +logo.getRect().getX());
		System.out.println("location(y) = " +logo.getRect().getY());
		
		//get Size Method 1
		System.out.println("Size - Method 1 " );
		System.out.println("Size = " +logo.getSize());
		System.out.println("Size Height = " +logo.getSize().getHeight());
		System.out.println("Size Width = " +logo.getSize().getWidth());
		
		//get Size Method 2
		System.out.println("Size - Method 3 " );
		System.out.println("Size = " +logo.getSize());
		System.out.println("Size Height = " +logo.getRect().getDimension().getHeight());
		System.out.println("Size Width = " +logo.getRect().getDimension().getWidth());
				
		
		//driver.close();
	}

}
