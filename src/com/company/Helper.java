package com.company;

public class Helper {
    protected static int getIndex() {
        int index = -1;
        do {
            try {
                index = checkIndex();
            } catch (NumberFormatException e) {
                System.out.println("Введено некорректное значение.");
            } catch (IndexException e) {
                System.out.println("Введённое значение выходит за границы строки.");
            }
        } while (index > TextEditor.mainString.length() || index < 0);
        return index;
    }

    protected static int checkIndex() {
        String input = TextEditor.scanner.nextLine();
        if (!input.matches("[0-9]*")) throw new NumberFormatException();
        if (Integer.parseInt(input) > TextEditor.mainString.length() || Integer.parseInt(input) < 0) throw new IndexException();
        return Integer.parseInt(input);
    }

    protected static void printString() {
        System.out.println(TextEditor.mainString);
    }
}
