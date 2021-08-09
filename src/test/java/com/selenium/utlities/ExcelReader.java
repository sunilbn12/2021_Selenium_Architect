package com.selenium.utlities;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {
    public static Workbook workbookFactory;

    public ExcelReader(String path) {
        try {
            workbookFactory = WorkbookFactory.create(new FileInputStream(path));
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }

    }

    public int getRowNumber(String sheetName) {
        return workbookFactory.getSheet(sheetName).getLastRowNum();
    }

    public int getColumnNumber(String sheetName, int rowNumber) {
        return workbookFactory.getSheet(sheetName).getRow(rowNumber).getLastCellNum();
    }

    public String getCellValue(String sheetName, int column, int row) {
        String value = workbookFactory.getSheet(sheetName).getRow(row).getCell(column).toString();
        return value;
    }


}
