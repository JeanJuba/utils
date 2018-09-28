/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.utils.xls;

/**
 *
 * @author jean
 */
public class DataCell {
    private int sheet;
    private int row;
    private int column;
    private Object data;
    

    public DataCell(int sheet, int row, int column, Object data) {
        this.sheet = sheet;
        this.row = row;
        this.column = column;
        this.data = data;
        
    }

    public int getSheet() {
        return sheet;
    }

    public void setSheet(int sheet) {
        this.sheet = sheet;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

   
    
    
    
}
