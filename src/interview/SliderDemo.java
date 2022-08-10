package interview;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderDemo {

	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		
		WebElement min_slider = driver.findElement(By.xpath("//span[1]"));
		WebElement max_slider = driver.findElement(By.xpath("//span[2]"));
		
		System.out.println( "Before - Min-slider location = " + min_slider.getLocation());
		System.out.println( "Before - Min-slider Height and width = " + min_slider.getSize());
		
		Actions act = new Actions(driver);
		act.dragAndDropBy(min_slider, 265, 00).perform() ;
		
		System.out.println("After - Min-slider location = " + min_slider.getLocation());
		System.out.println("After - Min-slider Height and width = " + min_slider.getSize());
		
		act.dragAndDropBy(max_slider, -100, 0).perform();
	}

}
