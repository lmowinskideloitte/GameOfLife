package com.deloittece.gui;

import com.deloittece.tui.FileHandler;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PrintBoardGUI extends JFrame {
    private JPanel contents = new JPanel();
    private JPanel container1 = new JPanel();
    private JPanel container2 = new JPanel();
    private JButton[][] squares;
    private Color colorBlack = Color.BLACK;
    private Color colorWhite = Color.WHITE;
    private int size = 16;
    private FileHandler newFileHandler = new FileHandler();

    public PrintBoardGUI(int size) {
        this.size = size;
        squares = new JButton[size][size];
        this.setLayout(new BorderLayout());
        setSize(500, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //newFileHandler.generateRandomLiveBacterias(size);

        Menu();
        printBoard();
        startButton();
    }

    private void printBoard() {
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
        add(contents, BorderLayout.CENTER);
    }

    private void Menu() {
        container1.setLayout(new GridLayout(1, 3));

        JLabel firstOption = new JLabel("1. Upload new file");
        JLabel secondOption = new JLabel("2. Save current file");
        JLabel thirdOption = new JLabel("3. Generate new board");
        container1.add(firstOption);
        container1.add(secondOption);
        container1.add(thirdOption);

        add(container1, BorderLayout.NORTH);

        container2 = new JPanel(new GridLayout(1, 2));

        JTextField userOption = new JTextField("Enter option (click me)");
        container2.add(userOption);
        userOption.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                userOption.setText("");
            }
        });
        //userOption.addActionListener(this);

        JButton enterOption = new JButton("Enter");
        container2.add(enterOption);
        //enterOption.addActionListener(this);


    }

    private void startButton() {
        // container main gridlayout(2, 1) add container2 i button
        JPanel mainContainer = new JPanel(new GridLayout(2, 1));
        mainContainer.add(container2);

        JButton start = new JButton("Start");
        mainContainer.add(start);
        this.add(mainContainer, BorderLayout.SOUTH);
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
