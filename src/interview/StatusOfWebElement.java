package interview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StatusOfWebElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver();
		
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/register");
		
		
		WebElement searchStore = driver.findElement(By.xpath("//*[@id=\"small-searchterms\"]"));
		
		System.out.println("Search store isDisplayed() = "+searchStore.isDisplayed());
		System.out.println("Search store .isEnabled() = "+searchStore.isEnabled() );
		
		
		//WebElement radio_male =driver.findElement(By.xpath("//*[@id=\"gender\"]/span[1]/label"));
		WebElement radio_male =driver.findElement(By.xpath("//*[@id=\"gender-male\"]"));
		System.out.println("radio_male .getText() = "+radio_male.getText() );
		System.out.println("radio_male .isSelected() = "+radio_male.isSelected() );
		//radio_male.clear();
		radio_male.click();
		System.out.println("radio_male .isSelected() = "+radio_male.isSelected() );
		
		System.out.println("=".repeat(25));
		WebElement radio_female =driver.findElement(By.xpath("//*[@id=\"gender-female\"]"));
		System.out.println("radio_female .getText() = "+radio_female.getText() );
		System.out.println("radio_female .isSelected() = "+radio_female.isSelected() );
		//radio_male.clear();
		radio_female.click();
		System.out.println("radio_female .isSelected() = "+radio_female.isSelected() );
		System.out.println("radio_male .isSelected() = "+radio_male.isSelected() );
		
		
		radio_male.click();
		System.out.println("radio_male.click(); radio_male .isSelected() = "+radio_male.isSelected() );
	}

}
