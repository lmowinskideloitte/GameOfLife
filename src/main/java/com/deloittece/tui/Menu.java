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

        FileHandler fileHandler = new FileHandler();
        // TODO musze to ogarnac bo on normalnie generuje nowy plik, ale z opoznieniem i jak przechodzi do 26 linijki to pokazuje ze nie ma pliku
        //fileHandler.generateRandomLiveBacterias(size);
        Board newBoard = new Board(size);

        int[][] aliveBacterias = fileHandler.getLiveBacteriasCords(size);

        for (int i = 0; i < aliveBacterias.length; i++) {
            newBoard.getBacteria(aliveBacterias[i][0], aliveBacterias[i][1]).setAlive();
        }

        //TO DO: here it will show board from current file
        PrintBoard newPrintBoard = new PrintBoard(newBoard);
        newPrintBoard.showBoard(newBoard);


        //gets respond what user wants to do
        //chooseOption(newUser, newBoard);
    }

    private void welcome() {
        System.out.println("""
                ----------------------------------------
                Welcome to the Game Of Life!""");
    }

    private void chooseOption(UserInput newUser) {
        System.out.println("""
                1. Upload new file
                2. Change current living bacterias
                3. Play!""");

        int option = newUser.getOptionFromUser();


        switch(option){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }

    private void enterBacteria() {

    }

    private void startGame() {

    }
}
