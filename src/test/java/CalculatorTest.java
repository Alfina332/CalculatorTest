import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CalculatorTest {
    private Calculator calculator;
    @BeforeEach
    public void beforeEach(){
        calculator = new Calculator();
    }

    @Test
    public void testDivideByZero() {
        int a = 6, b = 0;
        Assertions.assertThrows(ArithmeticException.class, ()-> calculator.devide.apply(a,b));
    }

    @Test
    public void testIsPositive() {
        int a = 6;
        Assertions.assertTrue(calculator.isPositive.test(a));
    }

    //null

    @ParameterizedTest
    @MethodSource("methodSource")
    public void testConcat_methodSource(int a, int b, int expectedResult) {
        int result = calculator.plus.apply(a, b);
        Assertions.assertEquals(expectedResult, result);
    }

    public Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(10, 50, 60)
        );
    }
}
