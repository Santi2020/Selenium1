package day14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FreamesDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperty(null, null)
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.get("https://seleniumhq.github.io/selenium/docs/api/java/index.html");
		
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		
		driver.manage().window().maximize();
		driver.switchTo().frame("packageListFrame");
		driver.findElement(By.linkText("org.openqa.selenium")).click();
		
		System.out.println("First link clicked");
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("packageFrame");
		driver.findElement(By.linkText("WebDriver")).click();
		System.out.println("Second link clicked");
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("classFrame");
		driver.findElement(By.xpath("/html/body/header/nav/div[1]/div[1]/ul/li[2]")).click();
		System.out.println("Third link clicked");
	}

}
