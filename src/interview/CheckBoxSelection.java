package interview;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxSelection {

	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		//driver.get("https://itera-qa.azurewebsites.net/home/automation");
		driver.navigate().to("https://itera-qa.azurewebsites.net/home/automation");
		//How to select specific check box
		
		//How to select specific check box
		//driver.findElement(By.xpath("//input[@id='monday']")).click() ;
		
		//How to select all the checkboxes
		List<WebElement> list = driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
		System.out.println("Total check boxes = " + list.size());
		/*
		for(WebElement element : list) {
			element.click();
		}
		*/
		/*
		for(int i =0; i< list.size();i++) {
			list.get(i).click();
		}
		*/
		//How to select multiple checkboxes by choice
		/*
		for(WebElement element : list) {
			String day = element.getAttribute("id"); 
			if(day.equals("sunday") || day.equals("friday")) {
				element.click();
			}
		}
		*/
		
		//How to select last 2 check boxes
		/*/
		for (int i = list.size()-2; i<list.size();i++) {
			list.get(i).click();
		}
		*/
		
		//How to select first 2 check boxes
		for (int i =0; i<2;i++) {
			list.get(i).click();
		}
		
	}

}
