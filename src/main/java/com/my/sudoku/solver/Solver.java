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
    
    private int[][] data;
    private List<EmptyCell> emptyCells = new ArrayList<EmptyCell>();
    
    public Solver(int[][] data){
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
    
    
}
