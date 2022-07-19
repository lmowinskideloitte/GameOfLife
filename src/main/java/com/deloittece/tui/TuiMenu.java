package com.deloittece.tui;

import com.deloittece.gamelogic.Board;
import com.deloittece.gamelogic.Game;
import com.deloittece.filehandle.FileHandler;

import java.io.IOException;
import java.util.List;
import java.lang.Thread;

public class TuiMenu {
    private int size = 0;
    // tu mozna dac wszystkie obiekty typu UserInput newUser = new User() i odwolywac sie prosto z metod do tego
    private UserInput newUser = new UserInput();
    private FileHandler newFileHandler = new FileHandler();
    private Board newBoard;
    private PrintBoard newPrintBoard = new PrintBoard();
    private Game newGame;


    public void start() throws IOException {
        System.out.println("""
                ----------------------------------------
                Welcome to the Game Of Life!""");

        // generating new board and file with user's size
        generateNewBoard();

        // show board from current file
        showBoard();

        //shows menu and gets respond what user wants to do
        chooseOption();
    }

    // shows current board
    private void showBoard() {
        this.newPrintBoard.showBoard(this.newBoard);
    }

    // shows menu and gets option from user
    private void chooseOption() throws IOException {
        System.out.println("""
                1. Upload new file
                2. Change current living bacterias
                3. Save current file
                4. Generate new board
                5. Play!
                6. Exit""");
        int option = this.newUser.getOptionFromUser();


        switch(option){
            case 1:
                // uploads and sets bacterias from user's file
                uploadNewFile();
                System.out.println("----------------------------------------");
                showBoard();
                chooseOption();
            case 2:
                // user changes bacteria states from current file
                changeBacteria();
                System.out.println("----------------------------------------");
                showBoard();
                chooseOption();
            case 3:
                // saves current file to user's path
                saveCurrentFile();
                System.out.println("----------------------------------------");
                showBoard();
                chooseOption();
            case 4:
                // generates new board from user's size
                generateNewBoard();
                System.out.println("----------------------------------------");
                showBoard();
                chooseOption();

            case 5:
                this.newGame = new Game(this.newBoard);
                try {
                    while (true) {
                        playGame();
                        Thread.sleep(200);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                //chooseOption();
            case 6:
                System.exit(0);
        }
    }

    // starts the game
    private void playGame() {
        // how to stop this loop
        //Scanner scan = new Scanner(System.in);
        this.newGame.nextGeneration();
        showBoard();
    }

    // generates new board and file from user's size
    private void generateNewBoard() throws IOException {
        //gets size from user and creates new object newBoard
        this.size = this.newUser.getSizeFromUser();

        // create file and generate random bacterias
        this.newFileHandler.generateRandomLiveBacterias(this.size);

        // create new board and sets bacterias objects from file
        this.newBoard = new Board(this.size);
        List<List<Integer>> aliveBacterias = this.newFileHandler.getLiveBacteriasCords(this.size);
        for (int i = 0; i < aliveBacterias.size(); i++) {
            this.newBoard.getBacteria(aliveBacterias.get(i).get(0), aliveBacterias.get(i).get(1)).reverseAlive();
        }
    }

    // saves current living bacterias file to user's path
    private void saveCurrentFile() {
        this.newFileHandler.saveFileInFilePath(this.newUser.inputFile());
    }

    // gets file path from user and sets current file_path to user's
    // 1. enters user's file and gets living bacterias coords
    // 2. checks if user's living bacteria coords are correct (should be >= 0 and < size):
    //      if are not correct, prints error and changes file_path to previous
    //      if are correct, sets living bacterias to board
    private void uploadNewFile() {
        this.newFileHandler.changeFilePath(this.newUser.inputFile());
        boolean isCorrect = true;

        try {
            List<List<Integer>> aliveBacterias = this.newFileHandler.getLiveBacteriasCords(this.size);

            for (int i = 0; i < aliveBacterias.size(); i++) {
                if (aliveBacterias.get(i).get(0) > (this.size - 1) || aliveBacterias.get(i).get(1) > (this.size - 1)) {
                    isCorrect = false;
                    break;
                }
            }

            if (isCorrect) {
                this.newBoard.boardClear();

                for (int i = 0; i < aliveBacterias.size(); i++) {
                    this.newBoard.getBacteria(aliveBacterias.get(i).get(0), aliveBacterias.get(i).get(1)).reverseAlive();
                }
            } else {
                System.out.println("""
                        ----------------------------------------
                        Error!!!
                        Bacteria cords in this file doesn't match the size of our board!
                        Changing file to default...""");
                this.newFileHandler.changeFilePath("./LiveBacterias.txt");
            }
        } catch (Exception e) {
            System.out.println("""
                    ----------------------------------------
                    Error!
                    Something went wrong!
                    Changing file to default...""");
            this.newFileHandler.changeFilePath("./LiveBacterias.txt");
        }
    }

    // user changes one bacteria state from current file
    private void changeBacteria() {
        int coord_x = this.newUser.getBacteriaCoordsFromUser(size, "X");
        int coord_y = this.newUser.getBacteriaCoordsFromUser(size, "Y");

        // changes bacteria on board
        this.newBoard.getBacteria(coord_x, coord_y).reverseAlive();
        // changes bacteria in file
        newFileHandler.changeBacteriaInFile(coord_x, coord_y);

        // shows board with changed bacteria
        this.newPrintBoard.showBoard(this.newBoard);

        if (this.newUser.getUsersWill() == 1) { changeBacteria(); }
        else { System.out.println("----------------------------------------"); }
    }

}
