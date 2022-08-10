package interview;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTableWithPagination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.opencart.com/admin/index.php");
		//Usernamr
		WebElement username = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		
		username.clear();
		username.sendKeys("demo");
		
		password.clear();
		password.sendKeys("demo");
		
		//Click login button
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[2]/form/div[3]/button/i")).click();
		//Sales link
		driver.findElement(By.linkText("Sales")).click();
		
		//order link
		driver.findElement(By.linkText("Orders")).click();
		

		//Find total number of pages in the table
		String text = driver.findElement(By.xpath("//div[@class='col-sm-6 text-right']")).getText();
		int startIndex = text.indexOf("(");
		int endIndex = text.indexOf("Pages");
		
		System.out.println("text = " + text +" Start index = " +  startIndex + " End index = " + endIndex);
		
		String noOfPages = text.substring(startIndex+1, endIndex-1);
		System.out.println("noOfPages = " + noOfPages);
		
		int total_pages = Integer.valueOf(noOfPages);
		System.out.println("total no. of pages = " + total_pages);
				
		total_pages=2;
		//Traverse all the pages
		for (int p=1 ; p<= total_pages; p++) {
			//WebElement active_page = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div[2]/div/div[2]/div/div[1]/ul//li//span"));
			WebElement active_page = driver.findElement(By.xpath("//ul[@class='pagination']//li//span"));
			
			//System.out.println("Active page = " + active_page.getText());
			active_page.click();
			
			//to get number of rows in each page
			int rows =driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size();
			System.out.println("No of rows in " + p + " is " + rows);
			
			//Read all the rows from each page
			
			for (int r =1; r<=rows ;r++) {
				String row = Integer.toString(r);
				String orderID = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[2]")).getText();			
				String customer = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[3]")).getText();				
				String status = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[4]")).getText();
				System.out.println(orderID + "     "+ customer  +"     "+ status );
			}
				
			String pageno = Integer.toString(p+1);
			driver.findElement(By.xpath("//ul[@class='pagination']//li//a[text()='"+pageno+"']")).click();
		}

	}
}