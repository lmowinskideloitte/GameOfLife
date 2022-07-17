package com.deloittece.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PrintBoardGUI extends JFrame {
    private JPanel contents = new JPanel();
    private JPanel container = new JPanel();
    private JButton[][] squares = new JButton[size][size];
    private Color colorBlack = Color.BLACK;
    private Color colorWhite = Color.WHITE;
    private static int size = 16;

    public void printBoard() {
        this.setLayout(new BorderLayout());
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

        Menu();
        startButton();
        add(contents, BorderLayout.CENTER);
    }

    private void Menu() {
        container.setLayout(new GridLayout(1, 3));

        JLabel firstOption = new JLabel("1. Upload new file");
        JLabel secondOption = new JLabel("2. Save current file");
        JLabel thirdOption = new JLabel("3. Generate new board");
        container.add(firstOption);
        container.add(secondOption);
        container.add(thirdOption);

        add(container, BorderLayout.NORTH);
    }

    private void startButton() {
        JButton start = new JButton("Start");
        add(start, BorderLayout.SOUTH);
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
