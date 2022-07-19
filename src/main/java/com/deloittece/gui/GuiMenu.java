package com.deloittece.gui;

import com.deloittece.gamelogic.Board;
import com.deloittece.filehandle.FileHandler;

import java.io.IOException;
import java.util.List;

public class GuiMenu {
    private Size userSize = new Size();
    private FileHandler newFileHandler = new FileHandler();
    private Board newBoard;
    private int size = 16;

    private int getUserSize() {
        userSize.setVisible(true);
        while (true) {
            System.out.println(userSize.isVisible());
            if (!userSize.isVisible()) {
                size = userSize.getUserSize();
                break;
            }
        }
        return size;
    }

    private void getBoard(Board board) {
        PrintBoardGUI newPrintBoard = new PrintBoardGUI(board);
        newPrintBoard.setVisible(true);
    }
    public void start() throws IOException {
        this.size = getUserSize();
        while (true){
            if (!userSize.isVisible()){
                this.newFileHandler.generateRandomLiveBacterias(this.size);

                this.newBoard = new Board(this.size);
                List<List<Integer>> aliveBacterias = this.newFileHandler.getLiveBacteriasCords(this.size);
                for (int i = 0; i < aliveBacterias.size(); i++) {
                    this.newBoard.getBacteria(aliveBacterias.get(i).get(0), aliveBacterias.get(i).get(1)).reverseAlive();
                }

                getBoard(this.newBoard);
                break;
            }
        }
    }
}
