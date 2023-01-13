package com.company;

import java.util.Scanner;

public class Menu {

    public static void menu() {
        TextEditor textEditor = new TextEditor();
        int choice;
        printMenu();
        while(true){
            while(true) {
                try {
                    choice=checkMenuInput();
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Введено некорректное значение");
                }
            }
            switchMenu(choice, textEditor);
            Helper.printString();
        }
    }

    private static void printMenu() {
        CommandList commandList = new CommandList();
        for(int i=1; i<=commandList.getLength(); i++) {
            System.out.println(i + ". " + commandList.getDescription(i));
        }
    }

    private static void switchMenu(int choice, TextEditor textEditor) {
        switch(choice) {
            case 1 -> textEditor.executeCommand(new AddToEnd(textEditor));
            case 2 -> textEditor.executeCommand(new AddToIndex(textEditor));
            case 3 -> textEditor.executeCommand(new Copy(textEditor));
            case 4 -> textEditor.executeCommand(new DeleteFromArea(textEditor));
            case 5 -> textEditor.executeCommand(new Paste(textEditor));
            case 6 -> textEditor.executeCommand(new Cut(textEditor));
            case 7 -> textEditor.undoCommand();
            case 8 -> System.exit(0);
            default -> System.out.println("Данный вариант не существует");
        }
    }

    private static int checkMenuInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (!input.matches("[0-9]*")) throw new NumberFormatException();
        return Integer.parseInt(input);
    }
}
