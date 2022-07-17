package com.deloittece;

import com.deloittece.gui.GuiMenu;
import com.deloittece.gui.Size;
import com.deloittece.tui.TuiMenu;

import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws IOException {
        //TuiMenu menu = new TuiMenu();
        //menu.start();

        GuiMenu menu = new GuiMenu();
        menu.start();
    }
}
