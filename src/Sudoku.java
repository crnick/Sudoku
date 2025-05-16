import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Sudoku {

    //where the button is in our 9*9 grid
    //keep track of row and column co-ordinates.
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
    JPanel buttonPanel = new JPanel();

    //keep track of which number we selected
    JButton numSelected = null;
    int errors = 0;

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
        frame.add(boardPanel,BorderLayout.CENTER);
        buttonPanel.setLayout(new GridLayout(1,9));
        setUpButtons();
        frame.add(buttonPanel,BorderLayout.SOUTH);
        frame.setVisible(true); //making window visible.after you have added all the components
    }

    void setUpTiles(){
        //for each row and column create a tile which is button
            for(int r = 0 ;r<9;r++){
                for (int c = 0; c < 9;c++){
                    Tile tile = new Tile(r,c);

                    //creating a tile
                    char tileChar = puzzle[r].charAt(c);

                    if(tileChar!= '-'){
                        tile.setFont(new Font("Arial", Font.BOLD,20));
                        tile.setText(String.valueOf(tileChar));
                        tile.setBackground(Color.lightGray);
                    }else{
                        tile.setFont(new Font("Arial", Font.PLAIN,20));
                        tile.setBackground(Color.WHITE);
                    }
                    tile.setFocusable(false);
                    boardPanel.add(tile);
                    tile.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Tile tile = (Tile)e.getSource();
                            //get the co-ordinates
                            int r = tile.r;
                            int c = tile.c;
                            if(numSelected!=null){
                                //if solution is already placed
                                if(tile.getText()!=""){
                                    return;
                                }
                                //get the text of number that was selected.
                                String numSelectedText = numSelected.getText();

                                //compare the solution for that row and column
                                String tileSolution = String.valueOf(solution[r].charAt(c));

                                if(tileSolution.equals(numSelectedText)){
                                    tile.setText(numSelectedText);
                                }else{
                                    errors+=1;
                                }
                            }
                        }
                    });
                }
            }
    }

    void setUpButtons(){
        for (int i=1;i<10;i++){
            JButton button = new JButton();
            button.setFont(new Font("Arial", Font.BOLD,20));
            button.setText(String.valueOf(i));
            button.setFocusable(false);
            button.setBackground(Color.white);
            buttonPanel.add(button);


            //Select the number you want to input
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton button = (JButton)e.getSource();
                    if(numSelected!=null){
                        numSelected.setBackground(Color.white);
                    }
                    numSelected = button;
                    //identify in UI which button was saved.
                    numSelected.setBackground(Color.lightGray);
                 }
            });
        }
    }
}
