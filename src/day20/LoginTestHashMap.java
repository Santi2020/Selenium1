package day20;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestHashMap {

	static HashMap <String, String> loginData()
	{
		HashMap <String, String> hm = new HashMap <String, String> ();
		hm.put("x", "mercury@mercury");
		hm.put("y", "mercury1@mercury1");
		hm.put("z", "mercury2@mercury2");
		return hm;
		
	}

	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		//driver.get("http://demo.guru99.com/test/newtours/register.php");
		driver.get("https://demo.guru99.com/test/newtours/");
		//String path="C://santoshi//Selenium//Test/Ora_loginTest.xlsx";
		//String sheet = "Sheet1";
		
		
		String credentials = loginData().get("z");
		System.out.println(credentials);
		String uarr[] = credentials.split("@", 2);
		
		//System.out.println(credentials.split("@", 1));
		System.out.println(uarr[0]);
		System.out.println(uarr[1]);
		
		//xpath of username
		driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[2]/td[2]/input")).sendKeys(uarr[0]);
		
		//xpath of password
		driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[3]/td[2]/input")).sendKeys(uarr[1]);
		
		//click login
		driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[4]/td[2]/div/input")).click();
		Thread.sleep(3000);
		
		System.out.println("Done");
		
	}

}
