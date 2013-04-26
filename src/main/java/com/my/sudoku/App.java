package com.my.sudoku;

import com.my.sudoku.reader.QuickReader;
import com.my.sudoku.reader.SudokuReader;
import com.my.sudoku.solver.SimpleValidator;
import com.my.sudoku.solver.Solver;
import com.my.sudoku.solver.Utility;
import com.my.sudoku.solver.interf.Validator;

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
        Validator validator = new SimpleValidator();
        
        Solver solver = new Solver(validator, reader.getData());
        
        Utility.printMatrix("Question:", solver.getData());
        
        solver.doSolve();
    }
}
