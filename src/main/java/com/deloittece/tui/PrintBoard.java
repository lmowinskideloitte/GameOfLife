package com.deloittece.tui;

import com.deloittece.Board;

public class PrintBoard {

    private int size;

    public PrintBoard(Board board) {
        this.size = board.getSize();
    }

    protected void showBoard(Board board) {
        String brdStr;
        String lines = "";

        for (int i = 0; i < size*3; i++){
            lines += "-";
        }
        System.out.println(lines);

        for (int row = 0; row < size; row++) {
            brdStr = "";
            for (int col = 0; col < size; col++) {
                if (board.getBacteria(row, col).isAlive()) { brdStr += " 0"; }
                else {brdStr += " ."; }
            }
            System.out.println(brdStr);
        }

        System.out.println(lines);
    }

    private void getBoardFromFile() {
        //getsBoardFromFile
    }

    private void createRandomBoardInFIle() {
        //creating random board with size
    }
}
