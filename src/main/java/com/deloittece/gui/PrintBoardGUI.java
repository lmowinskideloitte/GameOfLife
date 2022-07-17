package com.deloittece.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PrintBoardGUI extends JFrame {
    private Container contents;
    private JButton[][] squares = new JButton[size][size];
    private Color colorBlack = Color.BLACK;
    private Color colorWhite = Color.WHITE;
    private static int size = 16;

    public void printBoard() {
        contents = getContentPane();
        contents.setLayout(new GridLayout(size, size));

        ButtonHandler buttonHandler = new ButtonHandler();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                squares[i][j] = new JButton();
                squares[i][j].setBackground(colorWhite);
                contents.add(squares[i][j]);
                squares[i][j].addActionListener(buttonHandler);
            }
        }

        setSize(500, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void processClick(int i, int j) {
        System.out.println("[" + i + ", " + j + "]");
        if (squares[i][j].getBackground() == colorWhite) {
            squares[i][j].setBackground(colorBlack);
        } else {
            squares[i][j].setBackground(colorWhite);
        }
    }

    private class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++){
                    if (source == squares[i][j]) {
                        processClick(i, j);
                        return;
                    }
                }
            }
        }
    }
}
