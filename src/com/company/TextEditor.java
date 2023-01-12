package com.company;

import java.util.Scanner;

public class TextEditor {

    private StringBuilder mainString = new StringBuilder();
    private String bufferString = "";
    private Scanner scanner = new Scanner(System.in);

    public void printString() {
        System.out.println(mainString);
    }

    public void addToEnd() {
        System.out.println("Введите строку: ");
        mainString.append(scanner.nextLine());
    }

    public void addToIndex() {
        int index;
        if (!mainString.isEmpty()) {
            System.out.println("Введите индекс: ");
            index = getIndex();
            System.out.println("Введите строку: ");
            mainString.insert(index, scanner.nextLine());
        } else {
            System.out.println("Строка пустая");
        }
    }

    public void deleteFromIndex() {
        int startIndex, endIndex;
        if (!mainString.isEmpty()) {
            System.out.println("Введите индекс начала диапазона: ");
            startIndex = getIndex();
            System.out.println("Введите индекс конца диапазона: ");
            endIndex = getIndex();
            mainString.delete(startIndex, endIndex);
        } else {
            System.out.println("Строка пустая");
        }
    }

    //overloaded method "deleteFromIndex(int startIndex, int endIndex)" is used by "copy(boolean cut)" if summoned by "cut()" method
    private void deleteFromIndex(int startIndex, int endIndex) {
        mainString.delete(startIndex, endIndex);
    }

    //"boolean cut" is used to define if the "copy(boolean cut)" method is called by "cut()" method
    public void copy(boolean cut) {
        int startIndex, endIndex;
        if (!mainString.isEmpty()) {
            System.out.println("Введите индекс начала диапазона: ");
            startIndex = getIndex();
            System.out.println("Введите индекс конца диапазона: ");
            endIndex = getIndex();
            bufferString = mainString.substring(startIndex, endIndex);
            if (cut) deleteFromIndex(startIndex, endIndex);
        } else {
            System.out.println("Строка пустая");
        }
    }

    public void paste() {
        int index;
        if (!bufferString.equals("")) {
            System.out.println("Введите индекс: ");
            index = getIndex();
            mainString.insert(index, bufferString);
        } else {
            System.out.println("Буфер пустой");
        }
    }

    public void cut() {
        copy(true);
    }

    private int getIndex() {
        int index = -1;
        do {
            try {
                index = checkIndex();
            } catch (NumberFormatException e) {
                System.out.println("Введено некорректное значение.");
            } catch (IndexException e) {
                System.out.println("Введённое значение выходит за границы строки.");
            }
        } while (index > mainString.length() || index < 0);
        return index;
    }

    private int checkIndex() {
        String input = scanner.nextLine();
        if (!input.matches("[0-9]*")) throw new NumberFormatException();
        if (Integer.parseInt(input) > mainString.length() || Integer.parseInt(input) < 0) throw new IndexException();
        return Integer.parseInt(input);
    }
}
