package day20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataDrivenTestUsingDB {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
	
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/");
		
		
		//JDBC connection
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl", "hr", "hr");	
		
		//Step 2
		Statement stmt = con.createStatement();
		
		//Step3 and 4 Create and execute statement
		String s ="Select * from userLogin";
		ResultSet rs = stmt.executeQuery(s);
		
		while(rs.next())
		{
			String uname = rs.getString("username");
			String pwd = rs.getString("pwd");
			
			//xpath of username
			//driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[2]/td[2]/input")).sendKeys(uname);
			
			//xpath of password
			//driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[3]/td[2]/input")).sendKeys(pwd);
			
			//click login
			//driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[4]/td[2]/div/input")).click();
//			Thread.sleep(3000);
		 	
			
			System.out.println("Username = " + uname + " Password = " + pwd);
			/*
			try
			{
				//String title =	driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/h3")).getText();
				
				if (title.equals("Login Successfully"))
				{
					System.out.println("Success");
					driver.navigate().back();
				}
				else
				{
					System.out.println("Failed");
				}
			}	
			catch(Exception e)
			{
				System.out.println("Error");
			}*/
	}
		rs.close();
		con.close();
		
	}

}
