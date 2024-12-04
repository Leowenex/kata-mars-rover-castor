package com.castor;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test
    void it_works() {
        var hello = new Main();
        var actual = hello.getAnswer();
        assertEquals(42, actual);

    }
}
