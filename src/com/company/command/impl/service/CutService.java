package com.company.command.impl.service;

import com.company.TextEditor;

public class CutService {
    public static boolean service(int startIndex, int endIndex, TextEditor textEditor) {
        if (!textEditor.getMainString().isEmpty()) {
            textEditor.getBufferString().setLength(0);
            textEditor.getBufferString().append(textEditor.getMainString().substring(startIndex, endIndex));
            textEditor.getMainString().delete(startIndex, endIndex);
            return true;
        } else {
            System.out.println("Строка пустая");
            return false;
        }
    }
}
