package com.jsystems.qa.qajunit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class JunitTest {
        String stringTestowy = "stringTestowy";
        String testowy = null;

    @Test
    public void firstTest() {
        assertTrue(true, "massage for test result");
        assertEquals("stringTestowy", stringTestowy);
        assertNotNull(stringTestowy);
//        assertThat()
    }
            }

