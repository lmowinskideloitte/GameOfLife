package com.deloittece;

public class Logic {
    public static int countAlive(Bacteria[] bacteriaArr) {
        var count = 0;
        for (Bacteria bacteria : bacteriaArr) {
            count += bacteria.isAlive() ? 1 : 0;
        }
        return count;
    }

    public static boolean doesBacteriaSurvive(Board board, Bacteria bacteria) {
        Bacteria[] neighbours = board.getNeighbours(bacteria);
        int neighboursAlive = countAlive(neighbours);

        if (neighboursAlive > 3) {
            return false;
        } else if (neighboursAlive == 3) {
            return true;
        } else return neighboursAlive == 2 && bacteria.isAlive();
    }
}
