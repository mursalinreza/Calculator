package com.RMS;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class Tictactoe implements ActionListener {
    Random random = new Random();
    JFrame frame = new JFrame("Tic-Tac-Toe");
    JPanel title_Panel = new JPanel();
    JPanel buttons_Panel = new JPanel();
    JButton[] buttons = new JButton[9];
    JLabel textField = new JLabel();
    boolean player1_turn ;
    int count = 0;
// add JOption pane to restart game and keep score.
    Tictactoe(){
        // set the frame of the game.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setResizable(false);

        //set the display
        textField.setBackground(Color.BLACK);
        textField.setForeground(Color.GREEN);
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setFont(new Font("Ink Free",Font.BOLD,75));
        textField.setText("Tic-tac-toe");
        textField.setOpaque(true);

        title_Panel.setBounds(0,0,800,100);
        title_Panel.setLayout(new BorderLayout());

        title_Panel.add(textField);


        //set the buttons panel
        buttons_Panel.setLayout(new GridLayout(3,3));
        buttons_Panel.setBackground(new Color(150,150,150));

        for(int i = 0; i < 9;i++){
            buttons[i] = new JButton();
            buttons_Panel.add(buttons[i]);
            buttons[i].addActionListener(this);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].setBorder(BorderFactory.createRaisedBevelBorder());
            buttons[i].setBackground(Color.YELLOW);
        }
        frame.add(title_Panel,BorderLayout.NORTH);
        frame.add(buttons_Panel);

        firstTurn();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < 9; i++){
            if(e.getSource()==buttons[i]){
                if(player1_turn){
                    if(buttons[i].getText() == ""){
                        buttons[i].setForeground(new Color(250,0,0));
                        buttons[i].setText("X");
                        player1_turn = false;
                        textField.setText("O's turn");
                        count++;
                        checkWin();

                    }
                }
                else if (buttons[i].getText()== ""){
                            buttons[i].setForeground(new Color(0, 0, 250));
                            buttons[i].setText("O");
                            player1_turn = true;
                            textField.setText("X's turn");
                            count++;
                            checkWin();

                }
            }
        }
    }
    public void firstTurn(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(random.nextInt(2) == 0){
            player1_turn = true;
            textField.setText("X's turn");
        }
        else{
            player1_turn = false;
            textField.setText("O's turn");
        }
    }
    public void checkWin(){

            if ((buttons[0].getText() == "X") && (buttons[1].getText() == "X") && (buttons[2].getText() == "X")) {
                xWins(0, 1, 2);

            }
            if ((buttons[3].getText() == "X") && (buttons[4].getText() == "X") && (buttons[5].getText() == "X")) {
                xWins(3, 4, 5);

            }
            if ((buttons[6].getText() == "X") && (buttons[7].getText() == "X") && (buttons[8].getText() == "X")) {
                xWins(6, 7, 8);

            }
            if ((buttons[0].getText() == "X") && (buttons[3].getText() == "X") && (buttons[6].getText() == "X")) {
                xWins(0, 3, 6);

            }
            if ((buttons[1].getText() == "X") && (buttons[4].getText() == "X") && (buttons[7].getText() == "X")) {
                xWins(1, 4, 7);

            }
            if ((buttons[2].getText() == "X") && (buttons[5].getText() == "X") && (buttons[8].getText() == "X")) {
                xWins(2, 5, 8);

            }
            if ((buttons[0].getText() == "X") && (buttons[4].getText() == "X") && (buttons[8].getText() == "X")) {
                xWins(0, 4, 8);

            }
            if ((buttons[2].getText() == "X") && (buttons[4].getText() == "X") && (buttons[6].getText() == "X")) {
                xWins(2, 4, 6);

            }
            if ((buttons[0].getText() == "0") && (buttons[1].getText() == "O") && (buttons[2].getText() == "O")) {
                oWins(0, 1, 2);

            }
            if ((buttons[3].getText() == "O") && (buttons[4].getText() == "O") && (buttons[5].getText() == "O")) {
                oWins(3, 4, 5);

            }
            if ((buttons[6].getText() == "O") && (buttons[7].getText() == "O") && (buttons[8].getText() == "O")) {
                oWins(6, 7, 8);

            }
            if ((buttons[0].getText() == "O") && (buttons[3].getText() == "O") && (buttons[6].getText() == "O")) {
                oWins(0, 3, 6);

            }
            if ((buttons[1].getText() == "O") && (buttons[4].getText() == "O") && (buttons[7].getText() == "O")) {
                oWins(1, 4, 7);

            }
            if ((buttons[2].getText() == "O") && (buttons[5].getText() == "O") && (buttons[8].getText() == "O")) {
                oWins(2, 5, 8);

            }
            if ((buttons[0].getText() == "O") && (buttons[4].getText() == "O") && (buttons[8].getText() == "O")) {
                oWins(0, 4, 8);

            }
            if ((buttons[2].getText() == "O") && (buttons[4].getText() == "O") && (buttons[6].getText() == "O")) {
                oWins(2, 4, 6);
            }
            else if(count ==9){
                textField.setText("Match tie!!");
            }

    }
    public void xWins(int a,int b,int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i = 0; i < 9;i++){
            buttons[i].setEnabled(false);
        }
        textField.setText("X wins");

    }

    public void oWins(int a,int b,int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i = 0; i < 9;i++){
            buttons[i].setEnabled(false);
        }
        textField.setText("O wins");

    }
}


