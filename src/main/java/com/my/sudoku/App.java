package com.my.sudoku;

import com.my.sudoku.reader.QuickReader;
import com.my.sudoku.reader.SudokuReader;
import com.my.sudoku.solver.Solver;
import com.my.sudoku.solver.Utility;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        SudokuReader reader = new QuickReader();
        Solver solver = new Solver(reader.getData());
        
        Utility.printEmptyCells(solver.getEmptyCells());
    }
}
