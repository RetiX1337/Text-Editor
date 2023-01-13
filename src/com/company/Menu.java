package com.company;

import java.util.Scanner;

public class Menu {

    private static final Scanner scanner = new Scanner(System.in);

    public static void menu() {
        TextEditor textEditor = new TextEditor();
        int choice;
        System.out.println("1. Дописать строку");
        System.out.println("2. Вставить строку по индексу");
        System.out.println("3. Копировать часть строки в буфер");
        System.out.println("4. Удалить часть строки");
        System.out.println("5. Вставить строку по индексу из буфера");
        System.out.println("6. Вырезать часть строки в буфер");
        System.out.println("7. Отменить действие");
        System.out.println("8. Выйти из программы");
        while(true){
            while(true) {
                try {
                    choice=checkMenuInput();
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Введено некорректное значение");
                }
            }
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
            Helper.printString();
        }
    }

    public static int checkMenuInput() {
        String input = scanner.nextLine();
        if (!input.matches("[0-9]*")) throw new NumberFormatException();
        return Integer.parseInt(input);
    }
}
