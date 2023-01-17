package com.company.command.impl.service;

import com.company.TextEditor;

public class AddToIndexService {
    public static boolean service(String input, int index, TextEditor textEditor) {
        if (!textEditor.getMainString().isEmpty()) {
            textEditor.getMainString().insert(index, input);
            return true;
        } else {
            System.out.println("Строка пустая");
            return false;
        }
    }
}
