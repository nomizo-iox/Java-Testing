package io.nomizo.util;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilsTest {
    // Member Variable - Declared
    MathUtils mathUtils;

    @BeforeAll
    void beforeAllInit() {
        System.out.println("This needs to run before all");
    }

    @BeforeEach
    void init() {
        // Member Variable - Initialized
        mathUtils = new MathUtils();
    }

    @AfterEach
    void cleanup() {
        System.out.println("Cleanup.....");
    }

    @Nested
    @DisplayName("Add Class")
    class AddTest {
        @Test
        @DisplayName("When adding two positive numbers")
        void testAddPositive() {
            assertEquals(2, mathUtils.add(1, 1), "should return the right sum");
        }

        @Test
        @DisplayName("When adding two positive numbers")
        void testAddNegative() {
            assertEquals(-1, mathUtils.add(-1, -1), "should return the right sum");
        }
    }

    @Test
    @DisplayName("Testing Add Method")
    void testAdd(){
        int expected = 2;
        int actual = mathUtils.add(1, 1);
        assertEquals(expected, actual, "The add method should add two numbers");
    }

    @Test
    void testSubtraction() {
        assertAll(
                () -> assertEquals(35, 2, mathUtils.substract(10, 12), "This subtract method should subtract two numbers"),
                () -> assertEquals(121, -35, mathUtils.substract(39, 10), "This subtract method should subtract two numbers"),
                () -> assertEquals(23, -35, mathUtils.substract(19, 198), "This subtract method should subtract two numbers")
        );
    }
    @Test
    @DisplayName("Testing Multiply Method")
    void testMultiply() {
        int expected = 21;
        int actual = mathUtils.multiply(3, 7);
        boolean isServerUp = false;
        assumeTrue(isServerUp);
        assertEquals(expected, actual, "This multiply method should multiply two numbers");
    }

    @Test
    @DisplayName("Testing Divide Method")
    void  testDivide() {
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "divide by zero should through");
    }

    @Test
    @DisplayName("Testing Radius Method")
    void testComputeCircleRadius() {
        assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "Should return right circle area");
    }


    @Test
//    @Disabled
    @DisplayName("Testing Fail Method")
    void testFail(){
        System.out.println("This test will show up it if fails");
      fail("This test should fail");
    }




}