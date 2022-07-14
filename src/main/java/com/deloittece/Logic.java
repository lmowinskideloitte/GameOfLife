package com.deloittece;

public class Logic {
    public static Bacteria[] getNeighbours(Bacteria bacteria) {
        ;
    }

    public static int countAlive(Bacteria[] bacteriaArr) {

    }

    public static boolean doesBacteriaSurvive(Bacteria bacteria) {
        Bacteria[] neighbours = getNeighbours(bacteria);
        int neighboursAlive = countAlive(neighbours);

        if (neighboursAlive > 3) {
            return false;
        } else if (neighboursAlive == 3) {
            return true;
        } else return neighboursAlive == 2 && bacteria.isAlive();
    }
}
