package com.deloittece.tui;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {


    public UserInput() {

    }

    protected int getOptionFromUser() {
        Scanner scan = new Scanner(System.in);
        int input = 0;
        boolean inputCorrect = false;

        while (!inputCorrect) {
            try {
                System.out.print("Enter option: ");
                input = scan.nextInt();
                if (input == 1 || input == 2 || input == 3) {
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
                    System.out.println("Incorrect number! Size should be >0");
                }
            } catch (InputMismatchException e) {
                String wrongInput = scan.next();
                System.out.println(wrongInput + " is a wrong input! Input only integer numbers please...");
            }
        }
        return size;
    }
}
