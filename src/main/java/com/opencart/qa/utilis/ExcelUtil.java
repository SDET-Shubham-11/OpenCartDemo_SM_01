package com.opencart.qa.utilis;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	private static Workbook workbook;
    private static Sheet sheet;
    
    

    public static Object[][] getTestData(String sheetName) {
        Object[][] data = null;
        
       

        try (FileInputStream file = new FileInputStream(TestUtil.TESTDATA_SHEET_PATH);
             Workbook workbook = new XSSFWorkbook(file)) {

            Sheet sheet = workbook.getSheet(sheetName);
            
            if (sheet == null) {
                throw new RuntimeException("Sheet with name \"" + sheetName + "\" not found in the Excel file.");
            }
            
            int rowCount = sheet.getLastRowNum();
            int colCount = sheet.getRow(0).getLastCellNum();

            data = new Object[rowCount][colCount];

            for (int i = 0; i < rowCount; i++) {
                Row row = sheet.getRow(i + 1);
                for (int j = 0; j < colCount; j++) {
                    Cell cell = row.getCell(j);
                    data[i][j] = cell != null ? cell.toString() : "";
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}
