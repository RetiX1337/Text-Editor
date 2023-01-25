package com.company;

import javax.security.auth.login.Configuration;
import java.util.ResourceBundle;

public class Main {
    private static final TextEditor textEditor = new TextEditor();
    public static ResourceBundle bundle = ResourceBundle.getBundle("com.company.resources");

    public static void main(String[] args) {
        String s = args[0];
        boolean set = mode(s);
        if (set) Menu.menu(textEditor);
        else System.out.println(bundle.getString("IncorrectValue"));
    }

    private static boolean mode(String s) {
        switch (s) {
            case "1":
                new Configurator(false);
                break;
            case "2":
                new Configurator(true);
                break;
            default:
                return false;
        }
        return true;
    }
}
