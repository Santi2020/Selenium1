package day13;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SignUpAssignment {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		//Thread.sleep(5000);
		
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//*[@id=\"RESULT_TextField-1\"]")).sendKeys("Tisha Anika");
		driver.findElement(By.xpath("//*[@id=\"RESULT_TextField-2\"]")).sendKeys("Bandi");
		driver.findElement(By.xpath("//*[@id=\"RESULT_TextField-3\"]")).sendKeys("22334455");
		driver.findElement(By.xpath("//*[@id=\"RESULT_TextField-4\"]")).sendKeys("United States of America");
		driver.findElement(By.xpath("//*[@id=\"RESULT_TextField-5\"]")).sendKeys("Livermore");
		driver.findElement(By.xpath("//*[@id=\"RESULT_TextField-6\"]")).sendKeys("abcde@gmail.com");
		
		
		//Thread.sleep(3000);
		WebElement r_male=driver.findElement(By.xpath("//*[@id=\"q26\"]/table/tbody/tr[1]/td/label")) ;
		r_male.click();
		
		
		//Thread.sleep(3000);
		WebElement r_female =driver.findElement(By.xpath("//*[@id=\"q26\"]/table/tbody/tr[2]/td/label"));
		
		
		if (r_male.isSelected())
		{
			System.out.println("Male is selected");
		}
		else
		{
			System.out.println("Radio button Male is not selected");
		}
		
		r_female.click();	
		if (r_female.isSelected())
		{
			System.out.println("Female is selected");
		}
		else
		{
			System.out.println("Radio button Female is not selected");
		}	
		
		WebElement chk_sunday = driver.findElement(By.xpath("//*[@id=\"q15\"]/table/tbody/tr[1]/td/label"));
		chk_sunday.click();
		
		
		WebElement chk_monday = driver.findElement(By.xpath("//*[@id=\"q15\"]/table/tbody/tr[2]/td/label"));
		chk_monday.click();
		
		WebElement chk_tuesday = driver.findElement(By.xpath("//*[@id=\"q15\"]/table/tbody/tr[3]/td/label"));
		chk_tuesday.click();
		
		
		WebElement chk_wednesday = driver.findElement(By.xpath("//*[@id=\"q15\"]/table/tbody/tr[4]/td/label"));
		chk_wednesday.click();
		
		WebElement chk_thursday = driver.findElement(By.xpath("//*[@id=\"q15\"]/table/tbody/tr[5]/td/label"));
		chk_thursday.click();
		
		WebElement chk_friday = driver.findElement(By.xpath("//*[@id=\"q15\"]/table/tbody/tr[6]/td/label"));
		chk_friday.click();
		
		WebElement chk_saturday = driver.findElement(By.xpath("//*[@id=\"q15\"]/table/tbody/tr[7]/td/label"));
		chk_saturday.click();
		
		
		Select dd_ttcontact = new Select(driver.findElement(By.xpath("//*[@id=\"RESULT_RadioButton-9\"]")));
		System.out.println("Dropdown size is " + dd_ttcontact.getOptions().size() );
		List <WebElement> options = dd_ttcontact.getOptions();
		
		for (WebElement ele :options)
		{
			System.out.println(ele.getText());
		}
		
		dd_ttcontact.selectByIndex(2);
		
		
		driver.switchTo().defaultContent() ;
		System.out.println("==========================================");
		//Speed dropdown
		Select dd_speed = new Select(driver.findElement(By.xpath("//*[@id=\"speed\"]")));
		System.out.println("Speed Dropdown size = " + dd_speed.getOptions().size());
		List <WebElement> speed = dd_speed.getOptions();
		for(WebElement e :speed)
		{
			System.out.println("Speed = " + e.getText());
		}
		
		dd_speed.selectByIndex(4);
		
		System.out.println("==========================================");
		Select ddFile = new Select(driver.findElement(By.xpath("//*[@id=\"files\"]")));
		System.out.println("File Dropdown size = " + ddFile.getOptions().size() );
		List <WebElement> lst_file = ddFile.getOptions();
		for(WebElement e :lst_file)
		{
			e.getText();
		}
		ddFile.selectByIndex(3);
		
		System.out.println("==========================================");
		Select ddNum = new Select(driver.findElement(By.xpath("//*[@id=\"number\"]")));
		
		List <WebElement> lstNum = ddNum.getOptions();
		System.out.println("Size of dropdown Number = " +lstNum.size());
		
		for(WebElement e : lstNum)
		{
			System.out.println(e.getText());
		}
		
		ddNum.selectByIndex(1);
		
		System.out.println("==========================================");
		Select ddProduct =new Select(driver.findElement(By.xpath("//*[@id=\"products\"]")));
		List <WebElement> lstProduct = ddProduct.getOptions();
		System.out.println("Size of dropdown product = " + lstProduct.size() );
		
		for(WebElement e:lstProduct)
		{
			System.out.println(e.getText());
		}
		ddProduct.selectByIndex(3);
		
		System.out.println("==========================================");
		Select ddAnimal = new Select(driver.findElement(By.xpath("//*[@id=\"animals\"]")));
		List <WebElement> lstAnimal = ddAnimal.getOptions();
		System.out.println("Size of DD Animal = " + lstAnimal.size());
		int i=0;
		for (WebElement e : lstAnimal)
		{
			System.out.println(i +"   " + e.getText());
			i+=1;
		}
		ddAnimal.selectByIndex(3);
		//Link Test
		
		//driver.findElement(By.linkText("Software Testing Tutorials")).click();
		
		//driver.navigate().back();
		
		//Thread.sleep(5000);
		
		//driver.findElement(By.partialLinkText("Software Testing Tools Training")).click();
		
		//driver.navigate().back();
	}

}
