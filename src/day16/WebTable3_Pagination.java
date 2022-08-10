package day16;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable3_Pagination {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		//driver.get("https://examples.bootstrap-table.com/");
		
		//URL
		driver.get("https://datatables.net/examples/basic_init/alt_pagination.html");
		
		
		System.out.println("Start hare");
		//Get the paging Element
		WebElement page_navigation = driver.findElement(By.xpath("//*[@id=\"example_paginate\"]"));
		
		//Store all the page links into a list
		List <WebElement> sub_links = page_navigation.findElements(By.tagName("a"));
		System.out.println("SUB LINKS Size = " + sub_links.size());
		/*
		driver.findElement(By.xpath("//*[@id=\"example_paginate\"]/span/a[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"example_paginate\"]/span/a[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"example_paginate\"]/span/a[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"example_paginate\"]/span/a[4]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"example_paginate\"]/span/a[5]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"example_paginate\"]/span/a[6]")).click();
		Thread.sleep(2000);
		*/
		
		
		if(sub_links.size()>0)
		{
			//for(int i=1 ; i<=sub_links.size()-1; i++)
			for(int i=1 ; i<=sub_links.size()-4; i++)
			{
				System.out.println("Value of i =" +i);
				System.out.println("\nPage No " +i +"==================================================================");
				WebElement link = driver.findElement(By.xpath("//*[@id=\"example_paginate\"]/span/a["+i+"]"));
				link.click();
				Thread.sleep(1000)	;			//link_num.
				
				//Get the count of rows
				int rows = driver.findElements(By.xpath("//*[@id=\"example\"]/tbody/tr")).size();
				int cols = driver.findElements(By.xpath("//*[@id=\"example\"]/tbody/tr[1]/td")).size();
				//Read the table data
				for(int r=1; r<=rows; r++)
				{
					for (int c=1;c<=cols;c++)
					{
						String value =driver.findElement(By.xpath("//*[@id=\"example\"]/tbody/tr["+r+"]/td["+c+"]")).getText();
						System.out.print("    " +value);
					}
					System.out.println("");
				}
			}
		}
		else
		{
			System.out.println("Links not present");
		}
		
		//System.out.println(""+str);
		
		//driver.close();

	}

}
