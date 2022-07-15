package com.deloittece.tui;

import com.deloittece.Board;

import java.io.IOException;

public class Menu {
    private int size = 0;
    public Menu() {

    }

    public void start() throws IOException {
        UserInput newUser = new UserInput();

        welcome();

        //gets size from user and creates new object newBoard
        size = newUser.getSizeFromUser();

        // create file and generate random bacterias
        FileHandler fileHandler = new FileHandler();
        fileHandler.generateRandomLiveBacterias(size);

        // create new board and bacterias objects
        Board newBoard = new Board(size);
        int[][] aliveBacterias = fileHandler.getLiveBacteriasCords(size);
        for (int i = 0; i < aliveBacterias.length; i++) {
            newBoard.getBacteria(aliveBacterias[i][0], aliveBacterias[i][1]).setAlive(true);
        }

        // show board from current file
        PrintBoard newPrintBoard = new PrintBoard(newBoard);
        showBoard(newPrintBoard, newBoard);


        //gets respond what user wants to do
        chooseOption(newUser, newBoard, newPrintBoard);
    }

    private void showBoard(PrintBoard newPrintBoard, Board newBoard) {
        newPrintBoard.showBoard(newBoard);
    }
    private void welcome() {
        System.out.println("""
                ----------------------------------------
                Welcome to the Game Of Life!""");
    }

    private void chooseOption(UserInput newUser, Board newBoard, PrintBoard printBoard) {
        System.out.println("""
                1. Upload new file
                2. Change current living bacterias
                3. Play!""");

        int option = newUser.getOptionFromUser();


        switch(option){
            case 1:
                break;
            case 2:
                changeBacteria(newBoard, newUser, printBoard);
                break;
            case 3:
                break;
        }
    }

    private void changeBacteria(Board board, UserInput newUser, PrintBoard printBoard) {
        int coord_x = newUser.getBacteriaCoordsFromUser(size, "X");
        int coord_y = newUser.getBacteriaCoordsFromUser(size, "Y");
        board.getBacteria(coord_x, coord_y).setAlive(false);
        printBoard.showBoard(board);
    }
    private void enterBacteria() {

    }

    private void startGame() {

    }
}
