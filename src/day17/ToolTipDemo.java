package day17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToolTipDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/tooltip/");
		driver.switchTo().frame(0);
		WebElement ageTxtBox = driver.findElement(By.id("age"));
		String tooltiptext = ageTxtBox.getAttribute("title");
		System.out.println(tooltiptext);
		
		if (tooltiptext.equals("We ask for your age only for statistical purposes."))
		{
			System.out.println("Tool tip text passed");
		}
		else
		{
			System.out.println("Tool tip text failed");
		}
		
	}

}




