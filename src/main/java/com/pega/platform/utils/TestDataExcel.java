package com.pega.platform.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestDataExcel {
    private static final String testDataFileName = System.getProperty("user.dir") +  "//data//testdata.xlsx";
	
    public static String readExcel(String sheetname, int row, int col) {
    	String cellValue = "";
    	try {
    	File file = new File(testDataFileName);
		System.out.println("Reading data from excel address :--- " + testDataFileName);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet(sheetname);
		XSSFRow rowObj = sheet.getRow(row);
		XSSFCell cell = rowObj.getCell(col);
		
		if (cell != null) {
			switch (cell.getCellType()) {
			case STRING:
				cellValue = cell.getStringCellValue();
			break;
			case NUMERIC:
				cellValue = String.valueOf(cell.getNumericCellValue());
			break;
			case BOOLEAN:
				cellValue = String.valueOf(cell.getBooleanCellValue());
			break;
			case FORMULA:
				cellValue = cell.getCellFormula();
			break;
			default:
				cellValue = "";
			}
		}
		wb.close();
		fis.close();
		}
		catch (IOException ex) {
			System.out.println("Failed to read data from testdata.xlsx file: " + ex);
		}
		
		return cellValue;
	}
	
	public static void writeExcel(String sheetname, String cellvalue, int row, int col) {
		try {
		File file = new File(testDataFileName);
		System.out.println("write the data into excel address :--- " + testDataFileName);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet(sheetname);
		sheet.getRow(row).createCell(col).setCellValue(cellvalue);
		FileOutputStream fos = new FileOutputStream(new File(testDataFileName));
		wb.write(fos);
		wb.close();
		}
		catch (IOException ex) {
			System.out.println("Failed to write data to testdata.xlsx file: " + ex);
		}
	}
	
	/*
	public static void main(String[] args) {
		
	String compName = TestDataExcel.readExcel("Sheet1", 1, 0);
	System.out.println("Company Name: " + compName);
	TestDataExcel.writeExcel("Sheet1",  "ABC Inc.", 1, 0);
	compName = TestDataExcel.readExcel("Sheet1", 1, 0);
	System.out.println("Company Name: " + compName);
	
	}
	*/
}
