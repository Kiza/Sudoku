/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.sudoku.solver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Kiza
 */
public class Utility {
    
    public static void printEmptyCells(List<EmptyCell> emptyCells){
        System.out.println("Empty Cells ...");
        
        Iterator<EmptyCell> iterator = emptyCells.iterator();
        while(iterator.hasNext()){
            
            EmptyCell emptyCell = iterator.next();
            System.out.println("\t" + emptyCell.toString());
        }
        
        System.out.println();
        
    }
    
    public static void printMatrix(String title, int[][] data){
        System.out.println(title);
        printMatrix(data);
    }
    
    public static void printMatrix(int[][] data){
        for(int i = 0; i < data.length; i ++){
            for (int j = 0; j < data[0].length; j ++){
                System.out.print("[\t" + data[i][j] + "\t]");
            }
            
            System.out.println();
        }
    }
    
    public static List<EmptyCell> extractEmptyCells(int[][] data){
        
        List<EmptyCell> emptyCells = new ArrayList<EmptyCell>();
        
        for(int i = 0; i < data.length; i ++){
            for (int j = 0; j < data[0].length; j ++){
                if(data[i][j] == 0){
                    emptyCells.add(new EmptyCell(i, j));
                }
            }
        }
        
        return emptyCells;
    }
    
    public static void setDataCellZero(int[][] data, EmptyCell emptyCell){
        data[emptyCell.getRow()][emptyCell.getColumn()] = 0;
    }
    
    public static void setDataCellValue(int[][]data, EmptyCell emptyCell){
        data[emptyCell.getRow()][emptyCell.getColumn()] = emptyCell.getValue();
    }
}
