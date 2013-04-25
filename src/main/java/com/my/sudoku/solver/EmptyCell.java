/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.sudoku.solver;

/**
 *
 * @author Kiza
 */
public class EmptyCell {
    
    private int rowId;
    private int columnId;
    private int currentValue = 0;
    
    public EmptyCell(){
        
    }

    public EmptyCell(int rowId, int columnId) {
        this.rowId = rowId;
        this.columnId = columnId;
    }

    public int getRowId() {
        return rowId;
    }

    public void setRowId(int rowId) {
        this.rowId = rowId;
    }

    public int getColumnId() {
        return columnId;
    }

    public void setColumnId(int columnId) {
        this.columnId = columnId;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    }
    
    @Override
    public String toString(){
        
        String s = "";
        
        s += "[" + this.rowId +"]";
        s += "[" + this.columnId + "]=";
        s += this.currentValue;
        
        return s;
    }
    
}
