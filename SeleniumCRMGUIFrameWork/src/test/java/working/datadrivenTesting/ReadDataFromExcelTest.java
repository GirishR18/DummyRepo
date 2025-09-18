package working.datadrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelTest {

	public static void main(String[] args) throws Throwable, IOException {
		
		//Step 1:- get The excel path location and java object of the physical excel file
		FileInputStream fis = new FileInputStream("C:\\Users\\DELL\\Desktop\\AdvanceSeleniumTestData.xlsx");
		
		//Step 2:- Open WorkBook in read mode
		Workbook wb = WorkbookFactory.create(fis);
		
		//Step 3 :- get The control of the "Orgnization" sheet
		Sheet sh =wb.getSheet("Orgnization");
		
		//Step 4:- get The control of the 1st Row
		Row row = sh.getRow(1);
		
		//Step 5:- Get The control of the 2 nd cell and read the string data
		//Cell cel = row.getCell(2);
		
		//To get String value
		//String data = cel.getStringCellValue();
		
		//to get numeric value
		//double data = row.getCell(3).getNumericCellValue();
		
		//to convert int to string 
		String data = row.getCell(3).toString();
		
		System.out.println(data);
//		int num = row.getPhysicalNumberOfCells();
//		System.out.println(num);
		
		//Step 6:- Close The workbook
		wb.close();
		
	}

}
