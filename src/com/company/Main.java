package com.company;

import com.company.writeread.WriteRead;

import java.io.IOException;
import java.util.HashMap;
import java.util.ResourceBundle;

public class Main {

    public static ResourceBundle bundle = ResourceBundle.getBundle("com.company.resources");
    //commit
    public static void main(String[] args) {
        /*
        try {
            WriteRead.writeRead();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
        String s = args[0];
        Config configClass = new Config();
        configClass.config(s);
        Menu.menu(configClass.getTextEditor(), configClass.getCommandContainer());
    }
}
