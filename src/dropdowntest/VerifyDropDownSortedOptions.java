package dropdowntest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class VerifyDropDownSortedOptions {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		WebElement element = driver.findElement(By.xpath("//*[@id=\"animals\"]"));
		Select se = new Select(element);
		List  originalList = new ArrayList();
		List tempList = new ArrayList();
		
		List <WebElement> options = se.getOptions();
		
		for(WebElement e : options)
		{
			originalList.add(e.getText());
			tempList.add(e.getText());
		}
		System.out.println("originalList =" + originalList);
		
		
		//tempList = originalList;
		
		System.out.println("tempList =" + tempList);
		Collections.sort(tempList);
		System.out.println("After sorting Value of originalList =" + originalList);
		System.out.println("After sorting tempList =" + tempList);
		if (originalList ==  tempList)
		{
			System.out.println("Dropdown list is sorted");
		}
		else
		{
			System.out.println("Dropdown list is NOT sorted");
		}
		driver.quit();
	}
	
}



