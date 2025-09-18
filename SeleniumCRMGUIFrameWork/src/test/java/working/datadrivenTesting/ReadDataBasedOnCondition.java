package working.datadrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataBasedOnCondition {

	public static void main(String[] args) throws IOException {
		String expectedData = "TC_102";
		String data1 = "";
		String data2 = "";
		String data3 = "";
		boolean flag = false;

		FileInputStream fis = new FileInputStream("C:\\Users\\DELL\\Desktop\\AdvanceSeleniumTestData.xlsx");

		// Step 2:- Open WorkBook in read mode
		Workbook wb = WorkbookFactory.create(fis);

		// Step 3 :- get The control of the "Orgnization" sheet
		Sheet sh = wb.getSheet("Orgnization");

		// Step 4:- get The control of the 1st Row
		int rowCount = sh.getLastRowNum();
		//int num = sh.getPhysicalNumberOfRows();
		//System.out.println(num);

		for (int i = 0; i <= rowCount; i++) {
			String data = "";
			
			try {
				data = sh.getRow(i).getCell(0).toString();
				if (data.equals(expectedData)) {
					flag = true;
					data1 = sh.getRow(i).getCell(1).toString();
					data2 = sh.getRow(i).getCell(2).toString();
					data3 = sh.getRow(i).getCell(3).toString();
				}
			} catch (Exception e) {

			}
			
		}
		if (flag == true) {
			System.out.println(data1);
			System.out.println(data2);
			System.out.println(data3);
		} else {
			System.out.println(expectedData + " Data is not availble");
		}
		
		wb.close();
	}

}
