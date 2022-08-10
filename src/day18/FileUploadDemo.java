package day18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;


public class FileUploadDemo {

	public static void main(String[] args) throws InterruptedException, FindFailed {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		//not able to capture the image from the button
		driver.get("http://demo.automationtesting.in/Register.html");
		//driver.get("https://testautomationpractice.blogspot.com/");
		//driver.switchTo().frame(0);
		Thread.sleep(1000);
		//WebElement button = driver.findElement(By.xpath("//*[@id=\"imagesrc\"]"));
		WebElement button = driver.findElement(By.id("imagesrc"));
		String att_id = button.getAttribute("Id");
		driver.findElement(By.id(att_id));
		
		
		//button.click();
		Thread.sleep(1000);
		/*
		String imagesFilePath ="C:\\santoshi\\Selenium\\sikuli_images";
		String inputFilePath ="C:\\santoshi\\Selenium\\sikuli_images";
		
		Screen s = new Screen();
		Pattern fileInputTextBox = new Pattern(imagesFilePath + "upload_filename.png");
		Pattern openButton = new Pattern(imagesFilePath + "open_button.png");
		Thread.sleep(5000);
		s.wait(fileInputTextBox,20);
		s.type(fileInputTextBox, inputFilePath+"apple.png");
		s.click(openButton);
		*/
	}

}


