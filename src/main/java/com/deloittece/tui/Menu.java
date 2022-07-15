package com.deloittece.tui;

import com.deloittece.Board;

import java.io.IOException;
import java.util.List;

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
        List<List<Integer>> aliveBacterias = fileHandler.getLiveBacteriasCords(size);
        for (int i = 0; i < aliveBacterias.size(); i++) {
            newBoard.getBacteria(aliveBacterias.get(i).get(0), aliveBacterias.get(i).get(1)).setAlive(true);
        }

        // show board from current file
        PrintBoard newPrintBoard = new PrintBoard(newBoard);
        showBoard(newPrintBoard, newBoard);


        //gets respond what user wants to do
        chooseOption(newUser, newBoard, newPrintBoard, fileHandler);
    }

    private void showBoard(PrintBoard newPrintBoard, Board newBoard) {
        newPrintBoard.showBoard(newBoard);
    }
    private void welcome() {
        System.out.println("""
                ----------------------------------------
                Welcome to the Game Of Life!""");
    }

    private void chooseOption(UserInput newUser, Board newBoard, PrintBoard printBoard, FileHandler fileHandler) {
        System.out.println("""
                1. Upload new file
                2. Change current living bacterias
                3. Play!""");

        int option = newUser.getOptionFromUser();


        switch(option){
            case 1:
                fileHandler.changeFilePath(newUser.inputFile());
                Board temp = new Board(newBoard.getSize());
                try {
                    newBoard.boardClear();

                    List<List<Integer>> aliveBacterias = fileHandler.getLiveBacteriasCords(size);
                    for (int i = 0; i < aliveBacterias.size(); i++) {
                        newBoard.getBacteria(aliveBacterias.get(i).get(0), aliveBacterias.get(i).get(1)).setAlive(true);
                    }
                } catch (Exception e) {
                    System.out.println("Something went wrong!\nChanging file to default");
                    fileHandler.changeFilePath("./LiveBacterias.txt");
                    //newBoard = temp;
                } finally {
                    System.out.println("----------------------------------------");
                    showBoard(printBoard, newBoard);
                    chooseOption(newUser, newBoard, printBoard, fileHandler);
                 }
                break;
            case 2:
                changeBacteria(newBoard, newUser, printBoard);
                showBoard(printBoard, newBoard);
                chooseOption(newUser, newBoard, printBoard, fileHandler);
                break;
            case 3:
                break;
        }
    }

    private void changeBacteria(Board board, UserInput newUser, PrintBoard printBoard) {
        int coord_x = newUser.getBacteriaCoordsFromUser(size, "X");
        int coord_y = newUser.getBacteriaCoordsFromUser(size, "Y");

        if (board.getBacteria(coord_x, coord_y).isAlive()) { board.getBacteria(coord_x, coord_y).setAlive(false); }
        else { board.getBacteria(coord_x, coord_y).setAlive(true); }

        printBoard.showBoard(board);

        if (newUser.getUsersWill() == 1) { changeBacteria(board, newUser, printBoard); }
        else {System.out.println("----------------------------------------"); }
    }
    private void enterBacteria() {

    }

    private void startGame() {

    }
}
