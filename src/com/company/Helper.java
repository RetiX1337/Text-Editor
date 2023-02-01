package com.company;

import java.util.Scanner;

public class Helper {
    private static Scanner instance=null;

    public static int getIndex(TextEditor textEditor) {
        int index = -1;
        do {
            try {
                index = inputIndex(textEditor);
            } catch (NumberFormatException e) {
                System.out.println("Введено некорректное значение.");
            } catch (IndexException e) {
                System.out.println("Введённое значение выходит за границы строки.");
            }
        } while (index > textEditor.getTempString().length() || index < 0);
        return index;
    }

    public static boolean checkIndex(TextEditor textEditor, int input) {
        if (input > textEditor.getTempString().length() || input < 0) return false;
        return true;
    }

    public static int inputIndex(TextEditor textEditor) {
        int input;
        input = inputInt();
        if(checkIndex(textEditor, input)) return input;
        throw new IndexException();
    }

    public static int inputInt() {
        String input = getScanner().nextLine();
        if (!input.matches("[0-9]*")) throw new NumberFormatException();
        return Integer.parseInt(input);
    }

    public static void printString(TextEditor textEditor) {
        textEditor.getCommandHistory().historyExecute(textEditor);
        System.out.println(textEditor.getTempString());
        textEditor.getTempString().setLength(0);
    }

    public static void findCommand(String choice, TextEditor textEditor, CommandContainer commandContainer) {
        textEditor.executeCommand(commandContainer.getCommand(choice), textEditor);
    }

    public static Scanner getScanner() {
        if (instance != null) {
            return instance;
        }
        return instance = new Scanner(System.in);
    }

}
