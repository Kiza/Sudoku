/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.sudoku.solver;

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

    public Solver(int[][] data) {
        this.data = data;

        emptyCells = Utility.extractEmptyCells(data);
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

    public void doSolve() {
        /*
         *  value range:
         *      [1, data.length]
         */

        int maxValue = data.length;
        for (int i = 0; i < emptyCells.size(); i++) {
            if (i < 0) {
                System.out.println("No results found!");
                break;
            }

            EmptyCell currentCell = emptyCells.get(i);

            // zero out current cell in case of backtracking
            Utility.setDataCellZero(data, currentCell);

            do {
                currentCell.incrementValue();
                
                if(currentCell.getRow()==3 && currentCell.getColumn()==0){
                    System.out.println("");
                }
                
            } while (currentCell.getValue() <= maxValue && !validator.isValid(data, currentCell));

            if (currentCell.getValue() > maxValue) {
                currentCell.zeroValue();
                i = i - 2;
                
                System.out.println();
                System.out.println("Backtracking: ");
                Utility.printMatrix(data);
            } else {
                Utility.setDataCellValue(data, currentCell);

                System.out.println();
                System.out.println("Update: ");
                Utility.printMatrix(data);
            }
        }
        
        Utility.printMatrix(data);
    }
}
