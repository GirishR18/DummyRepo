package working.datadrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromExcelFile {

	public static void main(String[] args) throws Throwable, IOException {

		// Step 1:- get The excel path location and java object of the physical excel
		// file
		FileInputStream fis = new FileInputStream("C:\\Users\\DELL\\Desktop\\AdvanceSeleniumTestData.xlsx");

		// Step 2:- Open WorkBook in read mode
		Workbook wb = WorkbookFactory.create(fis);

		// Step 3 :- get The control of the "Orgnization" sheet
		Sheet sh = wb.getSheet("Products");

		// Step 4:- get The control of the 1st Row
		int rowCount = sh.getLastRowNum();
		//int count = 0;
		for (int i = 1; i <= rowCount; i++) {
			Row row = sh.getRow(i);

			String colData1 = row.getCell(0).toString();
			String colData2 = row.getCell(1).toString();
			System.out.println(colData1 + "\t" + colData2);
			//count++;
			
			
		}
		//System.out.println(count);
		wb.close();
	}

}
