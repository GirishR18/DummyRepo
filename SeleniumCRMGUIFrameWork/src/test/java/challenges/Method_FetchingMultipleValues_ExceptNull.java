package challenges;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Method_FetchingMultipleValues_ExceptNull {

	public static void readExcel(String filePath, String sheetName) throws Exception {
		FileInputStream fis = new FileInputStream(filePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		DataFormatter formatter = new DataFormatter();

		int rowCount = sh.getLastRowNum();
		int columnCount = sh.getRow(0).getLastCellNum();

		for (int i = 1; i <= rowCount; i++) {
			Row row = sh.getRow(i);
			if (row != null) {
				for (int j = 0; j < columnCount; j++) {
					Cell cell = row.getCell(j);
					
					//ternary operator
					//String value = (cell != null) ? formatter.formatCellValue(cell) : "";
					
					String value = ""; // Default value

					if (cell != null) {
						value = formatter.formatCellValue(cell); // Safely get the cell's value
					} else {
						value = ""; // If cell is null, assign empty string
					}
					System.out.print(value + "\t");
				}
				System.out.println();
			}
		}

		wb.close();
	}

	public static void main(String[] args) throws Exception {
		//String filePath = "C:\\Users\\DELL\\Documents\\Sample_Contact_Data.xlsx";
		//String sheetName = "ContactList";

		Method_FetchingMultipleValues_ExceptNull.readExcel("C:\\Users\\DELL\\Documents\\Sample_Contact_Data.xlsx", "ContactList");
	}
}