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
    
    private int row;
    private int column;
    private int value = 0;
    
    public EmptyCell(){
        
    }

    public EmptyCell(int row, int column) {
        this.row = row;
        this.column = column;
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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    public int incrementValue(){
        this.value ++;
        return this.value;
    }
    
    public int zeroValue(){
        this.value = 0;
        return this.value;
    }
    
    @Override
    public String toString(){
        
        String s = "";
        
        s += "[" + this.row +"]";
        s += "[" + this.column + "]=";
        s += this.value;
        
        return s;
    }
    
}
