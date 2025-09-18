package working.datadrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;





public class ReadDataBackToExcel_Write {

	public static void main(String[] args) throws Exception {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\DELL\\Desktop\\AdvanceSeleniumTestData.xlsx");

		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Orgnization");
		Row row = sh.getRow(7);
		// DataFormatter formatter = new DataFormatter();
		 DataFormatter formatter = new DataFormatter();
		 

		
		Cell cel = row.createCell(4);
		 formatter.formatCellValue(cel);
		//cel.setCellType(CellType.STRING);
		cel.setCellValue("FAIL");
	
		FileOutputStream fos = new FileOutputStream("C:\\Users\\DELL\\Desktop\\AdvanceSeleniumTestData.xlsx");
		wb.write(fos);
		wb.close();
		System.out.println("--Exceuted--");
		
		//getPhysicalNumberOfCells()
		//.getLastCellNum()
//		getLastRowNum()
//		getPhysicalNumberOfRows()

	}

}
