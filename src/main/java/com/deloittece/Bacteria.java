package com.deloittece;

public class Bacteria {
    private boolean alive;
    private boolean willSurvive;
    private int neighbourCount;
    private int xCoord;
    private int yCoord;

    protected boolean isAlive() {
        return this.alive;
    }

    protected int getXCoord() {
        return this.xCoord;
    }

    protected int getYCoord() {
        return this.yCoord;
    }

    protected void evolve() {
        this.alive = this.willSurvive;
        this.willSurvive = false;
    }
}
