package com.company;

import java.util.ResourceBundle;

public class Main {
    private final TextEditor textEditor = new TextEditor();
    public static ResourceBundle bundle = ResourceBundle.getBundle("com.company.resources");

    public static void main(String[] args) {
        Main mainClass = new Main();
        String s = args[0];
        boolean set = mode(s, mainClass);
        if (set) {
            mainClass.textEditor.getCommandContainer().fillContainer();
            Menu.menu(mainClass.textEditor);
        }
        else System.out.println(bundle.getString("IncorrectValue"));
    }

    private static boolean mode(String s, Main mainClass) {
        switch (s) {
            case "1":
                new Configurator(false, mainClass.textEditor);
                break;
            case "2":
                new Configurator(true, mainClass.textEditor);
                break;
            default:
                return false;
        }
        return true;
    }
}
