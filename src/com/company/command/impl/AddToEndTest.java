package com.company.command.impl;

import com.company.CommandHistory;
import com.company.TextEditor;
import com.company.command.impl.service.addtoend.AddToEndService;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class AddToEndTest {
    private AddToEnd underTest;
    private TextEditor textEditor;
    private AddToEndService addToEndService;
    private CommandHistory commandHistory;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        textEditor = Mockito.mock(TextEditor.class);
        addToEndService = Mockito.mock(AddToEndService.class);
        commandHistory = Mockito.mock(CommandHistory.class);
        underTest = new AddToEnd(textEditor, addToEndService);
    }

    @org.junit.jupiter.api.Test
    void getDescription() {
        assertEquals("Дописать строку к концу",underTest.getDescription());
    }

    @org.junit.jupiter.api.Test
    void addToEndTest() {
        Mockito.when(textEditor.getCommandHistory()).thenReturn(commandHistory);
        Mockito.when(textEditor.getTempString()).thenReturn(new StringBuilder());
        boolean result = underTest.execute();
        assertEquals(true, result);
        Mockito.verify(textEditor).getCommandHistory();
        Mockito.verify(textEditor).getTempString();
    }
}