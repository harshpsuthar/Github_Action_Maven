package com.test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

/*
 * this is integration of Excel with dataprovider
 * make sure add apache poi and  apache poi ooxml dependecies to pom.xml before using file and excel class
 * data coming from excel and feeding to testcases using dataprovider two dimension array
 * */

public class ExcelDataSupplier {

	@DataProvider
	public String[][] getLoginData() throws IOException {

		// getting data from excel follow -:   workbook -> Sheet -> row -> cell
		//1.locating excel file 
		File excelFile = new File("O:\\Eclipse_Project\\GithubAction\\src\\test\\resources\\LoginData.xlsx");
		System.out.println(" Excel file exists: "+excelFile.exists());

		//2.reading row data from file using inputstream 
		FileInputStream fis = new FileInputStream(excelFile);

		//3.creating workbook instance passing row data input stream - creating data in to excel workbook formate
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		//getting first sheet from workbook.
		XSSFSheet sheet = workbook.getSheet("LoginData");

		System.out.println("getting physical rows from sheet logindata: "+sheet.getPhysicalNumberOfRows());
		//getting no of rows in sheet
		int noOfRows=sheet.getLastRowNum();

		//getting no of columns (getting header row which is first row)
		int noOfColumns= sheet.getRow(0).getLastCellNum();

		//System.out.println("getting last row from sheet logindata: "+sheet.getLastRowNum());
		
		//creating data two dimensional array to store data from excel
		String[][] data =new String[noOfRows-1][noOfColumns];
		
		//going through rows 
		for (int i=0;i<noOfRows- 1;i++) {
			for (int j=0;j<noOfColumns;j++) {	

				//Dataformatter used to format excel data into perticular type 
				DataFormatter df = new DataFormatter();
				//this will format any type cell value into string
				data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
				//System.out.println(df.formatCellValue(sheet.getRow(i).getCell(j)));

				
				//this only get cell value that are in string formate other will be not printed
				//System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
			}
		
		}
		workbook.close();
		fis.close();
			
			//printing exceldata from arraydata.
			
			  for(String[] dataArray:data) {
			  System.out.println(Arrays.toString(dataArray)); }
			 
	
		return data;

	}

}
