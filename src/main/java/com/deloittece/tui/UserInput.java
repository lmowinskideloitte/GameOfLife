package com.deloittece.tui;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {

    // choose option from menu
    protected int getOptionFromUser() {
        Scanner scan = new Scanner(System.in);
        int input = 0;
        boolean inputCorrect = false;

        while (!inputCorrect) {
            try {
                System.out.print("Enter option: ");
                input = scan.nextInt();
                if (input >= 1 && input <= 6) {
                    inputCorrect = true;
                } else {
                    System.out.println("Incorrect number!");
                }
            } catch (InputMismatchException e) {
                String wrongInput = scan.next();
                System.out.println(wrongInput + " is a wrong input! Input only integer numbers please...");
            }
        }
        return input;
    }

    // input new board size
    protected int getSizeFromUser() {
        Scanner scan = new Scanner(System.in);
        int size = 0;
        boolean inputCorrect = false;

        while (!inputCorrect) {
            try {
                System.out.print("Enter board size: ");
                size = scan.nextInt();
                if (size > 0) {
                    inputCorrect = true;
                } else {
                    System.out.println("Incorrect number! Size should be > 0");
                }
            } catch (InputMismatchException e) {
                String wrongInput = scan.next();
                System.out.println(wrongInput + " is a wrong input! Input only integer numbers please...");
            }
        }
        return size;
    }

    // input bacteria coords to changes it's state
    protected int getBacteriaCoordsFromUser(int size, String whichCoord) {
        Scanner scan = new Scanner(System.in);
        int coord = 0;
        boolean inputCorrect = false;

        while (!inputCorrect) {
            try {
                System.out.print("Enter " + whichCoord + " coordinate of the bacteria: ");
                coord = scan.nextInt();
                if (coord >= 0 && coord < size) {
                    inputCorrect = true;
                } else {
                    System.out.println("Incorrect number! Coordinate should be between 0 and " + (size-1));
                }
            } catch (InputMismatchException e) {
                String wrongInput = scan.next();
                System.out.println(wrongInput + " is a wrong input! Input only integer numbers please...");
            }
        }
        return coord;
    }

    // asks if user wants to change some more bacterias or not
    protected int getUsersWill() {
        Scanner scan = new Scanner(System.in);
        int will = 0;
        boolean inputCorrect = false;

        while (!inputCorrect) {
            try {
                System.out.print("""
                                Do you want to change some bacteria again?
                                1. Yes
                                2. No
                                Input: """);
                will = scan.nextInt();
                if (will == 1 || will == 2) {
                    inputCorrect = true;
                } else {
                    System.out.println("Incorrect number! Input should be 1 or 2!");
                }
            } catch (InputMismatchException e) {
                String wrongInput = scan.next();
                System.out.println(wrongInput + " is a wrong input! Input only integer numbers please...");
            }
        }
        return will;
    }

    // input user's path of his file with living bacterias coords
    protected String inputFile() {
        Scanner scan = new Scanner(System.in);
        String input = "";
        boolean inputCorrect = false;

        while (!inputCorrect) {
            try {
                System.out.print("Enter new file path: ");
                input = scan.nextLine();
                inputCorrect = true;
            } catch (InputMismatchException e) {
                String wrongInput = scan.next();
                System.out.println(wrongInput + " is a wrong input!");
            }
        }
        return input;
    }
}
