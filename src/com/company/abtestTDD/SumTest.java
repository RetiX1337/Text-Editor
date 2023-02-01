package com.company.abtestTDD;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void sum() {
        assertEquals(10, Sum.sum(5, 5));
        assertThrows(RuntimeException.class, () -> Sum.sum(Integer.MAX_VALUE, 1));
        assertThrows(RuntimeException.class, () -> Sum.sum(Integer.MIN_VALUE, -1));
    }
}