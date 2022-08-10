package day16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.name("Submit")).click();
		
		Thread.sleep(3000);
		//goto Admin -> User management -> users
		driver.findElement(By.xpath("//*[@id=\"menu_admin_viewAdminModule\"]/b")).click(); // Click on admin
		
		driver.findElement(By.xpath("//*[@id=\"menu_admin_UserManagement\"]")).click(); //User management
		driver.findElement(By.xpath("//*[@id=\"menu_admin_viewSystemUsers\"]")).click(); //users
		
		//Table
		int rows = driver.findElements(By.xpath("//*[@id=\"resultTable\"]/tbody/tr")).size();
		System.out.println("Rows = " + rows);
		int cnt =0;
		int disabled_cnt =0;
		for(int r =1; r<=rows; r++)
		{
			String status=driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr["+r+"]/td[5]")).getText();
			if (status.equals("Enabled"))
			{
				System.out.println(status);
				cnt=cnt+1;
			}
			
			
			if (status.equals("Disabled"))
			{
				System.out.println(status);
				disabled_cnt=disabled_cnt+1;
			}
		}
		System.out.println("Enable count = " +cnt);
		System.out.println("Disable count = " +disabled_cnt);
		driver.quit();
	}

}
