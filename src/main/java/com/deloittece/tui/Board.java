package com.deloittece.tui;

public class Board {

    private int size;

    public Board(int size) {
        this.size = size;
    }

    protected void showBoard() {
        String brdStr;
        String lines = "";

        for (int i = 0; i < size*3; i++){
            lines += "-";
        }
        System.out.println(lines);

        for (int row = 0; row < size; row++) {
            brdStr = "";
            for (int col = 0; col < size; col++) {
                brdStr += " .";
                // tu bedzie obiekt bakteria(row, col).show()
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
