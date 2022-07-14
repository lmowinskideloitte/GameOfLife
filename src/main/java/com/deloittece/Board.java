package com.deloittece;

public class Board {
    private final int size;
    protected Bacteria[][] board;
    private int generationCount;

    Board(int size) {
        this.size = size;
        this.board = new Bacteria[size][size];
    }
    protected int getSize() {
        return this.size;
    }

    protected Bacteria getBacteria(int x, int y) {
        return this.board[x][y];
    }
    protected int getGenerationCount(){
        return this.generationCount;
    }

    protected void incrementGenerationCount(){
        this.generationCount++;
    }

    protected Bacteria[] getNeighbours(Bacteria bacteria) {
        int x = bacteria.getXCoord();
        int y = bacteria.getYCoord();

        Bacteria[] neighbours = new Bacteria[8];

        // upper row
        neighbours[0] = getNeighbourByCoords(x-1, y-1);
        neighbours[1] = getNeighbourByCoords(x, y-1);
        neighbours[2] = getNeighbourByCoords(x+1, y-1);
        // same row
        neighbours[3] = getNeighbourByCoords(x-1, y);
        neighbours[4] = getNeighbourByCoords(x+1, y);
        // lower low
        neighbours[5] = getNeighbourByCoords(x-1, y+1);
        neighbours[6] = getNeighbourByCoords(x, y+1);
        neighbours[7] = getNeighbourByCoords(x+1, y+1);

        return neighbours;
    }

    private Bacteria getNeighbourByCoords(int x0, int y0) {
        int x = x0 % this.size;
        if (x < 0) x += this.size;

        int y = y0 % this.size;
        if (y < 0) y += this.size;
        return this.board[x][y];
    }

}
