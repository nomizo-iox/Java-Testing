package io.nomizo.util;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("When Running MathUtils ")
class MathUtilsTest {
    // Member Variable - Declared
    MathUtils mathUtils;
    TestInfo testInfo;
    TestReporter testReporter;

    @BeforeAll
    void beforeAllInit() {
        System.out.println("This needs to run before all");
    }

    @BeforeEach
    void init(TestInfo testInfo, TestReporter testReporter) {
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        // Member Variable - Initialized
        mathUtils = new MathUtils();
        testReporter.publishEntry("Running " + testInfo.getDisplayName() + " with tags " + testInfo.getTags());
    }

    @AfterEach
    void cleanup() {
        System.out.println("Cleanup.....");
    }

    @Nested
    @DisplayName("Add Methods")
    @Tag("Math")
    class AddTest {
        @Test
        @DisplayName("1st Adding Method")
        void testAddPositive() {
            int expected = 2;
            int actual = mathUtils.add(1, 1);
            // Lambda expression makes JUnit only execute the string when the test fails.
            assertEquals(expected, actual, () -> "should return " + expected + " but returned " + actual + " ");
        }

        @Test
        @DisplayName("2nd Adding Method")
        void testAddNegative() {
            assertEquals(-2, mathUtils.add(-1, -1), "should return the right sum");
        }
    }

        @Test
        @DisplayName("Testing Add Method")
        void testAdd() {
            System.out.println("Running " + testInfo.getDisplayName() + " with tags " + testInfo.getTags());
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
        @Tag("Math")
        void testMultiply() {
            int expected = 21;
            int actual = mathUtils.multiply(3, 7);
            boolean isServerUp = false;
            assumeTrue(isServerUp);
            assertEquals(expected, actual, "This multiply method should multiply two numbers");
        }

        @Test
        @DisplayName("Testing Divide Method")
        @Tag("Math")
        void testDivide() {
            assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "divide by zero should through");
        }

        @Test
        @Tag("Circle")
        @DisplayName("Testing Radius Method")
        void testComputeCircleRadius() {
            assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "Should return right circle area");
        }

        @Test
//    @Disabled
        @DisplayName("Testing Fail Method")
        @Tag("Fail")
        void testFail() {
            System.out.println("This test will show up it if fails");
            fail("This test should fail");
        }

        @Test
        @DisplayName("Testing Square Method")
        @Tag("Math")
        @RepeatedTest(3)
        void testSquared(RepetitionInfo repetitionInfo) {
            double expected = 3125;
            double actual = mathUtils.squared(5, 5);
            assertEquals(expected, actual, () -> "Should return " + expected + "but returned " + actual + "");
        }

}