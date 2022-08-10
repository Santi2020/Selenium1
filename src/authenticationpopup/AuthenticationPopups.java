package authenticationpopup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticationPopups {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("the-internet.herokuapp.com/basic_auth");
		
		//http://username:password@URL
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		//String message = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p")).getText();
		String message = driver.findElement(By.cssSelector("p")).getText() ;
		if ( message.equals("Congratulations! You must have the proper credentials."))
		{
			System.out.println("Authentication passed");
		}
		else
		{
			System.out.println("Authentication FAILED");
		}
		driver.close();
	}

}


