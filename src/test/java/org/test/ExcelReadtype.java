package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.DateUtil;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.helper.DataUtil;


public class ExcelReadtype {
	public static void main(String[] args) throws IOException   {
		File lc=new File("C:\\Users\\hari4\\eclipse-workspace\\ProjectProMaven\\Excel\\excelread.xlsx");
		FileInputStream fis=new FileInputStream(lc);
		Workbook w=new XSSFWorkbook(fis);
	
		Sheet sht=w.getSheet("Sheet1");
		Row r=sht.getRow(3);
		Cell c=r.getCell(3);
		System.out.println(c);
		
		int type = c.getCellType();
		System.out.println(type);
		//string---type 1
		//number,date---
		if (type==1) {
			String value = c.getStringCellValue();
			System.out.println(value);
		}
		else {
			if (DateUtil.isCellDateFormatted(c)) {
				Date date = c.getDateCellValue();
				SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
				String value = sdf.format(date);
				System.out.println(value);
			}
			else {
				double num = c.getNumericCellValue();
				long ln=(long)num;
				String value = String.valueOf(ln);
				System.out.println(value);
			}
		}
		
	
	
	}
	
			
		}


