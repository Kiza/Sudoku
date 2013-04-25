/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.sudoku.reader;

/**
 *
 * @author Kiza
 */
public class QuickReader implements SudokuReader {

    @Override
    public int[][] getData() {
        return new int[][]{
            {0, 0, 0, 3}, 
            {0, 4, 2, 0}, 
            {0, 2, 3, 0}, 
            {4, 0, 0, 0}
        };
    }
}
