package interview;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JQueryDropDow {

	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		
		
		driver.findElement(By.id("justAnInputBox")).click();
		//selectChoiceValues(driver,"Choice 1");
		//selectChoiceValues(driver,"Choice 2", "Choice 2 3", "Choice 6", "Choice 6 2 1", "Choice 6 2", "Choice 7"  );
		selectChoiceValues(driver, "all");
	}
	
	public static void selectChoiceValues(WebDriver driver, String... value) {
		List <WebElement> choiceList = driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));
		if (!value[0].equalsIgnoreCase("all")) {
			for(WebElement item : choiceList) {
				String text = item.getText();
				for(String val : value) {
					if(text.equalsIgnoreCase(val)){
						item.click();
						break;
					}
				}
			}
		}
		else {
			try {
				for(WebElement item : choiceList) {
					System.out.println("Item =" + item.getText());
					item.click();
				}
			}
			catch(Exception e) {
				System.out.println("Elements not reachable. Some element belong to other drop down " );
			}
		}
			
	}
}
