package day19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FixedDepositCalculator {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		String path="C://santoshi//Selenium//Test//calculate_SI.xlsx";
		XLUtils.setExcelFile(path, "Sheet1");
		int rowcount = XLUtils.getRowCount(path, "Sheet1");
		int colcount =XLUtils.getCellCount(path, "Sheet1", rowcount);
		
		for(int i=1; i<=rowcount; i++)
		{
			int principal = Integer.parseInt( XLUtils.getCellData(path, "sheet1", i, 0));
			int interest = Integer.parseInt(XLUtils.getCellData(path, "sheet1", i, 1));
			int period = Integer.parseInt(XLUtils.getCellData(path, "sheet1", i, 2));
			String frequency = XLUtils.getCellData(path, "sheet1", i, 3);
			double exp_maturity_val =Double.parseDouble(XLUtils.getCellData(path, "sheet1", i, 4));
			
			//System.out.println("Frequency =" + frequency);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"principal\"]")).sendKeys(String.valueOf( principal)) ;
			driver.findElement(By.xpath("//*[@id=\"interest\"]")).sendKeys(String.valueOf(interest)) ;
			driver.findElement(By.xpath("//*[@id=\"tenure\"]")).sendKeys(String.valueOf(period)) ;
			
			Select period_dd = new Select(driver.findElement(By.xpath("//*[@id=\"tenurePeriod\"]")));
			period_dd.selectByVisibleText("year(s)");
			
			Select freq_dd = new Select(driver.findElement(By.xpath("//*[@id=\"frequency\"]"))); 
			freq_dd.selectByVisibleText(frequency);
			
			//click on calculate button
			driver.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[1]/img")).click();
			
			String act_maturity_value= driver.findElement(By.xpath("//*[@id=\"resp_matval\"]/strong")).getText();
			System.out.println("act_maturity_value = " + act_maturity_value);
			String result = "Failed";
			if(exp_maturity_val == Double.parseDouble(act_maturity_value) )
			{
				System.out.println("Test passed");
				result = "Passed";
			}
			else
			{
				System.out.println("Test failed");
				result = "Failed";
			}
			XLUtils.setCellData(path, "Sheet1", i, 5, act_maturity_value);
			XLUtils.setCellData(path, "Sheet1", i, 6, result);
			//Click clear button
			driver.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[2]/img")).click();
			Thread.sleep(1000);
		
		}
		driver.close();
	}

}
