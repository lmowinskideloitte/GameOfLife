package com.deloittece.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Size extends JFrame implements ActionListener {

    private JTextField userSize;
    private JButton enterSize;
    private int sizeInt = 10;

    public Size() {
        setTitle("Animation");
        setSize(500, 100);
        setResizable(false);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getSizeFromUser();
    }

    private void getSizeFromUser() {
        this.setLayout(new BorderLayout());
        JPanel containerPanel = new JPanel(new GridLayout(1, 2));

        userSize = new JTextField("Enter size (click me)");
        containerPanel.add(userSize);
        userSize.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                userSize.setText("");
            }
        });
        userSize.addActionListener(this);

        enterSize = new JButton("Set size");
        containerPanel.add(enterSize);
        enterSize.addActionListener(this);

        add(containerPanel, BorderLayout.CENTER);
    }

    public int getUserSize() {
        return this.sizeInt;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        Object source = arg0.getSource();
        if (source == enterSize) {
            try {
                this.sizeInt = Integer.parseInt(userSize.getText());
                if (sizeInt < 2) {
                    userSize.setText("VALUE SHOULD BE > 1");
                    System.err.println("VALUE SHOULD BE > 1");
                    return;
                }
            } catch (NumberFormatException e) {
                userSize.setText("WRONG VALUE");
                System.err.println("Enter integer value");
                return;
            }
            setVisible(false);
            GuiMenu menu = new GuiMenu();
        }
    }
}
