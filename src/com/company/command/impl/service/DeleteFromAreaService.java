package com.company.command.impl.service;

import com.company.TextEditor;

public class DeleteFromAreaService {
    public static boolean service(int startIndex, int endIndex, TextEditor textEditor) {
        if (!textEditor.getMainString().isEmpty()) {
            textEditor.getMainString().delete(startIndex, endIndex);
            return true;
        } else {
            System.out.println("Строка пустая");
            return false;
        }
    }
}
