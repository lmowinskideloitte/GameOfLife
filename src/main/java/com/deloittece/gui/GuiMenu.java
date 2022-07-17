package com.deloittece.gui;

public class GuiMenu {
    private Size userSize = new Size();
    private int size;

    private void getUserSize() {
        userSize.setVisible(true);
        if (userSize.isVisible()) {
            size = userSize.getUserSize();
        }
        System.out.println(size);
    }

    private void getBoard() {
        PrintBoardGUI newPrintBoard = new PrintBoardGUI();
        newPrintBoard.printBoard();
    }
    public void start() {
        //getUserSize();
        getBoard();
    }
}
