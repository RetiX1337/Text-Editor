package com.company;

import java.util.Scanner;
//Test commit using GitHub Desktop
//Test commit 2
public class Main {

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        TextEditor textEditor = new TextEditor();
        Scanner scanner = new Scanner(System.in);
        int choice;
        System.out.println("1. Дописать строку");
        System.out.println("2. Вставить строку по индексу");
        System.out.println("3. Копировать часть строки в буфер");
        System.out.println("4. Удалить часть строки");
        System.out.println("5. Вставить строку по индексу из буфера");
        System.out.println("6. Вырезать часть строки в буфер");
        System.out.println("7. Выйти из программы");
        while(true){
            choice=scanner.nextInt();
            switch(choice) {
                case 1 -> textEditor.addToEnd();
                case 2 -> textEditor.addToIndex();
                case 3 -> textEditor.copy(false);
                case 4 -> textEditor.deleteFromIndex();
                case 5 -> textEditor.paste();
                case 6 -> textEditor.cut();
                case 7 -> System.exit(0);
                default -> System.out.println("Вариант не существует");
            }
            textEditor.printString();
        }
    }
}
