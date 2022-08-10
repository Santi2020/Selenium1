package interview;

import java.util.List;

import javax.print.attribute.standard.MediaSize.JIS;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;

public class BootstrapDrpdownDemo {
	
	public WebDriver driver;
	
	BootstrapDrpdownDemo() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		selectBootstrapDrpdown();
	}
	
	public void selectBootstrapDrpdown() throws InterruptedException {
		driver.get("http://seleniumpractise.blogspot.in/2016/08/bootstrap-dropdown-example-for-selenium.html");
		
		
		//Click the main dropdown
		System.out.println("Clicking");
		//WebElement drpMain = driver.findElement(By.xpath("//*[@id=\"post-body-4615304122771162527\"]/div[1]/div"));
		WebElement drpMain = driver.findElement(By.xpath("//*[@id=\"menu1\"]"));
		//WebElement drpMain = driver.findElement(By.xpath("//*[@id=\\\"post-body-4615304122771162527\\\"]/div[1]/div"));
		
		System.out.println("GetText = " + drpMain.getText());
		
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView();",drpMain);
		drpMain.click();
		
		Thread.sleep(5000);
		System.out.println("done Clicking");
		
		//Thread.sleep(5);
		
		//Capture the options of the dropdown
		List <WebElement> options = driver.findElements(By.xpath("//*[@id=\"post-body-4615304122771162527\"]/div[1]/div/ul/li/a"));
		
		System.out.println("Size = " + options.size());
		
		for(WebElement ele : options) {
			System.out.println("Option = " + ele.getText());
			if (ele.getText().equals("JavaScript")) {
				ele.click();
				System.out.println("Breaking now");
				break;
			}
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		BootstrapDrpdownDemo obj = new BootstrapDrpdownDemo();

	}

}
