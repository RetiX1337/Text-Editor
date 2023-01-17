package com.company.command.impl.service;

import com.company.TextEditor;

public class PasteService {
    public static boolean service(int index, TextEditor textEditor) {
        if (!textEditor.getBufferString().isEmpty()) {
            textEditor.getMainString().insert(index, textEditor.getBufferString());
            return true;
        } else {
            System.out.println("Буфер пустой");
            return false;
        }
    }
}
