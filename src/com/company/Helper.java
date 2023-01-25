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
        int input;
        input = checkInt();
        if (input > textEditor.getTempString().length() || input < 0)
            throw new IndexException();
        return input;

    }

    public static int checkInt() {
        String input = scanner.nextLine();
        if (!input.matches("[0-9]*")) throw new NumberFormatException();
        return Integer.parseInt(input);
    }

    public static void printString(TextEditor textEditor) {
        textEditor.getCommandHistory().historyExecute(textEditor);
        System.out.println(textEditor.getTempString());
        textEditor.getTempString().setLength(0);
    }

    public static void findCommand(String choice, TextEditor textEditor) {
        textEditor.executeCommand(textEditor.getCommandContainer().getCommand(choice), textEditor);
    }

}
