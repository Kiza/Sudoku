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
}
