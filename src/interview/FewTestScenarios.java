package interview;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;



public class FewTestScenarios {
	public WebDriver driver;
	
	FewTestScenarios() {
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	public void populatText() {
		driver.get("https://admin-demo.nopcommerce.com");
		driver.findElement(By.xpath("//*[@id=\"Email\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys("AAAA");
		driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys("BBBB");
	}
	
	
	public void getTextValue() {
		driver.get("https://admin-demo.nopcommerce.com");
		String email = driver.findElement(By.xpath("//*[@id=\"Email\"]")).getAttribute("value") ;
		//String password = driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys("BBBB");
		System.out.println("Email = " + email);
		
	}
	
	
	/**
	 * 
	 */
	/**
	 * 
	 */
	public void dropDownDemo() {
		driver.get("https://www.opencart.com/index.php?route=account/register");
		WebElement drpCountryElement = driver.findElement(By.xpath("//*[@id=\"input-country\"]"));
		Select selectCountry = new Select(drpCountryElement);
		//selectCountry.selectByVisibleText("Denmark");
		
		//selectCountry.selectByIndex(3);
		//selectCountry.selectByValue("13");
		
		//Selecting options from dropdown without useing the methods
		
		List <WebElement> allOptions = selectCountry.getOptions();
		for(WebElement option : allOptions) {
			//System.out.println(option.getText());
			if (option.getText().equals("Denmark")){
				System.out.println("Found the option " + option.getText());
				option.click();
			}
		}
		
	}
	
	public void dropDownApproach2() {
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		WebElement ddElement = driver.findElement(By.name("Country"));
		//Select selectDrp = new Select(ddElement);
		//List <WebElement> options = selectDrp.getOptions(); 
		selectOptionFromdropDown(ddElement,"Brazil" );
	}
	
	
	public static void selectOptionFromdropDown(WebElement ele, String value) {
		Select drp = new Select(ele);
		List <WebElement> options = drp.getOptions();
		for(WebElement e : options) {
			if (e.getText().equals(value)){
				e.click();
			}
		}
	}
	
	
	public static void main(String[] args) {
		FewTestScenarios obj = new FewTestScenarios();
		//obj.getTextValue();
		//obj.dropDownDemo();
		obj.dropDownApproach2();
	}

}
