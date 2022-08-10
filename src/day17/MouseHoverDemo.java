package day17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 
		
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		
		driver.findElement(By.id("btnLogin")).click();
		
		
		//Admin -> User management -> user
		WebElement admin = driver.findElement(By.xpath("//*[@id=\"menu_admin_viewAdminModule\"]/b"));
		WebElement user_mgnt = driver.findElement(By.xpath("//*[@id=\"menu_admin_UserManagement\"]"));
		WebElement user = driver.findElement(By.xpath("//*[@id=\"menu_admin_viewSystemUsers\"]"));
		
		
		Actions act = new Actions(driver);
		act.moveToElement(admin).moveToElement(user_mgnt).moveToElement(user).click().build().perform();
		
		
	}

}
