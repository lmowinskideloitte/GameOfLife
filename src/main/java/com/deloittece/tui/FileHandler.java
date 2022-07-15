package com.deloittece.tui;

import com.deloittece.Board;

import java.util.*;
import java.io.*;
import java.util.Random;


// Handles read/writes to populate/save the state of the board
public class FileHandler {

    private String file_path = "./LiveBacterias.txt";
    protected void generateRandomLiveBacterias(int size) throws IOException {
        File file = new File(file_path);
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                System.err.println("Something went wrong!");
            }
        }
        FileWriter fwriter = new FileWriter(file, false);
        BufferedWriter bwriter = new BufferedWriter(fwriter);

        int howManyNumbers = new Random().nextInt(size*size/2);
        for (int i = 0; i < howManyNumbers; i++) {
            bwriter.write(new Random().nextInt(size) + "," + new Random().nextInt(size) + "\n");
        }
        bwriter.close();

    }

    //zwraca fileboarda
    protected List<List<Integer>> getLiveBacteriasCords(int size) throws IOException{
        String[] content;
        List<List<Integer>> listOfCords = new ArrayList<>();
        List<Integer> cords = new ArrayList<>();

        try {
            File file = new File(file_path);
            FileReader freader = new FileReader(file);
            BufferedReader breader = new BufferedReader(freader);
            String line;

            while ((line = breader.readLine()) != null) {
                content = line.split(",");
                cords.add(Integer.parseInt(content[0]));
                cords.add(Integer.parseInt(content[1]));
                listOfCords.add(new ArrayList<>(cords));
                cords.clear();
            }
        } catch (IOException e) {
            System.err.println("Database file doesn't exist!");
            e.printStackTrace();
        }
        return listOfCords;
    }

    protected void changeFilePath(String path) {
        File file = new File(path);

        if(!file.exists()) { System.out.println("This file does not exist!"); }
        else { this.file_path = path; }
    }
}
