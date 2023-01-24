package com.company;

import com.company.command.impl.service.Configurator;

public class Main {
    public static void main(String[] args) {
        mode();
        Menu.menu();
    }

    private static void mode() {
        System.out.println("""
                    1. Нормальный текст\s
                    2. Текст CAPS'ом
                    """);
        while(true) {
            try {
                int input = Helper.checkInt();
                if (input == 1) {
                    Configurator.setCaps(false);
                    break;
                } else if (input == 2) {
                    Configurator.setCaps(true);
                    break;
                } else {
                    System.out.println("Такого варианта нет");
                }
            } catch (NumberFormatException e) {
                System.out.println("Введено некорректное значение");
            }
        }
    }
}
