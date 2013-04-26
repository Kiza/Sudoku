/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.sudoku.solver;

import com.my.sudoku.solver.interf.Validator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kiza
 */
public class Solver {

    private Validator validator = new SimpleValidator();
    private int[][] data;
    private List<EmptyCell> emptyCells = new ArrayList<EmptyCell>();
    private List<int[][]> results = new ArrayList<int[][]>();
    
    public Solver(Validator validator, int[][] data) {
        this.data = data;

        emptyCells = Utility.extractEmptyCells(data);
    }

    public Validator getValidator() {
        return validator;
    }

    public void setValidator(Validator validator) {
        this.validator = validator;
    }

    public int[][] getData() {
        return data;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    public List<EmptyCell> getEmptyCells() {
        return emptyCells;
    }

    public void setEmptyCells(List<EmptyCell> emptyCells) {
        this.emptyCells = emptyCells;
    }

    public List<int[][]> doSolve() {
        /*
         *  value range:
         *      [1, data.length]
         */

        boolean found = true;
        int maxValue = data.length;
        for (int i = 0; i < emptyCells.size(); i++) {
            if (i < 0) {
                System.out.println("No results found!");
                found = false;
                break;
            }

            EmptyCell currentCell = emptyCells.get(i);

            // zero out current cell in case of backtracking
            Utility.setDataCellZero(data, currentCell);

            do {
                currentCell.incrementValue();
                
            } while (currentCell.getValue() <= maxValue && !validator.isValid(data, currentCell));

            if (currentCell.getValue() > maxValue) {
                currentCell.zeroValue();
                i = i - 2;
                
                Utility.printMatrix("\nBacktrack: ", data);
                
            } else {
                
                Utility.setDataCellValue(data, currentCell);

                Utility.printMatrix("\nUpdate: ", data);
            }
        }
        
        if(found){
            int[][] result = new int[data.length][data[0].length];
            for(int i = 0; i < data.length; i ++){
                System.arraycopy(data[i], 0, result[i], 0, data[0].length);
            }
            
            results.add(result);
            Utility.printMatrix("\nResults found!", data);
        }

        return results;
    }
}
