package io.mart.selenuimExperiments.excelDatasets;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelExperiment {


    public static void main(String[] args) throws IOException {
        FileInputStream file = new FileInputStream("path to file");

        XSSFWorkbook workBook = new XSSFWorkbook(file);
        XSSFSheet sheet = workBook.getSheet("sheet name");
        XSSFRow row = sheet.getRow(1);
        XSSFCell cell = row.getCell(1);
        String value = cell.getStringCellValue();
    }


}
