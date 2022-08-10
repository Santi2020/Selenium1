package barcodeautomation;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class ReadTextFromBarcode {

	public static void main(String[] args) throws IOException, NotFoundException {
		System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		//get the xpath for barcode = ABC-abc-123
		//String barcodeURL = driver.findElement(By.xpath("//*[@id=\"HTML12\"]/div[1]/img[1]")).getAttribute("src");
		
		//get the xpath for barcode = Hi this is Pavan
		String barcodeURL = driver.findElement(By.xpath("//*[@id=\"HTML12\"]/div[1]/img[2]")).getAttribute("src");
		System.out.println("barcodeURL = " + barcodeURL);
		URL url = new URL(barcodeURL);
		BufferedImage bufferedimage =ImageIO.read(url);
		LuminanceSource luminancesource = new BufferedImageLuminanceSource(bufferedimage);
		BinaryBitmap  binaryBitmap = new BinaryBitmap(new HybridBinarizer(luminancesource));
		
		Result result =  new MultiFormatReader().decode(binaryBitmap);
		System.out.println("Result =" + result.getText()  );
		
		
		
		
		
	}

}
