package com.company;

public class Menu {
    public static TextEditor textEditor = new TextEditor();
    public static CommandContainer commandContainer = new CommandContainer(textEditor);

    public static void menu() {
        int choice;
        printMenu();
        while (true) {
            while (true) {
                try {
                    choice = Helper.checkMenuInput();
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Введено некорректное значение");
                }
            }
            switchMenu(choice);
            Helper.printString(textEditor);
        }
    }

    private static void printMenu() {
        for(int i = 1; i<=commandContainer.getAllCommands().size(); i++) {
            System.out.println(i + ". " + commandContainer.getAllCommands().get(i).description);
        }
    }

    private static void switchMenu(int choice) {
        textEditor.executeCommand(commandContainer.getCommand(choice));
    }
}
