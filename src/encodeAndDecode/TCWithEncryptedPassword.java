package encodeAndDecode;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TCWithEncryptedPassword {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("https://demo.nopcommerce.com/");
		driver.get("http://admin-demo.nopcommerce.com");
		//driver.findElement(By.linkText("Log in")).click();
		//driver.findElement(By.xpath("//*[@id=\"Email\"]").sendKeys("Pavanoltraining@gmail.com")   ;
		driver.findElement(By.xpath("//*[@id=\"Email\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"Password\"]")).clear();
		
		
		driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys("admin@yourstore.com");
		driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys(decodeString("YWRtaW4="));
		
		driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button")).click();
		
		
		
	}

	
	static String decodeString(String password)
	{
		//Decoding the string
		byte[] decodedstring = Base64.decodeBase64(password);
		return( new String (decodedstring));
	}
}
