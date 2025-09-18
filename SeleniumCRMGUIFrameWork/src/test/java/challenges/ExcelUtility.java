package challenges;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.*;

public class ExcelUtility {

    public void writeDataToExcel(String sheetName, int rowNum, int celNum, String data) throws Throwable {
        String path = "C:\\Users\\DELL\\Desktop\\AdvanceSeleniumTestData.xlsx";
        FileInputStream fis = new FileInputStream(path);
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheet = wb.getSheet(sheetName);

        if (sheet == null) {
            sheet = wb.createSheet(sheetName);
        }

        Row row = sheet.getRow(rowNum);
        if (row == null) {
            row = sheet.createRow(rowNum);
        }

        Cell cell = row.createCell(celNum, CellType.STRING);
        cell.setCellValue(data);

        fis.close(); // Close input before writing

        FileOutputStream fos = new FileOutputStream(path);
        wb.write(fos);
        fos.close();
        wb.close();
    }
}
