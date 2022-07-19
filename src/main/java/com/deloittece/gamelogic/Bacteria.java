package com.deloittece.gamelogic;

import java.util.Random;

public class Bacteria {
    private boolean alive;
    private boolean willSurvive;
    private int neighbourCount;
    private final int xCoord;
    private final int yCoord;
    private boolean previousState;

    public Bacteria (boolean alive, int xCoord, int yCoord) {
        this.alive = alive;
        this.willSurvive = false;
        this.neighbourCount = 0;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    protected Bacteria (int xCoord, int yCoord, int randomAliveThreshold){
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.willSurvive = false;
        this.neighbourCount = 0;

        this.alive = new Random().nextInt(100) < randomAliveThreshold;
    }
    public boolean isAlive() {
        return this.alive;
    }
    public boolean getPreviousState(){
        return this.previousState;
    }
    protected int getNeighbourCount() {
        return this.neighbourCount;
    }
    protected void setNeighbourCount(int neighbourCount) {
        this.neighbourCount = neighbourCount;
    }

    protected int getXCoord() {
        return this.xCoord;
    }
    protected int getYCoord() {
        return this.yCoord;
    }

    protected void evolve() {
        this.previousState = this.alive;
        this.alive = this.willSurvive;
        this.willSurvive = false;
    }
    protected void updateWillSurvive() {
        this.willSurvive = Logic.doesBacteriaSurvive(this.neighbourCount, this.alive);
    }

    public void reverseAlive() {
        this.alive = !this.alive;
    }
}
