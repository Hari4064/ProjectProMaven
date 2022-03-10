package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelRead {
	
		
		public static void main(String[] args) throws IOException {
		//file path
		File loc=new File("C:\\Users\\hari4\\eclipse-workspace\\ProjectProMaven\\Excel\\excelread.xlsx");	
		//file Input stream
		FileInputStream st=new FileInputStream(loc);
		//workbook
		Workbook w=new XSSFWorkbook(st);
		//Sheet
		Sheet sht=w.getSheet("Sheet1");
		//row
		Row r=sht.getRow(2);
		//cell
		Cell cel=r.getCell(2);
	    System.out.println(cel);
	    //get RowCount
	    int RowCount = sht.getPhysicalNumberOfRows();
	    System.out.println(RowCount);
	    //get CellCount
	    int CellCount = r.getPhysicalNumberOfCells();
	    System.out.println(CellCount);
	    
	    
	    
	    
	    
	    //get all datas from excel
	    System.out.println();
	    for(int i=0;i<sht.getPhysicalNumberOfRows();i++) {
	    	Row ro=sht.getRow(i);
	    for(int j=0;j<r.getPhysicalNumberOfCells();j++) {
	    	Cell c=ro.getCell(j);
	    	System.out.println(c);
		   }	
	    	
	    }
	    
	    
	    
	    
	    
		
	
			
		}

}
