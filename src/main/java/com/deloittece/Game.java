package com.deloittece;

public class Game {
    private Board board;

    public Game (Board board) {
        this.board = board;
    }
    private void updateWillSurviveAll() {
        for (int i = 0; i < this.board.getSize(); i++) {
            for (int j = 0; j < this.board.getSize(); j++) {
                this.board.getBacteria(i, j).updateWillSurvive();
            }
        }
    }

    private void updateAliveNeighboursAll() {
        for (int i = 0; i < this.board.getSize(); i++) {
            for (int j = 0; j < this.board.getSize(); j++) {
                Bacteria[] neighbours = this.board.getNeighbours(this.board.getBacteria(i, j));
                this.board.getBacteria(i, j).setNeighbourCount(Logic.countAlive(neighbours));
            }
        }
    }

    private void evolveAll() {
        for (int i = 0; i < this.board.getSize(); i++) {
            for (int j = 0; j < this.board.getSize(); j++) {
                this.board.getBacteria(i, j).evolve();
            }
        }
        this.board.incrementGenerationCount();
    }

    public void nextGeneration() {
        updateAliveNeighboursAll();
        // in theory this step can be omitted as survival only depends on aliveNeighbourCount
        // but let's just do one more looping to future-proof ourselves for the logic-change
        updateWillSurviveAll();
        evolveAll();
        if(isFinal()) { System.exit(0); }
    }

    private boolean isFinal(){
        int sameAsPrevious = 0;
        for (int i = 0; i < this.board.getSize(); i++) {
            for (int j = 0; j < this.board.getSize(); j++) {
                if(this.board.getBacteria(i, j).getPreviousState() == this.board.getBacteria(i, j).isAlive()) { sameAsPrevious++; };
            }
        };
        return sameAsPrevious == this.board.getSize()*this.board.getSize();
    }

    private void flipAliveByCoords(int x, int y) {
        this.board.getBacteria(x, y).reverseAlive();
    }
}
