package pro.sky.skyprospringcalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CalculatorServiceImplTest {

    CalculatorServiceImpl out;

    @BeforeEach
    public void setUp() {
        out = new CalculatorServiceImpl();
    }

    public static Stream<Arguments> providedParamsForTests() {
        return Stream.of(Arguments.of(8, 4));

    }

    public static Stream<Arguments> providedParamsForExceptionThrow() {
        return Stream.of(Arguments.of(8, 0));

    }

    @ParameterizedTest
    @MethodSource("providedParamsForTests")
    public void plusTest(int num1, int num2) {
        String actual = out.plus(num1, num2);
        String expected = num1 + " + " + num2 + " = " + (num1 + num2);

        Assertions.assertEquals(actual, expected);
    }

    @ParameterizedTest
    @MethodSource("providedParamsForTests")
    public void minusTest(int num1, int num2) {
        String actual = out.minus(num1, num2);
        String expected = num1 + " - " + num2 + " = " + (num1 - num2);

        Assertions.assertEquals(actual, expected);
    }

    @ParameterizedTest
    @MethodSource("providedParamsForTests")
    public void multiplyTest(int num1, int num2) {
        String actual = out.multiply(num1, num2);
        String expected = num1 + " * " + num2 + " = " + (num1 * num2);

        Assertions.assertEquals(actual, expected);
    }

    @ParameterizedTest
    @MethodSource("providedParamsForTests")
    public void divideTest(int num1, int num2) {
        String actual = out.divide(num1, num2);
        String expected = num1 + " / " + num2 + " = " + (num1 / num2);
        Assertions.assertEquals(actual, expected);
    }

    @ParameterizedTest
    @MethodSource("providedParamsForExceptionThrow")
    public void exceptionThrowTest(int num1, int num2) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> out.divide(num1, num2));
    }
}
