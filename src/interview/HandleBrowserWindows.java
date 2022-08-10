package interview;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleBrowserWindows {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		//getWindowHandle
		String windowID = driver.getWindowHandle();
		System.out.println(windowID);
		
		
		//getWindowHandles
		driver.findElement(By.xpath("//*[@id=\"footer\"]/div[1]/a")).click();
		Set<String> windowIDs =  driver.getWindowHandles();
		
		driver.findElement(By.xpath("//*[@id=\"forgotPasswordLink\"]/a")).click();
		
		System.out.println("=".repeat(50));
		//First method using iterator
		Iterator<String> it = windowIDs.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
				      
		it = windowIDs.iterator();
		System.out.println("\n\n"+ "=".repeat(50));
		String ParentID =it.next();
		String childID =it.next();
		System.out.println("Parent window ID = " + ParentID);
		System.out.println("Child window ID = " + childID);
		
		System.out.println("\n\n"+ "=".repeat(50));
		System.out.println("\nAnother Way");
		//SEcond methos using List/ArrayList
		List <String>  windowIDList = new ArrayList(windowIDs);
		ParentID = windowIDList.get(0);
		childID = windowIDList.get(1);
		System.out.println("Parent window ID = " + ParentID);
		System.out.println("Child window ID = " + childID);
		

		//Switching between windows
		driver.switchTo().window(ParentID);
		System.out.println("Parent window Title =" + driver.getTitle());

		driver.switchTo().window(childID);
		System.out.println("Child window Title = " + driver.getTitle());
		
		Thread.sleep(5000);
		System.out.println("\n\n"+ "=".repeat(50));
		System.out.println("Using for loop");
		System.out.println(""+ "=".repeat(50));
		for(String str : windowIDList) {
			driver.switchTo().window(str);
			String title = driver.getTitle();
			System.out.println("Window = " + str + " Title = " +title);
			if (title.equals("OrangeHRM") ) {
				System.out.println("Title found");
				driver.close();
			}
		}
		
		//driver.close();
		//driver.quit();
	}

}


