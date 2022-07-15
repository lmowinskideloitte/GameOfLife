package com.deloittece.tui;

public class Menu {
    private int size = 0;
    public Menu() {

    }

    protected void start() {
        UserInput newUser = new UserInput();

        welcome();

        //gets size from user and creates new object newBoard
        size = newUser.getSizeFromUser();
        Board newBoard = new Board(size);

        //TO DO: here it will show board from current file
        newBoard.showBoard();

        //gets respond what user wants to do
        chooseOption(newUser, newBoard);
    }

    private void welcome() {
        System.out.println("""
                ----------------------------------------
                Welcome to the Game Of Life!""");
    }

    private void chooseOption(UserInput newUser, Board newBoard) {
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
