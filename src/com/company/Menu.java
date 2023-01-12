package com.company;

import java.util.Scanner;

public class Menu {

    private static final Scanner scanner = new Scanner(System.in);

    public static void menu() {
        TextEditor textEditor = new TextEditor();
        int choice;
        System.out.println("1. �������� ������");
        System.out.println("2. �������� ������ �� �������");
        System.out.println("3. ���������� ����� ������ � �����");
        System.out.println("4. ������� ����� ������");
        System.out.println("5. �������� ������ �� ������� �� ������");
        System.out.println("6. �������� ����� ������ � �����");
        System.out.println("7. ����� �� ���������");
        while(true){
            while(true) {
                try {
                    choice=checkMenuInput();
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("������� ������������ ��������");
                }
            }
            switch(choice) {
                case 1 -> textEditor.addToEnd();
                case 2 -> textEditor.addToIndex();
                case 3 -> textEditor.copy(false);
                case 4 -> textEditor.deleteFromIndex();
                case 5 -> textEditor.paste();
                case 6 -> textEditor.cut();
                case 7 -> System.exit(0);
                default -> System.out.println("������� �� ����������");
            }
            textEditor.printString();
        }
    }

    public static int checkMenuInput() {
        String input = scanner.nextLine();
        if (!input.matches("[0-9]*")) throw new NumberFormatException();
        return Integer.parseInt(input);
    }
}
