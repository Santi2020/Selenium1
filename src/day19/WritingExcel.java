package day19;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingExcel {

	public static void main(String[] args) throws IOException {
		FileOutputStream file = new FileOutputStream("C://santoshi//Selenium//Test//Auto_data.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("data1");
		for(int i =0;i<=5; i++)
		{
			XSSFRow row = sheet.createRow(i);
			for(int j=0;j<3; j++)
			{
				row.createCell(j).setCellValue("Welcome" +i +"   " +j);
			}
		}
		workbook.write(file);
		System.out.println("Completed writing");
	}

}
