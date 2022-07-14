package com.deloittece;

public class Game {
    private Board board;

    Game (Board board) {
        this.board = board;
    }
    protected void nextGeneration() {
        for (int i = 0; i < this.board.getSize(); i++) {
            for (int j = 0; j < this.board.getSize(); j++) {
                this.board.getBacteria(i, j).evolve();
            }
        }
        this.board.incrementGenerationCount();
    }
}
