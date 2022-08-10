package ashotAPI;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class CaptureLogoImage {

	public static void main(String[] args) throws IOException {
	
		System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		WebElement ImageLogoElement = driver.findElement(By.xpath("//*[@id=\"divLogo\"]/img"));
		Screenshot logoImageScreenshot = new AShot().takeScreenshot(driver, ImageLogoElement );
		ImageIO.write(logoImageScreenshot.getImage(), "png", new File("C://santoshi//Selenium//logos/OrangeHRMlogos.png"));
		File f = new File ("C://santoshi//Selenium//logos/OrangeHRMlogos.png");
		if (f.exists())
		{
			System.out.println("Image file captured");
		}
		else
		{
			System.out.println("Image file NOT captured");
		}	
	}

}
