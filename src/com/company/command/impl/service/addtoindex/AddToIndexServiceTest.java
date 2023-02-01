package com.company.command.impl.service.addtoindex;

import com.company.TextEditor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class AddToIndexServiceTest {
    private AddToIndexInterface addToIndex;
    private TextEditor textEditor;

    @BeforeEach
    void setUp() {
        addToIndex = AddToIndexService.getInstance();
        textEditor = Mockito.mock(TextEditor.class);
        Mockito.when(textEditor.getTempString()).thenReturn(new StringBuilder("qqqqq"));

    }

    @Test
    void execute() {
        assertEquals(addToIndex.execute("ee", 1, textEditor), true);
        assertEquals(addToIndex.execute("fdfsdf", 545345, textEditor), false);
        assertEquals(addToIndex.execute("423423", 3, textEditor), true);
    }
}