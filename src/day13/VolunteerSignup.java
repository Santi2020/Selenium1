package day13;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VolunteerSignup {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://goo.gl/RVdKM9");
		driver.manage().window().maximize();
		
		System.out.println(" Title = "+driver.getTitle());
		System.out.println(" Current URL = " + driver.getCurrentUrl());
		//System.out.println(" Source = " + driver.getPageSource());
		
		//Firstname
		driver.findElement(By.xpath("//*[@id=\"RESULT_TextField-1\"]")).sendKeys("TishaAnika");
		
		//Lastname
		driver.findElement(By.xpath("//*[@id=\"RESULT_TextField-2\"]")).sendKeys("Bandi");
		
		//Phone
		driver.findElement(By.xpath("//*[@id=\"RESULT_TextField-3\"]")).sendKeys("654321");
		
		//Country
		driver.findElement(By.xpath("//*[@id=\"RESULT_TextField-4\"]")).sendKeys("Bharat");
		
		//City
		driver.findElement(By.xpath("//*[@id=\"RESULT_TextField-5\"]")).sendKeys("Livermore");
		
		//email
		////*[@id="RESULT_TextField-6"]
		driver.findElement(By.xpath("//*[@id=\"RESULT_TextField-6\"]")).sendKeys("abcde@gmail.com");
		
		/*
		
		//RESULT_RadioButton-7_0
		WebElement rad_male =driver.findElement(By.xpath("//*[@id=\"q26\"]/table/tbody/tr[1]/td/label"));
		
		//WebElement rad_male =driver.findElement(By.id("RESULT_RadioButton-7_0"));
		
		System.out.println("Text of radio button = " +rad_male.getText());
		System.out.println("Radio button Male is displayed " +rad_male.isDisplayed());
		
		System.out.println("Radio button Male is enabled " +rad_male.isEnabled());
		System.out.println("Radio button Male is Selected " +rad_male.isSelected());
		
		rad_male.click();
		Thread.sleep(1000);
		System.out.println("After clicking Radio button Male is Selected " +rad_male.isSelected());
		*/
		
		//Checking for Female Radio button
		WebElement rad_female = driver.findElement(By.xpath("//*[@id=\"q26\"]/table/tbody/tr[2]/td/label"));
		System.out.println("Text of Radio button = " +rad_female.getText());
		rad_female.click();
		System.out.println("After clicking Radio button FEMALE is Selected " +rad_female.isSelected());
		
		
		//Checkbox
		
		WebElement sunday = driver.findElement(By.xpath("//*[@id=\"q15\"]/table/tbody/tr[1]/td"));
		System.out.println("Check box 1 =" +sunday.getText());
		
		WebDriverWait wait = new WebDriverWait(driver, 120);
	    wait.until(ExpectedConditions.elementToBeClickable(sunday)); 
	     
		sunday.click();
		boolean boo=false;
		boo = sunday.isSelected();
		String attr = sunday.getAttribute("checked");
		System.out.println("Attribute checked = " + attr);
		
		Thread.sleep(1000);
		System.out.println("XXXXXX Check box Sunday is clicked =" +boo);
		
		System.out.println("Check box is selected =" +sunday.isSelected());
		//dropdown
		//WebElement drp = driver.findElement(By.xpath("//*[@id=\"RESULT_RadioButton-9\"]"));
		// Select dropdown1 = new Select(drp);
		//            or
		
		Select dropdown1 =new Select(driver.findElement(By.xpath("//*[@id=\"RESULT_RadioButton-9\"]")));
		
		System.out.println("Dropdown size = " +dropdown1.getOptions().size());
		
		List <WebElement> options = dropdown1.getOptions();
		
		for(WebElement e :options)
		{
			System.out.println(e.getText());
		}
		
		//dropdown1.selectByVisibleText("Morning");
		//dropdown1.selectByIndex(3);
		dropdown1.selectByValue("Radio-1");
		
		
		//Link Testing
		driver.findElement(By.linkText("Software Testing Tutorials")).click();
		System.out.println("Page 1  = "+driver.getTitle());
		
		driver.navigate().back();
		System.out.println("Page 2  = "+driver.getTitle());
		
		driver.findElement(By.partialLinkText("Software Testing Tools Training")).click();
		System.out.println("Page 3  = "+driver.getTitle());
		
		driver.navigate().back();
		System.out.println("Page 4  = "+driver.getTitle());
		
		driver.navigate().forward();
		System.out.println("Page 5  = "+driver.getTitle());
		
		driver.navigate().back();
		System.out.println("Page 6  = "+driver.getTitle());
		
		driver.navigate().refresh();
		System.out.println("Page 7  = "+driver.getTitle());
	}

}
