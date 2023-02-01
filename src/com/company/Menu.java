package com.company;

import com.company.command.Command;

import java.util.Map;
import java.util.Set;

public class Menu {
    private static boolean menuIndicator = true;

    public static void menu(TextEditor textEditor, CommandContainer commandContainer) {
        String choice;
        printMenu(commandContainer);
        while (menuIndicator) {
            try {
                Thread.sleep(10);
                choice = Helper.getScanner().nextLine();
                Helper.findCommand(choice, textEditor, commandContainer);
                Helper.printString(textEditor);
            } catch (NumberFormatException e) {
                System.out.println(Main.bundle.getString("IncorrectValue"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExitException e) {
                menuIndicator=false;
            }
        }
    }

    private static void printMenu(CommandContainer commandContainer) {
        Set<Map.Entry<String, Command>> entries = commandContainer.getAllCommands().entrySet();
        for (Map.Entry<String, Command> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue().getDescription());
        }
    }
}
