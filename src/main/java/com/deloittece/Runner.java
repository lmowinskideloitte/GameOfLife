package com.deloittece;

import com.deloittece.tui.Menu;

import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws IOException {
        Menu menu = new Menu();
        menu.start();
    }
}
