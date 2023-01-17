package com.company.command.impl.service;

import com.company.TextEditor;

public class AddToEndService {
    public static boolean service(String input, TextEditor textEditor) {
        textEditor.getMainString().append(input);
        return true;
    }
}
