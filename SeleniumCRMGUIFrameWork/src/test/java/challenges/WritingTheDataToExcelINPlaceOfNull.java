package challenges;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WritingTheDataToExcelINPlaceOfNull {

	public static void readExcel(String filePath, String sheetName) throws Exception {
		FileInputStream fis = new FileInputStream(filePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		DataFormatter formatter = new DataFormatter();

		int rowCount = sh.getLastRowNum();
		int columnCount = sh.getRow(0).getLastCellNum();

		//System.out.println("Reading Excel content:");
		for (int i = 1; i <= rowCount; i++) {
			Row row = sh.getRow(i);
			if (row != null) {
				for (int j = 0; j < columnCount; j++) {
					Cell cell = row.getCell(j);
					
					String value;
					if (cell != null) {
						value = formatter.formatCellValue(cell);
					} else {
						// If cell is null, create it and set "NA"
						cell = row.createCell(j);
						cell.setCellValue("NA");
						value = "NA";
					}

					System.out.print(value + "\t");
				}
				System.out.println();
			}
		}

		// Write the changes back to the file
		FileOutputStream fos = new FileOutputStream(filePath);
		wb.write(fos);
		fos.close();
		wb.close();

		System.out.println("\nExcel updated successfully with 'NA' for null cells during reading.");
	}

	public static void main(String[] args) throws Exception {
		//String filePath = "C:\\Users\\DELL\\Documents\\Sample_Contact_Data.xlsx";
		//String sheetName = "ContactList";


		// read and print the updated content
		readExcel("C:\\Users\\DELL\\Documents\\Sample_Contact_Data.xlsx", "ContactList");
	}

}
