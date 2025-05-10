import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Sudoku {

    //where the button is in our 9*9 grid
    //keep track of row and column cordinates.
    class Tile extends JButton{
        int r;
        int c;

        Tile(int r,int c){
            this.r = r;
            this.c = c;
        }
    }

    int boardWidth = 600;
    int boardHeight = 500;
    JFrame frame = new JFrame("Sudoku"); //creates a window
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();

    JPanel boardPanel = new JPanel();

    String[] puzzle = {
            "--74916-5",
            "2---6-3-9",
            "-----7-1-",
            "-586----4",
            "--3----9-",
            "--62--187",
            "9-4-7---2",
            "67-83----",
            "81--45---"
    };

    String[] solution = {
            "387491625",
            "241568379",
            "569327418",
            "758619234",
            "123784596",
            "496253187",
            "934176852",
            "675832941",
            "812945763"
    };

    Sudoku(){
        frame.setVisible(true); //making window visible.
        frame.setSize(boardWidth,boardHeight);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // center the window.
        frame.setLayout(new BorderLayout());//adding a layout where components can be placed NSEW

        textLabel.setFont(new Font("Arial",Font.BOLD,30));
        textLabel.setHorizontalAlignment(JLabel.CENTER); // set the alignment of the labels content.
        textLabel.setText("Sudoku:0");

        //attach label to panel
        textPanel.add(textLabel);

        //attach panel to the frame
        frame.add(textPanel,BorderLayout.NORTH);

        boardPanel.setLayout(new GridLayout(9,9));
        setUpTiles();
    }

    void setUpTiles(){
        //for each row and column create a tile which is button
            for(int r = 0 ;r<9;r++){
                for (int c = 0; c < 9;c++){
                    Tile tile = new Tile(r,c);
                }
            }
    }
}
