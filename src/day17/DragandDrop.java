package day17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragandDrop {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		Thread.sleep(1000);
		WebElement source_element = driver.findElement(By.xpath("//*[@id=\"box6\"]")); //Rome
		WebElement target_element = driver.findElement(By.xpath("//*[@id=\"box106\"]")); //Italy
		
		Actions act = new Actions(driver);
		act.dragAndDrop(source_element, target_element).build().perform() ;
		
		source_element = driver.findElement(By.xpath("//*[@id=\"box3\"]")); //washington
		target_element =driver.findElement(By.xpath("//*[@id=\"box103\"]")); //usa
		act.dragAndDrop(source_element, target_element).build().perform();
		
		Thread.sleep(1000);
		
		source_element = driver.findElement(By.xpath("//*[@id=\"box5\"]")); //seoul
		target_element =driver.findElement(By.xpath("//*[@id=\"box105\"]")); //south korea
		act.dragAndDrop(source_element, target_element).build().perform();
		Thread.sleep(1000);
		
		
		source_element = driver.findElement(By.xpath("//*[@id=\"box7\"]")); //madrid
		target_element =driver.findElement(By.xpath("//*[@id=\"box107\"]")); //spain
		act.dragAndDrop(source_element, target_element).build().perform();
		Thread.sleep(1000);
		
		source_element = driver.findElement(By.xpath("//*[@id=\"box1\"]")); //oslo
		target_element =driver.findElement(By.xpath("//*[@id=\"box101\"]")); //norway
		act.dragAndDrop(source_element, target_element).build().perform();
		Thread.sleep(1000);
		
		source_element = driver.findElement(By.xpath("//*[@id=\"box4\"]")); //denmark
		target_element =driver.findElement(By.xpath("//*[@id=\"box104\"]")); // copenhagen
		act.dragAndDrop(source_element, target_element).build().perform();
		Thread.sleep(1000);
		
		source_element = driver.findElement(By.xpath("//*[@id=\"box2\"]")); //stockholm
		target_element =driver.findElement(By.xpath("//*[@id=\"box102\"]")); //spain
		act.dragAndDrop(source_element, target_element).build().perform();
		Thread.sleep(1000);
		
	
	}

}
