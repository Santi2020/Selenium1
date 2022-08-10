package interview;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InnerFrameDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");
		
		driver.switchTo().frame("iframeResult");
		
		WebElement innerFrame =driver.findElement(By.xpath("/html/body/iframe"));
		driver.switchTo().frame(innerFrame);
		
		String text = driver.findElement(By.xpath("/html/body/h1")).getText();
		System.out.println("Inner frame text = " + text);
		
		driver.switchTo().parentFrame();
		
		//Outer frame text capture
		text = driver.findElement(By.xpath("/html/body/h2")).getText();
		System.out.println("Outer frame text = " + text);
		
		text =driver.findElement(By.xpath("/html/body/p")).getText();
		System.out.println("Outer frame text = " + text);
	}

}
