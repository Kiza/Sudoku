/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.sudoku.solver;

/**
 *
 * @author kiza
 */
public class SimpleValidator implements Validator{
    
    public boolean isValid(int[][] data, EmptyCell emptyCell){
        return isValid(data, emptyCell.getRow(), emptyCell.getColumn(), emptyCell.getValue());
    }

    private boolean isValid(int[][] data, int row, int column, int value) {

        return isRowValid(data, row, value)
                && isColumnValid(data, column, value)
                && isSubregionValid(data, row, column, value);
    }

    private boolean isRowValid(int[][] data, int row, int value) {
        for (int i = 0; i < data[row].length; i++) {
            if (data[row][i] != 0 && data[row][i] == value) {
                return false;
            }
        }

        return true;
    }

    private boolean isColumnValid(int[][] data, int column, int value) {
        for (int i = 0; i < data.length; i++) {
            if (data[i][column] != 0 && data[i][column] == value) {
                return false;
            }
        }

        return true;
    }

    private boolean isSubregionValid(int[][] data, int row, int column, int value) {

        /*
         * subregion row range: 
         *      [row - row % subregionSize, row - row % subregionSize + subregionSize)
         * 
         * subregion column range:
         *      [column - column % subregionSize, column - column % subregionSize + subregionSize)
         */

        int subregionSize = (int) Math.sqrt(data.length);
        int lowerRow = row - row % subregionSize;
        int lowerColumn = column - column % subregionSize;

        for (int i = lowerRow; i < lowerRow + subregionSize; i++) {
            for (int j = lowerColumn; j < lowerColumn + subregionSize; j++) {
                if (data[i][j] != 0 && data[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }
}
