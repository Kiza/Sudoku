/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.sudoku.solver;

/**
 *
 * @author kiza
 */
public interface Validator {
    
    public boolean isValid(int[][] data, EmptyCell emptyCell);
    
}
