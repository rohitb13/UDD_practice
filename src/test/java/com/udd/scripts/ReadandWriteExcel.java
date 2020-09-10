package com.udd.scripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadandWriteExcel 
{
     public static void main(String args[])
     {
    	 try
    	 {
    		
    		 //Specify the file path to create or write
    		 File src = new File ("./TestCase/ElemenLifeCycle.xlsx");
    		 
    		 //Load the file
    		  FileInputStream fis=new FileInputStream(src);
    		  
    		  //Load the workbook
    		  XSSFWorkbook wb = new XSSFWorkbook(fis);
    		  
    		  //get sheet
    		  XSSFSheet sh= wb.getSheetAt(1);
    		  
    		  /*// getRow specify which row we want to read and getCell which column
    		  System.out.println(sh.getRow(1).getCell(5).getStringCellValue());*/
    		  
    		  CellStyle style = wb.createCellStyle();  
              // Setting Background color  
              style.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
              
    		  
    		  // and setCellvalue will set the value
    		  sh.getRow(1).createCell(11).setCellValue("Pass");
    		  //sh.getRow(1).createCell(11).setCellStyle(style);
    		  	             
    		  
    		  // here we need to specify where you want to save file
    		  FileOutputStream fout=new FileOutputStream(new File("./TestCase/ElemenLifeCycle.xlsx"));

    		  // finally write content 
    		  wb.write(fout);

    		  // close the file
    		  fout.close();

    	 }
    		  
    	 catch(Exception e)
    	 {
    		 System.out.println(e.getMessage());
    	 }
     }
     
}