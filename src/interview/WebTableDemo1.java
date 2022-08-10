package interview;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableDemo1 {
	/*
	 * How many rows in a table
		How many columns in a table
		Retrieve specifc row /column data
		Retrieve all the data fro the table
		Print release date . VersionNo of java language of selenium

	 */
	
	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.selenium.dev/ecosystem/");
		//How many rows in a table
		int rows = driver.findElements(By.xpath("//table[@class='table']/tbody/tr")).size();
		System.out.println("In 1st xpath Rows = " + rows);
		rows = driver.findElements(By.xpath("//div[@class='table-responsive']//table[@class='table']//tbody/tr")).size();
		System.out.println("In 2nd xpath Rows = " + rows);
		
		
		System.out.println("End of the line");
		
		//How many columns in a table
		int cols = driver.findElements(By.xpath("//table[@class='table']//thead/tr/th")).size();
		System.out.println("Cols = " + cols);
		System.out.println("End of the line");
		
		cols =3;
		rows =11;
		
		//Retrieve specifc row /column data
		String str = driver.findElement(By.xpath("//div[@class='table-responsive']//table[@class='table']/tbody//tr[5]/td[2]")).getText();
		System.out.println("String = " + str);
		
		//Retrieve all the data fro the table
		for (int r = 1;r<rows;r++) {
			for (int c =1; c<cols; c++) {
				String str1 = "//div[@class='table-responsive']//table[@class='table']/tbody//tr["+r+"]/td[" +c+"]";
				String value = driver.findElement(By.xpath(str1)).getText();
				//System.out.println("xpath= " + str1);
				//System.out.print("\n");
				System.out.print("--Row = " +r +"--Col =" + c + "-- " + value);
			}
			System.out.print("\n");
		}
		
		for(int r=1 ; r<rows; r++) {
			str= driver.findElement(By.xpath("//div[@class='table-responsive']//table[@class='table']/tbody//tr["+r+"]/td[1]")).getText();
			if (str.equals("Python")) {
				str= driver.findElement(By.xpath("//div[@class='table-responsive']//table[@class='table']/tbody//tr["+r+"]/td[2]")).getText();
				System.out.println("Author = " +str);
				//break;
			}
		}
		driver.quit();
	}

}
