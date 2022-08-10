package interview;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleBrokenLinks {

	public static void main(String[] args) throws IOException  {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.deadlinkcity.com/");
		
		int brokenLinkcount =0;
		List <WebElement> links = driver.findElements(By.tagName("a"));
		for(WebElement element : links) {
			String str = element.getAttribute("href");
			System.out.println("str = " + str);
			if (str == null || str.isEmpty() ){
				System.out.println("URL is empty");
				continue;
			}
			
			URL link = new URL(str);
			try {
				HttpURLConnection httpconn = (HttpURLConnection) link.openConnection();
				httpconn.connect();
				if(httpconn.getResponseCode()>=400) {
					System.out.println(httpconn.getResponseCode() + " " +str +" is broken link");
					brokenLinkcount++;
				}
				else {
					System.out.println(httpconn.getResponseCode() + " " +str +" is valid link");
				}
					
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("Error occured " + e.getMessage());
			}
													
			
		}
		
		System.out.println("Total broken links =" + brokenLinkcount);
	}

}
