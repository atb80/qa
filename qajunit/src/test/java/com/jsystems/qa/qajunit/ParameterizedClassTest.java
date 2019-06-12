package com.jsystems.qa.qajunit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Parameterized tests")
public class ParameterizedClassTest {

    @BeforeAll
    public static void setUpAll (){
        System.out.println("========== BeforeAll ==========");

    }

    @AfterAll
    public static void tearDownAll()

    {
        System.out.println("======= AfterAll ==========");
    }
    @BeforeEach
    public void setUp() {
        System.out.println("========= BeforeEach =======");
    }
    @AfterEach
    public void tearDown (){
        System.out.println("====== AfterEach======");
    }

    @DisplayName("Second parametrized test")
    @ParameterizedTest(name = "Parametrized test with value {0}")
    @ValueSource(strings = {"Hello", "Hello junit", "Hello student"})
    public void paramFirstTest(String value) {
        assertTrue(value.contains("Hello"));

    }

    @DisplayName("csv vALEUE PARAPETRIZED TEST")
    @ParameterizedTest(name = "Parametrized test with value name: {0} and value : {1}")
    @CsvSource(value = {"Hello, 5", "HelloJunit 5, 15", "Hello 5!, 25"}, delimiter = ',')
    public void paramMultiArgTest(String param1, int param2) {
        assertTrue(param1.contains("Hello"));
        assertTrue(param2 % 5 == 0);

    }

    @DisplayName("CSV file source parametrized test")
    @ParameterizedTest(name = "Parametrized test with data from csv file, name: {0} and value: {1}")
    @CsvFileSource(resources = ("/plik.csv"), delimiter = ',')
    public void csvFileSourceTest(String param1, int param2) {
        assertTrue(param1.contains("Hello"));
        assertTrue(param2 % 5 == 0);

    }
}






