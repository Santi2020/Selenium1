package day19;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream file = new FileInputStream("C://santoshi//Selenium//Test//Names.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		//Get the no. of rows
		int rowcnt = sheet.getLastRowNum();
		int colcnt = sheet.getRow(0).getLastCellNum();
		
		System.out.println("\n Rows =" +rowcnt +"\n Cols = " +colcnt);
		for(int r=0;r<=rowcnt;r++)
		{
			
			XSSFRow row = sheet.getRow(r);
			for(int c=0;c<colcnt;c++)
			{
				XSSFCell cell = row.getCell(c);
				String value = cell.toString();
				//or
				//String value = row.getCell(c).toString();
				System.out.print(value + "   ");
			}
			System.out.println(); 
		}
	}
}



