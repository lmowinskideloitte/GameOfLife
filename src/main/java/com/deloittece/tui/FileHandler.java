package com.deloittece.tui;

import com.deloittece.Board;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.io.*;
import java.util.Random;


// Handles read/writes to populate/save the state of the board
public class FileHandler {

    protected void generateRandomLiveBacterias(int size) throws IOException {
        File file = new File("./LiveBacterias.txt");
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                System.err.println("Something went wrong!");
            }
        }
        FileWriter fwriter = new FileWriter(file, false);
        BufferedWriter bwriter = new BufferedWriter(fwriter);

        int howManyNumbers = new Random().nextInt(size*size);
        for (int i = 0; i < howManyNumbers; i++) {
            bwriter.write(new Random().nextInt(size) + "," + new Random().nextInt(size) + "\n");
        }
        bwriter.close();

    }

    //zwraca fileboarda
    protected int[][] getLiveBacteriasCords(int size) {
        String[] content;
        int[][] cor = new int[size*size][2];

        try {
            File file = new File("./LiveBacterias.txt");
            FileReader freader = new FileReader(file);
            BufferedReader breader = new BufferedReader(freader);
            String line;
            int i = 0;

            while ((line = breader.readLine()) != null) {
                content = line.split(",");
                cor[i][0] = Integer.parseInt(content[0]);
                cor[i][1] = Integer.parseInt(content[1]);
                i++;
            }
        } catch (IOException e) {
            System.err.println("Database file doesn't exist!");
            e.printStackTrace();
        }
        return cor;
    }

    //zmienia jedna komorke
    protected void modifyLifeBacterias(int x, int y) {

    }


}
