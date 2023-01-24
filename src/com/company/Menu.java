package com.company;

import com.company.command.Command;
import com.company.command.impl.service.Configurator;

import java.util.Map;
import java.util.Set;

public class Menu {
    private static final TextEditor textEditor = new TextEditor();
    private static final CommandContainer commandContainer = new CommandContainer(textEditor);
    private static boolean menuIndicator = true;

    public static void menu() {
        String choice;
        printMenu();
        while (menuIndicator) {
            try {
                Thread.sleep(10);
                choice = Helper.checkMenuInput();
                switchMenu(choice);
                Helper.printString(textEditor);
            } catch (NumberFormatException e) {
                System.out.println("Введено некорректное значение");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void printMenu() {
        Set<Map.Entry<String, Command>> entries = commandContainer.getAllCommands().entrySet();
        for (Map.Entry<String, Command> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue().getDescription());
        }
    }

    private static void switchMenu(String choice) {
        textEditor.executeCommand(commandContainer.getCommand(choice), textEditor);
    }

    public static void setMenuIndicator(boolean menuIndicator) {
        Menu.menuIndicator = menuIndicator;
    }
}
