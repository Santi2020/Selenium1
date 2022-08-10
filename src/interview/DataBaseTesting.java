package interview;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataBaseTesting {

	public static void main(String[] args) throws SQLException {
		
		String cust_firstName ="Simba";
		String cust_lastName ="Jungle";
		String cust_email ="simba3@gmail.com";
		String cust_telPhone ="1122334455";
		String cust_password ="aabbccddee";
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.opencart.com/");
		
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
		
		driver.findElement(By.name("firstname")).sendKeys(cust_firstName);
		driver.findElement(By.name("lastname")).sendKeys(cust_lastName);
		driver.findElement(By.name("email")).sendKeys(cust_email);
		driver.findElement(By.name("telephone")).sendKeys(cust_telPhone);
		driver.findElement(By.name("password")).sendKeys(cust_password);
		driver.findElement(By.name("confirm")).sendKeys(cust_password);
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
		try {
			String message = driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();
			String expMessage = "Your Account Has Been Created!";
			System.out.println("Message = " + message);
			if (message.equals(expMessage)){
				System.out.println("Registration successful from UI ");
			}
			else {
				System.out.println("Registration NOT successful from UI ");
			}
		}
		catch(Exception e) {
			System.out.println("Exception occured " + e.getMessage());
		}
		
		//database validation
		String constring = "jdbc:mysql://localhost:3306/hrdb";
		Connection con = DriverManager.getConnection(constring, "root","@pex_2022*****");
		Statement stmt = con.createStatement();
		
		String query ="SELECt * FROM USER_DETAILS";
		
		ResultSet rs = stmt.executeQuery(query);
		boolean status = false;
		while(rs.next()) {
			String fn = rs.getString("firstname");
			String ln = rs.getString("lastname");
			String email = rs.getString("email");
			String ph = rs.getString("phone");
			
			if(cust_firstName.equals(fn) && cust_lastName.equals(ln)
					&& cust_telPhone.equals(ph) && cust_email.equals(email)) {
				System.out.println("Record found in the database and Test Passed");
				status = true;
				break;
			}	
		}
		
		if(status==false){
			System.out.println("No record found in the database and Test Failed");
		}		
	}

}
