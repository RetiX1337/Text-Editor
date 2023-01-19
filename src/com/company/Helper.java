package com.company;

import java.util.Scanner;

public class Helper {
    public static final Scanner scanner = new Scanner(System.in);

    public static int getIndex(TextEditor textEditor) {
        int index = -1;
        do {
            try {
                index = checkIndex(textEditor);
            } catch (NumberFormatException e) {
                System.out.println("Введено некорректное значение.");
            } catch (IndexException e) {
                System.out.println("Введённое значение выходит за границы строки.");
            }
        } while (index > textEditor.getTempString().length() || index < 0);
        return index;
    }

    public static int checkIndex(TextEditor textEditor) {
        String input = scanner.nextLine();
        if (!input.matches("[0-9]*")) throw new NumberFormatException();
        if (Integer.parseInt(input) > textEditor.getTempString().length() || Integer.parseInt(input) < 0)
            throw new IndexException();
        return Integer.parseInt(input);
    }

    public static String checkMenuInput() {
        return scanner.nextLine();
    }

    public static void printString(TextEditor textEditor) {
        textEditor.getCommandHistory().historyExecute(textEditor);
        System.out.println(textEditor.getTempString());
        textEditor.getTempString().setLength(0);
    }

}
