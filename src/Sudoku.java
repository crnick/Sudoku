import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Sudoku {
    int boardWidth = 600;
    int boardHeight = 500;
    JFrame frame = new JFrame("Sudoku");

    Sudoku(){
        frame.setVisible(true); //making window visible.
        frame.setSize(boardWidth,boardHeight);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // center the window.
    }
}
