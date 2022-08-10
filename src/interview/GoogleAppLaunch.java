package interview;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleAppLaunch {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com/");
		Thread.sleep(10);
		
		List <WebElement> lstElement =driver.findElements(By.xpath("//iframe"));
		System.out.println(lstElement.size());
		for (WebElement e : lstElement) {
			System.out.println("TagName = "+ e.getTagName());
			System.out.println("TagName = " + e.getAttribute("name"));
		}
		
		//click on apps link
		Thread.sleep(5);
		List <WebElement> lst =driver.findElements(By.tagName("a"));
		WebElement gApps = driver.findElement(By.xpath("//*[local-name()='svg'  and @class=\"gb_Ve\"]/*[local-name()='path']"));
		System.out.println("Default Element Text = "+ gApps.getText());
		gApps.click();
		
		//launch youtube
		Thread.sleep(5);
		driver.switchTo().frame(1);
		WebElement yt = driver.findElement(By.xpath("//a[@href='https://www.youtube.com/?gl=US']//div[@class='CgwTDb']//span[@class='MrEfLc']"));
		System.out.println("AppName =" + yt.getText()); 
		yt.click();
		
		//click on the third tab
		Thread.sleep(5);
		List <WebElement> ytTabs= driver.findElements(By.xpath("//yt-chip-cloud-chip-renderer/yt-formatted-string[@id=\"text\" ]"));
		System.out.println("No of tabs =" +  ytTabs.size());
		int ctr =0;
		for(WebElement e : ytTabs) {
			System.out.println("Tab name " + e.getText());
			ctr++;
			if (ctr==3) {
				e.click();
				break;
			}
		}
		
		driver.navigate().back();
	
		/*
		System.out.println("================================");
		
		List<WebElement> allElements = driver.findElements(By.xpath("//*"));
		System.out.println("No. of element on this page is " +allElements.size());
		for (WebElement e : allElements) {
			String txt = e.getText();
			if (txt.isEmpty()) {
				System.out.println("Text = "+ e.getText() + " TagName =" + e.getTagName() + " Attribute = "+ e.getAttribute("name")  );
			}else {
				//System.out.println("Attribute = "+ e.getAttribute("name"));
				//System.out.println("a href = "+ e.getAttribute("a"));
			}
		}
		*/
		
			
	}

}
