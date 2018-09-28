/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.utils.xls;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author jean
 */
public class XlsFileCreator {

    private HSSFWorkbook book;
    
    public XlsFileCreator(){
        book = new HSSFWorkbook();
    }


    public XlsFileCreator(String baseFilePath) {
        try {
            FileInputStream fis = new FileInputStream(baseFilePath);
            book = new HSSFWorkbook(fis);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(XlsFileCreator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XlsFileCreator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void writePredefinedData(List<DataCell> predefinedData) {
        HSSFSheet sheet;

        for (DataCell data : predefinedData) {

            sheet = book.getSheetAt(data.getRow());
            if(sheet == null){
                sheet = book.createSheet();
            }
            
            Row row = sheet.getRow(data.getRow());
            
            if(row == null){
                row = sheet.createRow(data.getRow());
            }
            
            Cell cell = row.getCell(data.getColumn());
            if(cell == null){
                cell = row.createCell(data.getColumn());
            }
            
            if(data.getData() instanceof BigDecimal){
                cell.setCellValue(((BigDecimal) data.getData()).doubleValue());
            }
            
            if(data.getData() instanceof Double){
                cell.setCellValue((double)data.getData());
            }
            
            if(data.getData() instanceof Integer){
                cell.setCellValue((Integer) data.getData());
            }
            
            if(data.getData() instanceof String){
                cell.setCellValue((String) data.getData());
            }
            
            if(data.getData() == null){
                cell.setCellValue("");
            }
        }
    }

    
    public void saveXlsFile(File file){
        try {
            book.write(file);
            book.close();
        } catch (IOException ex) {
            Logger.getLogger(XlsFileCreator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
