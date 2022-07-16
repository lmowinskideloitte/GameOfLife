package com.deloittece.tui;

import com.deloittece.Board;

import java.util.*;
import java.io.*;
import java.util.Random;


// Handles read/writes to populate/save the state of the board
public class FileHandler {

    private String file_path = "./LiveBacterias.txt";
    private int size;

    // generates new file(user size) and new random living bacterias coords
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

    // return live bacterias coords (as a list) from current file
    protected List<List<Integer>> getLiveBacteriasCords(int size) throws IOException{
        this.size = size;
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

    // changes current file_path
    protected void changeFilePath(String path) {
        File file = new File(path);

        if(!file.exists()) { System.out.println("This file does not exist!"); }
        else { this.file_path = path; }
    }

    // changes one bacteria state in file
    protected void changeBacteriaInFile(int x_cord, int y_cord) {
        boolean addNew = true;
        try {
            List<List<Integer>> listOfCords = getLiveBacteriasCords(this.size);

            for (int i = 0; i < listOfCords.size(); i++) {
                if (listOfCords.get(i).get(0) == x_cord && listOfCords.get(i).get(1) == y_cord) {
                    listOfCords.remove(i);
                    addNew = false;
                    break;
                }
            }
            if (addNew) {
                List<Integer> cords = new ArrayList<>();
                cords.add(x_cord);
                cords.add(y_cord);
                listOfCords.add(cords);
            }

            FileWriter fwriter = new FileWriter(file_path, false);
            BufferedWriter bwriter = new BufferedWriter(fwriter);

            for (int i = 0; i < listOfCords.size(); i++) {
                bwriter.write(listOfCords.get(i).get(0) + "," + listOfCords.get(i).get(1) + "\n");
            }
            bwriter.close();
        } catch (IOException e) {
            System.err.println("Something went wrong!");
            e.printStackTrace();
        }
    }

   // creates a copy of current file and saves it to the path which users gave
    protected void saveFileInFilePath(String file_path) {
        try {
            File file = new File(file_path);
            if(!file.exists()) {
                try {
                    file.createNewFile();
                } catch (Exception e) {
                    System.out.println("Something went wrong!");
                }
            }
            FileWriter fwriter = new FileWriter(file, false);
            BufferedWriter bwriter = new BufferedWriter(fwriter);

            List<List<Integer>> listOfCords = getLiveBacteriasCords(this.size);
            for (int i = 0; i < listOfCords.size(); i++) {
                bwriter.write(listOfCords.get(i).get(0) + "," + listOfCords.get(i).get(1) + "\n");
            }
            bwriter.close();
            System.out.println("File saved!");
        } catch (IOException e) {
            System.out.println("File path doesn't exist!");
        }
    }
}
