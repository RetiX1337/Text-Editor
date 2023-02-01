package com.company;

import com.company.command.Command;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class TextEditorTest {
    private TextEditor textEditor;
    private CommandHistory commandHistory;
    private Command command;

    @BeforeEach
    void setUp() {
        commandHistory = Mockito.mock(CommandHistory.class);
        command = Mockito.mock(Command.class);
        Mockito.when(command.execute()).thenReturn(true);
        textEditor = new TextEditor(commandHistory);
    }

    @Test
    void executeCommand() {
        textEditor.executeCommand(command, textEditor);
        Mockito.verify(commandHistory).push(command, textEditor);
    }

    @Test
    void setMainStringSnapshot() {
        textEditor.setMainStringSnapshot(command);
        Mockito.verify(command).outsideExecute();
    }
}