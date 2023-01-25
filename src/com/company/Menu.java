package com.company;

import com.company.command.Command;

import java.util.Map;
import java.util.Set;

public class Menu {
    private static boolean menuIndicator = true;

    public static void menu(TextEditor textEditor) {
        String choice;
        printMenu(textEditor);
        while (menuIndicator) {
            try {
                Thread.sleep(10);
                choice = Helper.scanner.nextLine();
                Helper.findCommand(choice, textEditor);
                Helper.printString(textEditor);
            } catch (NumberFormatException e) {
                System.out.println(Main.bundle.getString("IncorrectValue"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void printMenu(TextEditor textEditor) {
        Set<Map.Entry<String, Command>> entries = textEditor.getCommandContainer().getAllCommands().entrySet();
        for (Map.Entry<String, Command> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue().getDescription());
        }
    }

    public static void setMenuIndicator(boolean menuIndicator) {
        Menu.menuIndicator = menuIndicator;
    }
}
