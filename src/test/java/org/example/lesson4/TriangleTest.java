package org.example.lesson4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TriangleTest {

    private static Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @ParameterizedTest
//    @CsvSource({"2, 4, 3, 2.9047375096555625",
//            "4, 6, 8, 11.61895003862225",
//            "12, 21, 17, 101.9803902718557"})
    @CsvFileSource(resources = "/testData1.csv")
    void calcAreaPositiveTest(int a, int b, int c, double result) {
        Triangle triangle = new Triangle();
        Assertions.assertEquals(result, triangle.calcArea(a, b, c));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testData2.csv")
    void calcAreaNTSExceptionTest(int a, int b, int c) {
        Triangle triangle = new Triangle();
        Assertions.assertThrows(NegativeTriangleSideException.class, () -> triangle.calcArea(a, b, c));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testData3.csv")
    void calcAreaNETExceptionTest(int a, int b, int c) {
        Triangle triangle = new Triangle();
        Assertions.assertThrows(NonExistentTriangleException.class, () -> triangle.calcArea(a, b, c));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testData4.csv")
    void calcAreaZTSExceptionTest(int a, int b, int c) {
        Triangle triangle = new Triangle();
        Assertions.assertThrows(ZeroTriangleSideException.class, () -> triangle.calcArea(a, b, c));
    }
}
