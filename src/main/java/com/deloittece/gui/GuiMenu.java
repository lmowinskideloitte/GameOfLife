package com.deloittece.gui;

public class GuiMenu {
    private Size userSize;
    private int size;

    private void getUserSize() {
        userSize = new Size();
        userSize.setVisible(true);
        if (!userSize.isVisible()) {
            size = userSize.getUserSize();
        }
    }

    private void getBoard() {
        PrintBoardGUI newPrintBoard = new PrintBoardGUI();
        newPrintBoard.printBoard();
    }
    public void start() {
        getUserSize();
        getBoard();
    }
}
