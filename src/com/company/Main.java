package com.company;

import com.company.command.impl.service.Configurator;

import java.util.Locale;
import java.util.ResourceBundle;

public class Main {
    public static ResourceBundle bundle = ResourceBundle.getBundle("com.company.resources");

    public static void main(String[] args) {
        mode();
        Menu.menu();
    }

    private static void mode() {
        System.out.println(bundle.getString("Main.mode1") + "\n" + bundle.getString("Main.mode2"));
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
                    System.out.println(bundle.getString("CaseDoesntExist"));
                }
            } catch (NumberFormatException e) {
                System.out.println(bundle.getString("IncorrectValue"));
            }
        }
    }
}
