package interview;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckDropDownSorted {

	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.twoplugs.com/newsearchserviceneed");
		
		WebElement drpElement = driver.findElement(By.name("category_id"));
		Select drpSelect = new Select(drpElement);
		List <WebElement> drpOptions = drpSelect.getOptions();
		
		ArrayList<String> originalList = new ArrayList();
		ArrayList<String> tempList = new ArrayList();
		
		for(WebElement option: drpOptions) {
			originalList.add(option.getText());
			tempList.add(option.getText());
		}
		System.out.println("Before sorting  ");
		System.out.println("Original list \n" + originalList);
		System.out.println("Temp list \n" + tempList);
		Collections.sort(tempList);
			
		System.out.println("\n\n\nAfter sorting  ");
		System.out.println("Original list \n" + originalList);
		System.out.println("Temp list \n" + tempList);
		
		if(originalList.equals(tempList)) {
			System.out.println("Drop down  is sorted");
		}
		else {
			System.out.println("Drop down not is sorted");
		}
		System.out.println("Closing the browser");
		driver.quit();
		System.out.println("Done");
	}
}
