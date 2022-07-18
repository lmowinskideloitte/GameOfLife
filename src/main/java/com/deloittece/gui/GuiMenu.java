package com.deloittece.gui;

public class GuiMenu {
    private Size userSize = new Size();
    private int size = 16;

    private void getUserSize() {
        userSize.setVisible(true);
        if (!userSize.isVisible()) {
            size = userSize.getUserSize();
        }
        System.out.println(size);
    }

    private void getBoard() {
        PrintBoardGUI newPrintBoard = new PrintBoardGUI(this.size);
        newPrintBoard.setVisible(true);
    }
    public void start() {
        //getUserSize();
        getBoard();
    }
}
